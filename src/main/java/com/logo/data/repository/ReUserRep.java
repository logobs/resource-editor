package com.logo.data.repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.logo.data.entity.ReUser;

@Component
@Scope("prototype")
public interface ReUserRep extends JpaRepository<ReUser, Long> {

	List<ReUser> findByusernameLikeIgnoreCase(String nameFilter);

	ReUser findByid(Integer id);

	@Query(value = "select * from RE_USERS where ID = :id", nativeQuery = true)
	List<ReUser> findByidList(@Param("id") Integer id);

	@Query(value = "select USERNAME from RE_USERS", nativeQuery = true)
	List<String> findAllByUserName();

}