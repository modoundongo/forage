package sn.ndongoinformatique.forage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class MenuAbonnement {
	
	
	static IServiceAbonnementImpl abonnementServiceImpl = new IServiceAbonnementImpl();
	public static void affMenuAbonnement() {
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		Abonnement abonnemenet;	
		ClientForage clientForage;
		Compteur compteur;//represente un compteur
		String en;

		Boolean continuer = true;
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("****  Gestion des abonnemets *****");
			System.out.println("\n");
			System.out.println("1 : Ajouter un abonnement  ");
			System.out.println("2 : Liste des abonnements ");
			System.out.println("3 : Mise a jour d'un abonnement");
			System.out.println("4 : Supprimer un abonnement ");
			System.out.println("0 : Retour menu general ");

			System.out.println("\nVotre choix : ");
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
				System.out.println("******** Abonnement à ajouter *********");
				System.out.println("Donner le code de l'abonnement  : ");
				int codeAbonnement = sc.nextInt();
				System.out.println("Donner la date  : ");
				String dateString = sc.nextLine();
				try {
					Date dateAbonnement=sdf.parse(dateString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Donner le code client  : ");
				String codeClient = sc.nextLine();
				System.out.println("Donner le numero du compteur  : ");
				String codeCompteur = sc.nextLine();
				System.out.println("Donner etat de labonnement  : ");
				String etatAbonnement = sc.nextLine();
				clientForage=DaoUtilites.recupererClientForage(codeClient);
				compteur=DaoUtilites.recupererCompteur(codeCompteur);
				abonnemenet=new Abonnement(codeAbonnement, clientForage, compteur, etatAbonnement);
				abonnementServiceImpl.creer(abonnemenet);
				break;
			case 2:

				break;
			case 3:
				System.out.println("Liste des abonnements"+abonnementServiceImpl.lister());
				break;
			case 4:
				sc.nextLine();
				System.out.println("******** Abonnement à supprimer *********");
				System.out.println("Donner le code de l'abonnement a supprimer : ");
				int codeAbonnementASupprimer = sc.nextInt();
			abonnementServiceImpl.supprimer(DaoUtilites.recupererAbonnement(codeAbonnementASupprimer));
				break;
			default:
				System.out.println("Choix non diponible ");
				break;
			}
		} while (continuer);
	}

}
