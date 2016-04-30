package pdev.financialbrains.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pdev.financialbrains.ejb.contracts.IMDBondCrudServiceLocal;
import pdev.financialbrains.ejb.entities.MdBond;
import pdev.financialbrains.ejb.entities.Quote;

/*
 * Mariem
 */
@ManagedBean(name = "mbondBean")
@ViewScoped

public class MDBondBean {
	
	@EJB
	private IMDBondCrudServiceLocal mdBlocal;
	
	private List<MdBond> bonds = new ArrayList<MdBond>();
	private List<MdBond> muniBond = new ArrayList<MdBond>();
	private List<MdBond> corBond = new ArrayList<MdBond>();
	

	

	
	


	public IMDBondCrudServiceLocal getMdBlocal() {
		return mdBlocal;
	}








	public void setMdBlocal(IMDBondCrudServiceLocal mdBlocal) {
		this.mdBlocal = mdBlocal;
	}








	public List<MdBond> getBonds() {
		return bonds;
	}








	public void setBonds(List<MdBond> bonds) {
		this.bonds = bonds;
	}








	public List<MdBond> getMuniBond() {
		return muniBond;
	}








	public void setMuniBond(List<MdBond> muniBond) {
		this.muniBond = muniBond;
	}








	public List<MdBond> getCorBond() {
		return corBond;
	}








	public void setCorBond(List<MdBond> corBond) {
		this.corBond = corBond;
	}








	@PostConstruct
	public void addMBonds() throws IOException {
		int i = 1;

		System.out.println("Table of Bonds : ");
		Document docb = Jsoup.connect(
				"http://finance.yahoo.com/bonds/composite_bond_rates").get();
		
		String type = null;
		for (Element tablebody : docb.select(".yfirttbl")) {
			MdBond temp = null;
			if (i == 1) {
				type = "US Treasury Bonds";

				System.out.println("\t Table of US Treasury Bonds :");
			} else if (i == 2) {
				System.out.println("\t Municipal Bonds :");
				type = "Municipal Bonds";
			} else {
				System.out.println("\t Corporate Bonds :");
				type = "Corporate Bonds";
			}
		
		i = i + 1;
		System.out
				.println("Maturity \t Yield \t Yesterday \t Last Week \t Last Month");
		for (Element row : tablebody.select("tr")) {
			Elements tds = row.select("td");
			if (tds.size() > 4) {
				System.out.println(tds.get(0).text() + "   \t "
						+ tds.get(1).text() + "\t " + tds.get(2).text()
						+ "\t\t " + tds.get(3).text() + "\t\t "
						+ tds.get(4).text());

				temp = new MdBond();
				temp.setMaturity(tds.get(0).text());
				Double yield = Double.parseDouble(tds.get(1).text());
				Double yesterday = Double.parseDouble(tds.get(2).text());
				Double lastMonth = Double.parseDouble(tds.get(4).text());
				Double lastWeek = Double.parseDouble(tds.get(3).text());
				temp.setYield(yield);
				temp.setType(type);
				temp.setYesterday(yesterday);
				temp.setLastWeek(lastWeek);
				temp.setLastMonth(lastMonth);
				mdBlocal.add(temp);
				if (temp.getType().equals("US Treasury Bonds"))
					bonds.add(temp);
				else if (temp.getType().equals("Municipal Bonds"))
				muniBond.add(temp);
				else
				corBond.add(temp);

			}
		}
		}
	}

	

	
	
}

