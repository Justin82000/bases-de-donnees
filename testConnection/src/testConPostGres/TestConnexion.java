package testConPostGres;
import java.sql.*;
public class TestConnexion {

	public static void main(String[] args) {
	    try
	    {
	      //étape 1: charger la classe du driver postgres
	      Class.forName("org.postgresql.Driver");
	      
	      //étape 2: créer l'objet de connexion
	      Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tp1","userpostgres","userpostgres");
	      
	      //étape 3: créer l'objet statement qui va accueillir une requête 
	      Statement stmt = conn.createStatement();
	      
	      //étape 4: exécuter la requête
	      ResultSet res = stmt.executeQuery("SELECT * FROM instrument");

	      //étape 5: impression du résultat de la requête
	      while(res.next())
	        System.out.println(res.getString(1)+"  "+res.getString(2));
	      
	      //étape 6: fermeture de l'objet de connexion
	      conn.close();
	    }
	    catch(Exception e){ 
	      System.out.println(e);
	    }
	}

	
}
