package sn.ndongoinformatique.forage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class IDaoVillageImpl implements IDaoVillage {
	Connection con = MysqlConnection.getInstanceConnection();
	@Override
	public Boolean create(Village v) {
		try {
			//Etape1 : Création de la zone de requête
			String sql = "INSERT INTO villages VALUES(?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//Etape 2 : transmission des valeurs aux parametres de la requête
			preparedStatement.setInt(1,v.getCodeVillage());
			preparedStatement.setString(2,v.getNomVillage());
			preparedStatement.setInt(3,v.getNombreHabitant());
			
			
			//Etape 3 : exécution de la requête
			preparedStatement.executeUpdate();
			System.out.println("Insertion réussit");
		} catch (SQLException e1) {
			System.out.println("Erreur à l'insertion");
			e1.printStackTrace();
		}
		
		return true;
		} 
	



	@Override
	public void update(Village f) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Village> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Village f) {
		// TODO Auto-generated method stub

	}




	

}
