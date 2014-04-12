package pso.shop.web.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import pso.shop.domain.OrderProduct;
import pso.shop.domain.ShoppingCart;


/**
 * Stateful service tied to session scope to facade the details of a shopping cart
 * Note: This is a deliberate use of sessions to demonstrate a scenario where details are 
 * maintained in a session. 
 *
 * @author Biju Kunjummen
 */
@Service
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartService {
	private ShoppingCart shoppingCart = new ShoppingCart();
	
	public void addToCart(OrderProduct orderProduct) {
		this.shoppingCart.addToCart(orderProduct);
	}
	
	public void removeFromCart(long productId) {
		this.shoppingCart.removeItemFromCart(productId);
	}
	
	public void updateCart(List<OrderProduct> orderProducts) {
		this.shoppingCart.updateCart(orderProducts);
	}
	public List<OrderProduct> getProductsInCart() {
		return this.shoppingCart.getProductsInCart();
	}
}
