import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;


// een passief-agressief spel
public class YahtzeeSpel {
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Dobbelsteen> dobbelstenen;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// START GAME
		System.out.println("Nou, fantastisch, je gaat Yahtzee spelen.");
		YahtzeeSpel ys = new YahtzeeSpel();
		
		ys.spelen();
		
	}
	
	public YahtzeeSpel(){
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
		
	}
	
	public void spelen(){
		
		// GAME LOOP
		System.out.println("geef je input");
		while(sc.hasNextLine()){
			String spelerInput = sc.nextLine();
			switch (spelerInput){
			case "g": 
				werpAlleDobbelstenen();
			case "q":
				System.out.println("Geen zorgen, niet iedereen kan even goed tegen zijn verlies.");
				System.exit(0);
			default:
				System.out.println("Kijk nog eens goed naar wat de opties waren...");
				// break; niet?
			}
		}
	}
	
	public int[] werpAlleDobbelstenen(){
		int[] worpen = {-1, -1, -1, -1, -1};
				
		for (Dobbelsteen d : dobbelstenen){
			d.werpen();
			worpen[d.get(dobbelstenen.index)]
		}
		return 
	}
	


}
