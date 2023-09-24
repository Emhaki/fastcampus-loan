package com.fastcampus.loan.service;

import com.fastcampus.loan.domain.Balance;
import com.fastcampus.loan.dto.BalanceDTO;
import com.fastcampus.loan.exception.BaseException;
import com.fastcampus.loan.exception.ResultType;
import com.fastcampus.loan.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService{

    private final BalanceRepository balanceRepository;

    private final ModelMapper modelMapper;
    @Override
    public BalanceDTO.Response create(Long applicationId, BalanceDTO.Request request) {
        Balance balance = modelMapper.map(request, Balance.class);

        BigDecimal entryAmount = request.getEntryAmount();
        balance.setApplicationId(applicationId);
        balance.setBalance(entryAmount);

        balanceRepository.findByApplicationId(applicationId).ifPresent(b -> {
            balance.setBalanceId(b.getBalanceId());
            balance.setIsDeleted(b.getIsDeleted());
            balance.setCreatedAt(b.getCreatedAt());
            balance.setUpdatedAt(b.getUpdatedAt());
        });
        Balance saved = balanceRepository.save(balance);

        return modelMapper.map(saved, BalanceDTO.Response.class);
    }

    @Override
    public BalanceDTO.Response update(Long applicationId, BalanceDTO.UpdateRequest request) {

        // balance
        Balance balance = balanceRepository.findByApplicationId(applicationId).orElseThrow(() -> new BaseException(ResultType.SYSTEM_ERROR));

        // as-is -> to-be
        BigDecimal beforeEntryAmount = request.getBeforeEntryAmount();
        BigDecimal afterEntryAmount = request.getAfterEntryAmount();
        BigDecimal updateBalance = balance.getBalance();

        updateBalance = updateBalance.subtract(beforeEntryAmount).add(afterEntryAmount);
        balance.setBalance(updateBalance);

        Balance updated = balanceRepository.save(balance);

        return modelMapper.map(updated, BalanceDTO.Response.class);
    }
}
