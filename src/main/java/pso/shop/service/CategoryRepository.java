package pso.shop.service;


import org.springframework.data.repository.CrudRepository;

import pso.shop.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
