package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pdev.financialbrains.ejb.contracts.IFxoptionCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IFxoptionCrudServicesRemote;
import pdev.financialbrains.ejb.entities.ForeignExchangeOption;

@Stateless
public class FxoptionCrudServices implements IFxoptionCrudServicesLocal,IFxoptionCrudServicesRemote {

	@PersistenceContext(unitName="md")
	private EntityManager entityManager;
	
	public FxoptionCrudServices() {

	}
	@Override
	public void create(ForeignExchangeOption fxoption) {
		entityManager.persist(fxoption);
		
	}

	@Override
	public void update(ForeignExchangeOption fxoption) {
		entityManager.merge(fxoption);
		
	}

	@Override
	public void delete(ForeignExchangeOption fxoption) {
		entityManager.remove(entityManager.merge(fxoption));
		
	}

	@Override
	public ForeignExchangeOption read(Integer id) {
		
		return entityManager.find(ForeignExchangeOption.class, id);
	}

	@Override
	public List<ForeignExchangeOption> readAll() {

		return entityManager.createQuery("select f from t_foreignExchangeOption f",ForeignExchangeOption.class).getResultList();
	}
	@Override
	public Double Pricing(Integer callPut, Integer currentSpotPrice, Integer dRisk, Integer fRisk, Integer time,
			Float strikePrice, Float volatilite) {
		
		Double price = null ;
		//price =1.22545298;
		
		double d1=(Math.log(currentSpotPrice/strikePrice)+(dRisk-fRisk+volatilite*volatilite*0.5)*time )/(volatilite*Math.sqrt(time ));
		double d2=d1-volatilite*Math.sqrt(time );
		if(callPut==0)
		{ 
			//price=1.35;
			price=currentSpotPrice*Math.exp(-fRisk*time)*N(d1)-strikePrice*Math.exp(-dRisk *time)*N(d2);
			//System.out.println(price);
			//return price;
		}
	     if (callPut==1){
			//price=5.5;
			price=strikePrice*Math.exp(-dRisk *time)*N(-d2)-currentSpotPrice*Math.exp(-fRisk*time)*N(-d1);
			//System.out.println(price);
			//return price;
		}
		
		return price;
	}
	public  double N(double z) {
		 double zabs;
	      double p;
	      double expntl,pdf;

	      final double p0 = 220.2068679123761;
	      final double p1 = 221.2135961699311;
	      final double p2 = 112.0792914978709;
	      final double p3 = 33.91286607838300;
	      final double p4 = 6.373962203531650;
	      final double p5 = .7003830644436881;
	      final double p6 = .3526249659989109E-01;

	      final double q0 = 440.4137358247522;
	      final double q1 = 793.8265125199484;
	      final double q2 = 637.3336333788311;
	      final double q3 = 296.5642487796737;
	      final double q4 = 86.78073220294608;
	      final double q5 = 16.06417757920695;
	      final double q6 = 1.755667163182642;
	      final double q7 = .8838834764831844E-1;

	      final double cutoff = 7.071;
	      final double root2pi = 2.506628274631001;

	      zabs = Math.abs(z);

	//  |z| > 37

	      if (z > 37.0) {

	         p = 1.0;

	         return p;

	      }

	      if (z < -37.0) {

	         p = 0.0;

	         return p;

	      }

	//  |z| <= 37.

	      expntl = Math.exp(-.5*zabs*zabs);

	      pdf = expntl/root2pi;

	//  |z| < cutoff = 10/sqrt(2).

	      if (zabs < cutoff) {

	         p = expntl*((((((p6*zabs + p5)*zabs + p4)*zabs + p3)*zabs +
	             p2)*zabs + p1)*zabs + p0)/(((((((q7*zabs + q6)*zabs +
	             q5)*zabs + q4)*zabs + q3)*zabs + q2)*zabs + q1)*zabs +
	             q0);

	      } else {

	         p = pdf/(zabs + 1.0/(zabs + 2.0/(zabs + 3.0/(zabs + 4.0/
	             (zabs + 0.65)))));

	      }

	      if (z < 0.0) {

	         return p;

	      } else {

	         p = 1.0 - p;

	         return p;

	      }

	   }


	
}
