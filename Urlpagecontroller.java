package com.UrlShort.Url.repo;

///import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.UrlShort.Url.Url;

@Repository
public interface Urlpagecontroller extends PagingAndSortingRepository<Url, Long> {
	
	
	 Page<Url> findAll(Pageable pageable);

}
