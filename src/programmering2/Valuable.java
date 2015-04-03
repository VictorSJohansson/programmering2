package programmering2;

public abstract class Valuable {

    // Protected då vi ska använda den på alla toString() metoder (vet inte om det här är det bästa sättet att göra det)
    protected final double MOMS = 1.25;
    private String name;

    public Valuable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double value();

}
