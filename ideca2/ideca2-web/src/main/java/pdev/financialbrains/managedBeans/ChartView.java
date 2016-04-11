package pdev.financialbrains.managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

import pdev.financialbrains.ejb.contracts.ITradeCrudServiceLocal;

@ManagedBean
public class ChartView implements Serializable {

	@EJB
	private ITradeCrudServiceLocal tradeLocal;
	private Integer tradesSettled;
	private Integer tradesUnsettled;
	private PieChartModel pieModel;
	private static final long serialVersionUID = 1L;

	public Integer getTradesSettled() {
		return tradesSettled;
	}

	public void setTradesSettled(Integer tradesSettled) {
		this.tradesSettled = tradesSettled;
	}

	public Integer getTradesUnsettled() {
		return tradesUnsettled;
	}

	public void setTradesUnsettled(Integer tradesUnsettled) {
		this.tradesUnsettled = tradesUnsettled;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	@PostConstruct
	public void init() {
		createPieModels();
		tradesSettled = tradeLocal.readAccepted();
		tradesUnsettled = tradeLocal.readRefused();
		System.out.println(tradesSettled+"\n"+tradesUnsettled);
	}

	private void createPieModels() {
		createPieModel();
	}

	private void createPieModel() {
		pieModel = new PieChartModel();

		pieModel.set("Trades Settled", tradesSettled);
		pieModel.set("Trades Unsettled", tradesUnsettled);

		pieModel.setTitle("Settlement Chart");
		pieModel.setLegendPosition("w");
	}

}