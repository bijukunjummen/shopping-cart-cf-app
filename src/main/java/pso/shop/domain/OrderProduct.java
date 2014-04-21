package pso.shop.domain;

import java.io.Serializable;

/**
 * Product in a shopping cart or past a purchase.
 * Just has the quantity that is purchased alon with 
 * the product
 * 
 * @author Biju Kunjummen
 *
 */
public class OrderProduct implements Serializable{
	
	private static final long serialVersionUID = -3480296374500403880L;
	public OrderProduct() {
		
	}
	
	public OrderProduct(Product product, int purchasedQuantity) {
		this.product = product;
		this.purchasedQuantity = purchasedQuantity;
	}
	
	private int purchasedQuantity;
	private Product product;
	public int getPurchasedQuantity() {
		return purchasedQuantity;
	}
	public void setPurchasedQuantity(int purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
