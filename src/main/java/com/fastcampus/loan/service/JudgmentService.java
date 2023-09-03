package com.fastcampus.loan.service;

import com.fastcampus.loan.dto.JudgmentDTO.Response;
import com.fastcampus.loan.dto.JudgmentDTO.Request;

public interface JudgmentService {

    Response create(Request request);
}
