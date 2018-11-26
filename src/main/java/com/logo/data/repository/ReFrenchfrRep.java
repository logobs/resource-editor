package com.logo.data.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.logo.data.entity.ReFrenchfr;

@Component
public interface ReFrenchfrRep extends JpaRepository<ReFrenchfr, Long>{

	List<ReFrenchfr> findAllBy(Pageable pageable);

	List<ReFrenchfr> findByresourceitemrefEquals(Integer resourceitemref);
}