import java.util.ArrayList;

/**
 * Created by Josh on 1/24/17.
 */
public class Transaction {

    private static int transactionNo = 0;
    private ArrayList<Order> orders;

    public Transaction() {
        transactionNo++;
        orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order o) {
        orders.add(o);
    }

}
