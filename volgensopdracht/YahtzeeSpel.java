package volgensopdracht;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;


// een passief-agressief spel
public class YahtzeeSpel {
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();
	boolean[] blokkeerArray = {false, false, false, false, false};
	boolean gameIsActive = true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// START GAME
		System.out.println("Nou, fantastisch, je gaat Yahtzee spelen.");
		YahtzeeSpel ys = new YahtzeeSpel();
		
		System.out.println("blokkeerarray aan het begin: " + Arrays.toString(ys.blokkeerArray));
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
		
		//Speler bob = new Speler("Bob");
		//Speler cookie = new Speler("Cookie");
		
		
		
	}
	
	public void spelen(){
		
		// GAME LOOP
		
		while(gameIsActive){
			System.out.println("geef je input: (g) om te gooien, (q) for quitters");
			String spelerInput = sc.nextLine();
			switch (spelerInput){
			case "g": 
				resetBlokkeerArray();
				werpAlleDobbelstenen();
				vasthouden();
				werpGekozenDobbelstenen();
				Worp.geefUitslagWeer(dobbelstenen);
				Speler bob = new Speler("Bob"); // test, moet eigenlijk in main
				Worp.voegWorpToeAanGeschiedenis(bob);
				bob.toonWorpGeschiedenis();
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
	
	public void werpAlleDobbelstenen(){

		for (int i = 0; i < dobbelstenen.size(); i++){
			dobbelstenen.get(i).waarde = dobbelstenen.get(i).werpen();
			System.out.print(dobbelstenen.get(i).waarde); // test
			
		}
	}
	
	public void werpGekozenDobbelstenen(){
		//System.out.println(Arrays.toString(nieuweWorp)); //test
		
		for (int i = 0; i < dobbelstenen.size(); i++){
			if (blokkeerArray[i] == false){
				dobbelstenen.get(i).waarde = dobbelstenen.get(i).werpen();
				//System.out.println("nieuwe dobbelsteen met waarde " + dobbelstenen.get(i).waarde); // test
			}
		}
		Worp.stenen = dobbelstenen;
	}
	

	public void vasthouden(){
		
		System.out.println("\nOp welke posities wil je dobbelstenen vasthouden? (typ 0 voor geen)");
		String input = sc.nextLine();
		String vastgehoudenStenen = "";

		if (input.equals("0")){
			System.out.println("Geen enkele dobbelsteen is goed genoeg voor je?");
		} else{
			for (int i = 0; i < input.length(); i++){
				int convertedInput = Integer.parseInt(input.substring(i, i+1)) - 1; //input komt binnen als String, maar moet eerst een integer worden
				// System.out.println("convertedinput: " + convertedInput); //test
				blokkeerArray[convertedInput] = true;
				
				vastgehoudenStenen += dobbelstenen.get(convertedInput).waarde;
				// System.out.println("blokkeerarray op dit moment: " + Arrays.toString(blokkeerArray)); //test
				// System.out.println("blub:" + vastgehoudenStenen); //test 
			}
			//System.out.println("blokkeerarray totaal " + Arrays.toString(blokkeerArray)); // test
			System.out.println("vastgehouden dobbelstenen: " + vastgehoudenStenen + "\n"); //test
		}
		
	
	}
	
	public void resetBlokkeerArray(){
		for (int i = 0; i < blokkeerArray.length; i++){
			blokkeerArray[i] = false;
		}
	}

}
