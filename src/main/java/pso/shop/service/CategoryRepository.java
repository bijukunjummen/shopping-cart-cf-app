package pso.shop.service;


import org.springframework.data.repository.CrudRepository;

import pso.shop.domain.Category;
/**
 * Repository interface for Category
 * 
 * @author Biju Kunjummen
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
