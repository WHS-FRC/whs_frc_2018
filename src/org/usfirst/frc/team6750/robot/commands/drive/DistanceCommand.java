package org.usfirst.frc.team6750.robot.commands.drive;

import org.usfirst.frc.team6750.robot.*;
import org.usfirst.frc.team6750.robot.subsystems.Encoder.*;

import edu.wpi.first.wpilibj.command.*;

public abstract class DistanceCommand extends Command {
	/**
	 * Measured in inches
	 */
	public final double distance;
	
	public Counter counter;

	public DistanceCommand(double distance) {
		this.distance = distance;
		
		this.requires(Robot.drivetrain);
	}

	@Override
	protected void initialize() {
		counter = Robot.drivetrain.encoder.createCounter();
	}
	
	@Override
	protected void end() {
		counter.setToRemove();
	}

	@Override
	protected boolean isFinished() {
		return timeUp();
	}

	public boolean timeUp() {
		return distance > 0 ? (counter.getDistance() > distance) : counter.getDistance() < distance;
	}
}