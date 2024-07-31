package com.nqluong.hotel_management_system.controller;

import com.nqluong.hotel_management_system.dto.request.RoomCreationRequest;
import com.nqluong.hotel_management_system.dto.request.RoomUpdateRequest;
import com.nqluong.hotel_management_system.dto.response.ApiResponse;
import com.nqluong.hotel_management_system.dto.response.RoomResponse;
import com.nqluong.hotel_management_system.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping
    ApiResponse<RoomResponse> createRoom(@RequestBody RoomCreationRequest request){
        return ApiResponse.<RoomResponse>builder()
                .time(LocalDateTime.now())
                .status(HttpStatus.CREATED.value())
                .result(roomService.createRoom(request))
                .build();
    }
    @GetMapping
    ApiResponse<List<RoomResponse>> getAllRooms(){
        return ApiResponse.<List<RoomResponse>>builder()
                .time(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .result(roomService.getAllRooms())
                .build();
    }

    @GetMapping("/{number}")
    ApiResponse<RoomResponse> getByRoomNumber(@PathVariable("number") int num){
        return ApiResponse.<RoomResponse>builder()
                .time(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .result(roomService.getByRoomNumber(num))
                .build();
    }

    @PutMapping("/{number}")
    ApiResponse<RoomResponse> updateRoom(@PathVariable("number") int num,
                                         @RequestBody RoomUpdateRequest request){
        return ApiResponse.<RoomResponse>builder()
                .time(LocalDateTime.now())
                .status(HttpStatus.OK.value())
                .result(roomService.updateRoom(num,request))
                .build();
    }

    @DeleteMapping("/{number}")
    ApiResponse<String> deleteRoom(@PathVariable("number") int num){
        roomService.deleteRoom(num);
        return ApiResponse.<String>builder()
                .time(LocalDateTime.now())
                .status(HttpStatus.NO_CONTENT.value())
                .result("Room has been deleted")
                .build();
    }

}
