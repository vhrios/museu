package util;

public class Tupla<X, Y> { 
	  public final X x; 
	  public final Y y; 
	  
	  public Tupla(X x, Y y) { 
	    this.x = x; 
	    this.y = y; 
	  }
	  
	  @Override
	  public String toString(){
		  return x.toString()+" "+y.toString();
	  }	  
} 