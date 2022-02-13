package Handler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import metier.Agence;
import metier.Voiture;

public class MyAgency {
	private Agence A= new Agence(); 
	
	public MyAgency() {
		
		
		
		Voiture V1 = new Voiture("Mercedece", "benz", 500,2020); 
		Voiture V2 = new Voiture("Alfa Romeo", " Giulietta", 500,2020); 
		Voiture V3 = new Voiture("Citroën"," C4 Aircross", 50000, 2021);
		Voiture V4 = new Voiture(" BMW"," Série 3", 750000, 2021);
		Voiture V5 = new Voiture("Opel"," Antara", 80000, 2021);
		Voiture V6 = new Voiture("Audi"," A1 Sportback", 50000, 2021);
		Voiture V7 = new Voiture(" Audi"," A5 Coupé", 10000, 2021);
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
		 A.add(V9);
		 
		 
		 
	}
	
	public void serialisation(Object A, String f)
	{
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
		try {
			oos.writeObject(A); oos.flush();
				 
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

	public Agence getA() {
		return A;
	}

	public void setA(Voiture V) {
		A.add(V); 
		serialisation(A, "agence1.txt");
	}

	public void setAgence(Agence a)
	{
		A = a;
	}
	
}
