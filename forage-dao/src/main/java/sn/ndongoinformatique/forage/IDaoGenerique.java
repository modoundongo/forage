/**
 * 
 */
package sn.ndongoinformatique.forage;

import java.util.List;

/**
 * @author NdongoInfo
 *
 */
public interface IDaoGenerique<F>{
	public void create(F f);
	public void update(F f);
	public List<F> list();
	public void delete(F f);
	
	

}
