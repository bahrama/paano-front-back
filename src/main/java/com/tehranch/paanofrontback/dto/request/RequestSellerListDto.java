package com.tehranch.paanofrontback.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RequestSellerListDto implements Serializable {
    private String order;
    private Integer limit;
    private Integer page;
    private String panel;
    private String shopEng;
    private String shopPer;
    private String imgGovahi;
}
