package com.rewards.rewardsProgramApplication.repository;

import com.rewards.rewardsProgramApplication.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public interface TranscationRepository extends JpaRepository<Transaction,Long> {

    public List<Transaction> findAllByCustomerId(Long id);

    public List<Transaction> findAllByCustomerIdAndTransactionDateBetween(Long id, Timestamp fromDate, Timestamp toDate);
}
