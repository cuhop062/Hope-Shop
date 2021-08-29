package edu.poly.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.shop.dao.ProductDao;
import edu.poly.shop.entity.Product;
import edu.poly.shop.service.ProductService;

@Service
public class ProducServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;



	@Override
	public <S extends Product> Optional<S> findOne(Example<S> example) {
		return productDao.findOne(example);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productDao.findAll(pageable);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public List<Product> findAll(Sort sort) {
		return productDao.findAll(sort);
	}

	@Override
	public List<Product> findAllById(Iterable<Integer> ids) {
		return productDao.findAllById(ids);
	}

	@Override
	public Product findById(Integer id) {
		return productDao.findById(id).get();
	}

	@Override
	public <S extends Product> List<S> saveAll(Iterable<S> entities) {
		return productDao.saveAll(entities);
	}

	@Override
	public void flush() {
		productDao.flush();
	}

	@Override
	public <S extends Product> S saveAndFlush(S entity) {
		return productDao.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return productDao.existsById(id);
	}

	@Override
	public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
		return productDao.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
		return productDao.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Product> entities) {
		productDao.deleteInBatch(entities);
	}

	@Override
	public <S extends Product> long count(Example<S> example) {
		return productDao.count(example);
	}

	@Override
	public <S extends Product> boolean exists(Example<S> example) {
		return productDao.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Product> entities) {
		productDao.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return productDao.count();
	}

	@Override
	public void deleteById(Integer id) {
		productDao.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		productDao.deleteAllByIdInBatch(ids);
	}



	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		productDao.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		productDao.deleteAllInBatch();
	}

	@Override
	public Product getOne(Integer id) {
		return productDao.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Product> entities) {
		productDao.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		productDao.deleteAll();
	}


	@Override
	public <S extends Product> List<S> findAll(Example<S> example) {
		return productDao.findAll(example);
	}

	@Override
	public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
		return productDao.findAll(example, sort);
	}

	@Override
	public Product create(Product product) {
		return productDao.save(product);
	}


	@Override
	public Page<Product> findByCategoryId(String cid, Pageable pageable) { //lay san pham theo loai id
		// TODO Auto-generated method stub
		
		return productDao.findByCategoryId(cid, pageable);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		productDao.deleteById(id);
	}

	@Override
	public Page<Product> findByNameContaining(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return productDao.findByNameContaining(name, pageable);
	}

	@Override
	public List<Product> findByCategoryId(String cid) {
		// TODO Auto-generated method stub
		return productDao.findByCategoryId(cid);
	}

	@Override
	public List<Product> findTop() {
		// TODO Auto-generated method stub
		return productDao.findTop();
	}


	
	
}
