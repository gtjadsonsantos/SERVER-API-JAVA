package com.jadson.backend.models.bo;

import com.jadson.backend.models.vo.ContactVO;
import com.jadson.backend.models.dao.ContactDAO;
import java.util.ArrayList;

public class ContactBO {
    public int storeContactBO(ContactVO contactVO){
        ContactDAO contactDAO = new ContactDAO();

        return contactDAO.storeContactDAO(contactVO);
    }
    public ArrayList<ContactVO> indexAllContactBO(){
        ContactDAO contactDAO = new ContactDAO();
    
       return contactDAO.indexALl(); 
    }
    public ContactVO indexOneContactBO(ContactVO contactVO){
        ContactDAO contactDAO = new ContactDAO();

        return contactDAO.indexOne(contactVO); 
    }
	public int updateContactBO(ContactVO contactVO) {
        ContactDAO contactDAO = new ContactDAO();

        return contactDAO.updateContactDAO(contactVO); 
	}
	public int deleteContactBO(ContactVO contactVO) {
        ContactDAO contactDAO = new ContactDAO();

        return contactDAO.deleteContactDAO(contactVO); 
	}
}