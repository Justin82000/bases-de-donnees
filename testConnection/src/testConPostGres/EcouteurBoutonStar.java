package testConPostGres;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.JTextField;

public class EcouteurBoutonStar implements MouseListener {

	private JTextField jt1, jt2, jt3, jt4, jt5, jt6;
	private FenetreStar f;
	private static String URL = "jdbc:postgresql://localhost:5432/exoplanetes";
	private static String login = "postgres"; // mettez votre login
	private static String password = "password"; // mettre votre mot de passe
	private Connection conn;

	public EcouteurBoutonStar(JTextField jt1, JTextField jt2, JTextField jt3, JTextField jt4, JTextField jt5,
			JTextField jt6, FenetreStar f) {

		this.jt1 = jt1;
		this.jt2 = jt2;
		this.jt3 = jt3;
		this.jt4 = jt4;
		this.jt5 = jt5;
		this.jt6 = jt6;
		this.f = f;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
			if (jt1.getText().equals("") == false) {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(URL, login, password);

				// requetePreparee est une requ�te pr�compil�e : cela permet d'�viter les
				// injections sql...
				PreparedStatement requetePreparee = conn.prepareStatement(
						"INSERT INTO Star(star_id,name,spectral_type,mass_sun,radius_sun,temperature_K,distance_ly) VALUES(NEXTVAL('star_key'),?,?,?,?,?,?)");
				requetePreparee.setString(1, jt1.getText());
				requetePreparee.setString(2, jt2.getText());
				requetePreparee.setDouble(3, Double.valueOf(jt3.getText()));
				requetePreparee.setDouble(4, Double.valueOf(jt4.getText()));
				requetePreparee.setDouble(5, Double.valueOf(jt5.getText()));
				requetePreparee.setDouble(6, Double.valueOf(jt6.getText()));

				requetePreparee.executeUpdate();

				conn.close();
				f.setVisible(false);
				f.dispose();
				System.exit(0);
			} else {
				if (jt1.getText().equals("")) {
					FenetreErreur fe = new FenetreErreur("le nom d une etoile doit �tre renseign�");
				}
			}
		} catch (SQLException erreurSQL) {
			System.out.println(erreurSQL);
			FenetreErreur fe = new FenetreErreur(erreurSQL.getMessage());
		} catch (Exception exc) {
			System.out.println(exc);
			FenetreErreur fe = new FenetreErreur(exc.getMessage());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
