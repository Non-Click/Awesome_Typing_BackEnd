package com.awesome.typing1.domain.repository;

import com.awesome.typing1.domain.entity.Custom;
import com.awesome.typing1.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomRepository extends JpaRepository<Custom, Long> {

    @Query("SELECT c FROM Custom c WHERE c.user = :user AND c.isDeleted = false")
    Page<Custom> findActiveCustomsByUser(User user, Pageable pageable);
}
