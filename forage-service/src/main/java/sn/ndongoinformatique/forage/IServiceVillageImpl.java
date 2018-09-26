package sn.ndongoinformatique.forage;

import java.util.List;

public class IServiceVillageImpl implements IServiceVillage {
	private IDaoVillageImpl serviceVillageImp = new IDaoVillageImpl();

	@Override
	public void creer(Village t) {

		serviceVillageImp.create(t);
	}

	@Override
	public void MisAjour(Village t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Village> lister() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimer(Village t) {
		// TODO Auto-generated method stub

	}

}
