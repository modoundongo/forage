package sn.ndongoinformatique.forage;

import java.util.Scanner;

public class MenuVillage {
	 Scanner sc = new Scanner(System.in);
	 Village village;
	public  Village saisieVillage() {
		System.out.println("******** village à ajouter *********");
		System.out.println("Donner le code du village   : ");
		int codeVillage = sc.nextInt();
		sc.nextLine();
		System.out.println("Donner le nom : ");
		String nomVillage = sc.nextLine();
		System.out.println("Donner le nombre habitant  : ");
		int nombreHabitant = sc.nextInt();
		village=new Village(codeVillage, nomVillage, nombreHabitant);
		return village;
		
	}

	public static void main(String[] args) {
		

	}

}
