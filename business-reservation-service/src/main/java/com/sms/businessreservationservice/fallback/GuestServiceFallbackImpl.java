package com.sms.businessreservationservice.fallback;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.businessreservationservice.client.GuestService;
import com.sms.businessreservationservice.client.RoomService;
import com.sms.businessreservationservice.domain.Guest;

public class GuestServiceFallbackImpl {
	
	@Autowired
	private GuestService guestService;

	@RequestMapping(value="/guests", method= RequestMethod.GET)
    List<Guest> findAll(@RequestParam(name="emailAddress", required = false)String emailAddress)
    {
		return this.guestService.findAll(null);
    }
	
	 /**@RequestMapping(value = "/guests/{id}", method = RequestMethod.GET)
	    Guest findOne(@PathVariable(name="id")long id)
	    {
		 {
				return this.guestService.findOne(null);
		    }
	    }**/
}
