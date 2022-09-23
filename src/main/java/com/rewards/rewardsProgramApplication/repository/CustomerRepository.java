package com.rewards.rewardsProgramApplication.repository;

import com.rewards.rewardsProgramApplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Customer findByCustomerId(Long id);
}
