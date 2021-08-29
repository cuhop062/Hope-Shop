package edu.poly.shop.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.poly.shop.entity.Category;
import edu.poly.shop.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryId(String cid);
	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
    Page<Product> findByCategoryId(String cid, Pageable pageable);
	@Query(value = "select top(9)* from Product", nativeQuery = true)
	List<Product> findTop();

	Page<Product> findByNameContaining(String name, Pageable pageable);
	List<Product> findByNameContaining(String name);

}
