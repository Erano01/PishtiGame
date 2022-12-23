package me.serterano.com.Entities;

public enum SUIT {
	 
	KUPA(0,"KUPA"),
	KARO(1,"KARO"),
	SÝNEK(2,"SÝNEK"),
	MAÇA(3,"SPADES");
	
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
	      case SÝNEK:
		     return 2;
	      case MAÇA:
	    	 return 3;
	      default:
		     return 9999;//return nothing
		    }
		
	}
	
}
