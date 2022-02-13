package metier;

import java.io.Serializable;

public class Client implements Serializable{
	private String nom;
	private String prenom;
	private String cin;
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCin() {
		return cin;
	}

	private String civilite;
	
	public Client(String nom, String prenom, String cin, String civilite) {
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.civilite = civilite;
	}
	
	
}
