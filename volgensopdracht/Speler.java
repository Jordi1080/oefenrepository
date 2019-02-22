package volgensopdracht;
import java.util.ArrayList;
import java.util.List;


public class Speler {
	
	String naam;
	String worpGeschiedenis = "";
	int[] laatsteWorp;
	int worpTeller = 0;
	
	public Speler(String naam){
		this.naam = naam;
		System.out.println(worpGeschiedenis);
	}
	
	// set
	public void setNaam(String naam){
		// 
		this.naam = naam;
	}
	
	public void toonWorpGeschiedenis(){

		for (Dobbelsteen d : Worp.stenen){
			worpGeschiedenis = worpGeschiedenis + d.waarde;
			//System.out.println("tot nu toe " + worpGeschiedenis); //test
		}
		
		System.out.println("Worpgeschiedenis: " + worpGeschiedenis + "\n");
	}

}
