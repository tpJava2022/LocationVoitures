package UI_Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import metier.*;


public class Affichage_voiture extends JFrame {
	JPanel panelAffichage = new JPanel();
	 
	private DefaultTableModel model;
	public Affichage_voiture(Agence A) {
		// TODO Auto-generated constructor stub

		panelAffichage.setLayout(new BorderLayout());

		ArrayList<Voiture> Al = A.Voiture_agence();
		
	
		String [][] data = new String[Al.size()][6];
		int n=0;
		for (Voiture v : Al)
		{
		data[n][0] = String.valueOf( v.getId());
		data[n][1]= v.getMarque();
		data[n][2]= v.getModel();
		data[n][3]=String.valueOf( v.getPrixLocation());
		data[n][4] = String.valueOf(v.getAnneeProduction());
		   if(A.estLoue(v)) {
		         data[n][5] = "Louée";
		      }
		   else data[n][5]= "Disponible";
		  n++;
		}
		
		String[] columnNames = {"Id", "Marque", "Model", "Prix", "Anne Production", "Etat"};
	
		this.label();
		this.table(data, columnNames);
		
	
		
		
	}
	public void  label()
	{
		JLabel labelHead = new JLabel("Liste des Voitures");
        labelHead.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
       
		
	}
	public void table(String [][] data,String[] columnNames ) {
		
		
		model = new DefaultTableModel(data, columnNames);
		JTable table = new JTable(model);
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
	      table.setRowSorter(sorter);
	      add (table, BorderLayout.CENTER);
		JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);
		panelAffichage.add(scroll,BorderLayout.CENTER);

		/***Filter***/
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.pink.brighter());
	      JLabel label = new JLabel("Filter");
	      
	      panel.add(label, BorderLayout.WEST);
	      final JTextField filterText = new JTextField("");
	      
	      panel.add(filterText, BorderLayout.CENTER);
	      
	      panelAffichage.add(panel, BorderLayout.NORTH);
	      
	      
	      
	   
	      filterText.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				 String str = filterText.getText();
	                if (str.trim().length() == 0) {
	                    sorter.setRowFilter(null);
	                } else {
	                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
	                }
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				 String str = filterText.getText();
	                if (str.trim().length() == 0) {
	                    sorter.setRowFilter(null);
	                } else {
	                    //(?i) recherche insensible à la casse
	                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
	                }
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	      JPanel panbutton = new JPanel(new FlowLayout());
	      
	      JButton button = new JButton("Ajouter une Voiture +");
	    
	      button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int rowCoumt = table.getRowCount()-1;
					int value = Integer.parseInt((String) table.getValueAt(rowCoumt, 0))+1;
					Add_voiture Ajouter = new Add_voiture(value);
					
					System.out.println(value+1);
				}
			});
	      JButton button1 = new JButton("Supprimer les voiture");
	      
	      button1.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent ae) {
	             // check for selected row first
	             if(table.getSelectedRow() != -1) {
	                // remove selected row from the model
	            	
	            	int id =  Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
	            	 System.out.println(id);
	            	 
	            	 
	            	 First_Interface.monAgence.supprimer(id);
	            	 
	            	 model.removeRow(table.getSelectedRow());
	                JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
	            
	             }
	             else
	            	 JOptionPane.showMessageDialog(null, "You should select a Row");
	          }
	       });
	      panbutton.setBackground(Color.pink.darker());
	      
	     panbutton.add(button);
	     panbutton.add(button1);
	     panelAffichage.add(panbutton,BorderLayout.SOUTH);
	      
	      
	     // panelAffichage.setBackground(Color.RED);
		
	}
	public JPanel getPanelAffichage() {
		return panelAffichage;
	}

}






