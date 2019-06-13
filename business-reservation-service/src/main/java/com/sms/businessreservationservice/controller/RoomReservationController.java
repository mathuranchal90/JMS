package com.sms.businessreservationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sms.businessreservationservice.client.RoomService;
import com.sms.businessreservationservice.domain.Room;
import com.sms.businessreservationservice.domain.RoomReservation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="RoomReservations", description = "Business process service operations on rooms and reservations", tags=("roomReservations"))
public class RoomReservationController {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
   // private RoomReservationBusinessProcess businessProcess;
	
	@RequestMapping(value = "/rooms", method = RequestMethod.GET)
    @ApiOperation(value="Get All Rooms", notes="Gets all rooms in the system", nickname="getRooms")
    public List<Room> getAllRooms(@RequestParam(name="roomNumber", required=false)String roomNumber){
        return this.roomService.findAll(roomNumber);
    }
	
	/**@RequestMapping(value="/roomReservations/{date}", method=RequestMethod.GET)
    @ApiOperation(value="Get Room Reservations", notes="Gets all reservations for a specific date", nickname="getReservationsForDate")
    public List<RoomReservation> getRoomReservationsForDate(@PathVariable("date") String date){
        return this.businessProcess.getRoomReservationsForDate(date);
    }**/
	
	@RequestMapping(value="/rooms", method=RequestMethod.GET)
	public List<Room> getAllRooms()
	{
		return this.roomService.findAll(null);
	}
	
	
	/**@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/rooms", method=RequestMethod.GET)
	public List<Room> getAllRooms()
	{
		ResponseEntity<List<Room>> roomsResponse= this.restTemplate.exchange("http://room-service/rooms",HttpMethod.GET,null,new ParameterizedTypeReference<List<Room>>() {
			
		});
		
		return roomsResponse.getBody();
	}**/
	

}
