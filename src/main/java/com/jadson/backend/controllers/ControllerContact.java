package com.jadson.backend.controllers;

import java.util.ArrayList;
import com.jadson.backend.models.vo.ContactVO;
import com.jadson.backend.utils.ResponseClient;
import com.jadson.backend.models.bo.ContactBO;



public class ControllerContact {

    public ResponseClient store(ContactVO contactVO) {
        ContactBO contactBO = new ContactBO();
        ResponseClient responseClient = new ResponseClient();

        int result = contactBO.storeContactBO(contactVO);

        if (result == 1) {
            responseClient.setMessage("Success in create contact");
        } else {
            responseClient.setMessage("Faild in create contact");
        }

        return responseClient;
    }

    public ArrayList<ContactVO> indexAll() {
        ContactBO contactBO = new ContactBO();

        return  contactBO.indexAllContactBO();
        
    }

	public ContactVO indexOne(ContactVO contactVO) {
        ContactBO contactBO = new ContactBO();

        return  contactBO.indexOneContactBO(contactVO);

    }
    public ResponseClient update(ContactVO contactVO){
        ContactBO contactBO = new ContactBO();
        ResponseClient responseClient = new ResponseClient();

        int result = contactBO.updateContactBO(contactVO);

        if (result == 1) {
            responseClient.setMessage("Success in update contact");
        } else {
            responseClient.setMessage("Faild in update contact");
        }

        return responseClient;
    }
    public ResponseClient delete(ContactVO contactVO){
        ContactBO contactBO = new ContactBO();
        ResponseClient responseClient = new ResponseClient();

        int result = contactBO.deleteContactBO(contactVO);

        if (result == 1) {
            responseClient.setMessage("Success in exclude contact");
        } else {
            responseClient.setMessage("Faild in exclude contact");
        }

        return responseClient;
    }
}