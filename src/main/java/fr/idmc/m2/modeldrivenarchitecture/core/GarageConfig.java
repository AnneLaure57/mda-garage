package fr.idmc.m2.modeldrivenarchitecture.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import fr.idmc.m2.modeldrivenarchitecture.model.garage.Gate;
import fr.idmc.m2.modeldrivenarchitecture.model.garage.Motor;

@Configuration
public class GarageConfig {

    @Bean
    public Gate gate() {
        return new Gate();
    }

    @Bean
    public Motor motor(Gate gate) {
        return new Motor(gate);
    }

}
