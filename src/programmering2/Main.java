package programmering2;

public class Main {
	
	public static void main(String[] args){
		
        Valuable v1 = new Jewelery("smycket1", 5, true);
        Valuable v2 = new Stock("aktie1", 120, 100.00);
        Valuable v3 = new Apparatus("apparat1", 1000.0, 9);


        System.out.println(v1 + "\n" + v2 + "\n" + v3);

    }

}
