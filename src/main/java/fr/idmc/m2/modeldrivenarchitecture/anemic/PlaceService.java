package fr.idmc.m2.modeldrivenarchitecture.anemic;

import org.springframework.stereotype.Service;

import fr.idmc.m2.modeldrivenarchitecture.model.garage.Place;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository repository;
    private final ValidationHelper validationHelper;
    private final PlaceMapper mapper;

    // @Secured
    public Iterable<Place> findAll() {
        return repository.findAll();
    }

    // @Secured
    public PlaceDTO save(NewPlaceDTO dto) {
        validationHelper.validate(dto);
        var place = mapper.toEntity(dto);

        final var saved = repository.save(place);

        return mapper.toDto(saved);
    }
}
