package testConPostGres;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class FenetreStar extends JFrame{
	
	private JLabel l1, l2,l3, l4, l5, l6;
	private JTextField jt1, jt2, jt3, jt4, jt5, jt6;
	private JButton b;
	
	public FenetreStar(){
		super("création d'une etoile");
		this.setLayout(new BorderLayout());
		JPanel p1 = new JPanel(new GridLayout(6,1));
		JPanel p2 = new JPanel(new GridLayout(6,1));
		this.l1 = new JLabel("nom de l'etoile : ");
		this.l2 = new JLabel("type spectral de l'etoile : ");
		this.l3 = new JLabel("masse de l'etoile : ");
		this.l4 = new JLabel("rayon de l'etoile : ");
		this.l5 = new JLabel("temperature de l'etoile : ");
		this.l6 = new JLabel("distance de l'etoile : ");
		this.jt1 = new JTextField();
		this.jt2 = new JTextField();
		this.jt3 = new JTextField();
		this.jt4 = new JTextField();
		this.jt5 = new JTextField();
		this.jt6 = new JTextField();
		this.b = new JButton("envoyer");
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);
		p2.add(jt1);
		p2.add(jt2);
		p2.add(jt3);
		p2.add(jt4);
		p2.add(jt5);
		p2.add(jt6);
		this.add(p1,BorderLayout.WEST);
		this.add(p2,BorderLayout.CENTER);
		this.add(b,BorderLayout.SOUTH);
		b.addMouseListener(new EcouteurBoutonStar(jt1,jt2,jt3,jt4,jt5,jt6,this));
		this.setSize(400,250);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		FenetreStar f = new FenetreStar();
	}

}