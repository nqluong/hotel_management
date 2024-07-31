package com.nqluong.hotel_management_system.mapper;

import com.nqluong.hotel_management_system.dto.request.RoomCreationRequest;
import com.nqluong.hotel_management_system.dto.request.RoomUpdateRequest;
import com.nqluong.hotel_management_system.dto.response.RoomResponse;
import com.nqluong.hotel_management_system.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toRoom(RoomCreationRequest request);

    RoomResponse toRoomResponse(Room room);

    void updateRoom(@MappingTarget Room room, RoomUpdateRequest request);
}
