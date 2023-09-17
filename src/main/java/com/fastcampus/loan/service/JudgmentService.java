package com.fastcampus.loan.service;

import com.fastcampus.loan.dto.ApplicationDTO;
import com.fastcampus.loan.dto.JudgmentDTO.Response;
import com.fastcampus.loan.dto.JudgmentDTO.Request;

public interface JudgmentService {

    Response create(Request request);

    Response get(Long judgmentId);

    Response getJudgmentOfApplication(Long applicationId);

    Response update(Long judgmentId, Request request);

    void delete(Long judgmentId);

    ApplicationDTO.GrantAmount grant(Long judgment);
}
