package com.kodlamaio.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.core.entities.Users;

public interface UserDao extends JpaRepository<Users, Integer>{

}
