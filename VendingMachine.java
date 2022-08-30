import java.util.*;
class MyClass {
    public static void main(String args[]) {
      Payment payment= new Payment();
      payment.addCurrency(50, 2);
      payment.addCurrency(10, 6);
      payment.pay(60);
      payment.pay(60);
      // Please add test cases as required
    }
}

class Product{
    int price;
    int units;
    String type;
    public Product(int price, int units, String type){
        this.price = price;
        this.units = units;
        this.type = type.toUpperCase();
    }
    public int getPrice() {return this.price;}
    public int getUnits(){ return this.units;}
    // why do we have only set method for units ans: Because after every order nomber of units or each prouct is changed.
    public void setUnits(int uts) {this.units = uts; }
    public String getProductType() {return this.type;}
}

public class VendingMachine{
    Map<String, Product> productMap = new HashMap<>();
    
    public void addProduct(Product product){
        Product mapProduct = productMap.get(product.getProductType());
        if(mapProduct == null){
            mapProduct = product;
        }else{
            mapProduct = new Product(product.getPrice(), mapProduct.getUnits()+product.getUnits(), product.getProductType());
        }
        productMap.put(product.getProductType(), mapProduct);
    }
    // return type is price because return the whole product object is costly;
    public int order(String type, int unit){
        int units = productMap.get(type).getUnits();
        if(units < unit) return -1;
        Product product = productMap.get(type);
        product.setUnits(units-unit);
        productMap.put(type, product);
        return productMap.get(type).getPrice();
    }
    
    public boolean checkOut(Map<String, Integer> userOrder, Payment payment, int totalAmount){
        if(!payment.pay(totalAmount)){
            resetOrder(userOrder);
            return false;
        }
        return true;
    }
    public void resetOrder(Map<String, Integer> userOrder){
        for(Map.Entry<String, Integer> entry: userOrder.entrySet()){
            Product product = productMap.get(entry.getKey());
            int units = product.getUnits() + entry.getValue();
            product.setUnits(units);
            productMap.put(entry.getKey(), product);
        }
    }
    public void clearProducts(){
      productMap.clear();
    }
}

class Customer {
    VendingMachine vm;
    int totalAmount;
    Map<String, Integer> orderMap = new HashMap<>();
    public Customer(VendingMachine vm){
        this.vm = vm;
    }
    
    public void order(String type, int units){
        int price = this.vm.order(type, units);
        if(price > 0){
            orderMap.put(type, units);
            this.totalAmount += (units*price);
        }else{
            System.out.println("Can't place order");
        }
    }
    
    public void cancelrder(){
        this.vm.resetOrder(orderMap);
        this.totalAmount = 0;
    }
    
    public void checkOutOrder(Payment payment){
        if(this.vm.checkOut(this.orderMap, payment, this.totalAmount)){
            System.out.println("Order placed");
        } else {
            System.out.println("Order not placed");
        }
    }
}

class Payment{
    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(Collections.reverseOrder()); 
    
    public void addCurrency(int price, int unit){
        int units = map.getOrDefault(price, 0);
        map.put(price, units+unit);
    }
    public boolean pay(int Amount){
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(key <= Amount && value > 0 && Amount > 0){
                int unit = Amount/key;
                if(unit>value){
                    System.out.println((unit-value) + " Notes of "+ key);
                    Amount -= (unit-value)*key;
                    value = 0;
                }else{
                    Amount -= (unit*key);
                    value = value-unit;
                    System.out.println(unit + " Notes of "+ key);
                }
                entry.setValue(value);
            }
        }
        System.out.println();
        return Amount==0;
    }
}
