package org.example.demo.domian.user.repository;

import org.example.demo.domian.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}