package fr.idmc.m2.modeldrivenarchitecture.rich;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.idmc.m2.modeldrivenarchitecture.rich.*;

import java.util.List;

@RestController
@RequestMapping(value = "places")
@RequiredArgsConstructor
public class PlaceController {

    @GetMapping
    // @Secured
    public List<PlaceDTO> findAllPlace() {
        return Place.findAll();
    }

    @PostMapping
    public PlaceDTO createPlace(NewPlaceDTO place) {
        return place
                .toEntity()
                .save()
                .toDto();
    }

}
