package com.awesome.typing1.domain.repository;

import com.awesome.typing1.domain.entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<Text, Long> {
}
