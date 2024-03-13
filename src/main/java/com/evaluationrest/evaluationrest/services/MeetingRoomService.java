package com.evaluationrest.evaluationrest.services;

import com.evaluationrest.evaluationrest.entities.MeetingRoom;
import com.evaluationrest.evaluationrest.exceptions.MeetingRoomNotFoundException;
import com.evaluationrest.evaluationrest.repositories.MeetingRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingRoomService implements IMeetingRoomService{
    private final MeetingRoomRepository MeetingRoomRepository;

    @Override
    public List<MeetingRoom> findAll() {
        return MeetingRoomRepository.findAll();
    }

    @Override
    public MeetingRoom findById(Long id) {
        return MeetingRoomRepository.findById(id).orElseThrow(()->new MeetingRoomNotFoundException(id));
    }

    @Override
    public void createMeetingRoom(MeetingRoom MeetingRoom) {
        MeetingRoom.setId(0L);
        MeetingRoomRepository.save(MeetingRoom);
    }

    @Override
    public void updateMeetingRoom(Long id, MeetingRoom MeetingRoom) {
        MeetingRoom.setId(id);
        MeetingRoomRepository.save(MeetingRoom);
    }

    @Override
    public void deleteMeetingRoomById(Long id) {
        MeetingRoom MeetingRoom = findById(id);
        MeetingRoomRepository.delete(MeetingRoom);
    }
}
