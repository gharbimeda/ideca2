package pdev.financialbrains.ejb.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="query")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Query implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	public Results results;
	public Query() {
		
	}
	
	public Results getResults() {
		return results;
	}


	public Query(Results results) {
		
		this.results = results;
	}
	@Override
	public String toString() {
		StringBuilder sbq = new StringBuilder();
		sbq.append("Result: " + results.toString() + " \n");	
		return sbq.toString();
	}

	

	@XmlElement(name="results")
	public void setResults(Results results) {
		this.results = results;
	}
	

}
