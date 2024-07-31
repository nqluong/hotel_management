package com.nqluong.hotel_management_system.service;

import com.nqluong.hotel_management_system.dto.request.RoomCreationRequest;
import com.nqluong.hotel_management_system.dto.request.RoomUpdateRequest;
import com.nqluong.hotel_management_system.dto.response.RoomResponse;
import com.nqluong.hotel_management_system.exception.AppException;
import com.nqluong.hotel_management_system.exception.ErrorCode;
import com.nqluong.hotel_management_system.mapper.RoomMapper;
import com.nqluong.hotel_management_system.model.Room;
import com.nqluong.hotel_management_system.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoomService {

    RoomRepository roomRepository;
    RoomMapper roomMapper;

    public RoomResponse createRoom(RoomCreationRequest request){
        roomRepository.findByRoomNumber(request.getRoomNumber()).ifPresent(room -> {
            throw new AppException(ErrorCode.ROOM_EXISTED);
        });
        Room room = roomMapper.toRoom(request);
        roomRepository.save(room);
        return roomMapper.toRoomResponse(room);
    }

    public List<RoomResponse> getAllRooms(){
        return roomRepository.findAll().stream()
                .map(roomMapper::toRoomResponse)
                .toList();
    }

    public RoomResponse getByRoomNumber(int num){
        return roomMapper.toRoomResponse(roomRepository.findByRoomNumber(num).orElseThrow(
            () -> new RuntimeException("Room not found")
        ));
    }
    public RoomResponse updateRoom(int num, RoomUpdateRequest request){
        Room room = roomRepository.findByRoomNumber(num).orElseThrow(
                () -> new RuntimeException("Room not found")
        );
        roomMapper.updateRoom(room, request);

        return roomMapper.toRoomResponse(roomRepository.save(room));
    }

    @Transactional
    public void deleteRoom(int num){
        roomRepository.deleteByRoomNumber(num);
    }
}
