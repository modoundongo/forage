package sn.ndongoinformatique.forage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Cette classe permet 
 @author Modou Ndongo
 * @since 04/08/2018
 * @version 1.0 SNAPSHOT
 *
 */

public class IDaoAbonnementImpl implements IDaoAbonnement {
	Connection con = MysqlConnection.getInstanceConnection();
	@Override
	public void create(Abonnement f) {
		if(f.getClientForage().getCodePersonne()==null || f.getCompteur().getNumeroCompteur()==null) {
			System.out.println("le client et le compteur doit exister");
		}else {

		try {
			//Etape1 : Création de la zone de requête
			String sql = "INSERT INTO abonnements VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//Etape 2 : transmission des valeurs aux parametres de la requête
			preparedStatement.setInt(1,f.getIdAbonnement());
			Date d=new Date(0);
			preparedStatement.setDate(2,f.getDateAbonnement());
			preparedStatement.setString(3,f.getClientForage().getCodePersonne());
			preparedStatement.setString(4, f.getCompteur().getNumeroCompteur());
			preparedStatement.setString(5,f.getEtatAbonnement());
			
			//Etape 3 : exécution de la requête
			preparedStatement.executeUpdate();
			System.out.println("Insertion réussit");
		} catch (SQLException e1) {
			System.out.println("Erreur à l'insertion");
			e1.printStackTrace();
		}
		}

	}

	@Override
	public void update(Abonnement f) {
		try {
			// Creation de la zone de requete
			String sql = "UPDATE abonnements SET idabonnements=?, etat_abonnement=? where idabonnements=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1,500);
			preparedStatement.setString(2,"Suspendu");
			preparedStatement.setInt(3,f.getIdAbonnement());
			preparedStatement.executeUpdate();
			System.out.println("Modification effectué");
		} catch (SQLException e1) {
			System.out.println("Erreur de mise à jour");
			e1.printStackTrace();
		}

	}

	@Override
	public List<Abonnement> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Abonnement f) {
		// TODO Auto-generated method stub

	}



}
