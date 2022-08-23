package magar.atul.webservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import magar.atul.webservice.entity.Product;
import magar.atul.webservice.exception.InvalidProductException;
import magar.atul.webservice.exception.ProductNotFound;
import magar.atul.webservice.repository.ProductRepository;

@RestController //(controller+response body)
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	List<Product> products = new ArrayList<Product>();
	
	//get all product
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public List<Product> getProducts() {
		List<Product> productList = productRepository.findAll();
		if(productList.isEmpty()) {
			throw new ProductNotFound("product not found,List is empty");
		}
		return productList;
	}
	
	
	//get one product by id
	@RequestMapping(value="/product/{id}", method=RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {
		Optional<Product> productData = productRepository.findById(id);
		if(productData.isPresent()) {
			return productData.get();
		}
		throw new ProductNotFound("product not found with the give id:" + id);
	}
	
	//get one product by name
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public List<Product> getProduct(@RequestParam("name") String name) {
		List<Product> productList = productRepository.findByName(name);
		
			if(!productList.isEmpty()) {
				return productList;
			}
		
		throw new ProductNotFound("product not found with the given name:" + name);
	}
	
	//get product by availability
	@RequestMapping(value="/filter/product", method=RequestMethod.GET)
	public List<Product> filterProduct(@RequestParam("available") boolean available) {
		List<Product> productList = productRepository.findByIsAvailable(available);
		
			if(!productList.isEmpty()) {
				return productList;
			}
		
		throw new ProductNotFound("product not found, not available");
	}
	
	//search if letter contains
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public List<Product> searchProduct(@RequestParam("name") String name) {
		List<Product> productList = productRepository.searchByName(name);
		if(!productList.isEmpty()) {
			return productList;
		}
		throw new ProductNotFound("product not found with the give text:" + name);
	}
	
	//add product
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public Product addProduct(@RequestBody(required=false) Product p) {
		if(p != null) {
			if(p.getName() != null) {
				return productRepository.save(p);
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
		Optional<Product> productData = productRepository.findById(p.getId());
		if(productData.isPresent()) {
			return productRepository.save(p);
		}
		throw new ProductNotFound("product not found with the given name");
	}
	
	//delete
	@RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
	public Product deleteProduct(@PathVariable("id") int id) {
		Optional<Product> productData = productRepository.findById(id);
		if(productData.isPresent()) {
		  productRepository.delete(productData.get());
		  return productData.get();
		}
		throw new ProductNotFound("product not found with the give id:" + id);
	}
//	private void addDefaultData() {
//
//		products.add(new Product(1001, "HeroCycle", 10000.99, "It's a Cycle", true, new Date()));
//		products.add(new Product(1002, "Harley Davidson", 1232345.77, "It's a bike", true, new Date()));
//		products.add(new Product(1003, "Apple Air", 103456.99, "It's a laptop", false, new Date()));
//		products.add(new Product(1004, "Xiaomi 11iT", 40567.88, "It's a Cycle", true, new Date()));
//	}

}
