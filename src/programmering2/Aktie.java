package programmering2;

public class Aktie extends Värdesak {

    private int antal;
    private double kurs;

    public Aktie(String namn, int antal, double kurs) {
        super(namn);
        this.antal = antal;
        this.kurs = kurs;
    }

    public int getAntal(){
        return antal;
    }

    public double getKurs(){
        return kurs;
    }

    public void setKurs(double kurs) {
        this.kurs = kurs;
    }

    @Override
    public double värde(){
        return antal*kurs;
    }

    public String toString(){
        // Lägger moms i alla toString() metoder och inte tidigare. Har du en bättre idé, shoot.
        return "Aktie: " + getNamn() + " Värde: " + (värde()*MOMS) + " Antal: " + antal + " Kurs: " + kurs;
    }

}
