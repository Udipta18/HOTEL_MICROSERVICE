package com.user.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
