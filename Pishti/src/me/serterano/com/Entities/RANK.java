package me.serterano.com.Entities;

public enum RANK {
		ACE(0,"ACE"),
		TWO(1,"TWO"),
		THREE(2,"THREE"),
		FOUR(3,"FOUR"),
		FIVE(4,"FIVE"),
		SIX(5,"SIX"),
		SEVEN(6,"SEVEN"),
		EIGHT(7,"EIGHT"),
		NINE(8,"NINE"),
		TEN(9,"TEN"),
		JACK(10,"JACK"),
		QUEEN(11,"QUEEN"),
		KING(12,"KING");
	
		
		
		private int value;
		private String valueString;

		RANK(int value,String a){//add enum value types here
			this.value = value;
			this.valueString=a;
		}
		
		


		public int getIntValue() {
		    return value;
		 }
		public String getStringValue() {
		    return valueString;
		 }
		
		public int getRankValue() {
		    switch (this) {
		      case ACE:
		        return 0;
		      case TWO:
		        return 1;
		      case THREE:
			     return 2;
		      case FOUR:
		    	 return 3;
		      case FIVE:
		    	  return 4;
		      case SIX:
		    	  return 5;
		      case SEVEN:
		    	  return 6;
		      case EIGHT:
		    	  return 7;
		      case NINE:
		    	  return 8;
		      case TEN:
		    	  return 9;
		      case JACK:
		    	  return 10;
		      case QUEEN:
		    	  return 11;
		      case KING:
		    	  return 12;
		      default:
		        return 999999;//return nothing
		    }
		  }
	
}
