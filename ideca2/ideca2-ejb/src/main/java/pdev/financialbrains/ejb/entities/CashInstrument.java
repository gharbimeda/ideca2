package pdev.financialbrains.ejb.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CashInstrument extends FinancialInstrument {

	private String symbol;
	private static final long serialVersionUID = 1L;

	public CashInstrument() {
		// TODO Auto-generated constructor stub
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CashInstrument other = (CashInstrument) obj;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CashInstrument [symbol=" + symbol + ", toString()=" + super.toString() + "]";
	}

	public CashInstrument(Integer id, Float currentPrice, Float volatility, String symbol) {
		super(id, currentPrice, volatility);
		this.symbol = symbol;
	}

}
