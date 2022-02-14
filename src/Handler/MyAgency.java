package Handler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import metier.Agence;
import metier.Client;
import metier.Clients;
import metier.Voiture;

public class MyAgency {
	private Agence A= new Agence(); 
	 private Clients C1 = new Clients();
	public MyAgency() {
		
		
		/*
		Voiture V1 = new Voiture("Mercedece", "benz", 500,2020); 
		Voiture V2 = new Voiture("Alfa Romeo", " Giulietta", 500,2020); 
		Voiture V3 = new Voiture("Citroën"," C4 Aircross", 50000, 2021);
		Voiture V4 = new Voiture("BMW"," Série 3", 750000, 2021);
		Voiture V5 = new Voiture("Opel"," Antara", 80000, 2021);
		Voiture V6 = new Voiture("Audi"," A1 Sportback", 50000, 2021);
		Voiture V7 = new Voiture("Audi"," A5 Coupé", 10000, 2021);
		Voiture V8 = new Voiture("Dacia"," Sandero", 50000, 2021);
		Voiture V9 = new Voiture("Dacia"," Duster", 50000, 2021);
		
		
		 A.add(V1);
		 A.add(V2);
		 A.add(V3);
		 A.add(V4);
		 A.add(V5);
		 A.add(V6);
		 A.add(V6);
		 A.add(V7);
		 A.add(V8);
		 A.add(V9);*/
		 
	     //serialisation(A, "agenceFinale.txt");
		 
		Client	A1 = new Client("Cl1","Cl1","AA124545","Civil");
		Client	A2 = new Client("Cl2","Cl2","AA124545","Civil"); 		 
		Client	A3 = new Client("Cl3","Cl3","AA124545","Civil");
		Client	A4 = new Client("Cl4","Cl1","AA124545","Civil"); 
		 
		 C1.add(A1);
		 C1.add(A2);
		 C1.add(A2);
		 C1.add(A4);
		 
	  //this.serialisation(C1,"Clients.txt");
		 
		 
	}
	
	public void serialisation(Object A, String f)
	{
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
		try {
			oos.writeObject(A); 
			oos.flush();
				 
		}catch (Exception e1) { // TODO Auto-generated catch block
				 e1.printStackTrace(); }
		finally { oos.close(); } 
				 
		} catch (Exception e1) { // TODO Auto-generated catch block
				 
			 e1.printStackTrace(); }
	}
	
	public Object  deserialisation(String f) {
		//Agence A1 = new Agence();
		Object o = null;
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
				o= ois.readObject();
				ois.close();
				//setA(A1);
			}catch(Exception e1) {
				
			}
		
		return o;
		
	}
	
	public Agence deserialiserAgencr(String f) {
		Agence a=(Agence)deserialisation(f);
		Voiture.setNumbers(a.Voiture_agence().size());
		return a;
	}

	public Agence getA() {
		return A;
	}

	public void setA(Voiture V) {
		A.add(V); 
		serialisation(A, "agenceFinale.txt");
	}
	public void supprimer(int id)
	{
		//A.remove(V);
		A.remove(id);
		serialisation(A, "agenceFinale.txt");
	}
	public void supprimerCli(String i)
	{
		//A.remove(V);
		C1.delete(i);
			
		serialisation(C1, "Clients.txt");
	}

	public void setAgence(Agence a)
	{
		A = a;
		Voiture.setNumbers(a.Voiture_agence().size());
	}
	
	public static void main(String[] args) {
		MyAgency MA=new MyAgency();
		Voiture V1 = new Voiture("Mercedece", "benz", 500,2020); 
		Voiture V2 = new Voiture("Alfa Romeo", " Giulietta", 500,2020); 
		Voiture V3 = new Voiture("Citroën"," C4 Aircross", 50000, 2021);
		Voiture V4 = new Voiture("BMW"," Série 3", 750000, 2021);
		Agence a=new Agence();
		a.add(V1);
		a.add(V2);
		a.add(V3);
		a.add(V4);
		MA.setAgence(a);
		MA.deserialiserAgencr("agence.txt");
	}
	
}
