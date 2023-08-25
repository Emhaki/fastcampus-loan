package com.fastcampus.loan.service;

import com.fastcampus.loan.dto.TermsDTO.Response;
import com.fastcampus.loan.dto.TermsDTO.Request;

public interface TermsService {

    Response create(Request request);
}
