package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepo extends JpaRepository<UserEntity,Long> {

}
