package fr.idmc.m2.modeldrivenarchitecture.anemic;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.JpaRepository;
import fr.idmc.m2.modeldrivenarchitecture.model.garage.Place;


public interface PlaceRepository extends CrudRepository<Place, String>{

	Optional<Place> findById(@Param("id") String  id);

}
