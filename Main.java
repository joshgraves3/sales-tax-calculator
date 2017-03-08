import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Josh on 1/24/17.
 */
public class Main {

    private static Order o = new Order();
    private static Transaction t;

    public static void main(String[] args) {

        //get user input for the data to read
        readFile();

    }

    private static void readFile() {

        boolean moveOn = false;

        while(!moveOn) {

            System.out.print("Enter the text file you would like to load: ");

            try {

                //make a new transaction for each text file the user wants to instantiate
                t = new Transaction();

                //get user input for the text file
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                String file = input.readLine();

                System.out.println("\n");

                //read from the text file
                FileReader reader = new FileReader(file);
                BufferedReader fileReader = new BufferedReader(reader);

                //boolean to control bad file input
                moveOn = true;

                String line;

                //load each row of data into an array
                while ((line = fileReader.readLine()) != null) {
                    createItem(line);
                }

                //print out data for each order
                for(Order o : t.getOrders()) {
                    o.calculateOrderTotals();
                }

                boolean newFile = true;

                while(newFile) {
                    //ask user if they want to go through another input file
                    System.out.print("\nWould you like to process another file?\nEnter 'y' or 'n': ");
                    file = input.readLine();

                    //check what the user wants to do
                    if (file.toLowerCase().equals("y")) {
                        newFile = false;
                        moveOn = false;
                    }
                    else if (file.toLowerCase().equals("n")){
                        newFile = false;
                        fileReader.close();
                        input.close();
                    }
                    else {
                        System.out.println("That is not a valid input, please enter 'y' or 'n'.");
                    }
                }

            } catch (IOException io) {
                System.out.println("There was an error reading the file. Please make sure it is a working directory.");
            }
        }
    }

    private static void createItem(String s) {

        //orders are separated by "**" at the end of the file
        if(s.equals("**")) {

            //add the order to the transaction and set up a new order
            t.addOrder(o);
            o = new Order();
        }
        else {

            String[] arr;
            StringBuilder description = new StringBuilder();

            /*
             * set tax percentages based on the type of item
             * default percentage is 10
             * provided more data I could create a dictionary for more keywords instead of the 4 I have here, so that the application would be more flexible
            */
            int taxPercentage = 10;

            if (s.contains("book")) {
                taxPercentage -= 10;
            }
            if (s.contains("pills")) {
                taxPercentage -= 10;
            }
            if (s.contains("chocolate")) {
                taxPercentage -= 10;
            }
            if (s.contains("import")) {
                taxPercentage += 5;
            }

            //split up each line into respective attributes
            arr = s.split(" ");

            //set description for the item
            for (int i = 0; i < arr.length - 1; ++i) {
                if (i < arr.length - 2) {
                    description.append(arr[i] + " ");
                } else {
                    description.append(arr[i] + ": ");
                }
            }

            //get all of the pricing and tax data and create items for each line
            try {
                //get quantity of items
                int quantity = Integer.parseInt(arr[0]);

                //get original price
                double originalPrice = Double.parseDouble(arr[arr.length - 1]);

                //get tax on specific item
                double itemTax = calculateItemTax(originalPrice, taxPercentage);

                //get price of item with tax
                double completePrice = Double.parseDouble(arr[arr.length - 1]) + itemTax;
                completePrice = Math.round(completePrice * 100.0) / 100.0;

                //add each item to the order
                Item orderItem = new Item(quantity, description.toString(), originalPrice, itemTax, completePrice);
                o.addItem(orderItem);

            } catch (NumberFormatException n) {
                //catch number format exceptions in the data
                System.out.println("There was an error in your data. Please check to make sure" +
                        " the data matches the format below and run the application again:\n\n" +
                        "quantity(int) + description(String) + price(double)\n\n" +
                        "Example:\n" +
                        "1 imported bottle of perfume at 47.50");
                System.exit(0);
            }
        }
    }

    //calculate the tax for each item
    private static double calculateItemTax(double itemPrice, int percent) {

        double itemTax;
        double tax = (itemPrice*percent)/100;

        // To round to the nearest .05, multiply by 20, round to the nearest integer, then divide by 20
        BigDecimal taxAmt = new BigDecimal(tax);
        BigDecimal roundedTax =  new BigDecimal(Math.ceil(taxAmt.doubleValue() * 20) / 20);
        roundedTax = roundedTax.setScale(2, RoundingMode.HALF_UP);

        itemTax = roundedTax.doubleValue();

        return itemTax;
    }

}
