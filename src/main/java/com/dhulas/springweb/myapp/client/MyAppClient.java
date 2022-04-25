package com.dhulas.springweb.myapp.client;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpServerErrorException;

import com.dhulas.springweb.myapp.model.Product;


public interface MyAppClient {

	/**devuelve la lista de productos similares a un id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}/similar")
	List<Product> getSimilarProducts(@PathVariable("id") String id) throws HttpServerErrorException;
}
