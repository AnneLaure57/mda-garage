package fr.idmc.m2.modeldrivenarchitecture.model.garage;

import java.util.List;

public class DigitalLock {
	
	private Motor motor;

	private List<String> authorizedValues;
	
	public DigitalLock(Motor motor) {
		this.motor = motor;
		authorizedValues = List.of("1111", "0000", "6969", "1234");
	}

	public boolean validateKey(DigitalKey key) {
		return authorizedValues.contains(key.getValue());
	}

	public void open(DigitalKey digitalKey) {
		if(validateKey(digitalKey)) {
			motor.openGate();
		}
	}
	
}
