package sn.ndongoinformatique.forage;

public class Village {
	private int codeVillage;
	private String nomVillage;
	private int nombreHabitant;
	public Village() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Village(int codeVillage, String nomVillage) {
		super();
		this.codeVillage = codeVillage;
		this.nomVillage = nomVillage;
	}
	
	public Village(int codeVillage, String nomVillage, int nombreHabitant) {
		super();
		this.codeVillage = codeVillage;
		this.nomVillage = nomVillage;
		this.nombreHabitant = nombreHabitant;
	}
	public int getCodeVillage() {
		return codeVillage;
	}
	public void setCodeVillage(int codeVillage) {
		this.codeVillage = codeVillage;
	}
	public String getNomVillage() {
		return nomVillage;
	}
	public void setNomVillage(String nomVillage) {
		this.nomVillage = nomVillage;
	}
	public int getNombreHabitant() {
		return nombreHabitant;
	}
	public void setNombreHabitant(int nombreHabitant) {
		this.nombreHabitant = nombreHabitant;
	}
	@Override
	public String toString() {
		return "[code:" + codeVillage + ", nom" + nomVillage + ", nombreHabitant:"
				+ nombreHabitant + "]";
	}
	

}
