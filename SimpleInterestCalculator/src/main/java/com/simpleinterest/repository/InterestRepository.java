package com.simpleinterest.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simpleinterest.entity.Interest;

@Repository
public interface InterestRepository extends CrudRepository<Interest,Integer> {

	@Query("select coalesce(max(i.principal),0) from Interest i")
	Double getMaxPrincipal();
}
