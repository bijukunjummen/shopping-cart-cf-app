package pso.shop.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pso.shop.domain.Category;
import pso.shop.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findByCategory(Category category);
}
