package org.usfirst.frc.team6750.robot.commands.drive;

import org.usfirst.frc.team6750.robot.Robot;

public class DistanceDriveCommand extends DistanceCommand {
	public final double speed;

	/**
	 * Creates a new drive command with a given speed and a given distance
	 * 
	 * @param speed the speed
	 * @param distance the distance in inches
	 */
	public DistanceDriveCommand(double speed, double distance) {
		super(distance);

		this.requires(Robot.drivetrain);

		this.speed = speed;
	}

	@Override
	protected void initialize() {
		super.initialize();

		Robot.drivetrain.drive(speed);
	}

	@Override
	protected void execute() {
		Robot.drivetrain.drive(speed);
	}

	@Override
	protected void end() {
		super.end();

		Robot.drivetrain.drive(0D);
	}
}