package sn.ndongoinformatique.forage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

public class MenuAbonnement {
	private static final Logger LOGGER = Logger.getLogger(MenuAbonnement.class.getName());
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
			LOGGER.info("-----------------------------------------------");
			LOGGER.info("****  Gestion des abonnemets *****");
			LOGGER.info("\n");
			LOGGER.info("1 : Ajouter un abonnement  ");
			LOGGER.info("2 : Liste des abonnements ");
			LOGGER.info("3 : Mise a jour d'un abonnement");
			LOGGER.info("4 : Supprimer un abonnement ");
			LOGGER.info("0 : Retour menu general ");

			LOGGER.info("\nVotre choix : ");
			int rep = sc.nextInt();

			switch (rep) {
			case 0:
				sc.nextLine();
				LOGGER.info("Voulez vous vraimment retourner au menu general O/N ");
				en = sc.nextLine();
				continuer = (en.equals("n") || en.equals("N"));
				break;
			case 1:
				sc.nextLine();
				LOGGER.info("******** Abonnement à ajouter *********");
				LOGGER.info("Donner le code de l'abonnement  : ");
				int codeAbonnement = sc.nextInt();
				LOGGER.info("Donner la date  : ");
				String dateString = sc.nextLine();
				try {
					Date dateAbonnement=sdf.parse(dateString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LOGGER.info("Donner le code client  : ");
				String codeClient = sc.nextLine();
				LOGGER.info("Donner le numero du compteur  : ");
				String codeCompteur = sc.nextLine();
				LOGGER.info("Donner etat de labonnement  : ");
				String etatAbonnement = sc.nextLine();
				clientForage=DaoUtilites.recupererClientForage(codeClient);
				compteur=DaoUtilites.recupererCompteur(codeCompteur);
				abonnemenet=new Abonnement(codeAbonnement, clientForage, compteur, etatAbonnement);
				abonnementServiceImpl.creer(abonnemenet);
				break;
			case 2:

				break;
			case 3:
				LOGGER.info("Liste des abonnements"+abonnementServiceImpl.lister());
				break;
			case 4:
				sc.nextLine();
				LOGGER.info("******** Abonnement à supprimer *********");
				LOGGER.info("Donner le code de l'abonnement a supprimer : ");
				int codeAbonnementASupprimer = sc.nextInt();
			abonnementServiceImpl.supprimer(DaoUtilites.recupererAbonnement(codeAbonnementASupprimer));
				break;
			default:
				LOGGER.info("Choix non diponible ");
				break;
			}
		} while (continuer);
	}

}
