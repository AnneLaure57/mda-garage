package fr.idmc.m2.modeldrivenarchitecture.model.garage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class Motor {

	private final Gate gate;

	public void openGate() {
		turnGears();
		gate.open();
	}

	private void turnGears() {
		log.info("Turning gears");
	}

}
