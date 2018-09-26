package sn.ndongoinformatique.forage;

import java.util.ListIterator;
import java.util.Scanner;

public class MenuCompteur {

	
		static IServiceCompteurImpl serviceCompteur=new IServiceCompteurImpl();
		public static void affMenuCompteur() {
			

		
			Scanner sc = new Scanner(System.in);
			Compteur compteur;
			
			String en;

			Boolean continuer = true;
			do {
				System.out.println("-----------------------------------------------");
				System.out.println("****  Gestion des Compteurs *****");
				System.out.println();
				System.out.println("1 : Ajouter un compteur ");
				System.out.println("2 : Liste des compteurs ");
				System.out.println("3 : Mise a jour d'un compteur");
				System.out.println("4 : Supprimer un compteur ");
				System.out.println("0 : Retour menu general ");

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
					System.out.println("******** Compteur a ajouter *********");
					System.out.println("Donner le code du compteur  : ");
					String codeCompteur = sc.nextLine();
					System.out.println("Donner lancien index : ");
					int ancienIndex = sc.nextInt();
					System.out.println("Donner le nouveau index : ");
					int nouveauIndex= sc.nextInt();
					compteur=new Compteur(codeCompteur, ancienIndex, nouveauIndex);
				
					serviceCompteur.creer(compteur);
					break;
				case 2:
					ListIterator listCompteur=serviceCompteur.lister().listIterator();
					while(listCompteur.hasNext()) {
						System.out.println(listCompteur.next());
					System.out.println("---------------------------------");
					}
					
					break;
				case 3:
					//serviceCompteur.MisAjour(t);
					break;
				case 4:
					sc.nextLine();
					System.out.println("******** Compteur à supprimer *********");
					System.out.println("Donner le numero du compteur : ");
					String codeCompteurASupprimer = sc.nextLine();
					serviceCompteur.supprimer(DaoUtilites.recupererCompteur(codeCompteurASupprimer));
					break;
				default:
					System.out.println("Choix non diponible ");
					break;
				}
			} while (continuer);
		}

	}

