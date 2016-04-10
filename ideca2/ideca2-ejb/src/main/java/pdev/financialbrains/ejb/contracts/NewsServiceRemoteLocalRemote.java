package pdev.financialbrains.ejb.contracts;

import java.io.IOException;

import javax.ejb.Remote;

@Remote
public interface NewsServiceRemoteLocalRemote {
	void news() throws IOException;
}
