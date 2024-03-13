package com.evaluationrest.evaluationrest.mappers;

import com.evaluationrest.evaluationrest.dto.request.MeetingRoomRequest;
import com.evaluationrest.evaluationrest.dto.response.MeetingRoomResponse;
import com.evaluationrest.evaluationrest.entities.MeetingRoom;

public interface IMeetingRoomMapper {
    MeetingRoom meetingRoomRequestToMeetingRoom(MeetingRoomRequest meetingRoomRequest);
    MeetingRoomResponse meetingRoomToMeetingRoomResponse(MeetingRoom meetingRoom);
}
