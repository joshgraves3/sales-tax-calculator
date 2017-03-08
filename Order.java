import java.util.ArrayList;
import java.text.NumberFormat;

/**
 * Created by Josh on 1/24/17.
 */
public class Order {

    private static int orderNo;
    private ArrayList<Item> items;

    private double orderTotal;
    private double orderSalesTax;

    public Order() {
        orderNo = 0;
        items = new ArrayList<>();
        orderTotal = 0;
        orderSalesTax = 0;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public double getOrderSalesTax() {
        return orderSalesTax;
    }

    public void incrementOrderTotal(double value) {
        orderTotal += value;
    }

    public void incrementOrderSalesTax(double value) {
        orderSalesTax += value;
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public void calculateOrderTotals() {
        //calculate the totals and format the values to be monetary
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        //order number increases for each order
        orderNo++;
        System.out.println("- " + "OrderNo: " + orderNo + " -");

        //cycle through the items in the order and add to the totals
        for(Item i : items) {

            incrementOrderTotal(i.getNumOfItems() * i.getPriceWithTax());
            incrementOrderSalesTax(i.getNumOfItems() * i.getTaxOnItem());

            System.out.println(i.getDescrip() + formatter.format(i.getPriceWithTax()));
        }

        //print out totals
        System.out.println("Sales taxes: " + formatter.format(Math.round(getOrderSalesTax() * 100.0) / 100.0));
        System.out.println("Order total: " + formatter.format(Math.round(getOrderTotal() * 100.0) / 100.0));
        System.out.println("\n");
    }

}
