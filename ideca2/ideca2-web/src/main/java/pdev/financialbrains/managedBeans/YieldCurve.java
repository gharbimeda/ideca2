package pdev.financialbrains.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import pdev.financialbrains.ejb.contracts.IMDBondCrudServiceLocal;
import pdev.financialbrains.ejb.entities.MdBond;



/*
 * Mariem Rabia
 */
@ManagedBean(name = "yieldBean")
public class YieldCurve implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LineChartModel yieldCurve;
	private MdBond md = new MdBond();
	private List<MdBond> bonds;
	
	@EJB
	private IMDBondCrudServiceLocal mdlocal;

	private LineChartModel lineModel1;
    private LineChartModel lineModel2;
     
    @PostConstruct
    public void init() {
        createLineModels();
        initLinearModel();
    }
 
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
 
    public LineChartModel getLineModel2() {
        return lineModel2;
    }
     
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Yield Curve");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
         
        
    }
     
    
    private LineChartModel initLinearModel() {
    		LineChartModel model = new LineChartModel();

    		LineChartSeries series1 = new LineChartSeries();
    		series1.setLabel("Yield Curve");
    		
    		 bonds = mdlocal.readAll();

    		for (MdBond md : bonds) {

    			series1.set(md.getYield(),md.getYesterday());

    		}

    		model.addSeries(series1);

    		return model;
    	}

	public LineChartModel getYieldCurve() {
		return yieldCurve;
	}

	public void setYieldCurve(LineChartModel yieldCurve) {
		this.yieldCurve = yieldCurve;
	}

	public MdBond getMd() {
		return md;
	}

	public void setMd(MdBond md) {
		this.md = md;
	}

	public List<MdBond> getBonds() {
		return bonds;
	}

	public void setBonds(List<MdBond> bonds) {
		this.bonds = bonds;
	}

	public IMDBondCrudServiceLocal getMdlocal() {
		return mdlocal;
	}

	public void setMdlocal(IMDBondCrudServiceLocal mdlocal) {
		this.mdlocal = mdlocal;
	}

	public void setLineModel1(LineChartModel lineModel1) {
		this.lineModel1 = lineModel1;
	}

	public void setLineModel2(LineChartModel lineModel2) {
		this.lineModel2 = lineModel2;
	}
     

 
}
	

