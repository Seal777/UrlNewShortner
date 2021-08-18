package com.UrlShort.Url.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import com.UrlShort.Url.Url;
import com.UrlShort.Url.repo.UrlRepository;
import com.UrlShort.Url.repo.Urlpagecontroller;

@Service
public class UrlService {
	
@Autowired
private UrlRepository urlrepo;
@Autowired
private HashUtility hashUtility;


//Method to create shortUrl from the original Url
@Transactional
public Url createsave (String newurl)
{
	Url newUrlObject=new Url();
	if(newurl!=null)
	{
		
		String TranformedUrl=hashUtility.getHash(newurl);
		newUrlObject.setShortUrl(TranformedUrl);
		newUrlObject.setCount(1);
		newUrlObject.setOriginalUrl(newurl);
		
		urlrepo.save(newUrlObject);
	}
	else
	{
		return null;
	}
	return newUrlObject;
	
}
//Method to find the Short Url on basis of the given long(original)URl
@Transactional
public String findUrl(String toFindUrl)
{
	
	int newcount=0;
	
	
	Url existingUrl=(Url) urlrepo.findByOriginalUrl(toFindUrl);
	if(existingUrl!=null)
	{
		//existingKey=existingUrl.getShortUrl();
		newcount=existingUrl.getCount();
		existingUrl.setCount(newcount+1);
		
		
	}
	
	return existingUrl.getShortUrl();
	
	
	
	
}
//To find the count(no of times url has been accessed)
@Transactional
public int findUrlCount(String toFindUrlCount)
{
	//String existingKey="";
	int newcount=0;
	//Url existingUrl =new Url(); 
      Url existingUrl1 =  urlrepo.findByOriginalUrl(toFindUrlCount);
	// Url existingUrl=existingUrl1.get();
	if(existingUrl1!=null)
	{
		
		newcount=existingUrl1.getCount();
		
		
		
	}
	
	return newcount;
	
	
	
	
}


}












