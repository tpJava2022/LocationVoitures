package UI_Interface;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Handler.MyAgency;
import metier.*;

public class Louer_voiture extends JFrame{
	private JPanel p=new JPanel();
	private JPanel p2=new JPanel();
	private JPanel p3=new JPanel();
	MyAgency ma=new MyAgency();
	JTable table;
	Clients clts;
	private  DefaultTableModel model;
	public Louer_voiture(Agence A) {
		setTitle("Louer voiture");
		clts=(Clients)ma.deserialisation("Clients.txt");
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
		JLabel l1=new JLabel("critere marque :");l1.setFont(new Font("Arial",Font.BOLD,12));
		JLabel l2=new JLabel("critere prix :");l2.setFont(new Font("Arial",Font.BOLD,12));
		JButton b1=new JButton("chercher");
		p.add(l1);p.add(cb1);p.add(l2);p.add(cb2);p.add(b1);
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
		//p3.setLayout(new BorderLayout());
		p3.setSize(200,200);
		p2.add(p3);
		add(p2,BorderLayout.CENTER);
		b1.addActionListener(new ActionListener() {
			
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
					Voiture v=it.next();
					data[n][0]=String.valueOf(v.getId());
					data[n][1]= v.getMarque();
					data[n][2]= v.getModel();
					data[n][3]=String.valueOf( v.getPrixLocation());
					data[n][4] = String.valueOf(v.getAnneeProduction());
					   if(A.estLoue(v)) {
					         data[n][5] = "Louée";
					      }
					   else data[n][5]= "Disponible";
					   model.addRow(data[n]);
					n++;
				}
				table.setModel(model);
			}
		});
		JPanel p4=new JPanel();
		p4.setLayout(new FlowLayout());
		JButton b2=new JButton("ajouter client"),b3=new JButton("client existant");
		p4.add(b2);p4.add(b3);
		p2.add(p4);
		JPanel p5=new JPanel();
		p5.setLayout(new GridLayout(4,2));
		JLabel l3=new JLabel("cin");p5.add(l3);
		JTextField cin=new JTextField();p5.add(cin);
		JLabel l4=new JLabel("nom");p5.add(l4);
		JTextField nom=new JTextField();p5.add(nom);
		JLabel l5=new JLabel("prenom");p5.add(l5);
		JTextField prenom=new JTextField();p5.add(prenom);
		JLabel l7=new JLabel("civilite");p5.add(l7);
		JComboBox<String> civ=new JComboBox<String>();p5.add(civ);
		civ.addItem("mr");civ.addItem("mle/mme");
		p2.add(p5);
		JPanel p6=new JPanel();
		p6.setLayout(new GridLayout(1,2));
		JLabel l6=new JLabel("cin");p6.add(l6);
		JTextField cin1=new JTextField();p6.add(cin1);
		JButton b4=new JButton("louer");
		p6.setVisible(false);
		p2.add(p6);
		p2.add(b4);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				p5.setVisible(true);
				p6.setVisible(false);
			}
		});
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				p6.setVisible(true);
				p5.setVisible(false);
			}
		});
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int idr=table.getSelectedRow();
				
				if(table.getSelectedRow() != -1)  {
					String id=table.getModel().getValueAt(idr, 0).toString();
					String cing=cin.getText();
					Client cl;
					if(cing.length()>0) {
						String prenomg=prenom.getText();
						String nomg=nom.getText();
						String civg=civ.getSelectedItem().toString();
						cl=new Client(nomg, prenomg, cing, civg);
						clts.add(cl);
						ma.serialisation(clts, "Clients.txt");
						System.out.println(id);
					}else {
						cing=cin1.getText();
						cl=clts.getClient(cing);
					}
					
					A.louerVoiture(cl, A.getVoiture(Integer.parseInt(id)));
					ma.serialisation(A, "agence.txt");
				}
				else
					 JOptionPane.showMessageDialog(null, "You should select a Row");
			}
		});
		setVisible(true);
		
	}
	
	public void table(DefaultTableModel model) {
		//final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
	     // table.setRowSorter(sorter);
		//p3.add (table);
		JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);
		p3.add(scroll);
		
		/***Filter***/
	      
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

}
