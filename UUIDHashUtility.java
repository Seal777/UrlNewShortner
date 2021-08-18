package com.UrlShort.Url.service;

import org.springframework.stereotype.Component;

import java.util.UUID;
//to generate a random unique value of the URL
@Component
public class UUIDHashUtility implements HashUtility{
    public String getHash(String data) {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0,10);
    }
}
