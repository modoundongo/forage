package sn.ndongoinformatique.forage;

import java.util.List;

public class IServiceAbonnementImpl implements IServiceAbonnement {
IDaoAbonnementImpl daoAbonnement=new IDaoAbonnementImpl();
	@Override
	public void creer(Abonnement t) {
		
 daoAbonnement.create(t);
	}

	@Override
	public void MisAjour(Abonnement t) {
		daoAbonnement.update(t);
	}

	@Override
	public List<Abonnement> lister() {
		
		return daoAbonnement.list();
	}

	@Override
	public void supprimer(Abonnement t) {
		daoAbonnement.delete(t);

	}

}
