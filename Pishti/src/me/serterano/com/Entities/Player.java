package me.serterano.com.Entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Player {
	
	private int point =0;
	
	private ArrayList<Card> playerCards; //4
	
	private ArrayList<Card> Inventory;
	
	
	public Player() {
		Inventory = new ArrayList<Card>();
		playerCards = new ArrayList<Card>();
		
	}
	
	public Card round(int index) {
		
		Card card = playerCards.get(index);
		
		playerCards.remove(index);
		
		System.out.println("Oynadýnýz: "+card.getCardName());
		return card;
	}
	public Card aiRoundv2(Table table) {
		//table a göre bir tane card döndür ve removela
		Random rand = new Random();
		
		if(table.getCards().size() >0) {
			for (Iterator iterator = playerCards.iterator(); iterator.hasNext();) {
				Card card = (Card) iterator.next();
				
				if(card.getRank() == table.getCards().get(table.getCards().size()-1).getRank()) {
					table.getCards().add(card);
					playerCards.remove(card);
					System.out.println("Opponent: "+ card.getCardName());
					return card;
				}
				else if(card.getRank()==RANK.JACK) {
					table.getCards().add(card);
					playerCards.remove(card);
					System.out.println("Opponent: "+ card.getCardName());
					return card;
				}
			}
		}
		int index = rand.nextInt(playerCards.size());
		Card card = playerCards.get(index);
		playerCards.remove(card);
		System.out.println("Opponent: "+ card.getCardName());
		return card;
		
	}
	
	
	
	
	public ArrayList<Card> getInventory() {
		return Inventory;
	}

	public void setInventory(ArrayList<Card> inventory) {
		Inventory = inventory;
	}

	public void setCards(ArrayList<Card> arr) {
		playerCards = arr;
	}
	
	public ArrayList<Card> getCards(){
		return this.playerCards;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	

}
