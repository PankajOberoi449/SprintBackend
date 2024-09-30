package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Store;
import com.example.demo.repo.StoreRepository;



@Service
public class StoreService implements IStoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public List<Store> getAllStores() {
		System.out.println(storeRepository.findAll());
		return storeRepository.findAll();
	}

	@Override
	public Store getStoreById(Integer id) {
		return storeRepository.findById(id).orElseThrow(() -> new RuntimeException("Store not found"));
	}
}
