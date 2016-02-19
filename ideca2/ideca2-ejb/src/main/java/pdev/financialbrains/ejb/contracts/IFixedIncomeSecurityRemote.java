package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Remote;

import pdev.financialbrains.ejb.entities.FixedIncomeSecuritie;



@Remote
public interface IFixedIncomeSecurityRemote {
	void create(FixedIncomeSecuritie f);

	void delete(FixedIncomeSecuritie f);

	void update(FixedIncomeSecuritie f);

	FixedIncomeSecuritie readById(Integer id);

	

	List<FixedIncomeSecuritie> readAll();
  Double priceZeroCouponBond(Float faceValue,Integer timeMaturity,Float currentYield);

}
