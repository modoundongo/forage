package sn.ndongoinformatique.forage;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

import java.util.stream.Stream;


public class MenuForage {
	static Logger logger=Logger.getLogger("logg");
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)  {
		
		
		String en;

		Boolean continuer = true;
		do {
			affMenu();
			int rep = sc.nextInt();

			switch (rep) {
			case 0:
				sc.nextLine();
				logger.log(Level.INFO,"Voulez vous vraimment quitter l'application O/N ");
				en = sc.nextLine();
				continuer = (en.equals("n") || en.equals("N"));
			
				break;
			case 1:
				MenuClient.affMenuClient();

				System.out.print("\nVotre choix : ");
				break;
			case 2:
				MenuCompteur.affMenuCompteur();
				break;
			case 3:
				MenuAbonnement.affMenuAbonnement();
				break;
			case 4:
				MenuFacture.affMenuFacture();
				
				
				break;
			case 5:
				
				break;
			case 6:
			
				break;
			case 7:
			
				break;
			case 8:
			
				break;
			default:
				System.out.println("Choix non diponible ");
				break;
			}
		} while (continuer);
	}
	// le client 
	
	// fin client 

	private static void affMenu() {
		logger.log(Level.INFO,"-----------------------------------------------");
		logger.log(Level.INFO,"**** Base de donnees gestion forage *****");
		logger.log(Level.INFO,"\n");
		logger.log(Level.INFO,"1 : Gestion des clients ");
		logger.log(Level.INFO,"2 : Gestion des Compteurs ");
		logger.log(Level.INFO,"3 : Gestion Abonnements");
		logger.log(Level.INFO,"4 : Gestion Factures ");
		logger.log(Level.INFO,"0 : quitter l'application ");

		logger.log(Level.INFO,"\nVotre choix : ");
	}




}