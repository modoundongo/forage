package sn.ndongoinformatique.forage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class MenuAbonnement {
	static Logger logger=Logger.getLogger("logg");
	
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
			logger.log(Level.INFO,"-----------------------------------------------");
			logger.log(Level.INFO,"****  Gestion des abonnemets *****");
			logger.log(Level.INFO,"\n");
			logger.log(Level.INFO,"1 : Ajouter un abonnement  ");
			logger.log(Level.INFO,"2 : Liste des abonnements ");
			logger.log(Level.INFO,"3 : Mise a jour d'un abonnement");
			logger.log(Level.INFO,"4 : Supprimer un abonnement ");
			logger.log(Level.INFO,"0 : Retour menu general ");

			logger.log(Level.INFO,"\nVotre choix : ");
			int rep = sc.nextInt();

			switch (rep) {
			case 0:
				sc.nextLine();
				logger.log(Level.INFO,"Voulez vous vraimment retourner au menu general O/N ");
				en = sc.nextLine();
				continuer = (en.equals("n") || en.equals("N"));
				break;
			case 1:
				sc.nextLine();
				logger.log(Level.INFO,"******** Abonnement à ajouter *********");
				logger.log(Level.INFO,"Donner le code de l'abonnement  : ");
				int codeAbonnement = sc.nextInt();
				logger.log(Level.INFO,"Donner la date  : ");
				String dateString = sc.nextLine();
				try {
					Date dateAbonnement=sdf.parse(dateString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				logger.log(Level.INFO,"Donner le code client  : ");
				String codeClient = sc.nextLine();
				logger.log(Level.INFO,"Donner le numero du compteur  : ");
				String codeCompteur = sc.nextLine();
				logger.log(Level.INFO,"Donner etat de labonnement  : ");
				String etatAbonnement = sc.nextLine();
				clientForage=DaoUtilites.recupererClientForage(codeClient);
				compteur=DaoUtilites.recupererCompteur(codeCompteur);
				abonnemenet=new Abonnement(codeAbonnement, clientForage, compteur, etatAbonnement);
				abonnementServiceImpl.creer(abonnemenet);
				break;
			case 2:

				break;
			case 3:
				logger.log(Level.INFO,"Liste des abonnements"+abonnementServiceImpl.lister());
				break;
			case 4:
				sc.nextLine();
				logger.log(Level.INFO,"******** Abonnement à supprimer *********");
				logger.log(Level.INFO,"Donner le code de l'abonnement a supprimer : ");
				int codeAbonnementASupprimer = sc.nextInt();
			abonnementServiceImpl.supprimer(DaoUtilites.recupererAbonnement(codeAbonnementASupprimer));
				break;
			default:
				logger.log(Level.INFO,"Choix non diponible ");
				break;
			}
		} while (continuer);
	}

}
