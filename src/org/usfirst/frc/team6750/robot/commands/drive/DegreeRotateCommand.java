package org.usfirst.frc.team6750.robot.commands.drive;

import org.usfirst.frc.team6750.robot.Robot;

public class DegreeRotateCommand extends DistanceCommand {
	public static final double ROBOT_CIRCLE_CIRCUMFERENCE = 24D * Math.PI;
	
	public final double leftSpeed;

	/**
	 * Creates a new drive command with a given speed and a given distance
	 * 
	 * @param speed the speed
	 * @param distance the distance in inches
	 */
	public DegreeRotateCommand(double speed, double degrees) {
		super(degreesToInches(degrees));

		this.requires(Robot.drivetrain);

		this.leftSpeed = (speed > MAX_SPEED ? MAX_SPEED : speed) * (degrees < 0 ? -1D : 1D);
	}
	
	private static double degreesToInches(double degrees) {
		return Math.abs((degrees / 360D) * ROBOT_CIRCLE_CIRCUMFERENCE);
	}

	@Override
	protected void initialize() {
		super.initialize();
		
		Robot.drivetrain.driveLeft(leftSpeed);
		Robot.drivetrain.driveRight(leftSpeed);
	}

	@Override
	protected void execute() {
		Robot.drivetrain.driveLeft(leftSpeed);
		Robot.drivetrain.driveRight(leftSpeed);
	}

	@Override
	protected void end() {
		super.end();

		Robot.drivetrain.drive(0D);
	}
}