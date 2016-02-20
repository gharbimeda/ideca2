package pdev.financialbrains.ejb.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "t_generic")
public class Generic extends FinancialInstrument {

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name = "t_attributestring", joinColumns = @JoinColumn(name = "id") )
	@Column(name = "valuestring")
	private Map<String, String> propertiesString = new HashMap<String, String>();

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name = "t_attributeinteger", joinColumns = @JoinColumn(name = "id") )
	@Column(name = "valueinteger")
	private Map<String, Integer> propertiesInteger = new HashMap<String, Integer>();

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name = "t_attributefloat", joinColumns = @JoinColumn(name = "id") )
	@Column(name = "valuefloat")
	private Map<String, Float> propertiesFloat = new HashMap<String, Float>();

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name = "t_attributeboolean", joinColumns = @JoinColumn(name = "id") )
	@Column(name = "valueboolean")
	private Map<String, Boolean> propertiesBoolean = new HashMap<String, Boolean>();
	private static final long serialVersionUID = 1L;

	public Generic() {
	}

	public String getPropertyString(String key) {
		return propertiesString.get(key);
	}

	public void setPropertyString(String key, String value) {
		propertiesString.put(key, value);
	}

	public Integer getPropertyInteger(String key) {
		return propertiesInteger.get(key);
	}

	public void setPropertyInteger(String key, Integer value) {
		propertiesInteger.put(key, value);
	}

	public Float getPropertyFloat(String key) {
		return propertiesFloat.get(key);
	}

	public void setPropertyFloat(String key, Float value) {
		propertiesFloat.put(key, value);
	}

	public Boolean getPropertyBoolean(String key) {
		return propertiesBoolean.get(key);
	}

	public void setPropertyBoolean(String key, Boolean value) {
		propertiesBoolean.put(key, value);
	}

	@Override
	public String toString() {
		String str = "";
		for (Map.Entry<String, Integer> e : propertiesInteger.entrySet()) {
			str = str + e.getKey() + " : " + e.getValue() + "\n";
		}
		for (Map.Entry<String, Float> e : propertiesFloat.entrySet()) {
			str = str + e.getKey() + " : " + e.getValue() + "\n";
		}
		for (Map.Entry<String, String> e : propertiesString.entrySet()) {
			str = str + e.getKey() + " : " + e.getValue() + "\n";
		}
		for (Map.Entry<String, Boolean> e : propertiesBoolean.entrySet()) {
			str = str + e.getKey() + " : " + e.getValue() + "\n";
		}
		return str;
	}

}
