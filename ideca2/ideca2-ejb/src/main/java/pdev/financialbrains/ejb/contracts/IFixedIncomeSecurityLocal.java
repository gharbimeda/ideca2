package pdev.financialbrains.ejb.contracts;

import java.util.List;

import javax.ejb.Local;

import pdev.financialbrains.ejb.entities.FixedIncomeSecuritie;

@Local

public interface IFixedIncomeSecurityLocal {
	Double priceZeroCouponBond(Float faceValue,Integer timeMaturity,Float currentYield);
	  Double priceTreasuryBond(Float faceValue,Integer timeMaturity, Float currentYield,Integer frequency,Float couponRate);
	  Double priceCorpBond(Float faceValue,Integer timeMaturity, Float currentYield,Integer frequency,Float couponRate,Integer months);
	  public Boolean delete2(FixedIncomeSecuritie f);
	  public Boolean update2(FixedIncomeSecuritie f);
	  public Boolean add(FixedIncomeSecuritie f);
	  void create(FixedIncomeSecuritie f);

		void delete(FixedIncomeSecuritie f);

		void update(FixedIncomeSecuritie f);

		FixedIncomeSecuritie readById(Integer id);

		
		public Float dopricTreasuryBond(FixedIncomeSecuritie fx);

		List<FixedIncomeSecuritie> readAll();
}
