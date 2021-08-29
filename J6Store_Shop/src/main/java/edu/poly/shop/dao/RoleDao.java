package edu.poly.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.shop.entity.Role;

public interface RoleDao extends JpaRepository<Role, String> {

}
