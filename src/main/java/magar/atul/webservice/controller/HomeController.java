package magar.atul.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
	
	@RequestMapping(value="/", method= RequestMethod.GET )
	@ResponseBody
	public String indexMapping() {
		return "welcome to spring boot application, Server is up and running";
	}
	
	@RequestMapping(value="/hello", method= RequestMethod.GET )
	@ResponseBody
	public String helloMapping() {
		return "welcome everyone";
	}
	
	@RequestMapping(value="/hi", method= RequestMethod.GET )
	@ResponseBody
	public String hiMapping(@RequestParam("name") String name) {
		return "Hi " + name +" welcome to springboot learning";
	}
	
	@RequestMapping(value="/user/{id}", method= RequestMethod.GET )
	@ResponseBody
	public String userMapping(@PathVariable("id") long id) {
		return "Hello user Id:"+id;
	}
	
	

}
