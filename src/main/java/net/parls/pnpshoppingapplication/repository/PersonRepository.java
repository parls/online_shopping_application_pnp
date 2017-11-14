package net.parls.pnpshoppingapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.parls.pnpshoppingapplication.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long>{
	
	public Person findByEmail(String email);	

}
