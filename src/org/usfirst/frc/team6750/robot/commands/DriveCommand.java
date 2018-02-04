package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.*;

public class DriveCommand extends TimedCommand {
	public final double speed;

	/**
	 * Creates a new drive command with a given speed and a given duration
	 * 
	 * @param speed the speed
	 * @param duration the duration
	 */
	public DriveCommand(double speed, double duration) {
		super(duration);
		
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
		Robot.drivetrain.drive(0D);
	}

	@Override
	protected void interrupted() {
		end();
	}
}