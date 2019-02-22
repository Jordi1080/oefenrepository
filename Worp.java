import java.util.ArrayList;

public class Worp {
int array = 5;
static int[] steenWaardes;
	
	
	public Worp(){
		
	}
	
	//public static int[] 
	
	public static String geefUitslagWeer(ArrayList<Dobbelsteen> ald){
		String res = "";
		// iets met array
		for (Dobbelsteen d : ald){
			res = res + d.waarde + " \n";
			System.out.println(res);
			System.out.println("uitslagg");
		}
		
		
		return res;
	}
	
	/* zelfde als hierboven?
	public String naarString(){
		String res = "";
		
		return res;
	}
	*/
	
	
}
