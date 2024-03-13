package com.evaluationrest.evaluationrest.mappers;

import com.evaluationrest.evaluationrest.dto.request.MeetingRoomRequest;
import com.evaluationrest.evaluationrest.dto.response.MeetingRoomResponse;
import com.evaluationrest.evaluationrest.entities.MeetingRoom;

public class MeetingRoomMapper implements IMeetingRoomMapper{
    @Override
    public MeetingRoom meetingRoomRequestToMeetingRoom(MeetingRoomRequest meetingRoomRequest) {
        MeetingRoom meetingRoom = MeetingRoom.builder()
                .label(meetingRoomRequest.label())
                .build();
        return meetingRoom;
    }

    @Override
    public MeetingRoomResponse meetingRoomToMeetingRoomResponse(MeetingRoom meetingRoom) {
        MeetingRoomResponse meetingRoomResponse = new MeetingRoomResponse(
                meetingRoom.getId(),
                meetingRoom.getLabel()
        );
        return meetingRoomResponse;
    }
}
