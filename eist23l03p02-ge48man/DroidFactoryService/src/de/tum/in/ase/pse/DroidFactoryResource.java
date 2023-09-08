package de.tum.in.ase.pse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;



@RestController
@RequestMapping(value = "/droid/", consumes = "application/json")
public class DroidFactoryResource {

    private final DroidFactory factory = new DroidFactory();

    // TODO 2.1: implement both methods using the async features of the CompletableFuture class and remove the old methods


    @PostMapping("r2")
    public CompletableFuture<String> produceR2Async(@RequestBody Droids droid) {
        return CompletableFuture.supplyAsync(() -> {
            Droid droid1 = factory.produce(droid);
            return droid1.getName();
        });
    }

    @PostMapping("3po")
    public CompletableFuture<String> produce3POAsync(@RequestBody Droids droid) {
        return CompletableFuture.supplyAsync(() -> {
            Droid droid1 = factory.produce(droid);
            return droid1.getName();
        });
    }

}
