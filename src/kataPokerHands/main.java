package kataPokerHands;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// variables
		String black;
		String white;
		Hand h1;
		Hand h2;
		Game g;
		Scanner s = new Scanner(System.in);
		
		// begin game
		System.out.println("When entering a hand, please separate cards with a single space.");
		System.out.println("Enter First Player Hand (Black): ");
		black = s.nextLine();
		if(black.length() != 14){
			System.out.println("Black Hand entered incorrectly. Please enter 5 cards separated by a single space.");
			black = s.nextLine();
		}
		System.out.println("Enter Second Player Hand (White): ");
		white = s.nextLine();
		if(white.length() != 14){
			System.out.println("White Hand entered incorrectly. Please enter 5 cards separated by a single space.");
			white = s.nextLine();
		}
		
		h1 = new Hand(black);
		h2 = new Hand(white);
		g = new Game(h1,h2);
		System.out.println(g.CompareHands());
	}

}