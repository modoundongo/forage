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

				System.out.println("\nVotre choix : ");
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
		System.out.println("-----------------------------------------------");
		System.out.println("**** Base de donnees gestion forage *****");
		System.out.println("\n");
		System.out.println("1 : Gestion des clients ");
		System.out.println("2 : Gestion des Compteurs ");
		System.out.println("3 : Gestion Abonnements");
		System.out.println("4 : Gestion Factures ");
		System.out.println("0 : quitter l'application ");

		System.out.println("\nVotre choix : ");
	}




}