package com.fastcampus.loan.service;

import com.fastcampus.loan.dto.TermsDTO.Response;
import com.fastcampus.loan.dto.TermsDTO.Request;

import java.util.List;

public interface TermsService {

    Response create(Request request);

    List<Response> getAll();
}
