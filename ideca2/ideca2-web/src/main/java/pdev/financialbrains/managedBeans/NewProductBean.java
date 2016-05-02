package pdev.financialbrains.managedBeans;

import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIColumn;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.model.SelectItem;

import pdev.financialbrains.ejb.contracts.IGenericCrudServiceLocal;
import pdev.financialbrains.ejb.entities.Generic;

@ManagedBean
@ViewScoped
public class NewProductBean {

	@EJB
	private IGenericCrudServiceLocal genericLocal;
	private Generic generic;
	private HtmlPanelGrid containerComponent;
	private UIColumn col;
	private UIColumn col1;
	private UIColumn col2;
	private List<HtmlSelectOneMenu> menu;
	UISelectItems items;
	List<SelectItem> comboList;
	private HtmlOutputText name;
	private HtmlOutputText value;
	private HtmlOutputText type;
	private List<HtmlInputText> names;
	private List<HtmlInputText> values;
	private Integer i;
	private Float currentPrice;
	private Float volatility;

	public Float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Float getVolatility() {
		return volatility;
	}

	public void setVolatility(Float volatility) {
		this.volatility = volatility;
	}

	public Generic getGeneric() {
		return generic;
	}

	public void setGeneric(Generic generic) {
		this.generic = generic;
	}

	public HtmlPanelGrid getContainerComponent() {
		return containerComponent;
	}

	public void setContainerComponent(HtmlPanelGrid containerComponent) {
		this.containerComponent = containerComponent;
	}

	public UIColumn getCol() {
		return col;
	}

	public void setCol(UIColumn col) {
		this.col = col;
	}

	public UIColumn getCol1() {
		return col1;
	}

	public void setCol1(UIColumn col1) {
		this.col1 = col1;
	}

	public UIColumn getCol2() {
		return col2;
	}

	public void setCol2(UIColumn col2) {
		this.col2 = col2;
	}

	public List<SelectItem> getComboList() {
		return comboList;
	}

	public void setComboList(List<SelectItem> comboList) {
		this.comboList = comboList;
	}

	public List<HtmlSelectOneMenu> getMenu() {
		return menu;
	}

	public void setMenu(List<HtmlSelectOneMenu> menu) {
		this.menu = menu;
	}

	public UISelectItems getItems() {
		return items;
	}

	public void setItems(UISelectItems items) {
		this.items = items;
	}

	public HtmlOutputText getName() {
		return name;
	}

	public void setName(HtmlOutputText name) {
		this.name = name;
	}

	public HtmlOutputText getValue() {
		return value;
	}

	public void setValue(HtmlOutputText value) {
		this.value = value;
	}

	public HtmlOutputText getType() {
		return type;
	}

	public void setType(HtmlOutputText type) {
		this.type = type;
	}

	public List<HtmlInputText> getNames() {
		return names;
	}

	public void setNames(List<HtmlInputText> names) {
		this.names = names;
	}

	public List<HtmlInputText> getValues() {
		return values;
	}

	public void setValues(List<HtmlInputText> values) {
		this.values = values;
	}

	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		this.i = i;
	}

	public void addComponent() {
		i++;

		col = new UIColumn();
		name = new HtmlOutputText();
		name.setValue("Name :");
		col.getChildren().add(name);
		names.add(new HtmlInputText());
		col.getChildren().add(names.get(i));

		col2 = new UIColumn();
		type = new HtmlOutputText();
		type.setValue("Type :");
		col2.getChildren().add(type);
		items = new UISelectItems();
		items.setValue(comboList);
		menu.add(new HtmlSelectOneMenu());
		menu.get(i).getChildren().add(items);
		col2.getChildren().add(menu.get(i));
		// menu.getChildren().add(items);
		// col2.getChildren().add(menu);

		col1 = new UIColumn();
		value = new HtmlOutputText();
		value.setValue("Value :");
		col1.getChildren().add(value);
		values.add(new HtmlInputText());
		col1.getChildren().add(values.get(i));

		if (containerComponent == null) {
			containerComponent = new HtmlPanelGrid();
		}

		containerComponent.getChildren().add(col);
		containerComponent.getChildren().add(col1);
		containerComponent.getChildren().add(col2);
	}

	public void doSave() {
		
		generic.setCurrentPrice(currentPrice);
		generic.setVolatility(volatility);
		for (int k = 0; k < names.size(); k++) {
			if (menu.get(k).getValue().equals("String")) {
				generic.setPropertyString((String) names.get(k).getValue(), (String) values.get(k).getValue());
			}
			if (menu.get(k).getValue().equals("Boolean")) {
				generic.setPropertyBoolean((String) names.get(k).getValue(),
						Boolean.parseBoolean((String) values.get(k).getValue()));
			}
			if (menu.get(k).getValue().equals("Float")) {
				generic.setPropertyFloat((String) names.get(k).getValue(),
						Float.parseFloat((String) values.get(k).getValue()));
			}

			if (menu.get(k).getValue().equals("Integer")) {
				generic.setPropertyInteger((String) names.get(k).getValue(),
						Integer.parseInt((String) values.get(k).getValue()));
			}
		}
		genericLocal.create(generic);
	}

	@PostConstruct
	public void init() {
		containerComponent = new HtmlPanelGrid();
		generic = new Generic();
		col = new UIColumn();
		col1 = new UIColumn();
		items = new UISelectItems();
		comboList = new ArrayList<>();
		comboList.add(new SelectItem(" "));
		comboList.add(new SelectItem("String"));
		comboList.add(new SelectItem("Boolean"));
		comboList.add(new SelectItem("Float"));
		comboList.add(new SelectItem("Integer"));
		name = new HtmlOutputText();
		name.setValue("Name :");
		value = new HtmlOutputText();
		value.setValue("Value :");
		type = new HtmlOutputText();
		type.setValue("Type :");
		names = new ArrayList<HtmlInputText>(50);
		values = new ArrayList<HtmlInputText>(50);
		i = -1;
		menu = new ArrayList<HtmlSelectOneMenu>();

	}
}
