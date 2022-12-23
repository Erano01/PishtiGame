package me.serterano.com.Entities;

public class Card {
	
	private RANK rank;
	private SUIT suit;
	
	private String cardName;

	public Card(int rank,int suit) {
        
        if (rank < 0 || rank >= RANK.values().length) {
            throw new IllegalArgumentException("Invalid rank: " + rank);
        }
        if (suit < 0 || suit >= SUIT.values().length) {
            throw new IllegalArgumentException("Invalid suit: " + suit);
        }
        
     // map the integer values to the corresponding enum values
        this.rank = RANK.values()[rank];
        this.suit = SUIT.values()[suit];
        
        String rankString = this.rank.getStringValue();
        String suitString = this.suit.getStringValue();
        
        cardName = rankString+suitString;
//        this.color = COLOR.values()[color];  
	}
	
	public String getCardName() {
		return cardName;
	}

	public RANK getRank() {
		return rank;
	}

	public void setRank(RANK rank) {
		this.rank = rank;
	}

	public SUIT getSuit() {
		return suit;
	}

	public void setSuit(SUIT suit) {
		this.suit = suit;
	}

}
