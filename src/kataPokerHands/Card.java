package kataPokerHands;

public class Card {
	// variables
	char value;
	char suit;
	int rank;

	// constructor
	public Card(String entry){
		// set from user entry
		value = entry.charAt(0);
		suit = entry.charAt(entry.length()-1);
		
		switch(value){
			case 'A':
				rank = 1;
				break;
			case 'K':
				rank = 2;
				break;
			case 'Q':
				rank = 3;
				break;
			case 'J':
				rank = 4;
				break;
			case 'T':
				rank = 5;
				break;
			case '9':
				rank = 6;
				break;
			case '8':
				rank = 7;
				break;
			case '7':
				rank = 8;
				break;
			case '6':
				rank = 9;
				break;
			case '5':
				rank = 10;
				break;
			case '4':
				rank = 11;
				break;
			case '3':
				rank = 12;
				break;
			case '2':
				rank = 13;
				break;
		}
	}
	
	
	// ---------------------------------------
	// getters and setters
	// ---------------------------------------
	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public char getSuit() {
		return suit;
	}

	public void setSuit(char suit) {
		this.suit = suit;
	}
	
	public int getRank(int rank){
		return rank;
	}
	
}
	
