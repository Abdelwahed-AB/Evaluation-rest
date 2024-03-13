package com.evaluationrest.evaluationrest.services;

import com.evaluationrest.evaluationrest.dto.request.MeetingRoomRequest;
import com.evaluationrest.evaluationrest.dto.response.MeetingRoomResponse;
import com.evaluationrest.evaluationrest.entities.MeetingRoom;

import java.util.List;

public interface IMeetingRoomService {
    List<MeetingRoom> findAll();
    MeetingRoom findById(Long id);
    void createMeetingRoom(MeetingRoom MeetingRoom);
    void updateMeetingRoom(Long id, MeetingRoom MeetingRoom);
    void deleteMeetingRoomById(Long id);
}
