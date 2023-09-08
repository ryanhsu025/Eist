package de.tum.in.ase.pse.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class ObiWanKenobiController {
    @GetMapping("/train-apprentices")
    public String trainApprentices() {
        return "Apprentices are being trained...";
    }

    // TODO 1.2 Implement an enpoint responsible for training new apprentices.
    //  It should operate under the same path as in MasterYodaController


}
