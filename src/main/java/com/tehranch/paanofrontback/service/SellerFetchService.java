package com.tehranch.paanofrontback.service;

import com.google.gson.Gson;
import com.tehranch.paanofrontback.dto.request.RequestSellerListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerFetchService {

    private final RestTemplate restTemplate;

    public List<RequestSellerListDto> findSellers(RequestSellerListDto request){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("order",request.getOrder());
        requestBody.add("panel",request.getPanel());
        String jsonRequest = new Gson().toJson(request);
        HttpEntity entity = new HttpEntity(jsonRequest,headers);
        Gson gson = new Gson();
        String result = restTemplate.exchange("http://localhost:8084/api/sellerpro", HttpMethod.POST, entity, String.class).getBody();
        List<RequestSellerListDto> requestSellerListDtos =gson.fromJson(result,List.class);
        return requestSellerListDtos;
    }
}
