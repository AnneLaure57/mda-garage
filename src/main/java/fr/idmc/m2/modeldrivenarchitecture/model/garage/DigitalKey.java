package fr.idmc.m2.modeldrivenarchitecture.model.garage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class DigitalKey {

	@Getter
	@Setter
	private String value;

	@Setter
	private DigitalLock lock;
	
	public DigitalKey(String value) {
		this.value = value;
	}

	public void open() {
		lock.open(this);
	}
	
}
