package pso.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pso.shop.domain.Category;
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
	
	@ModelAttribute
	public void commonModelAttributes(Model model) {
		model.addAttribute("categories", this.categoryRepository.findAll());
	}
	
	@RequestMapping("/products")
	public String listProducts(Model model) {
		model.addAttribute("products", this.productRepository.findAll());
		return "products/list";
	}
	@RequestMapping("/categories/{categoryId}/products")
	public String listProductsForCategory(@PathVariable("categoryId") Long categoryId, Model model) {
		Category category = this.categoryRepository.findOne(categoryId);
		model.addAttribute("products", this.productRepository.findByCategory(category));
		model.addAttribute("currentcategory", category);
		return "products/listforcategory";
	}	
}
