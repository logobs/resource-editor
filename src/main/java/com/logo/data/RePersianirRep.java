package com.logo.data;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RePersianirRep extends JpaRepository<RePersianir, Long>{

	List<RePersianir> findAllBy(Pageable pageable);

	List<RePersianir> findByresourceitemrefEquals(Integer resourceitemref);
}
