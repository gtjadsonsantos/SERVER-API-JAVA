package com.jadson.backend.models.dao;


import java.sql.Connection;
import java.sql.Statement;


public class ProvisioningDatabase {
    public static void run() {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        String sqlContacts = "CREATE TABLE IF NOT EXISTS CONTACTS (CONTACTID INTEGER NOT NULL PRIMARY KEY  AUTOINCREMENT, NAME VARCHAR(255) NOT NULL, PHONE VARCHAR(11), EMAIL VARCHAR(255) )";

        try {
          stmt.executeUpdate(sqlContacts);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }finally{
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }
    }
}