package com.example.demo.dto;



import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class OrderItemDTO {
	@Min(value = 1, message = "Product ID must be a positive integer")
	private int productId;
}
