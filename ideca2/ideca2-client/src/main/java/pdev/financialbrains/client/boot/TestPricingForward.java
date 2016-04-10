package pdev.financialbrains.client.boot;

import pdev.financialbrains.client.delegate.ForwardSwapManagementDelegate;

public class TestPricingForward {

	public static void main(String[] args) {
		System.out.println(ForwardSwapManagementDelegate.getInstance().dopriceForwardSwap(20f, 0.5f, 10f, 12f, 9f, 0.9f));
	}

}
