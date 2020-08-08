package com.jadson.backend.models.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.jadson.backend.models.vo.ContactVO;

public class ContactDAO {
    public int storeContactDAO(ContactVO contactVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        int result = 0;
        String sql = "INSERT INTO CONTACTS (NAME,PHONE,EMAIL) VALUES(".concat("'" + contactVO.getName() + "'")
                .concat(",").concat("'" + contactVO.getPhone() + "'").concat(",")
                .concat("'" + contactVO.getEmail() + "'").concat(")");

        try {
            result = stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return result;
    }

    public ArrayList<ContactVO> indexALl() {

        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet result = null;
        ArrayList<ContactVO> listContacts = new ArrayList<ContactVO>();

        String sql = "SELECT CONTACTID,NAME,PHONE,EMAIL FROM CONTACTS";
        try {
            result = stmt.executeQuery(sql);

            while (result.next()) {
                ContactVO contact = new ContactVO();

                contact.setId(Integer.parseInt(result.getString(1)));
                contact.setName(result.getString(2));
                contact.setPhone(result.getString(3));
                contact.setEmail(result.getString(4));
                listContacts.add(contact);
            }

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());

        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return listContacts;
    }

    public ContactVO indexOne(ContactVO contactVO) {

        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet result = null;
        ContactVO contact = new ContactVO();

        String sql = "SELECT CONTACTID,NAME,PHONE,EMAIL FROM CONTACTS WHERE CONTACTID = " + contactVO.getId();

        try {
            result = stmt.executeQuery(sql);

            while (result.next()) {
                contact.setId(Integer.parseInt(result.getString(1)));
                contact.setName(result.getString(2));
                contact.setPhone(result.getString(3));
                contact.setEmail(result.getString(4));

            }

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());

        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return contact;
    }

	public int updateContactDAO(ContactVO contactVO) {

        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        int result = 0;
        String sql = "UPDATE CONTACTS SET "
                    .concat(" NAME  = " + "'" + contactVO.getName() + "',")
                    .concat(" EMAIL = " + "'" + contactVO.getEmail() + "',")
                    .concat(" PHONE = " + "'" + contactVO.getPhone() + "'")
                    .concat(" WHERE CONTACTID = " + contactVO.getId());

        try {
            result = stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return result;
	}

	public int deleteContactDAO(ContactVO contactVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        int result = 0;
    
        String sql = "DELETE FROM CONTACTS WHERE CONTACTID = " + contactVO.getId();

        try {
            result = stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return result;
	}

}