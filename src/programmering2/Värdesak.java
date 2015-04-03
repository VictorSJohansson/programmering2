package programmering2;

public abstract class Värdesak {

    // Protected då vi ska använda den på alla toString() metoder (vet inte om det här är det bästa sättet att göra det)
    protected final double MOMS = 1.25;
    private String namn;

    public Värdesak(String namn) {
        this.namn = namn;
    }

    public String getNamn() {
        return namn;
    }

    public abstract double värde();

}
