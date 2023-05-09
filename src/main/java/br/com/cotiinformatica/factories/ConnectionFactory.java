package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	// INSTANCIANDO FORA DO METODO PARA COLOCARMOS STATIC
	// COMO SÃO ITENS QUE NÃO SERÃO MODIFICADOS, DECLARAMOS TAMBEM COMO FINAL, PARA "DAR CHANCE" DE TENTATIVAS QND DECLARARMOS.
	
	private static final String  DRIVER = "org.postgresql.Driver";
	private static final String HOST = "jdbc:postgresql://localhost:5432/bd_api_cliente";
	private static final String USER = "postgres";
	private static final String PASSWORD = "coti";
	
	public static Connection getConnection() throws Exception {
		//AQUI TORNAMOS STATIC PARA NÃO PRECISARMOS INSTANCIAR QND DECLARARMOS ESSA CLASSE
		Class.forName(DRIVER);
		return DriverManager.getConnection(HOST, USER, PASSWORD);
	}

}
