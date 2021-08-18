package com.UrlShort.Url.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.UrlShort.Url.Url;
import com.UrlShort.Url.repo.UrlRepository;
import com.UrlShort.Url.repo.Urlpagecontroller;
import com.UrlShort.Url.service.UrlService;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/urlshort")
public class UrlController {
	
@Autowired
private UrlService urlservice;
@Autowired
private UrlRepository urlrepo;

@Autowired 
private  Urlpagecontroller  urlpage;

@PostMapping(value = "/storeurl/{originalUrl}")
@ResponseStatus(HttpStatus.OK)
@ResponseBody
public Url save(@PathVariable String originalUrl) {
    return urlservice.createsave(originalUrl);
}

@GetMapping(value = "/get/{ShortUrl}")
@ResponseStatus(HttpStatus.OK)
//@ResponseBody
public @ResponseBody  String find(@PathVariable String ShortUrl) {
    return urlservice.findUrl(ShortUrl);
}



@GetMapping(value = "/count/{originalUrl}")
@ResponseStatus(HttpStatus.OK)
@ResponseBody
public int count(@PathVariable String originalUrl) {
    int countOftheUrl=urlservice.findUrlCount(originalUrl);
    
    return countOftheUrl;
}


@GetMapping("/list/{pageNo}/{pageSize}")
@ResponseBody
public List<Url> ShowAll(@PathVariable int pageNo,@PathVariable int pageSize)
{
	PageRequest paging = PageRequest.of(pageNo,pageSize);
	Page<Url> responseList=urlrepo.findAll(paging);
	
	return responseList.getContent();
}







	
	
	
	
	
	
	

}
