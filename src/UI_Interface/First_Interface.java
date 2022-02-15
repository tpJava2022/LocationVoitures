package UI_Interface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import Handler.MyAgency;
import metier.*;

public class First_Interface extends JFrame {
	
	JFrame fj = this;
	JPanel panel= new JPanel();
	JPanel pancentre =new JPanel();
	JPanel panAffichage = new JPanel();
	JPanel panAjouter = new JPanel();
	JPanel panRemove = new JPanel();
	
	
	static MyAgency monAgence = new MyAgency();
	
	
	public First_Interface(){
		super("Agence De Location De Voiture ");
		
		setSize(700,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		add(panel, BorderLayout.SOUTH);
		JButton B = new JButton("Afficher voitures");
		JButton B3 = new JButton("Louer Voiture");
		JButton B4 = new JButton("Rendre Voiture");
		JButton B5 = new JButton("Afficher Clients");

		panel.add(B);
		panel.add(B3);
		panel.add(B4);
		panel.add(B5);
		
		panel.setBackground(Color.PINK.darker());
		
		ImageIcon icon = new ImageIcon("affiche.jpg");
		//Image scaleImage = icon.getImage().getScaledInstance(28, 28,Image.SCALE_DEFAULT);
		JLabel labimage = new JLabel(icon);
		labimage.setSize(200,200);
		add( labimage, BorderLayout.CENTER);
		//pack();
		
		B.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

		      
				/*
				 * Agence A= new Agence(); Voiture V1 = new Voiture("Mercedece", "benz",
				 * 500,2020); Voiture V2 = new Voiture("Audi", "benz", 500,2020); Client
				 * c1Client= new Client("Fadwa", "El ALAOUI", "BB183232", "CEL");
				 * 
				 * A.add(V1); A.add(V2); A.louerVoiture(c1Client, V2); A.louerVoiture(c1Client,
				 * V2); try { ObjectOutputStream oos=new ObjectOutputStream(new
				 * FileOutputStream("agence.txt")); try { oos.writeObject(A); oos.flush();
				 * }catch (Exception e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); }finally { oos.close(); }
				 * 
				 * 
				 * } catch (Exception e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); }
				 */
				/*Agence A;	
				try {
					ObjectInputStream ois=new ObjectInputStream(new FileInputStream("agence.txt"));
						A=(Agence)ois.readObject();
						ois.close();
						 Affichage_voiture AV =  new Affichage_voiture(A);
						 panAffichage = AV.getPanelAffichage();
						 add(panAffichage, BorderLayout.CENTER);
						 setVisible(true);
					}catch(Exception e1) {
						
					}*/
				
				
				 Affichage_voiture AV =  new Affichage_voiture(monAgence.deserialiserAgencr("agence.txt"));
				  monAgence.setAgence((Agence)monAgence.deserialisation("agence.txt"));
				 panAffichage = AV.getPanelAffichage();
				 add(panAffichage, BorderLayout.CENTER);
				 setVisible(true);
		       // Client c1Client= new Client("Fadwa", "El ALAOUI", "BB183232", "CEL");
			
			
			}
		});
		
		B5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				///removeAll();
				remove(panAffichage);
				remove(labimage);
				//Add_voiture Ajouter = new Add_voiture();
				AfficherClients AfficherCli = new AfficherClients((Clients)monAgence.deserialisation("Clients.txt"));
				panAjouter=AfficherCli.getPanelAffichage();
		//panAjouter.setBackground(Color.LIGHT_GRAY);
				add(panAjouter, BorderLayout.CENTER);
				//setBackground(Color.blue);
				setVisible(true);
			}
		});
		
            B4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Rendre_Voiture r=new Rendre_Voiture((Agence)monAgence.deserialisation("agence.txt"));
			}
		});
            B3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Louer_voiture lv=new Louer_voiture((Agence)monAgence.deserialiserAgencr("agence.txt"));
				}
			});
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new First_Interface();
		

	}

}
