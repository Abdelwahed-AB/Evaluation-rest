package com.evaluationrest.evaluationrest.controllers;

import com.evaluationrest.evaluationrest.dto.request.ReservationRequest;
import com.evaluationrest.evaluationrest.dto.response.ReservationResponse;
import com.evaluationrest.evaluationrest.entities.Reservation;
import com.evaluationrest.evaluationrest.mappers.IReservationMapper;
import com.evaluationrest.evaluationrest.services.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final IReservationMapper mapper;
    private final IReservationService meetingRoomReservationService;

    @GetMapping
    public List<ReservationResponse> getAllMeetingRoomReservations(){
        return meetingRoomReservationService.findAll().stream().map(mapper::reservationToReservationResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReservationResponse getMeetingRoomReservationById(@PathVariable("id") Long id){
        return mapper.reservationToReservationResponse(meetingRoomReservationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> createMeetingRoomReservation(@RequestBody ReservationRequest reservationRequest){
        Reservation reservation = mapper.reservationRequestToReservation(reservationRequest);
        meetingRoomReservationService.createReservation(reservation);

        return ResponseEntity.ok("Reservation created.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMeetingRoomReservation(@PathVariable("id") Long id, @RequestBody ReservationRequest reservationRequest){
        Reservation reservation = mapper.reservationRequestToReservation(reservationRequest);
        meetingRoomReservationService.updateReservation(id, reservation);

        return ResponseEntity.ok("Reservation updated.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMeetingRoomReservation(@PathVariable("id") Long id){
        meetingRoomReservationService.deleteReservationById(id);
        return ResponseEntity.ok("Reservation deleted.");
    }
}
