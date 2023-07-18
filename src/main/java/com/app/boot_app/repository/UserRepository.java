package com.app.boot_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.boot_app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value = "select * from tb_user where cpf = :cpf", nativeQuery = true)
	List<User> findByCPF(@Param("cpf") String cpf);

	@Query(value = "select * from tb_user where cpf = :cpf", nativeQuery = true)
	public Iterable<User> existCpf(String cpf);
	
	@Query(value = "select * from tb_user where name = :name", nativeQuery = true)
	List<User> findByName(@Param("name") String name);

	@Query(value = "select * from tb_user where phone = :phone", nativeQuery = true)
	List<User> findByPhone(@Param("phone") String phone);
}