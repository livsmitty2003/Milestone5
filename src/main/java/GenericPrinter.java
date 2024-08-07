
/**
 *
 * This is a generic printing class. It accepts two parameter and prints
 * items to console in a formatted print statement.
 */
import java.text.NumberFormat;

public class GenericPrinter <N, P>{
    //Decare variables
    private N name;
    private P price;

    //Currency formatter
    NumberFormat formatMoney = NumberFormat.getCurrencyInstance();

    public GenericPrinter(N name, P price) {
        this.name = name;
        this.price = price;
    }
    public void printPair() {
        System.out.println(String.format("%-20s", name +":")
                + "\t" + formatMoney.format(price));
    }
    public N getName() {
        return name;
    }
    public void setName(N name) {
        this.name = name;
    }
    public P getPrice() {
        return price;
    }
    public void setPrice(P price) {
        this.price = price;
    }
}
