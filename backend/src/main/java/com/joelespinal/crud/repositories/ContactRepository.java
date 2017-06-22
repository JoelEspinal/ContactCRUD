package com.joelespinal.crud.repositories;



import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.joelespinal.crud.models.Contact;

@Transactional
public interface ContactRepository extends  CrudRepository<Contact, Long>{
	
	public Contact getContactById(Long id);
}
