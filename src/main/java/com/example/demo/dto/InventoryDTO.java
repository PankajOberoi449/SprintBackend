package com.example.demo.dto;

import com.example.demo.model.Product;
import com.example.demo.model.Store;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class InventoryDTO {

    // Ensures the inventoryId is a positive integer
    @Positive(message = "Inventory ID must be positive.")
    private int inventoryId;

    // Ensures the store object is not null when setting the store property
    @NotNull(message = "Store cannot be null.")
    private Store store;

    // Ensures the productInventory is a positive integer (non-zero quantity)
    @Positive(message = "Product inventory must be positive.")
    private int productInventory;

    // Ensures the product object is not null when setting the products property
    @NotNull(message = "Product cannot be null.")
    private Product products;
}
