import java.util.ArrayList;
import java.util.List;


public class Speler {
	
	String naam;
	List<Integer> worpGeschiedenis = new ArrayList<Integer>();
	int[] laatsteWorp;
	int worpTeller = 0;
	
	public Speler(String naam){
		this.naam = naam;
	}
	
	// set
	public void setNaam(String naam){
		// 
		this.naam = naam;
	}
	
	public void addToWorpGeschiedenis(YahtzeeSpel ys){
		// add de huidige worp aan de worpgeschiedenis
		int[] huidigeWorp = ys.werpAlleDobbelstenen();
		
	}

}
