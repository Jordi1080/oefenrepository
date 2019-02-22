package volgensopdracht;

import java.util.ArrayList;

public class Worp {
int array = 5;
static ArrayList<Dobbelsteen> stenen = new ArrayList<Dobbelsteen>();
//static int[] steenWaardes;
	
	
	public Worp(){
		
	}
	
	//public static int[] 
	
	public static void geefUitslagWeer(ArrayList<Dobbelsteen> ald){
		String res = "";
		// iets met array
		for (Dobbelsteen d : ald){
			res = res + d.waarde;
			//System.out.println("tot nu toe " + res); //test
		}
		
		System.out.println("Worp: " + res + "\n");
	}
	
	/* zelfde als hierboven?
	public String naarString(){
		String res = "";
		
		return res;
	}
	*/
	
	public static void voegWorpToeAanGeschiedenis(Speler sp){
		for (Dobbelsteen d : stenen){
			sp.worpGeschiedenis += "hue";//d.waarde;
		}
	}
	
}
