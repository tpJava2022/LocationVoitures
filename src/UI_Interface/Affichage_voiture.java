package UI_Interface;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterators;

import javax.swing.*;

import metier.*;


public class Affichage_voiture extends JFrame {

	public Affichage_voiture(Agence A) {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		Iterator<Voiture> it;
		it= A.voituresLouees();
		ArrayList<Voiture> Al =new ArrayList<Voiture>();
		while(it.hasNext())
		{
			Al.add(it.next());
		}
		String [][] data = new String[Al.size()][4];
		int n=0;
		for (Voiture v : Al)
		{
		data[n][0]= v.getMarque();
		data[n][1]= v.getModel();
		data[n][2]=String.valueOf( v.getPrixLocation());
		data[n][3] = String.valueOf(v.getAnneeProduction());
		n++;
		}
		
		String[] columnNames = { "Marque", "Model", "Prix", "Anne Production" };
		JTable table = new JTable(data,columnNames);
		add (table, BorderLayout.CENTER);
		
		
		
		
	}
	
	
}
