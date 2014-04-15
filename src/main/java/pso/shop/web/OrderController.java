package pso.shop.web;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pso.shop.domain.OrderProduct;
import pso.shop.domain.Product;
import pso.shop.service.ProductRepository;
import pso.shop.service.ShoppingCartService;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping("/addToCart")
	public String addToCart(@RequestParam("productId") Long productId, RedirectAttributes redirectAttributes) {
		Product product = this.productRepository.findOne(productId);
		OrderProduct orderProduct = new OrderProduct(product, 1);
		this.shoppingCartService.addToCart(orderProduct);
		redirectAttributes.addFlashAttribute("statusmessage", String.format("Item \"%s\" added to cart", product.getName()));
		return "redirect:/shop/products";
	}
	
	@RequestMapping("/deleteFromCart/{productId}")
	public String deleteFromCart(@PathVariable("productId") Long productId, RedirectAttributes redirectAttributes) {
		Product product = this.productRepository.findOne(productId);
		if (product!=null) {
			this.shoppingCartService.removeFromCart(productId);
			redirectAttributes.addFlashAttribute("statusmessage", String.format("Item \"%s\" removed from cart", product.getName()));
		}
		return "redirect:/orders/viewCart";
	}
	
	@RequestMapping("/viewCart")
	public String viewShoppingCart(Model model) {
		model.addAttribute("orderProducts", this.shoppingCartService.getProductsInCart());
		return "orders/cart";
	}
	
	@RequestMapping(value="/updateCart", method=RequestMethod.POST)
	public String updateProductInCart(OrderProduct orderProduct, RedirectAttributes redirectAttributes) {
		long productId = orderProduct.getProduct().getId();
		Product product = this.productRepository.findOne(productId);
		OrderProduct toBeSaved = new OrderProduct(product, orderProduct.getPurchasedQuantity());
		this.shoppingCartService.updateCart(Arrays.asList(toBeSaved));
		redirectAttributes.addFlashAttribute("statusmessage", "Cart updated!");
		return "redirect:/orders/viewCart";
	}

}
