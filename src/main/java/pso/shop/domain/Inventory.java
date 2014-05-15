package pso.shop.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
/**
 * An inventory of Products. Currently keeps only track of quantity of products
 * 
 * @author Biju Kunjummen
 */
@Entity
@Table(name = "inventory")
public class Inventory implements Serializable{

	private static final long serialVersionUID = 4863234893689754284L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="product_id")
	@JsonBackReference
	private Product product;
	
	private Long quantity;
	
	@Version
	private long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public Long getQuantity() {
		return this.quantity;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}