package com.country.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.country.entity.Country;

@RepositoryRestResource(exported=false)
public interface CountryRepository extends CrudRepository<Country,String> {

}
