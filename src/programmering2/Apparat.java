package programmering2;

public class Apparat extends Värdesak {

    private double pris;
    private int slitage;

    public Apparat(String namn, double pris, int slitage) {
        super(namn);
        this.pris = pris;
        this.slitage = slitage;
    }

    public double getPris() {
        return pris;
    }

    public int getSlitage() {
        return slitage;
    }

    @Override
    public double värde() {
        return pris*slitage/10;
    }

    @Override
    public String toString() {
        // Lägger moms i alla toString() metoder och inte tidigare. Har du en bättre idé, shoot.
        return "Apparat: " + getNamn() + " Värde: " + (värde()*MOMS) + " Pris: " + pris + " Slitage: " + slitage;
    }
}
