package programmering2;

public class Smycke extends Värdesak {

    private int stenar;
    private boolean avGuld = false;

    public Smycke(String namn, int stenar, boolean avGuld) {
        super(namn);
        this.stenar = stenar;
        this.avGuld = avGuld;
    }

    public int getStenar() {
        return stenar;
    }

    public boolean isAvGuld() {
        return avGuld;
    }

    @Override
    public double värde() {
        // Kolla om det är gjort av guld eller inte, och lägger till värdet av stenarna
        double värde;
        if (avGuld) {
            värde = 2000;
        } else {
            värde = 700;
        }

        värde += stenar * 500;
        return värde;
    }

    public String toString() {
        // Kollar om smycket är gjort av guld. Skriver ut guld/silver vid slutet beroende på boolean variabel.
        // Lägger moms i alla toString() metoder och inte tidigare. Har du en bättre idé, shoot.
        if (avGuld) {
            return "Smycke: " + getNamn() + " Värde: " + (värde()*MOMS) + " Stenar: " + stenar + " Guld";
        } else {
            return "Smycke: " + getNamn() + " Värde: " + (värde()*MOMS) + " Stenar: " + stenar + " Silver";
        }
    }

}
