package UI_Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterators;
import java.util.regex.PatternSyntaxException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import metier.*;


public class Affichage_voiture extends JFrame {
	JPanel panelAffichage = new JPanel();
	 private TableModel model;
	public Affichage_voiture(Agence A) {
		// TODO Auto-generated constructor stub
		//setSize(600,200);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelAffichage.setLayout(new BorderLayout());
		/*Iterator<Voiture> it;
		it= A.voituresLouees();
		ArrayList<Voiture> Al =new ArrayList<Voiture>();*/
		ArrayList<Voiture> Al = A.Voiture_agence();
		
		/*while(it.hasNext())
		{
			Al.add(it.next());
		}*/
		String [][] data = new String[Al.size()][6];
		int n=0;
		for (Voiture v : Al)
		{
		data[n][0]= v.getMarque();
		data[n][1]= v.getModel();
		data[n][2]=String.valueOf( v.getPrixLocation());
		data[n][3] = String.valueOf(v.getAnneeProduction());
		   if(A.estLoue(v)) {
		         data[n][4] = "Lou�e";
		      }
		   else data[n][4]= "Disponible";
		   
		   
		   
		n++;
		}
		
		String[] columnNames = { "Marque", "Model", "Anne Production", "Prix", "Etat", "Action"};
		
		/*model = new DefaultTableModel(data, columnNames) {
	         public Class getColumnClass(int column) {
	            Class returnValue;
	            if((column >= 0) && (column < getColumnCount())) {
	               returnValue = getValueAt(0, column).getClass();
	            } else {
	               returnValue = Object.class;
	            }
	            return returnValue;
	         }
		};*/
		
		
		
		this.label();
		this.table(data, columnNames);
		
	
		
		
	}
	public void  label()
	{
		JLabel labelHead = new JLabel("Liste des Voitures");
        labelHead.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
        //this.getContentPane().add(labelHead,BorderLayout.PAGE_START);
        //panelAffichage.add(labelHead, BorderLayout.CENTER);
		
	}
	public void table(String [][] data,String[] columnNames ) {
		
		JTable table = new JTable(data,columnNames);
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
	      table.setRowSorter(sorter);
		add (table, BorderLayout.CENTER);
		JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);
		panelAffichage.add(scroll,BorderLayout.CENTER);
		
		/***Filter***/
		JPanel panel = new JPanel(new BorderLayout());
	      JLabel label = new JLabel("Filter");
	      panel.add(label, BorderLayout.WEST);
	      final JTextField filterText = new JTextField("");
	      panel.add(filterText, BorderLayout.CENTER);
	      
	      panelAffichage.add(panel, BorderLayout.NORTH);
	      
	     /* JButton button = new JButton("Filter");
	      button.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            String text = filterText.getText();
	            if(text.length() == 0) {
	               sorter.setRowFilter(null);
	            } else {
	               try {
	                  sorter.setRowFilter(RowFilter.regexFilter(text));
	               } catch(PatternSyntaxException pse) {
	                     System.out.println("Bad regex pattern");
	               }
	             }
	         }
	      });
	      panelAffichage.add(button,BorderLayout.SOUTH);*/
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
	                    //(?i) recherche insensible � la casse
	                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
	                }
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	      //setVisible(true);
	      JButton button = new JButton("Ajouter une Voiture +");
	      panelAffichage.add(button,BorderLayout.SOUTH);
	      button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					///removeAll();
					/*remove(panAffichage);
					remove(labimage);*/
					Add_voiture Ajouter = new Add_voiture();
					
					//panelAffichage=Ajouter.getPanel();
					//add(panelAffichage, BorderLayout.CENTER);
					//setVisible(true);
				}
			});
	     
		
	}
	public JPanel getPanelAffichage() {
		return panelAffichage;
	}
	
	
}
