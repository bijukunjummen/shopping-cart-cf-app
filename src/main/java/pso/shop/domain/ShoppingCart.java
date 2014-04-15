package pso.shop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * A temporary object to hold the details of what the user intends to 
 * purchase
 * 
 * @author Biju Kunjummen
 */

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements Serializable{
	private static final long serialVersionUID = 4573229359755965961L;
	//Linked hashmap to maintain order of added items
	private LinkedHashMap<Long, OrderProduct> map = new LinkedHashMap<Long, OrderProduct>();
	
	
	/**
	 * Explicitly add an order product to the cart
	 * 
	 * @param orderProduct
	 */
	public void addToCart(OrderProduct orderProduct) {
		//If the item already exists in the cart, increment quantity..
		if (this.map.containsKey(orderProduct.getProduct().getId())) {
			OrderProduct existingOrderProduct = this.map.get(orderProduct.getProduct().getId());
			int newQuantity = existingOrderProduct.getPurchasedQuantity() + orderProduct.getPurchasedQuantity();
			OrderProduct newOrderProduct = new OrderProduct(orderProduct.getProduct(), newQuantity);
			this.map.put(orderProduct.getProduct().getId(), newOrderProduct);
		}else {
			//assuming only one product at a time..but needs validation check
			this.map.put(orderProduct.getProduct().getId(), orderProduct);
		}
	}
	
	public void removeItemFromCart(Long productId) {
		this.map.remove(productId);
	}
	
	/**
	 * Update a cart..assumption is state will be managed and sent correctly 
	 * on the UI
	 * @param orderProducts
	 */
	public void updateCart(List<OrderProduct> orderProducts) {
		if (orderProducts != null) {
			for (OrderProduct orderProduct: orderProducts) {
				updateCart(orderProduct);
			}
		}
	}
	
	private void updateCart(OrderProduct orderProduct) {
		if (this.map.containsKey(orderProduct.getProduct().getId())) {
			if (orderProduct.getPurchasedQuantity()<=0) {
				removeItemFromCart(orderProduct.getProduct().getId());
			}else {
				map.put(orderProduct.getProduct().getId(), orderProduct);
			}
		}else {
			map.put(orderProduct.getProduct().getId(), orderProduct);
		}
	}
	
	public List<OrderProduct> getProductsInCart() {
		return new ArrayList<OrderProduct>(this.map.values());
	}
}
