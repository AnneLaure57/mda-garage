package fr.idmc.m2.modeldrivenarchitecture.model.actor;

import fr.idmc.m2.modeldrivenarchitecture.model.garage.DigitalKey;

public class Owner {
	
	private DigitalKey key;

	public Owner(DigitalKey key) {
		this.key = key;
	}
	
	public void open() {
		key.open();
	}
}
