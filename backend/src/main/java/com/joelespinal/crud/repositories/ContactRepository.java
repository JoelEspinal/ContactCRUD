package com.joelespinal.crud.dao;



import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.joelespinal.crud.models.Contact;

@Transactional
public interface ContactDao extends  CrudRepository<Contact, Long>{
	
	public Contact getContactById(Long id);
}
