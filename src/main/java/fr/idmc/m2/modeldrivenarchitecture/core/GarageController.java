package fr.idmc.m2.modeldrivenarchitecture.core;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.idmc.m2.modeldrivenarchitecture.model.actor.Owner;
import fr.idmc.m2.modeldrivenarchitecture.model.garage.DigitalKey;
import fr.idmc.m2.modeldrivenarchitecture.model.garage.DigitalLock;
import fr.idmc.m2.modeldrivenarchitecture.model.garage.Motor;

@RestController
@RequestMapping("garage")
@RequiredArgsConstructor
public class GarageController {

    private final Motor motor;

    @PostMapping
    public void openGarage(@RequestBody DigitalKey key) {
        final var dl = new DigitalLock(motor);
        key.setLock(dl);
        var owner = new Owner(key);
        owner.open();
    }

}
