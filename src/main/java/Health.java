//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Health extends Product implements Discount {
    public Health(String name, String description, double price, int quantity, int producID) {
        super(name, description, price, quantity, producID);
    }

    public void onSale(String i) {
        System.out.println(i + this.lineSeparator);
    }
}
