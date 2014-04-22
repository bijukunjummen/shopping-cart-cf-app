package pso.shop.web;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pso.shop.SampleWebApplication;
import pso.shop.domain.OrderProduct;
import pso.shop.domain.Product;
import pso.shop.service.ShoppingCartService;

/**
 * A Basic Spring MVC Test for the Shop Controller 
 * 
 * @author Biju Kunjummen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = SampleWebApplication.class)
public class ShoppingCartServiceTest {

	@Autowired
	private WebApplicationContext wac;

	@SuppressWarnings("unused")
	private MockMvc mockMvc;
	
	@Autowired 
	private ShoppingCartService shoppingCartService;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testListProducts() throws Exception {
		List<OrderProduct> orderProducts = this.shoppingCartService.getProductsInCart();
		assertThat(orderProducts, IsEmptyCollection.empty());
		
		Product prod = new Product(1l, "test", "test", new BigDecimal(10), null);
		this.shoppingCartService.addToCart(new OrderProduct(prod , 10));
		assertThat(this.shoppingCartService.getProductsInCart().size(), equalTo(1));
	}
}
