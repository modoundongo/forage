package sn.ndongoinformatique.forage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Cette classe met en oeuvre le design pattern singleton
 * elle permet de restreindre les accés à la base en une et une seule instance de
 * connection
 * @author modou Ndongo
 *
 */


public class MysqlConnection {
	 private static final String HOST  ="jdbc:mysql://localhost/gestionforage?useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	   private static final int PORT = 27017;
	   private static final String USERNAME = "modou";
	   private static final String PASSWORD = "ndongo";
	   private static Connection conn= null;  	
	   	
	   	//Constructeur privé pour blocquer la création d'instance de la classe
	   	private MysqlConnection() {
	   		super();
	   		
	   	}
	   	/**
	   	 * Cette methode retourne l'unique instance de connection avec la base
	   	 * @return
	   	 */
	   	public static Connection getInstanceConnection(){
	   		try {
	   			if(conn==null) {// Accune connexion avec la base
	   				conn=DriverManager.getConnection(HOST, USERNAME, PASSWORD);
	   				System.out.println("Connexion établie avec la base");
	   			}
	   		} catch (SQLException e) {
	   			System.out.println("Probléme de connexion");
	   			e.printStackTrace();
	   		}
	   		return conn;
	   	}
	   	
	   	
	   	
	   }



