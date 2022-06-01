package com.generali.burritoorderingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generali.burritoorderingservice.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}
