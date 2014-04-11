package pso.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pso.shop.service.CategoryRepository;
import pso.shop.service.ProductRepository;


@Controller
@RequestMapping("/shop")
public class ShopController {
	private CategoryRepository categoryRepository;
	private ProductRepository productRepository;
	
	@Autowired
	public ShopController(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	
	@RequestMapping("/products")
	public String listProducts(Model model) {
		model.addAttribute("products", this.productRepository.findAll());
		return "products/list";
	}
}
