package pso.shop.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pso.shop.domain.Category;
import pso.shop.domain.Product;
/**
 * Repository interface for Product
 * 
 * @author Biju Kunjummen
 */
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findByCategory(Category category);
}
