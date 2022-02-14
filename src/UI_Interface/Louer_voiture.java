package UI_Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Handler.MyAgency;
import metier.*;

public class Louer_voiture extends JFrame{
	private JPanel p=new JPanel();
	private JPanel p2=new JPanel();
	private JPanel p3=new JPanel();
	JTable table;
	private  DefaultTableModel model;
	public Louer_voiture(Agence A) {
		setTitle("Louer voiture");
		setSize(500,500);
		setLayout(new BorderLayout());
		JComboBox<String> cb1=new JComboBox<String>();
		JComboBox<String> cb2=new JComboBox<String>();
		ArrayList<String> list1=new ArrayList<String>();
		for(Voiture v:A.Voiture_agence()) {
			list1.add(v.getMarque());
		}
		Set<String> set=new HashSet<String>(list1);
		list1.clear();
		list1.addAll(set);
		for (String s : list1) {
			cb1.addItem(s);
		}
		for(int i=100;i<=1000;i+=100)
		cb2.addItem(String.valueOf(i));
		Label l1=new Label("critere marque :");l1.setFont(new Font("Arial",Font.BOLD,12));
		Label l2=new Label("critere prix :");l2.setFont(new Font("Arial",Font.BOLD,12));
		p.add(l1);p.add(cb1);p.add(l2);p.add(cb2);
		add(p,BorderLayout.NORTH);
		
		JTable jt=new JTable();
		ArrayList<Voiture> Al = A.Voiture_agence();
		
		/*while(it.hasNext())
		{
			Al.add(it.next());
		}*/
		String [][] data = new String[Al.size()][7];
		int n=0;
		for (Voiture v : Al)
		{
		data[n][0]=String.valueOf(v.getId());
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
		
		String[] columnNames = { "Id","Marque", "Model", "Anne Production", "Prix", "Etat", "Action"};
		model = new DefaultTableModel(data,columnNames);
		table = new JTable(model);
		table(model);
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		p2.add(p3);
		add(p2,BorderLayout.CENTER);
		cb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String marque=(String) cb1.getSelectedItem();
				String prix=(String) cb2.getSelectedItem();
				CritereMarque cm=new CritereMarque(marque);
				CriterePrix cp=new CriterePrix(Integer.parseInt(prix));
				InterCriteres ic=new InterCriteres();
				ic.add(cm);
				ic.add(cp);
				Iterator<Voiture> it=A.selectionne(ic);
				int n=0;
				while(model.getRowCount()>0) model.removeRow(0);
				while(it.hasNext()) {
					data[n][0]=String.valueOf(it.next().getId());
					data[n][1]= it.next().getMarque();
					data[n][2]= it.next().getModel();
					data[n][3]=String.valueOf( it.next().getPrixLocation());
					data[n][4] = String.valueOf(it.next().getAnneeProduction());
					   if(A.estLoue(it.next())) {
					         data[n][5] = "Louée";
					      }
					   else data[n][5]= "Disponible";
					   model.addRow(data[n]);
					n++;
				}
				table.setModel(model);
			}
		});
		setVisible(true);
		
	}
	
	public void table(DefaultTableModel model) {
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
	      table.setRowSorter(sorter);
		add (table, BorderLayout.CENTER);
		JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);
		p3.add(scroll,BorderLayout.CENTER);
		
		/***Filter***/
		JPanel panel = new JPanel(new BorderLayout());
	      JLabel label = new JLabel("Filter");
	      panel.add(label, BorderLayout.WEST);
	      final JTextField filterText = new JTextField("");
	      panel.add(filterText, BorderLayout.CENTER);
	      
	      p3.add(panel, BorderLayout.NORTH);
	      
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
	}
	
	public static void main(String[] args){
		MyAgency ma=new MyAgency();
		Louer_voiture l=new Louer_voiture((Agence)ma.deserialiserAgencr("agence.txt"));
	}
}
