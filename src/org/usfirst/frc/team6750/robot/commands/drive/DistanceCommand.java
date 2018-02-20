package org.usfirst.frc.team6750.robot.commands.drive;

import org.usfirst.frc.team6750.robot.Robot;
import org.usfirst.frc.team6750.robot.subsystems.Encoder.Counter;

import edu.wpi.first.wpilibj.command.Command;

public abstract class DistanceCommand extends Command {
	public static final double MAX_SPEED = 0.245D;
	
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
		return counter.getDistance() >= distance;
	}
}