package pdev.financialbrains.ejb.contracts;

import java.util.Date;
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
  Float priceZeroCouponBond(Float faceValue,Float timeMaturity,Float currentYield);
  Float priceTreasuryBond(Float faceValue,Float timeMaturity, Float currentYield,Integer frequency,Float couponRate);
 Float priceCorpBond(Float faceValue,Float timeMaturity, Float currentYield,Integer frequency,Float couponRate,Integer months);

}
