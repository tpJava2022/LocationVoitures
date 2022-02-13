package UI_Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.*;

import metier.*;

public class Rendre_Voiture extends JFrame {

	public Rendre_Voiture(Agence A) {
		// TODO Auto-generated constructor stub
		setTitle("Rendre voiture");
		setSize(400,400);
		setLayout(new FlowLayout());
		JTextField tf=new JTextField();
		tf.setPreferredSize( new Dimension( 200, 24 ) );
		JLabel l=new JLabel("CIN:");
		JButton b=new JButton("rendre");
		add(l);
		add(tf);
		add(b);
		setVisible(true);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s=tf.getText();
				if(s.length()>0) {
					Client c=A.getClient(s);
					A.rendVoiture(c);
					try {
						ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("agence.txt"));
						try {
							oos.writeObject(A);
							oos.flush();
						}catch(Exception e3) {
							
						}finally {
							oos.close();
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
