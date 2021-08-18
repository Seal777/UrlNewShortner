package com.UrlShort.Url.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.UrlShort.Url.Url;



@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {
	
	
	//To find the matching URL from the database
	@Query(value="From URL where ORIGINALURL =?1")
	public  Url findByOriginalUrl(String originalUrl);
	
	//Used for pagination
	Page<Url> findAll(Pageable pageable);

}
