package pdev.financialbrains.client.boot;

import pdev.financialbrains.client.GUI.BackOfficeUser.MessageManagement;
import pdev.financialbrains.client.delegate.ArticleManagementDelegate;
import pdev.financialbrains.client.delegate.MessageManagementDelegate;
import pdev.financialbrains.client.utils.Util;
import pdev.financialbrains.ejb.entities.Article;

public class TestArticle {

	public static void main(String[] args) {
		System.out.println(MessageManagementDelegate.doRead());
		System.out.println(MessageManagementDelegate.doRead(1));
	}

}
