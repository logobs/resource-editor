package com.logo.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.logo.data.entity.ReResourceitem;
import com.logo.util.QueryConstants;
import com.logo.util.search.SearchParam;

@Component
@Transactional(readOnly = true)
public interface ReResourceitemRep extends JpaRepository<ReResourceitem, Long> {
	 
	List<ReResourceitem> findAllBy(Pageable pageable);

	List<ReResourceitem> findByresourcerefEqualsOrderByOrdernrAsc(Integer resourceref);

	@Query(value = "select * from re_resourceitems with(nolock) where resourceref = ?1", nativeQuery = true)
	List<ReResourceitem> findByresourcerefEquals(Integer resourceref);

	@Query(value = "select max(tagnr) from re_resourceitems with(nolock) where resourceref = ?1", nativeQuery = true)
	Integer getMaxTagNr(Integer resourceref);

	@Query(value = "select max(ordernr) from re_resourceitems with(nolock) where resourceref = ?1", nativeQuery = true)
	Integer getMaxOrderNr(Integer resourceref);

	@Query(value = "select * from re_resourceitems where id in(select resourceitemref from re_turkishtr where resourcestr LIKE CONCAT('%',?1,'%')) ORDER BY resourceref ASC, ordernr ASC \n-- #pageable\n", 
			countQuery = "select count(*) from re_resourceitems where id in(select resourceitemref from re_turkishtr where resourcestr LIKE CONCAT('%',?1,'%'))", nativeQuery = true)
	Page<ReResourceitem> searchByresourcereTR(String searchTerm, Pageable pageable);

	@Query(value = "select * from re_resourceitems where id in(select resourceitemref from re_turkishtr where resourcestr LIKE CONCAT('%',?1,'%')) ORDER BY createdon DESC, resourceref ASC, ordernr ASC \n-- #pageable\n", 
			countQuery = "select count(*) from re_resourceitems where id in(select resourceitemref from re_turkishtr where resourcestr LIKE CONCAT('%',?1,'%'))", nativeQuery = true)
	Page<ReResourceitem> getAllResItems(String searchTerm, Pageable pageable);

	@Query(value = "select * from re_resourceitems where resourceref in (select id from re_resources where resourcenr = ?1 AND resourcegroup = ?2) ORDER BY resourceref ASC, ordernr ASC \n-- #pageable\n", 
			countQuery = "select count(*) from re_resourceitems where resourceref in (select id from re_resources where resourcenr = ?1 AND resourcegroup = ?2)", nativeQuery = true)
	Page<ReResourceitem> searchByresourceNr(Pageable pageable, String resNr, String resGrp);

	@Query(value = QueryConstants.SEARCHQUERY1, countQuery = QueryConstants.SEARCHCOUNT1, nativeQuery = true)
	Page<ReResourceitem> search1(Pageable pageable,
			String resourcenr1, 
			String resourcenr2,
			List<String> resourcegroup,
			List<Integer> resourcetype,
			List<Integer> resourcecase,
			List<Integer> active);
	
	@Query(value = QueryConstants.SEARCHQUERY2, countQuery = QueryConstants.SEARCHCOUNT2, nativeQuery = true)
	Page<ReResourceitem> search2(Pageable pageable,
			String resourcenr1, 
			String resourcenr2);
	
	@Query(value = QueryConstants.SEARCHBYPARAM, countQuery = QueryConstants.SEARCHBYPARAMCOUNT, nativeQuery = true)
	Page<ReResourceitem> searchByParam(Pageable pageable,
			@Param("searchParam")
			SearchParam searchParam);

	@Query(value = QueryConstants.SEARCHBYPARAMALL, countQuery = QueryConstants.SEARCHBYPARAMALLCOUNT, nativeQuery = true)
	Page<ReResourceitem> searchByParamAll(Pageable pageable,
			@Param("searchParam")
			SearchParam searchParam);

	@Query(value = QueryConstants.LOCCHARTQUERY, nativeQuery = true)
	<T> List<T> getCountForChart(Integer resNr, String resGrp);

}