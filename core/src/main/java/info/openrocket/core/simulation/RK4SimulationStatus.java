package info.openrocket.core.simulation;

import info.openrocket.core.models.atmosphere.AtmosphericConditions;
import info.openrocket.core.rocketcomponent.FlightConfiguration;
import info.openrocket.core.util.Coordinate;

public class RK4SimulationStatus extends SimulationStatus implements Cloneable {
	private Coordinate launchRodDirection;
	
	private double previousAcceleration = 0;

	// Used for determining when to store aerodynamic computation warnings:
	private double maxZVelocity = 0;
	private double startWarningTime = -1;
	
	public RK4SimulationStatus(FlightConfiguration configuration,
			SimulationConditions simulationConditions ) {
		super(configuration, simulationConditions);
	}

	public RK4SimulationStatus(SimulationStatus other) {
		super(other);
		if (other instanceof RK4SimulationStatus) {
			this.launchRodDirection = ((RK4SimulationStatus) other).launchRodDirection;
			this.previousAcceleration = ((RK4SimulationStatus) other).previousAcceleration;
			this.maxZVelocity = ((RK4SimulationStatus) other).maxZVelocity;
			this.startWarningTime = ((RK4SimulationStatus) other).startWarningTime;
		}
	}

	public void setLaunchRodDirection(Coordinate launchRodDirection) {
		this.launchRodDirection = launchRodDirection;
	}

	public Coordinate getLaunchRodDirection() {
		return launchRodDirection;
	}

	public double getPreviousAcceleration() {
		return previousAcceleration;
	}

	public void setPreviousAcceleration(double previousAcceleration) {
		this.previousAcceleration = previousAcceleration;
	}

	public double getMaxZVelocity() {
		return maxZVelocity;
	}

	public void setMaxZVelocity(double maxZVelocity) {
		this.maxZVelocity = maxZVelocity;
	}

	public double getStartWarningTime() {
		return startWarningTime;
	}

	public void setStartWarningTime(double startWarningTime) {
		this.startWarningTime = startWarningTime;
	}

	@Override
	public RK4SimulationStatus clone() {
		return (RK4SimulationStatus) super.clone();
	}

}
