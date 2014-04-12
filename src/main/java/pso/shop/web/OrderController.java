package pso.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pso.shop.domain.OrderProduct;
import pso.shop.domain.Product;
import pso.shop.service.ProductRepository;
import pso.shop.web.service.ShoppingCartService;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping("/addToCart")
	public String addToCart(@RequestParam("productId") Long productId) {
		Product product = this.productRepository.findOne(productId);
		OrderProduct orderProduct = new OrderProduct(product, 1);
		this.shoppingCartService.addToCart(orderProduct);
		return "redirect:/shop/products";
	}
	
	@RequestMapping("/viewCart")
	public String viewShoppingCart(Model model) {
		model.addAttribute("orderProducts", this.shoppingCartService.getProductsInCart());
		return "orders/cart";
	}
	

}
