package com.joelespinal.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.joelespinal.crud.models.Contact;
import com.joelespinal.crud.repositories.ContactRepository;


@RestController
public class ContactController {

//	private ContactRepository contactRepositorie;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/contacts", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody 
	public ResponseEntity<Iterable<Contact>> getContatcs(){	
			
			return new ResponseEntity<Iterable<Contact>>(contactRepository.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/contact/{id}", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Contact> getContact(@PathVariable("id") Long id){	
			Contact contact = contactRepository.findOne(id);
			return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String create(@RequestBody Contact contact){
	//	Contact contact = null;
		try{
			contactRepository.save(contact);
		}
		catch(Exception ex){
			ex.printStackTrace();
			 return "Error creating the user: " + ex.getMessage();
		}
		
		return "User succesfully created with id = " +  contact.getId();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT, consumes="application/json")
	public Contact update(@PathVariable("id") Long id, @RequestBody Contact contact){
		contact.setId(id);
		return contactRepository.save(contact);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		contactRepository.delete(id);
	}
	
	@Autowired
	private ContactRepository contactRepository;
}
