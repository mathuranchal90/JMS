package com.sms.businessreservationservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.businessreservationservice.domain.Reservation;

@FeignClient("RESERVATION-SERVICE")
public interface ReservationService {
	
	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
    List<Reservation> findAll(@RequestParam(name = "date", required = false) String date);

}
