package com.sms.guestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sms.guestservice.model.Guest;

import feign.Param;


@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>{
	
	@Query("select p from Guest p where p.emailAddress = emailAddress")
    Guest findByEmailAddress(@Param("emailAddress")String emailAddress);
	
	@Query("select p from Guest p where p.id = id")
    Guest findById(@Param("Id")String id);
}

