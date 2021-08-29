package edu.poly.shop.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.poly.shop.entity.Account;

public interface AccountDao extends JpaRepository<Account, String> {

	@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('DIRE','STAF')")
	List<Account> getAdministrators();

	@Query("SELECT a FROM Account a WHERE a.email = ?1")
	Optional<Account> findByEmail(String email);

	@Query("SELECT COUNT(a.username) from Account a ")
	Long getSize();

}
