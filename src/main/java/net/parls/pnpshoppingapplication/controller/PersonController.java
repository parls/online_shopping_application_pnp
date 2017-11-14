package net.parls.pnpshoppingapplication.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.parls.pnpshoppingapplication.entity.Person;
import net.parls.pnpshoppingapplication.service.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	@ResponseBody
	public Object index()
	{
		return personService.findAll();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String create(@RequestBody Person person) {
		String userId = "";
		try {
			personService.save(person);
			
		}catch(Exception ex) {
			return "Error creating the user" + ex.toString();
		}
		
		return "User successfully created with id" + userId;
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable long id) {
		String userId = "";
		try {
			Person user = personService.findById(id);
			personService.delete(user);
			
		}catch(Exception ex) {
			return "Error deleting the user" + ex.toString();
		}
		
		return "User successfully deleted!" ;
	}
	
	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String userId = "";
		try {
			Person user = personService.findByEmail(email);
	    userId = String.valueOf(user.getId());
		}catch(Exception ex) {
			return "User not found";
		}
		
		return "The user id is:" + userId;
	}
	
	@RequestMapping("/update/{id}")
	@ResponseBody
	public String updateUser(@RequestBody Person person, @PathVariable Long id) {
		try {
			person.setId(id);
			personService.save(person);
		}catch(Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User successfully updated:";
	}
	
}
