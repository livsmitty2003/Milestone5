//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Product implements Comparable<Product>, Discount {
    public String name;
    public String description;
    public double price;
    public int quantity;
    public int productID;
    String lineSeparator = System.lineSeparator();

    public Product(String name, String description, double price, int quantity, int productID) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLineSeparator() {
        return lineSeparator;
    }

    public void setLineSeparator(String lineSeparator) {
        this.lineSeparator = lineSeparator;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String toString() {
        //        System.out.println(String.format("%-20s", name +":") + "\t" + formatMoney.format(price));
        String listItem = ((String.format("%-20s", this.name)) + (String.format("%-55s", this.description))+ (String.format("%-20s", this.price)) + (String.format("%-20s", this.quantity)));
        return listItem;
    }

    public void reduceQuantity() {
        --this.quantity;
    }

    public void increaseQuantity() {
        ++this.quantity;
        System.out.println("The  " + this.name + " has been returned.");
    }

    public int compareTo(Product o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    public void onSale(String i) {
        System.out.println(i + this.lineSeparator);
    }
}
