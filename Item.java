/**
 * Created by Josh on 1/24/17.
 */
public class Item {

    private int numOfItems;
    private String descrip;
    private double origPrice;
    private double taxOnItem;
    private double priceWithTax;

    public Item(int numOfItems, String descrip, double origPrice, double taxOnItem, double priceWithTax) {
        this.numOfItems = numOfItems;
        this.descrip = descrip;
        this.origPrice = origPrice;
        this.taxOnItem = taxOnItem;
        this.priceWithTax = priceWithTax;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public String getDescrip() {
        return descrip;
    }

    public double getOrigPrice() {
        return origPrice;
    }

    public double getTaxOnItem() {
        return taxOnItem;
    }

    public double getPriceWithTax() {
        return priceWithTax;
    }

    public void setNumOfItems(int num) {
        numOfItems += num;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public void setOrigPrice(double origPrice) {
        this.origPrice = origPrice;
    }

    public void setTaxOnItem(double taxOnItem) {
        this.taxOnItem = taxOnItem;
    }

    public void setPriceWithTax(double priceWithTax) {
        this.priceWithTax = priceWithTax;
    }
}
