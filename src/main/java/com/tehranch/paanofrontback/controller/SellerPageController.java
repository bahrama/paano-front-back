package com.tehranch.paanofrontback.controller;

import com.tehranch.paanofrontback.dto.request.RequestSellerListDto;
import com.tehranch.paanofrontback.service.SellerFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sellerPage")
@RequiredArgsConstructor
public class SellerPageController {

    private final SellerFetchService sellerFetchService;

    @GetMapping
    public ResponseEntity<?> findMeeting(@RequestBody RequestSellerListDto requestSellerListDto){
        return new ResponseEntity<>(sellerFetchService.findSellers(requestSellerListDto), HttpStatus.OK);
    }
}
