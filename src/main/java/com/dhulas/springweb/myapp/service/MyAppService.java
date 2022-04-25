package com.dhulas.springweb.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.dhulas.springweb.myapp.exception.ApiRequestException;
import com.dhulas.springweb.myapp.model.Product;

@Service
public class MyAppService {

	private static final String URL_CONTEXT = "http://localhost:3001/product/";
	
	@Autowired
	private RestTemplate restTemplate;
	/** metodo para obtener productos similares a un id */
	public List<Product> getSimilarProducts(String id) {
		List<Product> similarProducts = new ArrayList<>();
		String[] similarIds = getIds(id);
		if (similarIds.length > 0) {
			for (String ids : similarIds) {
				similarProducts.add(getProductDetail(ids));
			}
			return similarProducts;
		}else throw new ApiRequestException("Error");
	}
	
	public String[] getIds (String id) {
		String uri = URL_CONTEXT + id + "/similarids";
		try {
			ResponseEntity<String[]> entity =restTemplate.getForEntity(uri, String[].class);
			return entity.getBody();
		 }catch (RestClientException e) {
			 throw new ApiRequestException("Product id:"+ id+" not found",e);
		}
		
	}
	
	public Product getProductDetail(String id) {
		String uri = URL_CONTEXT + id;
		try {
			ResponseEntity<Product> entity = restTemplate.getForEntity(uri, Product.class);
			return entity.getBody();
		}catch (Exception e) {
				throw new ApiRequestException("Details of product id:"+id +" not found",e);
			}
	}
}
