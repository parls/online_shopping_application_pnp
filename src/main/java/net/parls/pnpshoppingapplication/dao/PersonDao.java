package net.parls.pnpshoppingapplication.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import net.parls.pnpshoppingapplication.entity.Person;

@Repository
public class PersonDao {
		
	private static Map<Integer,Person> person;

}
