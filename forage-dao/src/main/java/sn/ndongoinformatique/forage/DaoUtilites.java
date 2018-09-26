package sn.ndongoinformatique.forage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Cette classe permet de recuperer les objets dans la base que ca soit un
 * client,commpteur etc...
 * 
 * @author Modou Ndongo
 * @since 04/08/2018
 * @version 1.0 SNAPSHOT
 */
public class DaoUtilites {
	static Connection con = MysqlConnection.getInstanceConnection();

	/**
	 * Cette methode de retourner un client en lui fournissant son code
	 * 
	 * @param codeClient
	 *            represente le code du client
	 * @return un client
	 */
	public static ClientForage recupererClientForage(String codeClient) {
		ClientForage client = new ClientForage();
		try {

			// Etape 1 : Création de la zone de reqête
			String sql = "SELECT * FROM clientforages where idclientforage=?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, codeClient);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				client.setCodePersonne(rs.getString("idclientforage"));
				client.setPrenomPersonne(rs.getString("prenom_clientforage"));
				client.setNomPersonne(rs.getString("nom_clientforage"));
				int villageId = rs.getInt("villages_id");
				client.setVillageClient(recupererVillage(villageId));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;

	}

	/*
	 * 
	 * 
	 * @param idvillage: le code du village
	 */
	/**
	 * Permet de recuperer un village par son code
	 * 
	 * @param idVillage
	 *            : le code du village
	 * @return le village
	 */
	public static Village recupererVillage(int idVillage) {
		Village vil = new Village();
		try {

			// Etape 1 : Création de la zone de reqête
			String sql = "SELECT * FROM villages where 	idvillages=?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, idVillage);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				vil.setCodeVillage(rs.getInt("idvillages"));
				vil.setNomVillage(rs.getString("nom_village"));
				vil.setNombreHabitant(rs.getInt("nhabitant_village"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vil;

	}

	/**
	 * permet de recupere un compteur par son code
	 * 
	 * @param codeCompteur:
	 *            represente le code du compteur
	 * @return : un objet de type compteur
	 */
	public static Compteur recupererCompteur(String codeCompteur) {
		Compteur compteur = new Compteur();
		try {

			// Etape 1 : Création de la zone de reqête
			String sql = "SELECT * FROM compteurs where idcompteurs=?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, codeCompteur);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				compteur.setNumeroCompteur(rs.getString("idcompteurs"));
				compteur.setAncienIndex(rs.getInt("ancien_index_compteur"));
				compteur.setNouveauIndex(rs.getInt("nouveau_index_compteur"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return compteur;

	}

	/**
	 * Permet de recuper un abonnement par son code
	 * 
	 * @param codeAbonnement
	 *            : represente le code de l'abonnement
	 * @return : retourne un abonnement ou null
	 */
	public static Abonnement recupererAbonnement(int codeAbonnement) {
		Abonnement abonnement = new Abonnement();
		try {

			// Etape 1 : Création de la zone de reqête
			String sql = "SELECT * FROM abonnements where idclientforage=?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, codeAbonnement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				abonnement.setIdAbonnement(codeAbonnement);
				abonnement.setClientForage(recupererClientForage(rs.getString("clientforage_id")));
				abonnement.setCompteur(recupererCompteur(rs.getString("compteurs_id")));
				abonnement.setDateAbonnement(rs.getDate("date_abonnement"));
				abonnement.setEtatAbonnement(rs.getString("etat_abonnement"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return abonnement;

	}

	/**
	 * Permet de vgerifier si un client est dans la base
	 * 
	 * @param cf:code
	 *            Client
	 * @return : retourne le code du client ou null .
	 */
	public String verifierCodeClient(ClientForage cf) {

		ClientForage client = new ClientForage();

		try {

			// Etape 1 : Création de la zone de reqête
			String sql = "SELECT * FROM clientforages where idclientforage=?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, cf.getCodePersonne());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				client.setCodePersonne(rs.getString("idclientforage"));
				client.setPrenomPersonne(rs.getString("prenom_clientforage"));
				client.setNomPersonne(rs.getString("nom_clientforage"));
				int villageId = rs.getInt("villages_id");
				client.setVillageClient(DaoUtilites.recupererVillage(villageId));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ((client.getCodePersonne()) == null) {
			System.out.println(" ce client nexiste pas dans la base ");
			return null;
		} else
			return client.getCodePersonne();

	}

	/**
	 * Permet de calculer le montant d'une facture
	 * 
	 * @param f:un
	 *            objet facture
	 * @return : retourne le montant de la facture
	 */
	public static Double calculerMontantFacture(Facture f) {
		double montanFactureCalculer = 0;
		int ancienIndx = f.getAbonnement().getCompteur().getAncienIndex();
		int nouveauIndex = f.getAbonnement().getCompteur().getNouveauIndex();
		montanFactureCalculer = (nouveauIndex - ancienIndx) * Facture.getPrixIndex();
		return montanFactureCalculer;
	}

	/**
	 * Permet de verifier si un abonnement est actif ou non
	 * 
	 * @param codeCompteur:code
	 *            du comteur
	 * @return
	 */
	public static String verifierCompteurAbonnement(String codeCompteur) {
		String numeroCompteur = null;
		try {

			// Etape 1 : Création de la zone de reqête
			String sql = "SELECT * FROM abonnements where compteurs_id=? and etat_abonnement=?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, codeCompteur);
			preparedStatement.setString(2, "actif");
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				numeroCompteur = rs.getString("compteurs_id");
				if (numeroCompteur != null) {
					return numeroCompteur;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numeroCompteur;

	}

}
