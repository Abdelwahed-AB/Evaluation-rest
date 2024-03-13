package com.evaluationrest.evaluationrest.controllers;

import com.evaluationrest.evaluationrest.dto.request.MeetingRoomReservationRequest;
import com.evaluationrest.evaluationrest.dto.response.MeetingRoomReservationResponse;
import com.evaluationrest.evaluationrest.entities.MeetingRoomReservation;
import com.evaluationrest.evaluationrest.mappers.IMeetingRoomReservationMapper;
import com.evaluationrest.evaluationrest.services.IMeetingRoomReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/meetingroomreservations")
@RequiredArgsConstructor
public class MeetingRoomReservationController {
    private final IMeetingRoomReservationMapper mapper;
    private final IMeetingRoomReservationService meetingRoomReservationService;

    @GetMapping
    public List<MeetingRoomReservationResponse> getAllMeetingRoomReservations(){
        return meetingRoomReservationService.findAll().stream().map(mapper::meetingRoomReservationToMeetingRoomReservationResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MeetingRoomReservationResponse getMeetingRoomReservationById(@PathVariable("id") Long id){
        return mapper.meetingRoomReservationToMeetingRoomReservationResponse(meetingRoomReservationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> createMeetingRoomReservation(@RequestBody MeetingRoomReservationRequest meetingRoomReservationRequest){
        MeetingRoomReservation meetingRoomReservation = mapper.meetingRoomReservationRequestToMeetingRoomReservation(meetingRoomReservationRequest);
        meetingRoomReservationService.createMeetingRoomReservation(meetingRoomReservation);

        return ResponseEntity.ok("MeetingRoomReservation created.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMeetingRoomReservation(@PathVariable("id") Long id, @RequestBody MeetingRoomReservationRequest meetingRoomReservationRequest){
        MeetingRoomReservation meetingRoomReservation = mapper.meetingRoomReservationRequestToMeetingRoomReservation(meetingRoomReservationRequest);
        meetingRoomReservationService.updateMeetingRoomReservation(id, meetingRoomReservation);

        return ResponseEntity.ok("MeetingRoomReservation updated.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMeetingRoomReservation(@PathVariable("id") Long id){
        meetingRoomReservationService.deleteMeetingRoomReservationById(id);
        return ResponseEntity.ok("MeetingRoomReservation deleted.");
    }
}
