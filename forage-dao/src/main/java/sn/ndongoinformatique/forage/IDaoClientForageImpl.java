/**
 * 
 */
package sn.ndongoinformatique.forage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * @author NdongoInfo
 *
 */
public class IDaoClientForageImpl implements IDaoClientForage  {
	Connection con = MysqlConnection.getInstanceConnection();
	// ma methode
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see sn.ndongoinformatique.gestionforage.dao.IDaoGenerique#create(java.lang.
	 * Object)
	 */
	
	@Override
	public Boolean create(ClientForage f) {
		IDaoVillageImpl villageImpl=new IDaoVillageImpl();
		
		try {
			//Etape1 : Création de la zone de requête
			String sql = "INSERT INTO clientforages VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//Etape 2 : transmission des valeurs aux parametres de la requête
			preparedStatement.setString(1,f.getCodePersonne());
			preparedStatement.setString(2, f.getPrenomPersonne());
			preparedStatement.setString(3,f.getNomPersonne());
			preparedStatement.setInt(4, f.getVillageClient().getCodeVillage());
			Village v=new Village(f.getVillageClient().getCodeVillage(), f.getVillageClient().getNomVillage(), f.getVillageClient().getNombreHabitant());
			villageImpl.create(v);
			
			//Etape 3 : exécution de la requête
			preparedStatement.executeUpdate();
			System.out.println("Insertion du client réussit");
		} catch (SQLException e1) {
			System.out.println("Erreur à l'insertion");
			e1.printStackTrace();
		}
		return true;

		} 
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see sn.ndongoinformatique.gestionforage.dao.IDaoGenerique#update(java.lang.
	 * Object)
	 */
	@Override
	public void update(ClientForage f) {
		try {
			// Creation de la zone de requete
			String sql="UPDATE clientforages SET prenom_clientforage=?,nom_clientforage=?"
					+ "WHERE 	idclientforage=?";
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1,f.getPrenomPersonne());
			preparedStatement.setString(2, f.getNomPersonne());
			preparedStatement.setString(3,f.getCodePersonne());
			preparedStatement.executeUpdate();
			System.out.println("Modification effectué");
		} catch (SQLException e1) {
			System.out.println("Erreur de mise à jour");
			e1.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sn.ndongoinformatique.gestionforage.dao.IDaoGenerique#list()
	 */
	@Override
	public List<ClientForage> list() {
		List<ClientForage> list = new ArrayList<>();
		try {
			//Etape 1 : Création de la zone de reqête
			String sql = "SELECT * FROM clientforages";
			Statement statement = con.createStatement();
			//Etape 2: Exécution de la requête
			ResultSet resultSet = statement.executeQuery(sql);
			//Traitement du resultat
			
			while(resultSet.next()) {
				ClientForage e =new ClientForage();
				int villageId=resultSet.getInt("villages_id");
				e.setCodePersonne(resultSet.getString("idclientforage"));
				e.setPrenomPersonne(resultSet.getString("prenom_clientforage"));
				e.setNomPersonne(resultSet.getString("nom_clientforage"));
				e.setVillageClient(DaoUtilites.recupererVillage(villageId));
				list.add(e);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sn.ndongoinformatique.gestionforage.dao.IDaoGenerique#delete(java.lang.
	 * Object)
	 */
	@Override
	public void delete(ClientForage f) {
try {
			
			
		
		//étape 2:création de la zone de requête
		String sql="delete from clientforages where idclientforage=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		//etape 3 : transmission des valeurs 
		ps.setString(1,f.getCodePersonne());
		//étape 4: execution de la requête
		ps.executeUpdate();
		System.out.println("Suppresion du client avec success");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erreur pour suppresion client ");
		}


	}






}
