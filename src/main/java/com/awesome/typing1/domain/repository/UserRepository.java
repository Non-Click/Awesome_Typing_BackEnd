package com.awesome.typing1.domain.repository;

import com.awesome.typing1.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
