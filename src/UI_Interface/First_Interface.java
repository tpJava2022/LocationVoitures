package UI_Interface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import metier.Agence;

public class First_Interface extends JFrame {

	JFrame fj = this;
	public First_Interface(){
		super("Agence De Location De Voiture ");
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel panel= new JPanel();
		add(panel, BorderLayout.SOUTH);
		JButton B1 = new JButton("Afficher voitures");
		JButton B2 = new JButton ("Chercher  par critères");
		JButton B3 = new JButton("Louer Voiture");
		JButton B4 = new JButton("Rendre Voiture");

		panel.add(B1);
		panel.add(B2);
		panel.add(B3);
		panel.add(B4);
		
		panel.setBackground(Color.GRAY);
		setVisible(true);
		
		
		B1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Agence A= new Agence();
			 Affichage_voiture AV =  new Affichage_voiture(A);
			 fj.add(AV, BorderLayout.CENTER);
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new First_Interface();
		

	}

}
