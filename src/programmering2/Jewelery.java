package programmering2;

public class Jewelery extends Valuable {

    private int rocks;
    private boolean ofGold = false;

    public Jewelery(String name, int rocks, boolean ofGold) {
        super(name);
        this.rocks = rocks;
        this.ofGold = ofGold;
    }

    public int getRocks() {
        return rocks;
    }

    public boolean isGold() {
        return ofGold;
    }

    @Override
    public double value() {
        // Kolla om det är gjort av guld eller inte, och lägger till värdet av stenarna
        double value;
        if (ofGold) {
            value = 2000;
        } else {
            value = 700;
        }

        value += rocks * 500;
        return value;
    }

    public String toString() {
        // Kollar om smycket är gjort av guld. Skriver ut guld/silver vid slutet beroende på boolean variabel.
        // Lägger moms i alla toString() metoder och inte tidigare. Har du en bättre idé, shoot.
        if (ofGold) {
            return "Smycke: " + getName() + " Värde: " + (value()*MOMS) + " Stenar: " + rocks + " Guld";
        } else {
            return "Smycke: " + getName() + " Värde: " + (value()*MOMS) + " Stenar: " + rocks + " Silver";
        }
    }

}
