package pdev.financialbrains.ejb.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_fixedIncomeSecuritie")
public class FixedIncomeSecuritie extends DerivativeInstrument {

	// private Integer notional;
		private Integer timeMaturity;
		private Integer couponFreq;
		// private Boolean steppedBond;
		// private Boolean rollDate;
		// private Boolean firstCoupon;
		private Float faceValue;
		// private Boolean weekend;
		private Float couponRate;
		private Float yield;
		private Float currentYield;
		private Double bondPrice;
		private int months;
		private int bd;
		
		
		public String getbdString(){
			if (bd == 0){
				return "ZCB";
			}else if(bd== 1)
			{
				return "treasury";
			} else return "treasury";
		}
		
		public int getMonths() {
			return months;
		}

		public void setMonths(int months) {
			this.months = months;
		}

		private static final long serialVersionUID = 1L;

		public Integer getTimeMaturity() {
			return timeMaturity;
		}

		public void setTimeMaturity(Integer timeMaturity) {
			this.timeMaturity = timeMaturity;
		}

		public Integer getCouponFreq() {
			return couponFreq;
		}

		public void setCouponFreq(Integer couponFreq) {
			this.couponFreq = couponFreq;
		}

		public Float getFaceValue() {
			return faceValue;
		}

		public void setFaceValue(Float faceValue) {
			this.faceValue = faceValue;
		}

		public Float getCouponRate() {
			return couponRate;
		}

		public void setCouponRate(Float couponRate) {
			this.couponRate = couponRate;
		}

		public Float getYield() {
			return yield;
		}

		public void setYield(Float yield) {
			this.yield = yield;
		}

		public Float getCurrentYield() {
			return currentYield;
		}

		public void setCurrentYield(Float currentYield) {
			this.currentYield = currentYield;
		}

		public Double getBondPrice() {
			return bondPrice;
		}

		public void setBondPrice(Double bondPrice) {
			this.bondPrice = bondPrice;
		}

		public int getBd() {
			return bd;
		}

		public void setBd(int bd) {
			this.bd = bd;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public FixedIncomeSecuritie(Integer timeMaturity, Integer couponFreq, Float faceValue, Float couponRate,
				Float yield, Float currentYield, Double bondPrice) {
			super();
			this.timeMaturity = timeMaturity;
			this.couponFreq = couponFreq;
			this.faceValue = faceValue;
			this.couponRate = couponRate;
			this.yield = yield;
			this.currentYield = currentYield;
			this.bondPrice = bondPrice;
		}

		public FixedIncomeSecuritie() {
			super();
		}

		@Override
		public String toString() {
			return "FixedIncomeSecuritie [timeMaturity=" + timeMaturity + ", couponFreq=" + couponFreq + ", faceValue="
					+ faceValue + ", couponRate=" + couponRate + ", yield=" + yield + ", currentYield=" + currentYield
					+ ", bondPrice=" + bondPrice + ", toString()=" + super.toString() + "]";
		}

		public FixedIncomeSecuritie(Integer id, Float currentPrice, Float volatility, Integer timeMaturity,
				Integer couponFreq, Float faceValue, Float couponRate, Float yield, Float currentYield, Double bondPrice) {
			super(id, currentPrice, volatility);
			this.timeMaturity = timeMaturity;
			this.couponFreq = couponFreq;
			this.faceValue = faceValue;
			this.couponRate = couponRate;
			this.yield = yield;
			this.currentYield = currentYield;
			this.bondPrice = bondPrice;
		}
}