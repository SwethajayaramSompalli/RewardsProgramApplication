package com.rewards.rewardsProgramApplication.controller;

import com.rewards.rewardsProgramApplication.entity.Customer;
import com.rewards.rewardsProgramApplication.model.RewardPoints;
import com.rewards.rewardsProgramApplication.repository.CustomerRepository;
import com.rewards.rewardsProgramApplication.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class RewardsController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RewardsService rewardsService;

    @GetMapping(value = "/{customerId}/rewards",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RewardPoints> getRewardsByCustomerId(@PathVariable("customerId") Long customerId){
        Customer customer = customerRepository.findByCustomerId(customerId);
        if(customer == null)
        {
            throw new RuntimeException("Invalid / Missing customer Id ");
        }
        RewardPoints customerRewards = rewardsService.getRewardsByCustomerId(customerId);
        return new ResponseEntity<>(customerRewards, HttpStatus.OK);
    }

}
