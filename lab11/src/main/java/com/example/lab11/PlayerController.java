package com.example.lab11;


import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class PlayerController {
    private final List<Player> infoPlayers=new ArrayList<>();

    @GetMapping("/getInfoPlayers")
    public List<Player> getPlayers(){
        return infoPlayers;
    }

    @PostMapping("/postInfoPlayers")
    public int addPlayer(@RequestParam String name){
        Player player=new Player(name);
        infoPlayers.add(player);
        return infoPlayers.size();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestParam String name){
        Player player;
        if(id>=0 && id<infoPlayers.size()){
            player = infoPlayers.get(id);
            player.setName(name);
            return new ResponseEntity<>("Player updated",HttpStatus.OK);
        }
        else {

            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Player player;
        if(id>=0 && id<infoPlayers.size()){
            player=infoPlayers.get(id);
            infoPlayers.remove(player);
            return new ResponseEntity<>("Player removed",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);

        }
    }
}
