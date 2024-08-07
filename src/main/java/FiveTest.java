import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FiveTest {


    public static void main(String[] args) {
        //Create product array list
        List<Product> prodArray = new ArrayList<>();
        prodArray.add(new Armor("Super Suit", "Protects wearer from all types of devastation.", 50.0, 6, 1));
        prodArray.add(new Armor("Lazy Shell", "Hide under it for absolute invisibility.", 30.0, 4, 1));
        prodArray.add(new Weapon("Frying Pan", "Slay any attacker that comes your way.", 25.0, 7, 3));
        prodArray.add(new Weapon("Punch Glove", "Knock any foe down with a triple punch.", 30.0, 3, 3));
        prodArray.add(new Health("Chicken Leg", "Enjoy a protein punch.", 20.0, 2, 5));
        prodArray.add(new Health("Spinach", "Up your vitamins with rich greens.", 20.0, 2, 5));
        prodArray.add(new Health("Elixir", "Supercharge your tired self with a powerful potion", 20.0, 2, 5));


        //Sort by name, ascending
        prodArray.sort(Comparator.comparing(Product::getName));
        System.out.printf("\nAscending by Name: \n");
        //Print by name: Ascending
        for (int i = 0; i < prodArray.size(); i++) {
            String name = prodArray.get(i).getName();
            Double price = prodArray.get(i).getPrice();
            GenericPrinter gPrinter = new GenericPrinter(name, price);
            gPrinter.printPair();
        }

        //Sort by price, ascending
        prodArray.sort(Comparator.comparing(Product::getPrice));
        System.out.printf("\nAscending by Price: \n");
        for (int i = 0; i < prodArray.size(); i++) {
            String name = prodArray.get(i).getName();
            Double price = prodArray.get(i).getPrice();
            GenericPrinter gPrinter = new GenericPrinter(name, price);
            gPrinter.printPair();
        }

        //Sort by name, descending
        Collections.sort(prodArray, Collections.reverseOrder());
        System.out.printf("\nDescending by Name: \n");
        //Print list: Descending by Name
        for (int i = 0; i < prodArray.size(); i++) {
            String name = prodArray.get(i).getName();
            Double price = prodArray.get(i).getPrice();
            GenericPrinter gPrinter = new GenericPrinter(name, price);
            gPrinter.printPair();
        }

        //Sort by price, descending
        List<Product> sortedList = prodArray.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
        //print list: Descending by Price
        System.out.printf("\nDescending by Price: \n");
        for (int i = 0; i < sortedList.size(); i++) {
            String name = sortedList.get(i).getName();
            Double price = sortedList.get(i).getPrice();
            GenericPrinter gPrinter = new GenericPrinter(name, price);
            gPrinter.printPair();
        }
    }
}
