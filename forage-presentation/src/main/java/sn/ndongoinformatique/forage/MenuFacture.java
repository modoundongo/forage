package sn.ndongoinformatique.forage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MenuFacture {
	static IServiceFactureJmpl serviceFacture=new IServiceFactureJmpl();
	public static void affMenuFacture() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		Abonnement abonnement;
			Facture facture = null;			
		String en;

		Boolean continuer = true;
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("****  Gestion des factures *****");
			System.out.println();
			System.out.println("1 : Ajouter une facture  ");
			System.out.println("2 : Liste des factures ");
			System.out.println("3 : Mise a jour d'une facture");
			System.out.println("4 : Supprimer une facture ");
			System.out.println("0 : Reour au menu general ");

			System.out.print("\nVotre choix : ");
			int rep = sc.nextInt();

			switch (rep) {
			case 0:
				sc.nextLine();
				System.out.println("Voulez vous vraimment retourner au menu general O/N ");
				en = sc.nextLine();
				continuer = (en.equals("n") || en.equals("N"));
				break;
			case 1:
				sc.nextLine();
				try {
				System.out.println("******** Facture  à ajouter *********");
				System.out.println("Donner le code de la facture  : ");
				int codeFacture = sc.nextInt();
				System.out.println("Donner le code abonnement : ");
				int codeAbonnement = sc.nextInt();
				System.out.println("Donner la date debut  : ");
				String dateDebutString = sc.nextLine();
				System.out.println("Donner la date debut  : ");
				String dateFinString = sc.nextLine();
				System.out.println("Donner la date limite : ");
				String datelimiteString = sc.nextLine();
				
					Date dateDebut=sdf.parse(dateDebutString);
					Date dateFin=sdf.parse(dateFinString);
					Date dateLimite=sdf.parse(datelimiteString);
				
				abonnement=DaoUtilites.recupererAbonnement(codeAbonnement);
				facture=new Facture(codeFacture, abonnement,dateDebut, dateLimite, dateFin);
				serviceFacture.creer(facture);
				
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:

				break;
			case 3:
				System.out.println(serviceFacture.lister());
				break;
			case 4:
				serviceFacture.supprimer(facture);
				break;
			default:
				System.out.println("Choix non diponible ");
				break;
			}
		} while (continuer);
	}
}
