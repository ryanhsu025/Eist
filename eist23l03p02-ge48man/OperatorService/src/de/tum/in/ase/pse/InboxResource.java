package de.tum.in.ase.pse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/message/", consumes = "application/json")
public class InboxResource {
    private final DroidFactory factory = new DroidFactory();
    @PostMapping("3po")
    public ResponseEntity<String> droidReady3PO(@RequestBody String message) {
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("e2")
    public ResponseEntity<String> droidReadyR2(@RequestBody String message) {
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
