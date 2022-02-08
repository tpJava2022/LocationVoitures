package UI_Interface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import metier.*;

public class First_Interface extends JFrame {

	JFrame fj = this;
	JPanel panel= new JPanel();
	public First_Interface(){
		super("Agence De Location De Voiture ");
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		add(panel, BorderLayout.SOUTH);
		JButton B = new JButton("Afficher voitures");
		JButton B2 = new JButton ("Chercher  par critères");
		JButton B3 = new JButton("Louer Voiture");
		JButton B4 = new JButton("Rendre Voiture");

		panel.add(B);
		panel.add(B2);
		panel.add(B3);
		panel.add(B4);
		
		panel.setBackground(Color.GRAY);
		
		
		
		B.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

		      
				Agence A= new Agence();
				Voiture V1 = new Voiture("Mercedece", "benz", 500,2020);
				Voiture V2 = new Voiture("Audi", "benz", 500,2020);
				Client  c1Client= new Client("Fadwa", "El ALAOUI", "BB183232", "CEL");
				
				A.add(V1);
				A.add(V2);
				A.louerVoiture(c1Client, V2);
				A.louerVoiture(c1Client, V2);
				
			 Affichage_voiture AV =  new Affichage_voiture(A);
			
			}
		});
		B2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  JButton inputButton = new JButton("Send");
				    JTextArea editTextArea = new JTextArea("Type Here!");
				    panel.add(inputButton);
					panel.add(editTextArea);
					setVisible(true);
				    
			}
		});
		
		setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new First_Interface();
		

	}

}
