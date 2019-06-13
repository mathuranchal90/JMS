package com.sms.reservationservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.reservationservice.model.ReservationEntity;

import java.sql.Date;
import java.util.List;


@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findByDate(Date date);
}

