package com.hcl.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.app.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("select u from User u where u.userName = :userName")
	public abstract User findByName(@Param("userName") String userName);

	@Query("select u from User u where u.userName = :userName and u.password = :password")
	public abstract User findByNameAndPassword(@Param("userName") String userName, @Param("password") String password);

	@Query("select u from User u where u.userName = :userName or u.password = :password")
	public abstract User findByNameOrPassword(@Param("userName") String userName, @Param("password") String password);

	public abstract List<User> findAll();

}
