package me.serterano.com.Entities;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Deck {
			
	//52 card(without 2 joker)
	
	private ArrayList<Card> Cards;//daðýtýlacak deste
	

	public Deck() {
		Cards = new ArrayList<Card>();	
		for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 0; rank <= 12; rank++) {
            	
            	Cards.add(new Card(rank,suit));//hata
            	
            }
        }
		
	}
	
	public ArrayList<Card> getCards() {
		return Cards;
	}
	
	public Card get(int i){
	    if (i < 0 || i >= Cards.size()) {
	        throw new IndexOutOfBoundsException("Index out of bounds: " + i);
	    }
	    return Cards.get(i);
	}
	
	//we are going to use custom shuffle method
	//instead of Collection.shuffle(Cards);
	
	public ArrayList<Card> shuffle(){
        // create a Random object to generate random indices
        Random rand = new Random();

        // iterate through the cards list and swap each card with a random other card
        for (int i = 0; i < Cards.size(); i++) {
            int randomIndex = rand.nextInt(Cards.size());
            if (randomIndex != i) {  // make sure the indices are different
            Card temp = Cards.get(i);
            Cards.set(i, Cards.get(randomIndex));
            Cards.set(randomIndex, temp);
            }
        }

        return Cards;
	}
	
	
				
}
			
	
