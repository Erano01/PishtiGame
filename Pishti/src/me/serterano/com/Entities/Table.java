package me.serterano.com.Entities;

import java.util.ArrayList;

public class Table {
	
	private ArrayList<Card> cards;//oyuncularýn masaya attýðý kartlar

	  public Table() {
	    this.cards = new ArrayList<Card>();
	  }

	  public void addCard(Card card) {
	    this.cards.add(card);
	  }

	  public Card removeCard(int index) {
	    return this.cards.remove(index);
	  }

	  public Card getCard(int index) {//specific cards
	    return this.cards.get(index);
	  }
	  
	  public ArrayList<Card> getCards() {//all of them
			return cards;
	  }
}
