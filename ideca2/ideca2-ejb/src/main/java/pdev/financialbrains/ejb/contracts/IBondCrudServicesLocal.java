package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.Bond;

@Local
public interface IBondCrudServicesLocal {
	void create(Bond b);

	void delete(Bond b);

	void update(Bond b);

	Bond readById(Integer id);

	List<Bond> readBySteppedCoupon(Integer steppedCoupon);

	List<Bond> readAll();
}
