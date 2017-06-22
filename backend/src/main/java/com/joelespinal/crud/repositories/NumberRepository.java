package com.joelespinal.crud.dao;



import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface NumberDao extends  CrudRepository<com.joelespinal.crud.models.Number, Long>{

	//public Iterable<com.joelespinal.crud.models.Number> getNumbersByContact();
}
