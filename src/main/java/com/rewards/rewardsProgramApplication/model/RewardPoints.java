package com.rewards.rewardsProgramApplication.model;

public class RewardPoints {

    private long customerId;
    private long firstMonthRewardPoints;
    private long secondMonthRewardPoints;
    private long thirdMonthRewardPoints;

    private long totalRewards;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getFirstMonthRewardPoints() {
        return firstMonthRewardPoints;
    }

    public void setFirstMonthRewardPoints(long firstMonthRewardPoints) {
        this.firstMonthRewardPoints = firstMonthRewardPoints;
    }

    public long getSecondMonthRewardPoints() {
        return secondMonthRewardPoints;
    }

    public void setSecondMonthRewardPoints(long secondMonthRewardPoints) {
        this.secondMonthRewardPoints = secondMonthRewardPoints;
    }

    public long getThirdMonthRewardPoints() {
        return thirdMonthRewardPoints;
    }

    public void setThirdMonthRewardPoints(long thirdMonthRewardPoints) {
        this.thirdMonthRewardPoints = thirdMonthRewardPoints;
    }

    public long getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(long totalRewards) {
        this.totalRewards = totalRewards;
    }
}
