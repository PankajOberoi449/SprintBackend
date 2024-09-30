package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class ShipmentStatusCountDTO {
	@NotNull(message = "Shipment status cannot be null.")
	private String shipmentStatus;

	@Positive(message = "Total products sold must be positive.")
	private long totalProductsSold;

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public long getTotalProductsSold() {
		return totalProductsSold;
	}

	public void setTotalProductsSold(long totalProductsSold) {
		this.totalProductsSold = totalProductsSold;
	}

	public ShipmentStatusCountDTO(@NotNull(message = "Shipment status cannot be null.") String shipmentStatus,
			@Positive(message = "Total products sold must be positive.") long totalProductsSold) {
		super();
		this.shipmentStatus = shipmentStatus;
		this.totalProductsSold = totalProductsSold;
	}

	public ShipmentStatusCountDTO() {
		super();
	}
	
}
