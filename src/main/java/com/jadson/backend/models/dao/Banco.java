package com.jadson.backend.models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Banco {

    private static final Path FILEDATABASE = Paths.get("src","main","java","com","jadson","backend","models","dao","database.db");
	private static final String CONEXAO = "jdbc:sqlite:" + FILEDATABASE.toAbsolutePath().toString();
    
	public static Connection getConnection(){
		try {
			Connection conn = null;
			conn = DriverManager.getConnection(CONEXAO);
            return conn;
		} catch (SQLException e) {
            System.out.println("Erro ao obter a Connection.");
			System.out.println("Erro: " + e.getMessage());
			return null;
		}
	}
	
	public static void closeConnection(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento da conexão.");
			System.out.println("Erro: " + e.getMessage());
		}	
	}
	
	public static Statement getStatement(Connection conn){
		try {
			Statement stmt = conn.createStatement();
			return stmt;
		} catch (SQLException e) {
			System.out.println("Erro ao obter o Statement.");
			System.out.println("Erro: " + e.getMessage());
			return null;
		}
	}
		
	public static void closeStatement(Statement stmt){
		try {
			if(stmt != null){
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do Statement.");
			System.out.println("Erro: " + e.getMessage());
		}	
	}
	
	public static PreparedStatement getPreparedStatement(Connection conn, String sql){
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement.");
			System.out.println("Erro: " + e.getMessage());
			return null;
		}
	}

	public static void closePreparedStatement(Statement stmt){
		try {
			if(stmt != null){
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do PreparedStatement.");
			System.out.println("Erro: " + e.getMessage());
		}	
	}
	
	public static void closeResultSet(ResultSet result){
		try {
			if(result != null){
				result.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do ResultSet");
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
