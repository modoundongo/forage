package sn.ndongoinformatique.forage;

import java.util.List;

public class IServiceAbonnementImpl implements IServiceAbonnement {
	// IDaoAbonnementImpl daoAbonnement=new IDaoAbonnementImpl();
	IServiceAbonnement serviceAbonnement;
	

	public IServiceAbonnement getServiceAbonnement() {
		return serviceAbonnement;
	}

	public void setServiceAbonnement(IServiceAbonnement serviceAbonnement) {
		this.serviceAbonnement = serviceAbonnement;
	}

	@Override
	public Boolean creer(Abonnement t) {

		return serviceAbonnement.creer(t);
	}

	@Override
	public void MisAjour(Abonnement t) {
		serviceAbonnement.MisAjour(t);
	}

	@Override
	public List<Abonnement> lister() {

		return serviceAbonnement.lister();
	}

	@Override
	public void supprimer(Abonnement t) {
		serviceAbonnement.supprimer(t);

	}

}
