package sn.ndongoinformatique.forage;

import java.util.List;

public interface IServiceGenerique<T> {
	public void creer(T t);
	public void MisAjour(T t);
	public List<T> lister();
	public void supprimer(T t);
	

}
