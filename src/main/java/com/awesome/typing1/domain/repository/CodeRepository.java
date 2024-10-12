package com.awesome.typing1.domain.repository;

import com.awesome.typing1.domain.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<Code, Long> {
}
