package com.fastcampus.loan.service;

import com.fastcampus.loan.dto.ApplicationDTO.Response;
import com.fastcampus.loan.dto.ApplicationDTO.Request;

public interface ApplicationService {

    Response create(Request request);
}
