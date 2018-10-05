package sn.ndongoinformatique.forage;

import java.util.ListIterator;
/**
 * Menu client
 */
import java.util.Scanner;

public class MenuClient {
	static IServiceClientForageImpl clientServiceImpl = new IServiceClientForageImpl();

	public static void affMenuClient() {
		Scanner sc = new Scanner(System.in);
		ClientForage clientForage;
		Village village;
		MenuVillage menuVillage = new MenuVillage();
		String en;

		Boolean continuer = true;
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("****  Gestion des Clients *****");
			System.out.println();
			System.out.println("1 : Ajouter un client  ");
			System.out.println("2 : Liste des clients ");
			System.out.println("3 : Mise a jour d'un client");
			System.out.println("4 : Supprimer un client ");
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
				System.out.println("******** Personne à ajouter *********");
				System.out.println("Donner le code du client  : ");
				String codeClient = sc.nextLine();
				System.out.println("Donner le prénom : ");
				String prenomClient = sc.nextLine();
				System.out.println("Donner le nom du client  : ");
				String nomClient = sc.nextLine();
				village = menuVillage.saisieVillage();
				clientForage = new ClientForage(codeClient, prenomClient, nomClient, village);
				clientServiceImpl.creer(clientForage);
				break;
			case 2:
				ListIterator listClient = clientServiceImpl.lister().listIterator();
				while (listClient.hasNext()) {
					System.out.println(listClient.next());
					System.out.println("---------------------------------");
				}
				break;
			case 3:
				System.out.println(clientServiceImpl.lister());
				break;
			case 4:
				sc.nextLine();
				System.out.println("******** Personne à supprimer *********");
				System.out.println("Donner le code du client a supprimer : ");
				String codeClientASupprimer = sc.nextLine();
				clientServiceImpl.supprimer(DaoUtilites.recupererClientForage(codeClientASupprimer));
				break;
			default:
				System.out.println("Choix non diponible ");
				break;
			}
		} while (continuer);
	}

}
