package br.com.sw2you.realmeet.service;

import static java.util.Objects.requireNonNull;

import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.domain.entity.Room;
import br.com.sw2you.realmeet.exception.RoomNotFoundException;
import br.com.sw2you.realmeet.mapper.RoomMapper;
import br.com.sw2you.realmeet.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
        this.roomRepository = roomRepository;
    }

    public RoomDTO finById(Long id) {
        requireNonNull(id);
        Room room = roomRepository.findById(id).orElseThrow(()-> new RoomNotFoundException("Room not found "+id));
        //        return new RoomDTO().name(room.getName()).id(room.getId()).seats(room.getSeats());
        return roomMapper.fromEntityToDto(room);
    }
}
