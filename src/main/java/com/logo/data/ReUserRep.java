package com.logo.data;

import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface ReUserRep extends JpaRepository<ReUser, Long> {
    
    /* A version to fetch List instead of Page to avoid extra count query. */
    List<ReUser> findAllBy(Pageable pageable);
    
    List<ReUser> findByusernameLikeIgnoreCase(String nameFilter);
    
    ReUser findByid(Integer  id);
    
    @Query(value="select * from re_users where id = ?1",nativeQuery=true)
    List<ReUser> findByidList(Integer  id);
    
    // For lazy loading and filtering
    List<ReUser> findByusernameLikeIgnoreCase(String nameFilter, Pageable pageable);
    
	@Query(value="select username from re_users",nativeQuery=true)
	List<String> findAllByUserName();

    long countByusernameLike(String nameFilter);

}