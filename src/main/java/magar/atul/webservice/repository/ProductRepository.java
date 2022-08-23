package magar.atul.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import magar.atul.webservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	//derived quarry
	List<Product> findByName(String name);
	
	List<Product> findByPrice(double price);
	
	List<Product> findByIsAvailable(boolean isAvailable);
	
	//hql query
	@Query("select p from Product p where p.name LIKE %?1%") //from Product entity
	List<Product> searchByName(String name);
		
	}
