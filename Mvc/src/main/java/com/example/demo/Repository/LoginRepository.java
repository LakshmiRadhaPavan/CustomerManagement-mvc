package com.example.demo.Repository;



	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.example.demo.Model.LoginModel;

	@Repository
	public interface LoginRepository  extends CrudRepository<LoginModel, Integer>{

	}