package org.usfirst.frc.team6750.robot.commands.drive;

import org.usfirst.frc.team6750.robot.Robot;
import org.usfirst.frc.team6750.robot.subsystems.Encoder;

public class DegreeRotateCommand extends DistanceCommand {
	public static final double INCHES_PER_DEGREE = (414.69D / (5D * 360D));
	
	public final double speed;

	/**
	 * Creates a new drive command with a given speed and a given distance
	 * 
	 * @param speed the speed
	 * @param distance the distance in inches
	 */
	public DegreeRotateCommand(double speed, double degrees) {
		super(Math.abs(degrees * INCHES_PER_DEGREE));

		this.requires(Robot.drivetrain);

		this.speed = (speed > MAX_SPEED ? MAX_SPEED : speed) * (degrees < 0 ? -1D : 1D);
	}

	@Override
	protected void initialize() {
		super.initialize();
		
		Robot.drivetrain.driveLeft(speed);
		Robot.drivetrain.driveRight(speed);
	}

	@Override
	protected void execute() {
		Robot.drivetrain.driveLeft(speed);
		Robot.drivetrain.driveRight(speed);
	}

	@Override
	protected void end() {
		super.end();

		Robot.drivetrain.drive(0D);
	}
}