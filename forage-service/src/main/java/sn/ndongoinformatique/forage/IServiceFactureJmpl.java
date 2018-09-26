package sn.ndongoinformatique.forage;

import java.util.List;

public class IServiceFactureJmpl implements IServiceFacture {
IDaoFactureImpl daoFacture=new IDaoFactureImpl();
	@Override
	public void creer(Facture t) {
		
daoFacture.create(t);
	}

	@Override
	public void MisAjour(Facture t) {
		daoFacture.update(t);

	}

	@Override
	public List<Facture> lister() {
	
		return daoFacture.list();
	}

	@Override
	public void supprimer(Facture t) {
		daoFacture.delete(t);
	}

}
