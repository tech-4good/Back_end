package tech4good.cruds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech4good.cruds.service.AuxilioGovernamentalService;

@RestController
@RequestMapping("/auxilio-governamentais")
public class AuxilioGovernamentalController {

    private final AuxilioGovernamentalService auxilioGovernamentalService;

    public AuxilioGovernamentalController(AuxilioGovernamentalService auxilioGovernamentalService) {
        this.auxilioGovernamentalService = auxilioGovernamentalService;
    }
}
