package com.dhulas.springweb.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhulas.springweb.myapp.client.MyAppClient;
import com.dhulas.springweb.myapp.model.Product;
import com.dhulas.springweb.myapp.service.MyAppService;

@RestController
@RequestMapping("/product")
public class MyAppController implements MyAppClient {

	@Autowired
	private MyAppService myAppService;
	
	@Override
	public List<Product> getSimilarProducts(String id){
			return myAppService.getSimilarProducts(id);
		
	}

}
