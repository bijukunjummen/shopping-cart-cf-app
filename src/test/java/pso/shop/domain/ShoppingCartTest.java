package pso.shop.domain;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {
	
	private Map<Long, Product> productMap = new HashMap<Long, Product>();
	

	@Test
	public void testAddToShoppingCart() {
		ShoppingCart cart = new ShoppingCart();
		OrderProduct op1 = new OrderProduct(this.productMap.get(1l), 10);
		cart.addToCart(op1);
		assertThat(cart.getProductsInCart(), contains(op1));
	}
	
	@Test
	public void testAddToCartWithExistingOrderProduct() {
		ShoppingCart cart = new ShoppingCart();
		OrderProduct op1 = new OrderProduct(this.productMap.get(1l), 10);
		cart.addToCart(op1);
		OrderProduct op2 = new OrderProduct(this.productMap.get(1l), 12);
		cart.addToCart(op2);
		
		assertThat(cart.getProductsInCart().size(), equalTo(1));
		assertThat(cart.getProductsInCart().get(0).getPurchasedQuantity(), equalTo(22));
	}
	
	@Test
	public void testUpdateCart() {
		ShoppingCart cart = new ShoppingCart();
		OrderProduct op1 = new OrderProduct(this.productMap.get(1l), 10);
		OrderProduct op2 = new OrderProduct(this.productMap.get(2l), 12);

		List<OrderProduct> ordersList = Arrays.asList(op1, op2);	
		cart.updateCart(ordersList);
		assertThat(cart.getProductsInCart().size(), equalTo(2));
	}	

	@Test
	public void testUpdateWith0QuantityInCart() {
		ShoppingCart cart = new ShoppingCart();
		OrderProduct op1 = new OrderProduct(this.productMap.get(1l), 10);
		OrderProduct op2 = new OrderProduct(this.productMap.get(2l), 12);

		List<OrderProduct> ordersList = Arrays.asList(op1, op2);	
		cart.updateCart(ordersList);
		
		OrderProduct op3 = new OrderProduct(this.productMap.get(2l), 0);
		
		cart.updateCart(Arrays.asList(op3));
		assertThat(cart.getProductsInCart().size(), equalTo(1));
	}	

	
	
	@Before
	public void setUp() {
		productMap.put(1l, new Product(1l, "prod1", "prod1", new BigDecimal(1), null));
		productMap.put(2l, new Product(2l, "prod2", "prod2", new BigDecimal(2), null));
		productMap.put(3l, new Product(3l, "prod3", "prod3", new BigDecimal(3), null));
		productMap.put(4l, new Product(4l, "prod4", "prod4", new BigDecimal(4), null));
	}

}
