package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Store;

public interface IStoreService {
	public List<Store> getAllStores();

	public Store getStoreById(Integer id);
}