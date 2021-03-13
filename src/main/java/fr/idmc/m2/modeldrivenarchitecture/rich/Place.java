package fr.idmc.m2.modeldrivenarchitecture.rich;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
@NoArgsConstructor
public class Place extends BasicDAO {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @JoinColumn
    private String password;

    public static List<PlaceDTO> findAll() {
//        return list()
//                .stream()
//                .map(Place::toDto)
//                .collect(Collectors.toList());
        return null;
    }

    // @Secured
    public Place save() {
        validate();

        // TODO save in DB;
        //super.save(this);

        return this;
    }

    void validate() {
    // TODO
    }

    public PlaceDTO toDto() {
        return PlaceDTO
                .builder()
                .id(this.getId())
                .build();
    }
}
@AllArgsConstructor
@Getter
class NewPlaceDTO {

    private final String password;

    public Place toEntity() {
        return Place
                .builder()
                .password(getPassword())
                .build();
    }
}

@Getter
@Builder
class PlaceDTO extends PlaceController {

    private final Long id;

}