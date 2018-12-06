package kataPokerHands;

public class Game {
	Hand p1;
	Hand p2;
	int gameWinning;
	public Game(Hand h1, Hand h2){
		p1 = h1;
		p2 = h2;
	}
	public String CompareHands(){
		String winningHand;
		p1.computeHand();
		p2.computeHand();
		
		// if no tie, black has higher hand
		if(p1.handValue < p2.handValue){
			return "Black wins with " + p1.winningHandType +": "  + p1.getRankString(p1.highestRank);
		}
		// if no tie, white has higher hand
		if(p1.handValue > p2.handValue){
			return "White wins with " + p2.winningHandType +": " + p2.getRankString(p2.highestRank);
		}
		// if they have the same hand but different high cards
		if(p1.handValue == p2.handValue){
			if(p1.highestRank < p2.highestRank){
				return "Black wins with " + p1.winningHandType +": "  + p1.getRankString(p1.highestRank);
			}
			if(p1.highestRank > p2.highestRank){

				return "White wins with " + p2.winningHandType +": " + p2.getRankString(p2.highestRank);
			}
			// if they both have high card hands and the same high card
			if((p1.handValue == 9 && p2.handValue == 9) && p1.highestRank == p2.highestRank){
				if(p1.ranks[1] < p2.ranks[1]){
					return "Black wins with " + p1.winningHandType +": "  + p1.getRankString(p1.ranks[1]);
				}
				if(p1.ranks[1] > p2.ranks[1]){

					return "White wins with " + p2.winningHandType +": " + p2.getRankString(p2.ranks[1]);
				}
			}
			// if they have the same hand and same high card
			if (p1.highestRank == p2.highestRank){
				return "TIE";
			}
		}
		return "NO WINNER YET";
	}
}
