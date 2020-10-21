package br.com.giovani.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.giovani.auxiliary.SortingObjects;
import br.com.giovani.objects.TableFile;

public class ConnectionConfig {
	public ConnectionConfig () {}
	public static Connection con = null;

	public static void ConnectDB() {
		System.out.println("======================");
		System.out.println("Conectando ao banco...");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/poc","root","1234");
			System.out.println("Conectado.");

		} catch (ClassNotFoundException ex) {
			System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
			Logger.getLogger(ConnectionConfig.class.getName()).log(Level.SEVERE, null, ex);
		} catch(SQLException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
		System.out.println("======================\n\n\n");
	}

	public ArrayList<TableFile> addTableLinesToArray(String query)  {
		ArrayList<TableFile> tableLines = new ArrayList<TableFile>();
		TableFile tl;

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				tl = new TableFile();
				
				//adicionar as informações de cada coluna para cada atributo do objeto tl do tipo TableFile
				tl.setName(rs.getObject(1).toString().trim());
				tl.setLastname(rs.getObject(2).toString().trim());
				tl.setAge(rs.getObject(3).toString().trim());
				
				tableLines.add(tl);	
			}
			tableLines.sort(new SortingObjects());
		} catch (SQLException e) {
			e.printStackTrace();
			for(Throwable ex : e) {
				System.err.println("Error occurred " + ex);
			}
			System.out.println("Error in fetching data");
		}
		return tableLines;
	}
}