package programmering2;

public class Apparatus extends Valuable {

    private double price;
    private int wear;

    public Apparatus(String name, double price, int wear) {
        super(name);
        this.price = price;
        this.wear = wear;
    }

    public double getPrice() {
        return price;
    }

    public int getWear() {
        return wear;
    }

    @Override
    public double value() {
        return price*wear/10;
    }

    @Override
    public String toString() {
        // Lägger moms i alla toString() metoder och inte tidigare. Har du en bättre idé, shoot.
        return "Apparat: " + getName() + " Värde: " + (value()*MOMS) + " Pris: " + price + " Slitage: " + wear;
    }
}
