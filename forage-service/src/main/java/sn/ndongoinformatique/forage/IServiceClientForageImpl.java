package sn.ndongoinformatique.forage;

import java.util.List;

public class IServiceClientForageImpl implements IServiceClientForage {
	IDaoClientForageImpl daoClient =new IDaoClientForageImpl();

	@Override
	public Boolean creer(ClientForage t) {
		
return daoClient.create(t);
	}

	@Override
	public void MisAjour(ClientForage t) {
		daoClient.update(t);

	}

	@Override
	public List<ClientForage> lister() {
		
		return daoClient.list();
	}

	@Override
	public void supprimer(ClientForage t) {
		daoClient.delete(t);
	}

}
