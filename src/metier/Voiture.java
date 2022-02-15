package metier;

import java.io.Serializable;

public class Voiture implements Serializable {
	private static int numbers=0;
	private int id=++numbers;
	public static int getNumbers() {
		return numbers;
	}

	public static void setNumbers(int numbers) {
		Voiture.numbers = numbers;
	}

	private String marque;
	private String model;
	private int anneeProduction;
	private int prixLocation;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Voiture(String marque, String model, int anneeProduction, int prixLocation) {
		this.marque = marque;
		this.model = model;
		this.anneeProduction = anneeProduction;
		this.prixLocation = prixLocation;
	}
	
	public String getMarque() {
		return marque;
	}

	public boolean equals(Voiture obj) {
		// TODO Auto-generated method stub
		return ((marque==obj.marque)&&(model==obj.model)&&(anneeProduction==obj.anneeProduction)&&
				(prixLocation==obj.prixLocation));
	}
	
	public String toString() {
		String s= "";
		s= "------Affichage des caracteristiques-----\n";
		s= s+ "La Marque est : "+ this.marque+"\n"
				+ " Le model : "+ this.model+ "\n"
				+ " Le prix : "+ this.prixLocation + "\n"
				+ " L'anne de production : "+ this.anneeProduction;
		return s;
		
	}

	public int getPrixLocation() {
		return prixLocation;
	}

	public String getModel() {
		return model;
	}

	public int getAnneeProduction() {
		return anneeProduction;
	}
	
	
	

}
