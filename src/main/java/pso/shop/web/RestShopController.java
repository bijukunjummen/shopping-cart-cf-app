package pso.shop.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pso.shop.Utils;
import pso.shop.domain.Category;
import pso.shop.domain.Product;
import pso.shop.service.CategoryRepository;
import pso.shop.service.ProductRepository;
/**
 * Main controller of the Shop. 
 * 
 * @author Biju Kunjummen
 */

@RestController
@RequestMapping("/shop/rest")
public class RestShopController {
	private CategoryRepository categoryRepository;
	private ProductRepository productRepository;
	
	@Autowired
	public RestShopController(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public List<Product> listProductsRest() {
		Iterable<Product> products = this.productRepository.findAll();
		return Utils.iterablesToList(products);
	}

	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public List<Category> listCategoriesRest() {
		Iterable<Category> categories = this.categoryRepository.findAll();
		return Utils.iterablesToList(categories);
	}
	
	
}
