package br.com.sw2you.realmeet;
import static java.util.concurrent.CompletableFuture.*;

import br.com.sw2you.realmeet.api.facade.RoomsApi;
import br.com.sw2you.realmeet.api.model.Room;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RoomController implements RoomsApi {

    @Override
    public CompletableFuture<ResponseEntity<Room>> listRooms(@Valid Long id) {
        return supplyAsync(() -> ResponseEntity.ok(new Room().id(1L).name("room #1")));
    }
}
