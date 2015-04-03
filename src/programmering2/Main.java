package programmering2;

public class Main {
	
	public static void main(String[] args){
		
        Värdesak v1 = new Smycke("smycket1", 5, true);
        Värdesak v2 = new Aktie("aktie1", 120, 100.00);
        Värdesak v3 = new Apparat("apparat1", 1000.0, 9);


        System.out.println(v1 + "\n" + v2 + "\n" + v3);

    }

}
