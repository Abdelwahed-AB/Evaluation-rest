package com.evaluationrest.evaluationrest.mappers;

import com.evaluationrest.evaluationrest.dto.request.ReservationRequest;
import com.evaluationrest.evaluationrest.dto.response.ReservationResponse;
import com.evaluationrest.evaluationrest.entities.MeetingRoom;
import com.evaluationrest.evaluationrest.entities.Reservation;
import com.evaluationrest.evaluationrest.entities.User;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper implements IReservationMapper {
    @Override
    public Reservation reservationRequestToReservation(ReservationRequest req) {
        MeetingRoom meetingRoom = MeetingRoom.builder().id(req.meetingRoomId()).build();
        User user = User.builder().id(req.userId()).build();

        Reservation reservation = Reservation.builder()
                .user(user)
                .room(meetingRoom)
                .startTime(req.startTime())
                .endTime(req.endTime())
                .build();

        return reservation;
    }

    @Override
    public ReservationResponse reservationToReservationResponse(Reservation reservation) {
        ReservationResponse response = new ReservationResponse(
                reservation.getId(),
                reservation.getRoom().getId(),
                reservation.getUser().getId(),
                reservation.getStartTime(),
                reservation.getEndTime()
        );
        return response;
    }
}
