package com.evaluationrest.evaluationrest.services;

import com.evaluationrest.evaluationrest.entities.MeetingRoom;
import com.evaluationrest.evaluationrest.exceptions.MeetingRoomNotFoundException;
import com.evaluationrest.evaluationrest.repositories.MeetingRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingRoomService implements IMeetingRoomService{
    private final MeetingRoomRepository meetingRoomRepository;

    @Override
    public List<MeetingRoom> findAll() {
        return meetingRoomRepository.findAll();
    }

    @Override
    public List<MeetingRoom> getAvailableRooms(LocalDateTime start, LocalDateTime end) {
        return meetingRoomRepository.getAvailableRooms(start, end);
    }

    @Override
    public MeetingRoom findById(Long id) {
        return meetingRoomRepository.findById(id).orElseThrow(()->new MeetingRoomNotFoundException(id));
    }

    @Override
    public void createMeetingRoom(MeetingRoom meetingRoom) {
        meetingRoom.setId(0L);
        meetingRoomRepository.save(meetingRoom);
    }

    @Override
    public void updateMeetingRoom(Long id, MeetingRoom meetingRoom) {
        meetingRoom.setId(id);
        meetingRoomRepository.save(meetingRoom);
    }

    @Override
    public void deleteMeetingRoomById(Long id) {
        MeetingRoom meetingRoom = findById(id);
        meetingRoomRepository.delete(meetingRoom);
    }
}
