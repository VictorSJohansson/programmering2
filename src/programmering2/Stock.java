package programmering2;

public class Stock extends Valuable {

    private int quantity;
    private double price;

    public Stock(String name, int quantity, double price) {
        super(name);
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double value(){
        return quantity*price;
    }

    public String toString(){
        // Lägger moms i alla toString() metoder och inte tidigare. Har du en bättre idé, shoot.
        return "Aktie: " + getName() + " Värde: " + (value()*MOMS) + " Antal: " + quantity + " Kurs: " + price;
    }

}
