//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Armor extends Product implements Discount {
    public Armor(String name, String description, double price, int quantity, int productID) {
        super(name, description, price, quantity, productID);
    }

    public void onSale(String i) {
        System.out.println(i + this.lineSeparator);
    }
}
