package vn.iostar.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "products")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	private String productName;
	private int quantity;
	private int quantitySold;
	private double unitPrice;
	private String description;
	
	private LocalDateTime createAt;

	@JsonIgnore 
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;
}
