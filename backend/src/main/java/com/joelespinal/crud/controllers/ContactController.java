package com.joelespinal.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.joelespinal.crud.dao.ContactDao;
import com.joelespinal.crud.models.Contact;


@RestController	
public class ContactController {

//	private ContactRepository contactRepositorie;
	
	@RequestMapping(value = "/contacts", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody 
	public Iterable<Contact> getContacs(){	
			return contactDao.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String create(@RequestBody Contact contact){
	//	Contact contact = null;
		try{
			contactDao.save(contact);
		}
		catch(Exception ex){
			ex.printStackTrace();
			 return "Error creating the user: " + ex.getMessage();
		}
		
		return "User succesfully created with id = " +  contact.getId();
	}
	

	@RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") Long id, @RequestBody Contact contact){
		contact.setId(id);
		contactDao.save(contact);
	}

	
	 @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		contactDao.delete(id);
	}
	
	@Autowired
	private ContactDao contactDao;
}
