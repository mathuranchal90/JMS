package com.sms.roomservice.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sms.roomservice.model.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
    Room findByRoomNumber(String roomNumber);
	
}
