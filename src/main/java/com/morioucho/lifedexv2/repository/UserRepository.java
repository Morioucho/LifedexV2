package com.morioucho.lifedexv2.repository;

import com.morioucho.lifedexv2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
