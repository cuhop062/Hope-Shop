package edu.poly.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.poly.shop.entity.Category;

public interface CategoryDao extends JpaRepository<Category, String> {
	@Query(value = "select top(9)* from Categories", nativeQuery = true)
	List<Category> findTop();

}
