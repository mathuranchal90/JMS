package com.sms.businessreservationservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.businessreservationservice.domain.Room;

@FeignClient(value="room-service")
public interface RoomService {

	@RequestMapping(value="/rooms", method=RequestMethod.GET)
	List<Room> findAll(@RequestParam(name="roomNumber",required=false)String roomNumber);
	
	 @RequestMapping(value="/rooms/{id}", method = RequestMethod.GET)
	    Room findOne(@PathVariable("id")long id);
}
