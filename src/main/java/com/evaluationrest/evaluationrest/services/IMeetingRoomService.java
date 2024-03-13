package com.evaluationrest.evaluationrest.services;

import com.evaluationrest.evaluationrest.entities.MeetingRoom;

import java.time.LocalDateTime;
import java.util.List;

public interface IMeetingRoomService {
    List<MeetingRoom> findAll();

    List<MeetingRoom> getAvailableRooms(LocalDateTime start, LocalDateTime end);
    MeetingRoom findById(Long id);
    void createMeetingRoom(MeetingRoom MeetingRoom);
    void updateMeetingRoom(Long id, MeetingRoom MeetingRoom);
    void deleteMeetingRoomById(Long id);
}
