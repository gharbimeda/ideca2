package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.MdBond;
/*
 * Mariem
 */

@Local
public interface IMDBondCrudServiceLocal {
	public List<MdBond> readAll();
	public void remove(MdBond mbond);
	public void add(MdBond mbond);
}
