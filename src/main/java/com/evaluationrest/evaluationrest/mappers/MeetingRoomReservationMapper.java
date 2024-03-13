package com.evaluationrest.evaluationrest.mappers;

import com.evaluationrest.evaluationrest.dto.request.MeetingRoomReservationRequest;
import com.evaluationrest.evaluationrest.dto.response.MeetingRoomReservationResponse;
import com.evaluationrest.evaluationrest.entities.MeetingRoom;
import com.evaluationrest.evaluationrest.entities.MeetingRoomReservation;
import com.evaluationrest.evaluationrest.entities.User;
import org.springframework.stereotype.Component;

@Component
public class MeetingRoomReservationMapper implements IMeetingRoomReservationMapper{
    @Override
    public MeetingRoomReservation meetingRoomReservationRequestToMeetingRoomReservation(MeetingRoomReservationRequest req) {
        MeetingRoom meetingRoom = MeetingRoom.builder().id(req.meetingRoomId()).build();
        User user = User.builder().id(req.userId()).build();

        MeetingRoomReservation reservation = MeetingRoomReservation.builder()
                .user(user)
                .room(meetingRoom)
                .startTime(req.startTime())
                .endTime(req.endTime())
                .build();

        return reservation;
    }

    @Override
    public MeetingRoomReservationResponse meetingRoomReservationToMeetingRoomReservationResponse(MeetingRoomReservation reservation) {
        MeetingRoomReservationResponse response = new MeetingRoomReservationResponse(
                reservation.getId(),
                reservation.getRoom().getId(),
                reservation.getUser().getId(),
                reservation.getStartTime(),
                reservation.getEndTime()
        );
        return response;
    }
}
