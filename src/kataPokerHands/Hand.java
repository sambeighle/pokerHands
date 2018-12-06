package kataPokerHands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hand {

	//variables
	ArrayList<Card> c = new ArrayList<Card>(5);
	public int[] ranks;
	public int highestRank;
	public int handValue;
	public String winningHandType;

	// constructor
	public Hand(String userEntry){
		// create cards
		Card c0 = new Card(userEntry.substring(0,2));
		Card c1 = new Card(userEntry.substring(3,5));
		Card c2  = new Card(userEntry.substring(6,8));
		Card c3 = new Card(userEntry.substring(9,11));
		Card c4 = new Card(userEntry.substring(12,14));

		// add cards to hand
		c.add(c0); 
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		ranks = ranks();

		// sort ranks array in ascending order
		Arrays.sort(ranks);
	}

	// methods

	// ------------------------------------------------------------
	// creates basic int array of the ranks of each card in the hand
	//--------------------------------------------------------------
	private int[] ranks(){
		int[] result = new int[5];
		for(int i = 0; i<c.size(); i++){
			result[i] = c.get(i).rank;
		}
		return result;
	}

	// ------------------------------------------------------------
	// checks rank values to see if four ranks are the same
	//--------------------------------------------------------------
	public boolean isFourOfAKind(){
		if(ranks[0]==ranks[3]){
			highestRank = ranks[0];
			return true;
		}
		if(ranks[1]==ranks[4]){
			highestRank = ranks[1];
			return true;
		}
		else return false;
	}

	// ------------------------------------------------------------
	// checks for three of a kind and not a full house
	//--------------------------------------------------------------
	public boolean isThreeOfAKind(){
		if(!isFourOfAKind()){
			if((ranks[0]==ranks[2]) && (ranks[3] != ranks[4])){
				highestRank = ranks[2];
				return true;
			}
			if(ranks[1]==ranks[3]){
				highestRank = ranks[2];
				return true;
			}
			if(ranks[2]==ranks[4] && (ranks[0] != ranks[1])){
				highestRank = ranks[2];
				return true;
			}
		}
		return false;
	}

	// ------------------------------------------------------------
	// checks for full house
	//--------------------------------------------------------------
	public boolean isFullHouse(){
		if(!isFourOfAKind()){
			if((ranks[0]==ranks[2]) && (ranks[3] == ranks[4])){
				highestRank = ranks[2];
				return true;
			}
			if(ranks[2]==ranks[4] && (ranks[0] == ranks[1])){
				highestRank = ranks[2];
				return true;
			}
		}
		return false;
	}

	// ------------------------------------------------------------
	// checks for flush
	//--------------------------------------------------------------
	public boolean isFlush(){
		int i = 0;
		int test = 0;
		while(i < c.size()-1){
			if(c.get(i).getSuit() == c.get(i+1).getSuit()){
				test++;
			}
			i++;
		}
		if (test==4) {
			highestRank = ranks[0];
			return true;
		}
		else return false;
	}

	// ------------------------------------------------------------
	// checks for straight
	//--------------------------------------------------------------
	public boolean isStraight(){
		int i = 0;
		int test = 0;
		while(i < c.size()-1) {
			if(ranks[i+1]==1+ranks[i]){ 
				test++;
			}
			i++;
		}
		if (test==4) {
			highestRank = ranks[0];
			return true;
		}
		else return false;
	}

	// ------------------------------------------------------------
	// checks for straight flush
	//--------------------------------------------------------------
	public boolean isStraightFlush(){
		if(isStraight() && isFlush()){
			highestRank = ranks[0];
			return true;
		}
		else return false;
	}

	// ------------------------------------------------------------
	// checks for TwoPairs
	//--------------------------------------------------------------
	public boolean isTwoPairs(){
		int i = 0;
		int[] pairRank = new int[5];
		int test = 0;
		if(!isThreeOfAKind() && !isFourOfAKind()){
			while(i < c.size()-1) {
				if(ranks[i]==ranks[i+1]){ 
					pairRank[test] = ranks[i];
					test++;
				}
				i++;
			}
			if (test==2) {
				Arrays.sort(pairRank);
				highestRank = pairRank[0];
				return true;
			}
		}
		return false;
	}

	// ------------------------------------------------------------
	// checks for onePair
	//--------------------------------------------------------------
	public boolean isOnePair(){
		int i = 0;
		int test = 0;
		if(!isThreeOfAKind() && !isFourOfAKind() && !isTwoPairs()){
			while(i < c.size()-1) {
				if(ranks[i]==ranks[i+1]){ 
					highestRank = ranks[i];
					test++;
				}
				i++;
			}
			if (test==1) {
				return true;
			}
		}
		return false;
	}
	// ------------------------------------------------------------
	// get high Card
	//--------------------------------------------------------------
	public int getHighCard(){
		highestRank = ranks[0];
		return ranks[0];
	}

	// ------------------------------------------------------------
	// finds winning card and converts to string
	//--------------------------------------------------------------
	public String getRankString(int rank){
		String rankName = "";
		switch(rank){
		case 1:
			rankName = "Ace";
			break;
		case 2:
			rankName = "King";
			break;
		case 3:
			rankName = "Queen";
			break;
		case 4:
			rankName = "Jack";
			break;
		case 5:
			rankName = "10";
			break;
		case 6:
			rankName = "9";
			break;
		case 7:
			rankName = "8";
			break;
		case 8:
			rankName = "7";
			break;
		case 9:
			rankName = "6";
			break;
		case 10:
			rankName =  "5";
			break;
		case 11:
			rankName = "4";
			break;
		case 12:
			rankName = "3";
			break;
		case 13:
			rankName =  "2";
			break;
		}
		return rankName;
	}


	// ------------------------------------------------------------
	// compute type of hand
	//--------------------------------------------------------------
	public int computeHand(){
		if(isStraightFlush()){
			winningHandType = "Straight Flush";
			return handValue = 1;
		}
		if(isFourOfAKind()){
			winningHandType = "Four of a Kind";
			return handValue = 2;
		}
		if(isFullHouse()){
			winningHandType = "Full House";
			return handValue = 3;
		}
		if(isFlush()){
			winningHandType = "Flush";
			return handValue = 4;
		}
		if(isStraight()){
			winningHandType = "Straight";
			return handValue = 5;
		}
		if(isThreeOfAKind()){
			winningHandType = "Three of a Kind";
			return handValue=6;
		}
		if(isTwoPairs()){
			winningHandType = "Two Pairs";
			return handValue=7;
		}
		if(isOnePair()){
			winningHandType = "One Pair";
			return handValue = 8;
		}
		else {
			getHighCard();
			winningHandType = "High Card";
			return handValue = 9;
		}
	}
}

