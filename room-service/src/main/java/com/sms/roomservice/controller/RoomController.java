package com.sms.roomservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sms.roomservice.model.Room;
import com.sms.roomservice.repository.RoomRepository;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by anchalmathur on 5/09/19.
 */
@RestController
@RequestMapping(value="/rooms")
@Api(value="rooms", description = "Data service operations on rooms", tags=("rooms"))
public class RoomController {

    private RoomRepository roomRepository;
    
    

    @Autowired
    public RoomController(RoomRepository roomRepository) {
		super();
		this.roomRepository=roomRepository;
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Get All Rooms", notes="Gets all rooms in the system", nickname="getRooms")
    public List<Room> findAll(@RequestParam(name="roomNumber", required = false)String roomNumber){
        if(StringUtils.isNotEmpty(roomNumber)){
            return Collections.singletonList(this.roomRepository.findByRoomNumber(roomNumber));
        }
        return (List<Room>) this.roomRepository.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ApiOperation(value="Get Room", notes="Gets a single room based on its unique id", nickname = "getRoom")
    public Optional<Room> findOne(@PathVariable("id")long id){
        return this.roomRepository.findById(id);
    }
}
