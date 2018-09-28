package sn.ndongoinformatique.forage;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import java.util.logging.*;

public class MenuForage {
	static Logger logger;
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
				System.out.println("Voulez vous vraimment quitter l'application O/N ");
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
		logger.log(null,"-----------------------------------------------");
		logger.log(null,"**** Base de donnees gestion forage *****");
		logger.log(null,"\n");
		logger.log(null,"1 : Gestion des clients ");
		logger.log(null,"2 : Gestion des Compteurs ");
		logger.log(null,"3 : Gestion Abonnements");
		logger.log(null,"4 : Gestion Factures ");
		logger.log(null,"0 : quitter l'application ");

		logger.log(null,"\nVotre choix : ");
	}




}