package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.Machine;
import de.tum.in.ase.pse.utils.FactoryException;

/**
 * The (terminal) controller superclass
 * This class and the corresponding buttons form the controller part of the system.
 * Actually this only delegates the calls. It was however implemented to mock a dedicated controller.
 */
public class MachineTerminal {

	private final Machine machine;

	public MachineTerminal(Machine machine) {
		this.machine = machine;
	}

	/**
	 * This method updates the target temperature of the machine (by using machine's setter).
	 * It checks if the input value is between the min. and the max. temperature of the machine,
	 * and throws a FactoryException otherwise.
	 */
	public void setTargetTemperature(int targetTemperature) {
		/**
		 * 1. TODO: Implement this function by checking, if the passed targetTemperature is in the range denoted \
		 *          by the machine's min- and max-temperature. If in range, set the machines target temperature, \
		 *          if not throw a new Factory Exception
		 */
		if (targetTemperature >= machine.getMinTemperature() && targetTemperature <= machine.getMaxTemperature()) {
			machine.setTargetTemperature(targetTemperature);
		} else {
			throw new FactoryException("invalid");
		}
	}

	/**
	 * This method updates the target voltage of the machine (by using machine's setter).
	 * It checks if the input value is between the min. and the max. voltage of the machine,
	 * and throws a FactoryException otherwise.
	 */
	public void setTargetVoltage(int targetVoltage) {
		/**
		 * 2. TODO: Implement this function by checking, if the passed targetVoltage is in the range denoted \
		 *          by the machine's min- and max-temperature. If in range, set the machines target voltage, \
		 *          if not throw a new Factory Exception
		 */
		if (targetVoltage >= machine.getMinVoltage() && targetVoltage <= machine.getMaxVoltage()) {
			machine.setTargetVoltage(targetVoltage);
		} else {
			throw new FactoryException("invalid");
		}
	}
}
