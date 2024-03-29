package br.com.sw2you.realmeet.service;

import static java.util.Objects.requireNonNull;

import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.domain.entity.Room;
import br.com.sw2you.realmeet.domain.repository.RoomRepository;
import br.com.sw2you.realmeet.exception.RoomNotFoundException;
import br.com.sw2you.realmeet.mapper.RoomMapper;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
        this.roomRepository = roomRepository;
    }

    public RoomDTO getRoom(Long id) {
        requireNonNull(id);
        Room room = roomRepository
            .findByIdAndActive(id, true)
            .orElseThrow(() -> new RoomNotFoundException("Room not found " + id));
        return roomMapper.fromEntityToDto(room);
    }
}
