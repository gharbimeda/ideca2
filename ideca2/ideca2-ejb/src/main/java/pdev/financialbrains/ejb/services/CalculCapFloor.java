package pdev.financialbrains.ejb.services;

public class CalculCapFloor {

	public static Double CNDF(double x) {
		int neg = (x < 0d) ? 1 : 0;
		if (neg == 1)
			x *= -1d;

		double k = (1d / (1d + 0.2316419 * x));
		double y = ((((1.330274429 * k - 1.821255978) * k + 1.781477937) * k - 0.356563782) * k + 0.319381530) * k;
		y = 1.0 - 0.398942280401 * Math.exp(-0.5 * x * x) * y;

		return (1d - neg) * y + neg * (1d - y);
	}
	
	public static Integer nDays(Integer tenor){
		if (tenor == 3){
			return 90;
		}
		if (tenor == 6){
			return 180;
		}
		if(tenor == 12){
			return 360;
		}
		return 0;
	}
	
	public static double europeanOption(boolean operationType, boolean cF, float s, float k, double r, float q, float v,float t) {
		double d1 = 0;
		double d2 = 0;
		double euroOption = 0;

		d1 = Math.log(s / k) + ((r - q + 0.5 * Math.pow(v, 2)) * t / (v * Math.sqrt(t)));
		d2 = Math.log(s / k) + ((r - q - 0.5 * Math.pow(v, 2)) * t / (v * Math.sqrt(t)));

	
		double nd1 = CNDF(d1);
		double nd2 = CNDF(d2);
		double nnd1 = CNDF(-d1);
		double nnd2 = CNDF(-d2);
		System.out.println(nd1 + "  " + "   " + nd2 + "  " + nnd1 + "    " + "  " + nnd2);
		if (operationType == true) {
			euroOption = s * Math.exp(-q * t) * nnd1 - k * Math.exp(-r * t) * nnd2;
		} else

			euroOption = s * Math.exp(-q * t) * nnd1 + k * Math.exp(-r * t) * nnd2;
		return euroOption;
	}
	
	public static double calculD1(){
		return 0.0 ;
	}
	
	
}
