package fr.idmc.m2.modeldrivenarchitecture;

import fr.idmc.m2.modeldrivenarchitecture.model.actor.Owner;
import fr.idmc.m2.modeldrivenarchitecture.model.garage.DigitalKey;
import fr.idmc.m2.modeldrivenarchitecture.model.garage.DigitalLock;
import fr.idmc.m2.modeldrivenarchitecture.model.garage.Gate;
import fr.idmc.m2.modeldrivenarchitecture.model.garage.Motor;

public class Main {

    public static void main(String[] args) {
        Gate g = new Gate();
        Motor m = new Motor(g);
        DigitalLock dl = new DigitalLock(m);

        DigitalKey dk = new DigitalKey("1111");
        dk.setLock(dl);

        Owner o = new Owner(dk);
        o.open();
    }

}
