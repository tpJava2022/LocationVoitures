package UI_Interface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import metier.Voiture;

public class Add_voiture extends JFrame {

	JPanel panel = new JPanel();
	public Add_voiture(int rowc) {
		
		setSize(500,500);
		
		
		
		 JLabel lab1 = new JLabel("Marque:");
		 lab1.setBounds(20,40,200,28);
		 
		JTextField text1 = new JTextField();
	    text1.setBounds(120,40,200,28);
	    
	    
	    JLabel lab2 = new JLabel("Model:");
		 lab2.setBounds(20,80,200,28);
	    JTextField text2 = new JTextField();
	    text2.setBounds(120,80,200,28);
	    
	    JLabel lab3 = new JLabel("Prix:");
		 lab3.setBounds(20,120,200,28);
	    JTextField text3 = new JTextField();
	    text3.setBounds(120,120,200,28);
	    
	    JLabel lab4 = new JLabel("Annee de Prod:");
		 lab4.setBounds(20,160,200,28);
	    JTextField text4 = new JTextField();
	    text4.setBounds(120,160,200,28);
	    
	    
	    JButton save = new JButton("Ajouter");
	    
	    save.setBounds(150,200,100,28);
	    
	    
	    panel.add(lab1);
	    panel.add(lab2);
	    panel.add(lab3);
	    panel.add(lab4);
	  panel.add(text1); 
	   panel.add(text2);
	   panel.add(text3);
	   panel.add(text4);
	   panel.add(save);
	 
	   panel.setSize(250,250);
	   panel.setLayout(null);
	   
	    panel.setBackground(Color.pink);
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if((text1.getText() != "") && (text2.getText() != "") && (text3.getText()!="") && (text4.getText()!= ""))
				{
					Voiture V = new Voiture(text1.getText(),
							                text2.getText(),
							                Integer.parseInt(text3.getText()),
							                Integer.parseInt(text4.getText()));
					V.setId( rowc);
					int res = JOptionPane.showConfirmDialog(panel,"Etes-vous sur?");
					
					if(res == JOptionPane.YES_OPTION)
				    {
						First_Interface.monAgence.setA(V);
						text1.setText("");
						text2.setText("");
						text3.setText("");
						text4.setText("");
					
				    }
				  }
				else {
					JOptionPane.showMessageDialog(null,"Veulliez remplir tout les champs ");
				}
			}
				
		});
		
		
		
		
		add(panel);
		
		setVisible(true);
	}
	public JPanel getPanel() {
		return panel;
	}
	
}
