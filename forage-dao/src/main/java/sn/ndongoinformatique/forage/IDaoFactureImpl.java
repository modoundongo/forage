 package sn.ndongoinformatique.forage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class IDaoFactureImpl implements IDaoFacture {
	Connection con = MysqlConnection.getInstanceConnection();
	IDaoClientForageImpl daoClientForage=new IDaoClientForageImpl();
	IDaoAbonnementImpl daoAbonnementImpl=new IDaoAbonnementImpl();
	

	public IDaoFactureImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Facture f) {
		
		if(f.getAbonnement()==null) {
			System.out.println("l'abonnement ne doit pas etre null  ");
		}else {

		try {
			//Etape1 : Création de la zone de requête
			String sql = "INSERT INTO factures VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//Etape 2 : transmission des valeurs aux parametres de la requête
			preparedStatement.setInt(1, f.getCodeFacture());
			preparedStatement.setInt(2,f.getAbonnement().getIdAbonnement());
			preparedStatement.setDate(3,(Date) f.getDateDebutFacturation());
			preparedStatement.setDate(4, (Date) f.getDateFinFacturation());
		    preparedStatement.setDate(5,(Date) f.getDateLimiteFacturation());
		    
			//Etape 3 : exécution de la requête
			preparedStatement.executeUpdate();
			System.out.println("Insertion de l'abonnement reussi");
		} catch (SQLException e1) {
			System.out.println("Erreur pour linsertion de l'abonnement");
			e1.printStackTrace();
		}
		}

	}

	@Override
	public void update(Facture f) {
		System.out.println(" to  be implimented ");

	}

	@Override
	public List<Facture> list() {
		System.out.println(" to  be implimented ");
		return null;
	}

	@Override
	public void delete(Facture f) {
		System.out.println(" to  be implimented ");

	}



}
