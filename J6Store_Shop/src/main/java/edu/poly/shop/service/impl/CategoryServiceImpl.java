package edu.poly.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.shop.dao.CategoryDao;
import edu.poly.shop.entity.Category;
import edu.poly.shop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDao categoryDao;

	@Override
	public <S extends Category> S save(S entity) {
		return categoryDao.save(entity);
	}

	@Override
	public <S extends Category> Optional<S> findOne(Example<S> example) {
		return categoryDao.findOne(example);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryDao.findAll(pageable);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryDao.findAll(sort);
	}

	@Override
	public List<Category> findAllById(Iterable<String> ids) {
		return categoryDao.findAllById(ids);
	}


	@Override
	public <S extends Category> List<S> saveAll(Iterable<S> entities) {
		return categoryDao.saveAll(entities);
	}

	@Override
	public void flush() {
		categoryDao.flush();
	}

	@Override
	public <S extends Category> S saveAndFlush(S entity) {
		return categoryDao.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return categoryDao.existsById(id);
	}

	@Override
	public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
		return categoryDao.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable) {
		return categoryDao.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Category> entities) {
		categoryDao.deleteInBatch(entities);
	}

	@Override
	public <S extends Category> long count(Example<S> example) {
		return categoryDao.count(example);
	}

	@Override
	public <S extends Category> boolean exists(Example<S> example) {
		return categoryDao.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Category> entities) {
		categoryDao.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return categoryDao.count();
	}

	@Override
	public void deleteById(String id) {
		categoryDao.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		categoryDao.deleteAllByIdInBatch(ids);
	}



	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		categoryDao.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		categoryDao.deleteAllInBatch();
	}

	@Override
	public Category getOne(String id) {
		return categoryDao.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Category> entities) {
		categoryDao.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		categoryDao.deleteAll();
	}

	@Override
	public Category getById(String id) {
		return categoryDao.getById(id);
	}

	@Override
	public <S extends Category> List<S> findAll(Example<S> example) {
		return categoryDao.findAll(example);
	}

	@Override
	public <S extends Category> List<S> findAll(Example<S> example, Sort sort) {
		return categoryDao.findAll(example, sort);
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.save(category);
	}

	@Override
	public Category create(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.save(category);
	}

	@Override
	public Category findById(String id) {
		// TODO Auto-generated method stub
		return categoryDao.findById(id).get();
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		categoryDao.deleteById(id);
	}

	@Override
	public List<Category> findTop() {
		// TODO Auto-generated method stub
		return categoryDao.findTop();
	}
	
}
