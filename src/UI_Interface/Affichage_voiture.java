package UI_Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterators;

import javax.swing.*;

import metier.*;


public class Affichage_voiture extends JFrame {

	public Affichage_voiture(Agence A) {
		// TODO Auto-generated constructor stub
		setSize(600,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		this.label();
		this.table(data, columnNames);
		
		setVisible(true);
		
		
	}
	public void  label()
	{
		JLabel labelHead = new JLabel("Liste des Voitures");
        labelHead.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
        this.getContentPane().add(labelHead,BorderLayout.PAGE_START);
		
	}
	public void table(String [][] data,String[] columnNames ) {
		
		JTable table = new JTable(data,columnNames);
		add (table, BorderLayout.CENTER);
		JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);
		this.getContentPane().add(scroll,BorderLayout.CENTER);
		
	}
	
}
