//class Product
public class Product {
    private String ID;
    private String name;
    private double price;
    private int qty;

    public Product(String ID, String name, double price, int qty) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        String s = String.format("|  %-20s |  %-20s  |  %-20.1f  |  %-20d  |",ID,name,price,qty);
        return s;
    }
}
