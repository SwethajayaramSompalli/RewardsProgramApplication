Reward Points Calculator based on Transactions

This REST API is used to get reward points based on Customer ID

A Retailer offers a rewards program to its customers awarding  points based on each 
recorded purchase.
A customer receives 2 points for every dollar($) spent over $100 in each transaction, 
plus 1 point for every dollar spent over $50 in each transaction.
Ex: a $ 120 purchase = 2* $20+ 1* $50 = 90 points
Given record of every transaction during a three-month period, calculate the reward points earned for each customer
per month and total

  The package name is structured as com.rewards.rewardsProgramApplication
  Used In Memory database H2 to store the transaction data
  Install H2 db locally and run, change the properties file in application.properties file
  In Start up data.sql file will run, and data will be populated in tables

  http://localhost:8080/customers/{customerId}/rewards









