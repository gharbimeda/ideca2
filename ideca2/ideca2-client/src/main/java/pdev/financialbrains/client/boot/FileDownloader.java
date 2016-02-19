package pdev.financialbrains.client.boot;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;

public class FileDownloader {
	public static void main(String[] args) {
        try {
            URL url = new URL("http://ichart.yahoo.com/table.csv?s=^GSPC&a=3&b=1&c=2014&d=3&e=15&f=2014&g=d");
            URLConnection urlConn = url.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(urlConn.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
            inputStreamReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

