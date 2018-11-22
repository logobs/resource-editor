package com.logo.data;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ReProjectVerisonRep extends JpaRepository<ReProjectVersion, Long> {
    
    /* A version to fetch List instead of Page to avoid extra count query. */
    List<ReProjectVersion> findAllBy(Pageable pageable);
    
    ReProjectVersion findByid(Integer  id);

}