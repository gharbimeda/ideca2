package pdev.financialbrains.managedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pdev.financialbrains.ejb.contracts.IEquityOptionCrudServicesRemote;
import pdev.financialbrains.ejb.services.BlackScholesGreeks2;

@ManagedBean
@SessionScoped
public class PricingOptionBean {
	
	private IEquityOptionCrudServicesRemote eql;
	@EJB
	private BlackScholesGreeks2 er;
	private  String CallPutFlag;
	private double S;
	private double X;
	private double T;
	private double resultat ;
	private double[] p = new double[6];
	private double r;
	private double v ;

	  private String   resultatmessagedelta;
	  private String resultatmessagethehta;
	 private String resultatmessageRho;
	 private String resultatmessageGamma;
	   private String resultatmessageVega;
	  


	
	public double  doBlackScholes(String CallPutFlag, double  S, double X, double T, double r, double v) {
	
		
		double d1, d2;

		d1 = (Math.log(S / X) + (r + v * v / 2) * T) / (v * Math.sqrt(T));
		d2 = d1 - v * Math.sqrt(T);

		if (CallPutFlag == "Call") {
			System.out.println("call" + CallPutFlag);
			resultat = S * CND(d1) - X * Math.exp(-r * T) * CND(d2); 
			System.out.println(resultat);
			return resultat;
			
		} else {
			  resultat = X * Math.exp(-r * T) * CND(-d2) - S * CND(-d1);
			  System.out.println(resultat);
			  return resultat ; 
		}

		//return this.resultat = eql.BlackScholes(CallPutFlag, S, X, T, r, v);
		
		
	}


	public double CND(double X) {
		double L, K, w;
		double a1 = 0.31938153, a2 = -0.356563782, a3 = 1.781477937, a4 = -1.821255978, a5 = 1.330274429;
		L = Math.abs(X);
		System.out.println("l est" + L);
		K = 1.0 / (1.0 + 0.2316419 * L);
		System.out.println("k est " + K);
		w = 1.0 - 1.0 / Math.sqrt(2.0 * Math.PI) * Math.exp(-L * L / 2)
				* (a1 * K + a2 * K * K + a3 * Math.pow(K, 3) + a4 * Math.pow(K, 4) + a5 * Math.pow(K, 5));

		if (X < 0.0) {
			System.out.println(" x est negative");
			w = 1.0 - w;
		}
		System.out.println(" x est +");
		return w;
	}
	
	public String doGreeks(){
		 System.out.println("amine");
		
p= er.calculate(CallPutFlag, X, S, r, T,v );
	      resultatmessagedelta= "  Delta  "+p[1];
	  resultatmessagethehta=" Gamma "+p[4];
	     resultatmessageRho=" Rho "+p[5];
	      
	    resultatmessageGamma= "  Gamma "+p[2];
	      resultatmessageVega= "Vega  "+p[3];
		return "/trader/pricing/options?faces-redirect=true";	
		
	}

	
	
	
	
	
	
	
	
	
	public double[] getP() {
		return p;
	}


	public void setP(double[] p) {
		this.p = p;
	}


	public String getResultatmessagedelta() {
		return resultatmessagedelta;
	}


	public void setResultatmessagedelta(String resultatmessagedelta) {
		this.resultatmessagedelta = resultatmessagedelta;
	}


	public String getResultatmessagethehta() {
		return resultatmessagethehta;
	}


	public void setResultatmessagethehta(String resultatmessagethehta) {
		this.resultatmessagethehta = resultatmessagethehta;
	}


	public String getResultatmessageRho() {
		return resultatmessageRho;
	}


	public void setResultatmessageRho(String resultatmessageRho) {
		this.resultatmessageRho = resultatmessageRho;
	}


	public String getResultatmessageGamma() {
		return resultatmessageGamma;
	}


	public void setResultatmessageGamma(String resultatmessageGamma) {
		this.resultatmessageGamma = resultatmessageGamma;
	}


	public String getResultatmessageVega() {
		return resultatmessageVega;
	}


	public void setResultatmessageVega(String resultatmessageVega) {
		this.resultatmessageVega = resultatmessageVega;
	}


	public void setS(double s) {
		S = s;
	}


	public void setX(double x) {
		X = x;
	}


	public void setT(double t) {
		T = t;
	}


	public void setResultat(double resultat) {
		this.resultat = resultat;
	}


	public void setR(double r) {
		this.r = r;
	}


	public void setV(double v) {
		this.v = v;
	}


	public String getCallPutFlag() {
		return CallPutFlag;
	}
	public void setCallPutFlag(String callPutFlag) {
		CallPutFlag = callPutFlag;
	}
	public Double getS() {
		return S;
	}
	public void setS(Double s) {
		S = s;
	}
	public Double getX() {
		return X;
	}
	public void setX(Double x) {
		X = x;
	}
	public Double getT() {
		return T;
	}
	public void setT(Double t) {
		T = t;
	}
	public Double getR() {
		return r;
	}
	public void setR(Double r) {
		this.r = r;
	}
	public Double getV() {
		return v;
	}
	public void setV(Double v) {
		this.v = v;
	}
	public Double getResultat() {
		return resultat;
	}
	public void setResultat(Double resultat) {
		this.resultat = resultat;
	} 
	
	
	

}
