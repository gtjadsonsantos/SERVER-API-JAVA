package com.jadson.backend;

import express.DynExpress;
import express.http.RequestMethod;
import express.http.request.Request;
import express.http.response.Response;
import express.utils.Status;
import com.jadson.backend.models.vo.ContactVO;
import com.jadson.backend.utils.ResponseClient;
import com.jadson.backend.controllers.ControllerContact;

import com.google.gson.Gson;


public class Routes {

    @DynExpress(context = "/contacts",method = RequestMethod.GET) 
    public void getContacts(Request req, Response res) {
        ControllerContact controllerContact = new ControllerContact();
        String data = new Gson().toJson(controllerContact.indexAll());

        res.setContentType("application/json");
        res.setStatus(Status._200);
        res.send(data);
    }
    @DynExpress(context = "/contact",method = RequestMethod.POST)    
    public void createContact(Request req, Response res) {
        String name =  req.getFormQuery("name");
        String phone =  req.getFormQuery("phone");
        String email =  req.getFormQuery("email");
        ContactVO contactVO = new ContactVO();

        ControllerContact controllerContact = new ControllerContact();

        contactVO.setName(name);
        contactVO.setPhone(phone);
        contactVO.setEmail(email);  
        
        ResponseClient responseClient =  controllerContact.store(contactVO);   

        res.setContentType("application/json");
        res.setStatus(Status._200);
        res.send(responseClient.getMessage());

    }
    @DynExpress(context = "/contact/:contactId", method = RequestMethod.GET)
    public void getContact(Request req, Response res){
       String contactId = req.getParam("contactId");
       ContactVO contactVO = new ContactVO();
       ControllerContact controllerContact = new ControllerContact();

       contactVO.setId(Integer.parseInt(contactId));
       String data = new Gson().toJson(controllerContact.indexOne(contactVO));  

       res.setContentType("application/json");
       res.setStatus(Status._200);
       res.send(data);
       
    }
    @DynExpress(context = "/contact", method = RequestMethod.PUT)
    public void updateContact(Request req, Response res){
        
        String id =  req.getFormQuery("id");
        String name =  req.getFormQuery("name");
        String phone =  req.getFormQuery("phone");
        String email =  req.getFormQuery("email");
        ContactVO contactVO = new ContactVO();

        ControllerContact controllerContact = new ControllerContact();

        contactVO.setId(Integer.parseInt(id));
        contactVO.setName(name);
        contactVO.setPhone(phone);
        contactVO.setEmail(email);  
        
        ResponseClient responseClient =  controllerContact.update(contactVO);   

        res.setContentType("application/json");
        res.setStatus(Status._200);
        res.send(responseClient.getMessage());
       
    }

    @DynExpress(context = "/contact", method = RequestMethod.DELETE)
    public void deleteContact(Request req, Response res){
        
        String id =  req.getFormQuery("id");
        ContactVO contactVO = new ContactVO();

        ControllerContact controllerContact = new ControllerContact();

        contactVO.setId(Integer.parseInt(id)); 
        
        ResponseClient responseClient =  controllerContact.delete(contactVO);   

        res.setContentType("application/json");
        res.setStatus(Status._200);
        res.send(responseClient.getMessage());
       
    }
}
