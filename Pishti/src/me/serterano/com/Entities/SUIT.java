package me.serterano.com.Entities;

public enum SUIT {
	 
	KUPA(0,"KUPA"),
	KARO(1,"KARO"),
	S�NEK(2,"S�NEK"),
	MA�A(3,"SPADES");
	
	//NONE(5);//for joker
		
	private int value;
	private String valueString;
	
	SUIT(int value,String a){
		this.value = value;
		this.valueString =a;
	}
	
	public int getIntValue() {
	    return value;
	 }
	public String getStringValue() {
	    return valueString;
	 }
	
	public int getSuit() {
		switch (this) {
	      case KUPA:
	        return 0;
	      case KARO:
	        return 1;
	      case S�NEK:
		     return 2;
	      case MA�A:
	    	 return 3;
	      default:
		     return 9999;//return nothing
		    }
		
	}
	
}
