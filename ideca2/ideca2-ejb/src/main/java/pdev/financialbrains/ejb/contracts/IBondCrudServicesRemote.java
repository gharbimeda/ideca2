package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.Bond;

@Remote
public interface IBondCrudServicesRemote {
	void create(Bond b);

	void delete(Bond b);

	void update(Bond b);

	Bond readById(Integer id);

	List<Bond> readBySteppedCoupon(Integer steppedCoupon);

	List<Bond> readAll();

}
