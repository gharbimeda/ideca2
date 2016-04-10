package pdev.financialbrains.ejb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pdev.financialbrains.ejb.contracts.IForwardSwapCrudServicesLocal;
import pdev.financialbrains.ejb.contracts.IForwardSwapCrudServicesRemote;
import pdev.financialbrains.ejb.entities.ForwardSwap;

@Stateless
public class ForwardSwapCrudServices implements IForwardSwapCrudServicesLocal, IForwardSwapCrudServicesRemote {

	@PersistenceContext(unitName = "data")
	private EntityManager entityManager;
	private List<ForwardSwap> forwardSwaps;

	public ForwardSwapCrudServices() {
	}

	public List<ForwardSwap> getForwardSwaps() {
		return forwardSwaps;
	}

	public void setForwardSwaps(List<ForwardSwap> forwardSwaps) {
		this.forwardSwaps = forwardSwaps;
	}

	@Override
	public void create(ForwardSwap forwardSwap) {
		entityManager.persist(forwardSwap);
	}

	@Override
	public void delete(ForwardSwap forwardSwap) {
		entityManager.remove(entityManager.find(ForwardSwap.class, forwardSwap.getId()));
	}

	@Override
	public ForwardSwap update(ForwardSwap forwardSwap) {
		ForwardSwap fs = entityManager.merge(forwardSwap);
		return fs;
	}

	@Override
	public ForwardSwap readById(Integer id) {
		return entityManager.find(ForwardSwap.class, id);
	}

	@Override
	public List<ForwardSwap> readAll() {
		return entityManager.createQuery("select f from ForwardSwap f ", ForwardSwap.class).getResultList();
	}

	@Override
	public Double priceForwardSwap(Float strikeRate, Float rate, Float notional, Float period, Float expiryTime,
			Float volatility) {

		Double discountFactor = (1 - (Math.pow(1 + rate, period))) / (1 - (1 + rate));
		Double a = 0d;
		for (int i = 0; i < period; i++) {
			a = a + (discountFactor * period);
		}
		a = a * (notional);

		Double d1;
		d1 = ((Math.log((rate / strikeRate)) + ((0.5 * Math.pow(volatility, 2)) * expiryTime))
				/ (volatility * (Math.sqrt(expiryTime))));

		Double d2;
		d2 = d1 - (volatility * Math.sqrt(expiryTime));

		Double op;
		return (discountFactor * a) * ((rate * N(d1)) - (strikeRate * N(d2)));
	}

	public double N(double z) {
		double zabs;
		double p;
		double expntl, pdf;

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
		// |z| > 37
		if (z > 37.0) {
			p = 1.0;
			return p;
		}
		if (z < -37.0) {
			p = 0.0;
			return p;
		}
		// |z| <= 37.
		expntl = Math.exp(-.5 * zabs * zabs);
		pdf = expntl / root2pi;
		// |z| < cutoff = 10/sqrt(2).
		if (zabs < cutoff) {
			p = expntl * ((((((p6 * zabs + p5) * zabs + p4) * zabs + p3) * zabs + p2) * zabs + p1) * zabs + p0)
					/ (((((((q7 * zabs + q6) * zabs + q5) * zabs + q4) * zabs + q3) * zabs + q2) * zabs + q1) * zabs
							+ q0);
		} else {
			p = pdf / (zabs + 1.0 / (zabs + 2.0 / (zabs + 3.0 / (zabs + 4.0 / (zabs + 0.65)))));
		}
		if (z < 0.0) {
			return p;
		} else {
			p = 1.0 - p;
			return p;
		}
	}

	@Override
	public ForwardSwap readByCurrentPrice(Float currentPrice) {
		Query query = entityManager.createQuery("select f from ForwardSwap f where f.fixedRate=:x");
		query.setParameter("x", currentPrice);
		forwardSwaps = query.getResultList();
		return forwardSwaps.get(0);
	}

}
