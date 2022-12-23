package me.serterano.com.Dto;

import java.util.Random;
import java.util.Scanner;

import me.serterano.com.Entities.Deck;
import me.serterano.com.Entities.Player;
import me.serterano.com.Entities.RANK;
import me.serterano.com.Entities.SUIT;
import me.serterano.com.Entities.Table;

public class GameManager {
	//Oyun algoritmasý burda olcak
	
	private int roundCounter =1;
	
	private Deck deck;
	private Table table;
	private Player p1;
	private Player p2;
	
	
	public GameManager() {
		deck = new Deck();//hata
		table = new Table();
		p1 = new Player();
		p2 = new Player();
	}
	
	public void startGame() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to pishti game...");
		System.out.println("Press 1 to start game...");
		System.out.println("Press any key to escape...");
		
		int st = input.nextInt();
		
		if(st==1) {//if game started
			while(p1.getPoint()<=101 || p2.getPoint()<=101) {
				deck = new Deck();
				deck.shuffle();deck.shuffle();
				roundCounter=1;
				splitCards();
			while(deck.getCards().size()>0) {

				if(p1.getPoint()>101 || p2.getPoint() >101) {
					if(p1.getPoint()>p2.getPoint()) {
						System.out.println("You won..Congrats.");
					}else {
						System.out.println("Opponent won..Try again.");
					}
					return;
				}
				System.out.println();
				System.out.println("Round: "+roundCounter+", YourPoint: "+p1.getPoint()+" Opponent point: "+p2.getPoint());
				System.out.println("----------------------");
				
				//splitCards();
				
				//masada ki son kartý(en üstteki) göster
				if(table.getCards().size()>0) {
					System.out.println("Table latest card: ["+table.getCard(table.getCards().size()-1).getCardName()+"]");//stream ile enum tiplerine göre yazdýr
				}else {
					System.out.println("Table deck: ..");
				}
				
				
				System.out.print("Your deck: ");
				p1.getCards().stream().forEachOrdered(p -> System.out.print(p.getCardName()+", "));;
				
				System.out.println();
				
				System.out.println("Which index do you want to play ?..");
				int decision = input.nextInt();
				
				table.getCards().add(p1.round(decision));//table mesajý okut

				if(isPishti(table)){
					System.out.println("You did pishti you did gain +10 point..");
					//+10 point
					p1.setPoint(p1.getPoint()+10);
					
					p1.getInventory().addAll(table.getCards());//take all cards
					
					table.getCards().clear();//delete table cards
				}
				
				//p2 play
				table.getCards().add(p2.aiRoundv2(table));
				
				if(table.getCards().size() > 0){
					if(isPishti(table)){
					//System.out.println("Table: "+table.getCards().get(table.getCards().size()-1).getCardName());
					
					System.out.println("Opponent did pishti he gain +10 point..");
					
					p2.setPoint(p2.getPoint()+10);
					
					p2.getInventory().addAll(table.getCards());
					
					table.getCards().clear();
					
					}
				}
				
				
				roundCounter++;
				splitCards();
				
			}
			//while deck end
			if(deck.getCards().size()==0) {
				pointCalculator(p1);
				pointCalculator(p2);
				if(p1.getInventory().size() > p2.getInventory().size()) {
					p1.setPoint(p1.getPoint()+3);
				}
				else if(p1.getInventory().size() < p2.getInventory().size()) {
					p2.setPoint(p2.getPoint()+3);
					//Kâðýt Sayýsý: Eldeki kâðýt sayýsý rakibe göre fazla ise 3 puan.
				}
				else {
					//do nothing if they have 26 - 26 card
				}
				System.out.println("Deck is over ..");
				System.out.println("Your point: "+p1.getPoint()+" Opponnent point: "+p2.getPoint());
			}
			}
			System.out.println("Game is over..");
			System.out.println("Your point: "+p1.getPoint()+" Opponnent point: "+p2.getPoint());
		}else {
			System.out.println("See you");
		}
		
		
		
	}
	public void splitCards(){
		//first round ->  +4 Table, +4 P1, +4 P2, -12 Deck
		
		//after -> +4 card p1, +4 card p2, -8 deck

		if(deck.getCards().size() > 0) {//Destede ki kartlar 0 dan büyükse
			
			if(roundCounter == 1) {

				for (int i = 0; i < 4; i++) { 
					//12 kart 3 farklý arrayliste daðýtýldý
					//ve bu kartlar deckten çýkartýldý
					p1.getCards().add(deck.getCards().remove(0));
					p2.getCards().add(deck.getCards().remove(0));
					table.getCards().add(deck.getCards().remove(0));
				}
			}else if(p1.getCards().size()==0 && p2.getCards().size()==0) {
				for(int i =0;i<4;i++) {
					p1.getCards().add(deck.getCards().remove(0));
					p2.getCards().add(deck.getCards().remove(0));
				}
			}		
		}
	}
	public boolean isPishti(Table t) {
			//table da pishti durumu varmý diye kontrol ediyor.
		if(t.getCards().size() > 1) {
			if(t.getCards().get(t.getCards().size()-1).getRank() == t.getCards().get(t.getCards().size()-2).getRank()) {
				//üst üste gelmiþ 2 kardýn ranký eþitmi
				return true;
			}
			else if(t.getCards().get(t.getCards().size()-1).getRank() == RANK.JACK) {
				//en üstteki kart vale mi
				return true;
			}else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}
	public void pointCalculator(Player p) {//round sonu controller
		
		
		for(int i =0;i<p.getInventory().size();i++) {
			if(p.getInventory().get(i).getRank()==RANK.ACE) {
				p.setPoint(p.getPoint()+1);
			}
			if(p.getInventory().get(i).getRank()==RANK.TWO && p.getInventory().get(i).getSuit()==SUIT.SÝNEK) {
				p.setPoint(p.getPoint()+2);
			}
			if(p.getInventory().get(i).getRank()==RANK.TEN && p.getInventory().get(i).getSuit()==SUIT.KARO) {
				p.setPoint(p.getPoint()+3);
			}
			if(p.getInventory().get(i).getRank()==RANK.JACK) {
				p.setPoint(p.getPoint()+1);
			}
		}

	}
	
	
}
