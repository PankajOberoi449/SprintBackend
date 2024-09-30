package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ShipmentDto;
import com.example.demo.model.Shipment;
import com.example.demo.repo.ShipmentRepository;


@Service
public class ShipmentService implements IShipmentService {

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Override
	public List<ShipmentDto> getAllShipments() {

		List<Shipment> shipments = shipmentRepository.findAll();

		return shipments.stream().map(this::convertToDTO).collect(Collectors.toList());

	}

	
	
	private ShipmentDto convertToDTO(Shipment shipment) {

		ShipmentDto dto = new ShipmentDto();

		dto.setShipmentId(shipment.getShipmentId());

		dto.setDeliveryAddress(shipment.getDeliveryAddress());

		dto.setShipmentStatus(shipment.getShipmentStatus());

		dto.setStoreId(shipment.getStore() != null ? shipment.getStore().getStoreId() : null);

		dto.setCustomerId(shipment.getCustomer() != null ? shipment.getCustomer().getCustomerId() : null);

		return dto;

	}

}
