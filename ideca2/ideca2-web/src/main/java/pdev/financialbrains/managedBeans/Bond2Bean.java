package pdev.financialbrains.managedBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@ManagedBean(name="bond")
public class Bond2Bean {
	
	public static List<Float> BondYieldToday;
	public String maturity;

	public static List<Float> getBondYieldToday() {
		return BondYieldToday;
	}



	public static void setBondYieldToday(List<Float> bondYieldToday) {
		BondYieldToday = bondYieldToday;
	}



	@PostConstruct
	public void init() {
		
		BondYieldToday =list_bond_yield_today();

	}
	
	
	
	
	public List<Float> list_bond_yield_today(){
		List<String> yield = new ArrayList<>();
		List<String> bondYield = new ArrayList<>();
		List<Float> bondYieldFinal = new ArrayList<>();
	      String html = "http://finance.yahoo.com/bonds";
	        try {
	           Document doc = Jsoup.connect(html).get();
	           Elements tableElements = doc.select("table");
	           Elements tableHeaderEles = tableElements.select("thead tr th");
	          
	           for (int i = 0; i < tableHeaderEles.size(); i++) {
	              
	           }
	           
	           Elements tableRowElements = tableElements.select(":not(thead) tr");
	           for (int i = 1; i < tableRowElements.size()-2; i++) {
	              Element row = tableRowElements.get(i);
	              Elements rowItems = row.select("td");
	              for (int j = 0; j < rowItems.size(); j++) {
	            	  yield.add(rowItems.get(j).text());
	                 
	              }
	           }
	        } catch (IOException e) {
	           e.printStackTrace();
	        }
	        
	        
	        for (int i = 0 ; i<yield.size();i++)
	        {
	        }
	        int i = 1 ;
	        		while(i<=yield.size())
	        				{
	        				bondYield.add(yield.get(i));
	        					i=i+5;
	        				}
	        		int j = 2 ;
	        		while(j<=yield.size())
	        		{
	        			        bondYield.add(yield.get(j));
	        			        j=j+5;
	        		}
	        		int k = 3 ;
	        		while(k<=yield.size())
	        		{
	        			        bondYield.add(yield.get(k));
	        			        k=k+5;
	        		}
	        		int z = 4 ;
	        		while(z<=yield.size())
	        		{
	        			        bondYield.add(yield.get(z));
	        			        z=z+5;
	        		}
					for (String s : bondYield)
					{
						Float f = Float.parseFloat(s);
						bondYieldFinal.add(f);
					}
		return bondYieldFinal;
	}
	
	public List<String> listMaturity()
	{
		List<String> list = new ArrayList<>();
		list.add("3 Month");
		list.add("6 Month");
		list.add("2 Year");
		list.add("3 Year");
		list.add("5 Year");
		list.add("10 Year");
		list.add("30 Year");
		return list;
	}
	
	public static Float Yield1Today()
	{
		return BondYieldToday.get(0);
	}
	public static Float Yield2Today()
	{
		return BondYieldToday.get(1);
	}
	public static Float Yield3Today()
	{
		return BondYieldToday.get(2);
	}
	public  static Float Yield4Today()
	{
		return BondYieldToday.get(3);
	}
	public static Float Yield5Today()
	{
		return BondYieldToday.get(4);
	}
	public  static Float Yield6Today()
	{
		return BondYieldToday.get(5);
	}
	public static Float Yield7Today()
	{
		return BondYieldToday.get(6);
	}
	public static Float Yield1Yesterday()
	{
		return BondYieldToday.get(7);
	}
	public static  Float Yield2Yesterday()
	{
		return BondYieldToday.get(8);
	}
	public  static Float Yield3Yesterday()
	{
		return BondYieldToday.get(9);
	}
	public static  Float Yield4Yesterday()
	{
		return BondYieldToday.get(10);
	}
	public static Float Yield5Yesterday()
	{
		return BondYieldToday.get(11);
	}
	public  static Float Yield6Yesterday()
	{
		return BondYieldToday.get(12);
	}
	public static Float Yield7Yesterday()
	{
		return BondYieldToday.get(13);
	}
	public static Float Yield1LastWeek()
	{
		return BondYieldToday.get(14);
	}
	public static Float Yield2LastWeek()
	{
		return BondYieldToday.get(15);
	}
	public static Float Yield3LastWeek()
	{
		return BondYieldToday.get(16);
	}
	public static Float Yield4LastWeek()
	{
		return BondYieldToday.get(17);
	}
	public static Float Yield5LastWeek()
	{
		return BondYieldToday.get(18);
	}
	public  static Float Yield6LastWeek()
	{
		return BondYieldToday.get(19);
	}
	public static Float Yield7LastWeek()
	{
		return BondYieldToday.get(20);
	}
	public static Float Yield1LastMonth()
	{
		return BondYieldToday.get(21);
	}
	public static Float Yield2LastMonth()
	{
		return BondYieldToday.get(22);
	}
	public static Float Yield3LastMonth()
	{
		return BondYieldToday.get(23);
	}
	public static Float Yield4LastMonth()
	{
		return BondYieldToday.get(24);
	}
	public static Float Yield5LastMonth()
	{
		return BondYieldToday.get(25);
	}
	public static Float Yield6LastMonth()
	{
		return BondYieldToday.get(26);
	}
	public static Float Yield7LastMonth()
	{
		return BondYieldToday.get(27);
	}



	public String getMaturity() {
		return maturity;
	}



	public void setMaturity(String maturity) {
		this.maturity = maturity;
	}
	
}
