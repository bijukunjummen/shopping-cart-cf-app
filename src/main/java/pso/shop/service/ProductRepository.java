package pso.shop.service;

import org.springframework.data.repository.CrudRepository;

import pso.shop.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
