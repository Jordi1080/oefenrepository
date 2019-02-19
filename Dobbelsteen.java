import java.util.Random;

public class Dobbelsteen {

	public Dobbelsteen(){
		
	}
	
	// gooi de dobbelsteen
	public int werpen(){
		int worp;
		Random rng = new Random();
		
		worp = rng.nextInt(6) + 1;
		return worp;
	}
}
