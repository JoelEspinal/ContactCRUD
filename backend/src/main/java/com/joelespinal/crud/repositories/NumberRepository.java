package com.joelespinal.crud.repositories;



import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface NumberRepository extends  CrudRepository<com.joelespinal.crud.models.Number, Long>{

	//public Iterable<com.joelespinal.crud.models.Number> getNumbersByContact();
}
