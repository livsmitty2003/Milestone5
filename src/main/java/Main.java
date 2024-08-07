
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This shopping experience allows the user to interact with a storefront. While shopping, they
 * will be able to purchase products, return products, check credit balance and view a list of
 * sorted items.
 */
public class Main {

    //Writes product inventory array to 'products.txt'
    static void writeToFile(List<Product> arr) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("products.txt"), arr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void sortLists(List<Product> arr) {
        //Sort and Print by name, ascending
        System.out.printf("\nAscending by Name: \n");
        //Print by name: Ascending
        for (int i = 0; i < arr.size(); i++) {
            String name = arr.get(i).getName();
            Double price = arr.get(i).getPrice();
            GenericPrinter gPrinter = new GenericPrinter(name, price);
            gPrinter.printPair();
        }
        //Sort & Print by price, ascending
        arr.sort(Comparator.comparing(Product::getPrice));
        System.out.printf("\nAscending by Price: \n");
        for (int i = 0; i < arr.size(); i++) {
            String name = arr.get(i).getName();
            Double price = arr.get(i).getPrice();
            GenericPrinter gPrinter = new GenericPrinter(name, price);
            gPrinter.printPair();
        }
        //Sort and Print by name, descending
        Collections.sort(arr, Collections.reverseOrder());
        System.out.printf("\nDescending by Name: \n");
        //Print list: Descending by Name
        for (int i = 0; i < arr.size(); i++) {
            String name = arr.get(i).getName();
            Double price = arr.get(i).getPrice();
            GenericPrinter gPrinter = new GenericPrinter(name, price);
            gPrinter.printPair();
        }
        //Sort and Print by price, descending
        List<Product> sortedList = arr.stream()
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

    public static void printHeader() {
        System.out.println((String.format("%-8s","ID") + (String.format("%-20s", "PRODUCT NAME")) + (String.format("%-55s", "DESCRIPTION")) + (String.format("%-20s", "PRICE")) + (String.format("%-20s", "IN STOCK"))));
    }

    public static void printList(List<Product> arr) {
        String lineSeparator = System.lineSeparator();

        for (int i = 0; i < arr.size(); ++i) {
            System.out.print(i+1 + ": \t\t" + arr.get(i).toString() + " " + lineSeparator);
        }
    }
    public static void Sale(Product saleItem) {
        saleItem.onSale(saleItem.name);
    }

    public static void main(String[] args) throws IOException {

        //Declare variables/Arrays
        String lineSeparator = System.lineSeparator();
        double points = 100.0;


        //Create Product Inventory List
        List<Product> prodArray = new ArrayList<>();
        prodArray.add(new Armor("Super Suit", "Protects wearer from all types of devastation.", 50.0, 6, 1));
        prodArray.add(new Armor("Lazy Shell", "Hide under it for absolute invisibility.", 30.0, 4, 2));
        prodArray.add(new Weapon("Frying Pan", "Slay any attacker that comes your way.", 25.0, 7, 3));
        prodArray.add(new Weapon("Punch Glove", "Knock any foe down with a triple punch.", 30.0, 3, 4));
        prodArray.add(new Health("Chicken Leg", "Enjoy a protein punch.", 20.0, 2, 5));
        prodArray.add(new Health("Spinach", "Up your vitamins with rich greens.", 20.0, 2, 6));
        prodArray.add(new Health("Elixir", "Supercharge your tired self with a powerful potion", 20.0, 2, 7));
        Collections.sort(prodArray);

        //Creates and initializes Shopping Cart
        List<ShoppingCart> cartArray = new ArrayList<>();
        cartArray.add(new ShoppingCart("null", "null", 0.0));


        //Calls method that writes inventory list to 'products.txt' and to console
        writeToFile(prodArray);

        //prints inventory list from 'products.txt'
        try {
            File myObj = new File("products.txt");
            Scanner myReader = new Scanner(myObj);
            int k = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // System.out.println(data);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //Begin shopping experience. Take input from user.
        Scanner obj = new Scanner(System.in);
        System.out.println("Welcome to the Game Stop. If you see a product you like, press 'y' for yes? Otherwise, press 'n' for no.");

        //Possible actions based on user input
        String choice = obj.nextLine();
        if (choice.equals("y")) {
            printHeader();
            printList(prodArray);
        }

        System.out.println("\nPress 'p' to purchase product" + lineSeparator + "Press 'v' to view lists sorted by name/price" + lineSeparator + "Press 'c' to check credits" + lineSeparator + "Press 'e' to exit." + lineSeparator + "Press 's' to see what's on sale.");
        choice = obj.nextLine();

        if (choice.equals("v")) {
            prodArray.sort(Comparator.comparing(Product::getName));
            sortLists(prodArray);
        }

        if (choice.equals("c")) {
            System.out.println("You have " + points + " points.");
        }

        if (choice.equals("s")) {
            System.out.println("The following items are on sale: " + lineSeparator);
            Sale(prodArray.get(3));
            Sale(prodArray.get(4));
        }

        if (choice.equals("p")) {
            System.out.println("Enter the ID of the prodArray you wish to purchase.");
            int choiceID = obj.nextInt();
           int item = choiceID - 1;
            points -= prodArray.get(item).price;
            prodArray.get(item).reduceQuantity();
            cartArray.add(new ShoppingCart(prodArray.get(item).name, prodArray.get(item).description, prodArray.get(item).price));
        //    PrintStream var10000 = System.out;
           // String var10001 = cartArray[0].getName();
            System.out.println("The following item is in your cart: " + prodArray.get(item).name + ".  You're point balance is: " + points + System.lineSeparator());
            System.out.println("Buyer's remorse? Click 'y' to return. Click 'l' to check out the inventory");
            choice = obj.next();
            if (choice.equals("y")) {
                prodArray.get(item).increaseQuantity();
                points += prodArray.get(item).price;
                cartArray.add(new ShoppingCart("empty", "empty", 0.0));
                System.out.println("You're cart is empty. You're point balance is: " + points + System.lineSeparator());
            }

            if (choice.equals("l")) {
                printHeader();
                printList(prodArray);
                }
            }


            if (choice.equals("e")) {
                System.out.println("Thank you for checking out our inventory. Come back soon!");
            }
        }
    }









