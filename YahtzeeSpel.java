import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;


// een passief-agressief spel
public class YahtzeeSpel {
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();
	//blokkeerArray??
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// START GAME
		System.out.println("Nou, fantastisch, je gaat Yahtzee spelen.");
		YahtzeeSpel ys = new YahtzeeSpel();
		
		ys.spelen();

		/*
		System.out.println(ys.werpAlleDobbelstenen());
		boolean[] vasteStenen = ys.vasthouden();
		System.out.println(ys.werpGekozenDobbelstenen(vasteStenen));
		*/
		
	}
	
	public YahtzeeSpel(){
		// maak alle dobbelstenen, en voeg ze toe aan de ArrayList
		Dobbelsteen d1 = new Dobbelsteen();
		Dobbelsteen d2 = new Dobbelsteen();
		Dobbelsteen d3 = new Dobbelsteen();
		Dobbelsteen d4 = new Dobbelsteen();
		Dobbelsteen d5 = new Dobbelsteen();
		
		dobbelstenen.add(d1);
		dobbelstenen.add(d2);
		dobbelstenen.add(d3);
		dobbelstenen.add(d4);
		dobbelstenen.add(d5);
		
		Speler bob = new Speler("Bob");
		Speler cookie = new Speler("Cookie");
		
		
		
	}
	
	public void spelen(){
		
		// GAME LOOP
		System.out.println("geef je input");
		while(sc.hasNextLine()){
			String spelerInput = sc.nextLine();
			switch (spelerInput){
			case "g": 
				werpAlleDobbelstenen();
				boolean[] vastgehouden = vasthouden();
				int[] nieuweWorp = werpGekozenDobbelstenen(vastgehouden);
				break;
			case "q":
				System.out.println("Geen zorgen, niet iedereen kan even goed tegen zijn verlies.");
				System.exit(0);
				break;
			default:
				System.out.println("Kijk nog eens goed naar wat de opties waren...");
				// break; niet?
			}
		}
	}
	
	public int[] werpAlleDobbelstenen(){
		int[] worp = {-1, -1, -1, -1, -1};
				
		
		/*
		// zou dit werken? versie 1
		for (Dobbelsteen d : dobbelstenen){
			// ??? hoe vraag je hier de index van de ArrayList?
			worpen[dobbelstenen.indexOf(d)] = d.werpen();
			System.out.println("Dobbelsteen " + d + ": " + worpen[dobbelstenen.indexOf(d)]);
		}
		return worpen;
		*/
		
		// alternatieve versie (moet nog getest worden)
		for (int i = 0; i < dobbelstenen.size(); i++){
			// ??? hoe vraag je hier de index van de ArrayList?
			worp[i] = dobbelstenen.get(i).werpen();
			System.out.print(worp[i] + " ");
			
			
		}
		return worp;
	}
	
	public int[] werpGekozenDobbelstenen(boolean[] vastgehoudenStenen){
		int[] nieuweWorp = Worp.steenWaardes;
		System.out.println(Arrays.toString(nieuweWorp)); //test
		
		for (int i = 0; i < dobbelstenen.size(); i++){
			if (vastgehoudenStenen[i] == false){
				nieuweWorp[i] = dobbelstenen.get(i).werpen();
				System.out.print(nieuweWorp[i] + " ");
			}
		}
		System.out.println("uiteindelijke nieuwe worp: " + nieuweWorp); //test
		return nieuweWorp;
	}
	

	public boolean[] vasthouden(){
		boolean[] welkeVasthouden = {false, false, false, false, false};
		
		System.out.println("Welke dobbelstenen wil je vasthouden? (typ 0 voor geen)");
		String input = sc.nextLine();
		
		if (input.length() < 6){
			for (int i = 0; i < input.length(); i++){
				int convertedInput = Integer.parseInt(input.substring(i, i+1)) - 1; //input komt binnen als String, maar moet eerst een integer worden
				welkeVasthouden[convertedInput] = true;
			}
		}
		System.out.println(Arrays.toString(welkeVasthouden)); // methode nodig om arrays te printen
		
		for (int i = 0; i < dobbelstenen.size(); i++){ 
			if (welkeVasthouden[i] == true){
				
			}
			System.out.println("vastgehouden dobbelstenen: " + Arrays.toString(welkeVasthouden));
		}
		return welkeVasthouden;
	}

}
