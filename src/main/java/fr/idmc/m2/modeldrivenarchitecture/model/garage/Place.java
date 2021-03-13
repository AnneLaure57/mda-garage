package fr.idmc.m2.modeldrivenarchitecture.model.garage;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.idmc.m2.modeldrivenarchitecture.anemic.NewPlaceDTO;
import fr.idmc.m2.modeldrivenarchitecture.anemic.PlaceDTO;
import fr.idmc.m2.modeldrivenarchitecture.anemic.PlaceService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Slf4j
public class Place {
	
	private static final long serialVersionUID = 1234567854567L;
	
	//@Inject
    private PlaceDTO placeDTO; //using composition doesn't make it acceptable
	
	@Id
	private Long id;
	private int stage;
	private String driveway;
	private Boolean available = true;
	@Column
    @JoinColumn
    private String password;
	
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
