package sn.ndongoinformatique.forage;

import java.util.List;

public class IServiceCompteurImpl implements IServiceCompteur {
	IDaoCompteurImpl daoCompteur=new IDaoCompteurImpl();

	@Override
	public Boolean creer(Compteur t) {
		return daoCompteur.create(t);

	}

	@Override
	public void MisAjour(Compteur t) {
		daoCompteur.update(t);

	}

	@Override
	public List<Compteur> lister() {
		
		return daoCompteur.list();
	}

	@Override
	public void supprimer(Compteur t) {
		daoCompteur.delete(t);
	}

}
