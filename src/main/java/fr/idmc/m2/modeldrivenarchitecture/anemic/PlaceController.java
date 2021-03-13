package fr.idmc.m2.modeldrivenarchitecture.anemic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.idmc.m2.modeldrivenarchitecture.model.garage.Place;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "places", produces = "")
@RequiredArgsConstructor
@Slf4j
public class PlaceController {
	
	private final PlaceService service;
	
	@GetMapping
	public Iterable<Place> findAllPlace() {
		log.debug("je suis ici");
		return service.findAll();
		
	}
	
	@PostMapping
	public PlaceDTO createPlace(NewPlaceDTO place) {
		return service.save(place);
	}
}
