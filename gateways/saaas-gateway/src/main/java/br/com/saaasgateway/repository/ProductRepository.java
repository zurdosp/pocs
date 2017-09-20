package br.com.saaasgateway.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.saaasgateway.domain.Product;

@RepositoryRestResource(collectionResourceRel = "products", path = "aaaa")
public interface ProductRepository extends MongoRepository<Product, String> {

		//List<Product> findByLastName(@Param("name") String name);
	
}
