package br.com.giovani.tests;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.giovani.config.ConnectionConfig;
import br.com.giovani.config.FileConfig;
import br.com.giovani.objects.TableFile;

public class Testes {
	
	FileConfig aux = new FileConfig();
	ConnectionConfig con = new ConnectionConfig();

	ArrayList<TableFile> tableLines = new ArrayList<TableFile>();
	//WebDriver driver;
	//Configuracoes conf = new Configuracoes(driver);

	@Before
	public void setUp() {
		con.ConnectDB();
	}

	@Test
	public void testLegal(){
		String query = "select * from table_test;";
		String filePath = "Util\\Arquivos\\teste.txt";
		
		int amountFileLines = aux.addFileLinesToArray(filePath).size();
		int amountTableLines = con.addTableLinesToArray(query).size();

		Assert.assertTrue(amountTableLines == amountFileLines);
		
		for (int i = 0; i < amountFileLines; i++) {
			TableFile ln = aux.addFileLinesToArray(filePath).get(i);
			TableFile tb = con.addTableLinesToArray(query).get(i);
			
			Assert.assertEquals(ln.getName(), tb.getName());
			Assert.assertEquals(ln.getLastname(), tb.getLastname());
			Assert.assertEquals(ln.getAge(), tb.getAge());
		}
	}
}