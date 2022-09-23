package com.rewards.rewardsProgramApplication.service;

import com.rewards.rewardsProgramApplication.model.RewardPoints;

public interface RewardsService {

    public RewardPoints getRewardsByCustomerId(Long id);
}
