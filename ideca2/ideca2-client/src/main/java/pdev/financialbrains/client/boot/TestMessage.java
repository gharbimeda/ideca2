package pdev.financialbrains.client.boot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import pdev.financialbrains.client.delegate.BondManagementDelegate;
import pdev.financialbrains.client.delegate.FixedIncomeSecurityManagementDelegate;
import pdev.financialbrains.client.delegate.MessageManagementDelegate;
import pdev.financialbrains.ejb.contracts.IMessageCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Bond;
import pdev.financialbrains.ejb.entities.FixedIncomeSecuritie;
import pdev.financialbrains.ejb.entities.Message;
import pdev.financialbrains.ejb.entities.User;

public class TestMessage {

	MessageManagementDelegate messageDeletage;
	BondManagementDelegate bondDeletage;
	FixedIncomeSecurityManagementDelegate fixedSecurDeletage;

	@Before
	public void setUp() throws Exception {
		messageDeletage = MessageManagementDelegate.getInstance();
		bondDeletage = BondManagementDelegate.getInstance();
		fixedSecurDeletage = FixedIncomeSecurityManagementDelegate.getInstance();

	}

	@Test
	public void addMessage() {
		Message m = new Message();
		User u = new User(1);
		User u1 = new User(2);

		m.setTexte("wiwi");
		m.setDate(new Date("2016/02/02"));
		m.setUserDest(u);
		m.setUserSource(u1);
		messageDeletage.doCreate(m);
	}
@Test
public  void show()
{
	messageDeletage.doRead();
}
	@Test
	public void udapteMessage() {
		List<Message> m = MessageManagementDelegate.doRead(1);
		User u = new User(1);
		User u1 = new User(2);

		//m.setTexte("chaima");
		//m.setDate(new Date("2015/02/03"));
		//messageDeletage.doUpdate(m);

	}

	@Test
	public void removeMessage() {
		Message m = new Message();
		m.setId(3);
		messageDeletage.doDelete(m);

	}

	@Test
	public void addBond() {
		Bond b = new Bond(1,125.5f, 5.5f, "symbole", "50");
		bondDeletage.doCreate(b);
	}

	@Test
	public void udapteBond() {

		Bond b = bondDeletage.doReadById(1);
		b.setCurrentPrice(205.5f);
		bondDeletage.doUpdate(b);
	}

	@Test
	public void removeBond() {
		Bond b = new Bond();
		b.setId(1);
		bondDeletage.doDelete(b);

	}

	@Test
	public void createSecurity() {
		// FixedIncomeSecuritie f = new FixedIncomeSecuritie(1, 122.5f, 0.5f, 1,
		// 2, 100f, 0.3f, 0.23f, 45.2f, 1002f);
		FixedIncomeSecuritie f = new FixedIncomeSecuritie(1,2.5f, 0.06f, 30, 2, 100.5f, 0.26f, 1.5f, 2.5f, 1000f);
		fixedSecurDeletage.doCreate(f);
	}

	@Test
	public void udapteSecur() {

		FixedIncomeSecuritie f = fixedSecurDeletage.doRead(1);
		f.setCurrentPrice(10589f);
		fixedSecurDeletage.doUpdate(f);
	}

	@Test
	public void removeSecur() {
		FixedIncomeSecuritie f = new FixedIncomeSecuritie();
		f.setId(1);
		fixedSecurDeletage.doDelete(f);

	}

	@Test
	public void priceFixedIncomeSecurity() {
		// Double bondPrice = null;
		FixedIncomeSecuritie f = fixedSecurDeletage.doRead(1);

		System.out.println(
				fixedSecurDeletage.doPriceZeroCouponBond(f.getFaceValue(), f.getTimeMaturity(), f.getCurrentYield()));

	}
}
