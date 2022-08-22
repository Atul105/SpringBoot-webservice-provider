package magar.atul.webservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import magar.atul.webservice.entity.Product;
import magar.atul.webservice.exception.InvalidProductException;
import magar.atul.webservice.exception.ProductNotFound;

@RestController //(controller+response body)
public class ProductController {
	
	List<Product> products = new ArrayList<Product>();
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public List<Product> getProducts() {
		if(products.isEmpty()) {
			addDefaultData();
		}
		return products;
	}
	
	
	
	@RequestMapping(value="/product/{id}", method=RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {
		for(Product p:products) {
			if(p.getId()==id) {
				return p;
			}
		}
		throw new ProductNotFound("product not found with the give id:" + id);
	}
	
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public Product getProduct(@RequestParam("name") String name) {
		for(Product p:products) {
			if(p.getName().equals(name)) {
				return p;
			}
		}
		throw new ProductNotFound("product not found with the given name:" + name);
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public Product searchProduct(@RequestParam("name") String name) {
		for(Product p:products) {
			if(p.getName().contains(name)) {
				return p;
			}
		}
		throw new ProductNotFound("product not found with the give text:" + name);
	}
	//add
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public List<Product> addProduct(@RequestBody(required=false) Product p) {
		if(p != null) {
			if(p.getName() != null) {
				products.add(p);
				return products;
			}
			else {
				throw new InvalidProductException("required name is missing");
			}
		}
		
		throw new InvalidProductException("required fileds are missing");
	}
	//update
	@RequestMapping(value="/products", method=RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product p) {
		for(int index = 0; index < products.size(); index++) {
			if(products.get(index).getId() == p.getId()) {
				products.set(index, p);
				return p;
			}
		}
		throw new ProductNotFound("product not found with the given name");
	}
	//delete
	@RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
	public Product deleteProduct(@PathVariable("id") int id) {
		for(int index = 0; index < products.size(); index++) {
			if(products.get(index).getId() == id) {
				Product remove = products.get(index);
				products.remove(remove);
				return remove;
			}
		}
		throw new ProductNotFound("product not found with the give id:" + id);
	}
	private void addDefaultData() {

		products.add(new Product(1001, "HeroCycle", 10000.99, "It's a Cycle", true, new Date()));
		products.add(new Product(1002, "Harley Davidson", 1232345.77, "It's a bike", true, new Date()));
		products.add(new Product(1003, "Apple Air", 103456.99, "It's a laptop", false, new Date()));
		products.add(new Product(1004, "Xiaomi 11iT", 40567.88, "It's a Cycle", true, new Date()));
	}

}
