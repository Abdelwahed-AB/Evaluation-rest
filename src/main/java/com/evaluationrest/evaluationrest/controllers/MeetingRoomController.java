package com.evaluationrest.evaluationrest.controllers;

import com.evaluationrest.evaluationrest.dto.request.AvailableMeetingRoomsRequest;
import com.evaluationrest.evaluationrest.dto.request.MeetingRoomRequest;
import com.evaluationrest.evaluationrest.dto.response.MeetingRoomResponse;
import com.evaluationrest.evaluationrest.entities.MeetingRoom;
import com.evaluationrest.evaluationrest.mappers.IMeetingRoomMapper;
import com.evaluationrest.evaluationrest.services.IMeetingRoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/meetingrooms")
@RequiredArgsConstructor
public class MeetingRoomController {
    private final IMeetingRoomMapper meetingRoomMapper;
    private final IMeetingRoomService meetingRoomService;

    @GetMapping
    public List<MeetingRoomResponse> getAllMeetingRooms(){
        return meetingRoomService.findAll().stream().map(meetingRoomMapper::meetingRoomToMeetingRoomResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MeetingRoomResponse getMeetingRoomById(@PathVariable("id") Long id){
        return meetingRoomMapper.meetingRoomToMeetingRoomResponse(meetingRoomService.findById(id));
    }

    @GetMapping("/available")
    public List<MeetingRoomResponse> getAvailableMeetingRooms(@RequestBody @Valid AvailableMeetingRoomsRequest req){
        return meetingRoomService.getAvailableRooms(req.start(), req.end())
                .stream()
                .map(meetingRoomMapper::meetingRoomToMeetingRoomResponse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> createMeetingRoom(@RequestBody @Valid MeetingRoomRequest MeetingRoomRequest){
        MeetingRoom MeetingRoom = meetingRoomMapper.meetingRoomRequestToMeetingRoom(MeetingRoomRequest);
        meetingRoomService.createMeetingRoom(MeetingRoom);

        return ResponseEntity.status(HttpStatus.CREATED).body("MeetingRoom created.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMeetingRoom(@PathVariable("id") Long id, @RequestBody @Valid MeetingRoomRequest MeetingRoomRequest){
        MeetingRoom MeetingRoom = meetingRoomMapper.meetingRoomRequestToMeetingRoom(MeetingRoomRequest);
        meetingRoomService.updateMeetingRoom(id, MeetingRoom);

        return ResponseEntity.ok("MeetingRoom updated.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMeetingRoom(@PathVariable("id") Long id){
        meetingRoomService.deleteMeetingRoomById(id);
        return ResponseEntity.ok("MeetingRoom deleted.");
    }
}
