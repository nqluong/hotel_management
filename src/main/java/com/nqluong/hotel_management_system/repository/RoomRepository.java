package com.nqluong.hotel_management_system.repository;

import com.nqluong.hotel_management_system.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

    Optional<Room> findByRoomNumber(int num);

    void deleteByRoomNumber(int num);
}
