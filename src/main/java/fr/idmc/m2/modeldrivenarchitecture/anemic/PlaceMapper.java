package fr.idmc.m2.modeldrivenarchitecture.anemic;

import org.springframework.stereotype.Component;

import fr.idmc.m2.modeldrivenarchitecture.model.garage.Place;

@Component
public class PlaceMapper {

    public Place toEntity(NewPlaceDTO dto) {
        return Place
                .builder()
                .password(dto.getPassword())
                .build();
    }

    public PlaceDTO toDto(Place saved) {
        return PlaceDTO
                .builder()
                .id(saved.getId())
                .build();
    }
}
