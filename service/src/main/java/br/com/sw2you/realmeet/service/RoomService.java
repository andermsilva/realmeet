package br.com.sw2you.realmeet.service;


import br.com.sw2you.realmeet.domain.entity.Room;
import br.com.sw2you.realmeet.exception.RoomNotFoundException;
import br.com.sw2you.realmeet.repository.RoomRepository;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public Room finById(Long id){
        Objects.requireNonNull(id);
       return roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);


    }


}
