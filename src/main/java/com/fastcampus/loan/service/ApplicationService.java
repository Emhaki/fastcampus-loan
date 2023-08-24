package com.fastcampus.loan.service;

import com.fastcampus.loan.dto.ApplicationDTO.Response;
import com.fastcampus.loan.dto.ApplicationDTO.Request;

public interface ApplicationService {

    Response create(Request request);

    Response get(Long applicationId);

    Response update(Long applicationId, Request request);

    void delete(Long applicationId);
}
