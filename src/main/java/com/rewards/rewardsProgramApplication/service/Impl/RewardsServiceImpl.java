package com.rewards.rewardsProgramApplication.service.Impl;

import com.rewards.rewardsProgramApplication.constants.Constants;
import com.rewards.rewardsProgramApplication.entity.Transaction;
import com.rewards.rewardsProgramApplication.model.RewardPoints;
import com.rewards.rewardsProgramApplication.repository.TranscationRepository;
import com.rewards.rewardsProgramApplication.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class RewardsServiceImpl implements RewardsService {

    @Autowired
    TranscationRepository transcationRepository;


    @Override
    public RewardPoints getRewardsByCustomerId(Long id) {

        Timestamp lastMonthTimeStamp = getDateBasedOnOffSetDays(Constants.MONTH_IN_DAYS);
        Timestamp lastSecondMonthTimeStamp = getDateBasedOnOffSetDays(2*Constants.MONTH_IN_DAYS);
        Timestamp lastThirdMonthTimeStamp = getDateBasedOnOffSetDays(3*Constants.MONTH_IN_DAYS);

        List<Transaction> lastMonthTranscations = transcationRepository.findAllByCustomerIdAndTransactionDateBetween(id,Timestamp.from(Instant.now().minus(21, ChronoUnit.DAYS)),Timestamp.from(Instant.now()));
        List<Transaction> lastSecondMonthTranscations = transcationRepository.findAllByCustomerIdAndTransactionDateBetween(id,lastSecondMonthTimeStamp,lastMonthTimeStamp);
        List<Transaction> lastThirdMonthTranscations = transcationRepository.findAllByCustomerIdAndTransactionDateBetween(id,lastThirdMonthTimeStamp,lastSecondMonthTimeStamp);


        Long lastMonthRewardPoints = getRewardsPerMonth(lastMonthTranscations);
        Long lastSecondMonthRewardPoints = getRewardsPerMonth(lastSecondMonthTranscations); 
        Long lastThirdMonthRewardPoints = getRewardsPerMonth(lastThirdMonthTranscations);

        RewardPoints rewards = new RewardPoints();
        rewards.setFirstMonthRewardPoints(lastMonthRewardPoints);
        rewards.setSecondMonthRewardPoints(lastSecondMonthRewardPoints);
        rewards.setThirdMonthRewardPoints(lastThirdMonthRewardPoints);
        Long TotalRewards =  lastMonthRewardPoints+lastSecondMonthRewardPoints+lastThirdMonthRewardPoints;
        rewards.setTotalRewards(TotalRewards);
        return rewards;
    }

    private Long getRewardsPerMonth(List<Transaction> lastMonthTranscations) {
        return lastMonthTranscations.stream().map(transaction -> calRewards(transaction))
                .collect(Collectors.summingLong(r->r.longValue()));
    }

    private Timestamp getDateBasedOnOffSetDays(int monthInDays) {
        return Timestamp.valueOf(LocalDateTime.now().minusDays(monthInDays));
    }

    private Long calRewards(Transaction t) {
        if (t.getAmt() > Constants.FIRST_LIMIT && t.getAmt() <= Constants.SECOND_LIMIT) {
            return Math.round(t.getAmt() - Constants.FIRST_LIMIT);
        } else if (t.getAmt() > Constants.SECOND_LIMIT) {
            return Math.round(t.getAmt() - Constants.SECOND_LIMIT) * 2
                    + (Constants.SECOND_LIMIT - Constants.FIRST_LIMIT);
        } else
            return 0l;

    }
}
