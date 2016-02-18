package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.CapFloor;

@Remote
public interface ICapFloorServiceRemote {

	void create(CapFloor capFloor);

	void update(CapFloor capFloor);

	void delete(CapFloor capFloor);

	CapFloor read(Integer id);

	List<CapFloor> readAll();
}
