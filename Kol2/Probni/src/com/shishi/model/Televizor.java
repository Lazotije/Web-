package com.shishi.model;


public class Televizor {
	
	String serijskiBroj;
	public static final String[] MOGUCI_MODELI = 
			new String[] {"Samsung", "Panasonic",  "Lg"};
	int cena;
	String model;
	
	
	public String getSerijskiBroj() {
		return serijskiBroj;
	}
	public void setSerijskiBroj(String serijskiBroj) {
		this.serijskiBroj = serijskiBroj;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	
	public Televizor(String serijskiBroj, int cena, String model) {
		super();
		this.serijskiBroj = serijskiBroj;
		this.cena = cena;
		this.model = model;
	}
	
	
	public Televizor() {
		super();
	}
	
	
	
	
	
}

