package pso.shop.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pso.shop.domain.OrderProduct;
import pso.shop.domain.Product;
import pso.shop.service.ProductRepository;
import pso.shop.service.ShoppingCartService;

@RestController
@RequestMapping("/orders/rest")
public class RestOrderController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private ProductRepository productRepository;
	

	
	@RequestMapping(value="/orderProducts", method=RequestMethod.GET)
	public List<OrderProduct> listOrderProductsRest() {
		return this.shoppingCartService.getProductsInCart();
	}
	
	@RequestMapping(value="/productsCount", method=RequestMethod.GET)
	public int getProductCountInCart() {
		return this.shoppingCartService.getNumberOfProductsInCart();
	}
	
	@RequestMapping(value="/addToCart", method=RequestMethod.POST)
	public OrderProduct addToCartRest(@RequestBody OrderProduct orderProduct) {
		long productId = orderProduct.getProduct().getId();
		Product product = this.productRepository.findOne(productId);
		OrderProduct orderProductToSave = new OrderProduct(product, 1);
		return this.shoppingCartService.addToCart(orderProductToSave);		
	}

	@RequestMapping(value="/updateOrderProduct", method=RequestMethod.POST)
	public List<OrderProduct> updateProductInCartRest(@RequestBody OrderProduct orderProduct) {
		long productId = orderProduct.getProduct().getId();
		Product product = this.productRepository.findOne(productId);
		OrderProduct toBeSaved = new OrderProduct(product, orderProduct.getPurchasedQuantity());
		this.shoppingCartService.updateCart(Arrays.asList(toBeSaved));
		return this.shoppingCartService.getProductsInCart();
	}	
	
	@RequestMapping(value="/deleteFromCart", method=RequestMethod.POST)
	public List<OrderProduct> deleteFromCartRest(@RequestBody OrderProduct orderProduct) {
		Product product = this.productRepository.findOne(orderProduct.getProduct().getId());
		if (product!=null) {
			this.shoppingCartService.removeFromCart(product.getId());
		}
		return this.shoppingCartService.getProductsInCart();
	}

}
