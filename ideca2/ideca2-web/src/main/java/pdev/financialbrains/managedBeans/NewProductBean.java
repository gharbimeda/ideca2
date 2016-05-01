package pdev.financialbrains.managedBeans;

import java.awt.TextField;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pdev.financialbrains.ejb.contracts.IGenericCrudServiceLocal;

@ManagedBean
@ViewScoped
public class NewProductBean {

	@EJB
	private IGenericCrudServiceLocal genericLocal; 
	
	TextField tf ;
//    gridPanel1.getChildren().add(tf);

	
	
	
	
	@PostConstruct
	public void init(){
		tf = new TextField();
		tf.setText("Test");
	}
}
