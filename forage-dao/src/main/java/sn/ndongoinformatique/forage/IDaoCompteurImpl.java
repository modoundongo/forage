package sn.ndongoinformatique.forage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IDaoCompteurImpl implements IDaoCompteur {
	Connection con = MysqlConnection.getInstanceConnection();

	@Override
	public Boolean create(Compteur f) {
		try {
			// Etape1 : Création de la zone de requête
			String sql = "INSERT INTO compteurs VALUES(?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			// Etape 2 : transmission des valeurs aux parametres de la requête
			preparedStatement.setString(1, f.getNumeroCompteur());
			preparedStatement.setInt(2, f.getAncienIndex());
			preparedStatement.setInt(3, f.getNouveauIndex());
			// Etape 3 : exécution de la requête
			preparedStatement.executeUpdate();
			System.out.println("Insertion réussit");
		} catch (SQLException e1) {
			System.out.println("Erreur à l'insertion");
			e1.printStackTrace();
		}
		return true;
	}

	@Override
	public void update(Compteur f) {
		try {
			// Creation de la zone de requete
			String sql = "UPDATE compteurs SET ancien_index_compteur=?,nouveau_index_compteur=? WHERE idcompteurs=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, 300);
			preparedStatement.setInt(2, 500);
			preparedStatement.setString(3,f.getNumeroCompteur());
			preparedStatement.executeUpdate();
			System.out.println("Modification effectué");
		} catch (SQLException e1) {
			System.out.println("Erreur de mise à jour");
			e1.printStackTrace();
		}
	}

	@Override
	public List<Compteur> list() {
		List<Compteur> list = new ArrayList<>();
		try {
			//Etape 1 : Création de la zone de reqête
			String sql = "SELECT * FROM compteurs";
			Statement statement = con.createStatement();
			//Etape 2: Exécution de la requête
			ResultSet resultSet = statement.executeQuery(sql);
			//Traitement du resultat
			
			while(resultSet.next()) {
				Compteur compteur=new Compteur();
				String codeCompteur=resultSet.getString("idcompteurs");
				compteur.setNumeroCompteur(resultSet.getString("idcompteurs"));
				compteur.setAncienIndex(resultSet.getInt("ancien_index_compteur"));
				compteur.setNouveauIndex(resultSet.getInt("nouveau_index_compteur"));
				
				list.add(compteur);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void delete(Compteur f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nouveauIndex(Compteur f) {
		// TODO Auto-generated method stub

	}

}
