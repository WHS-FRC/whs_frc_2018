package org.usfirst.frc.team6750.robot.commands.drive;

import org.usfirst.frc.team6750.robot.*;
import org.usfirst.frc.team6750.robot.commands.*;

public class TimedRotateCommand extends TimedCommand {
	public final double speed;

	/**
	 * Creates a new rotate command with a given speed and a given duration
	 * 
	 * +speed = turn right
	 * -speed = turn left
	 * 
	 * @param speed the speed
	 * @param duration the duration in seconds
	 */
	public TimedRotateCommand(double speed, double duration) {
		super(duration);

		this.requires(Robot.drivetrain);

		this.speed = speed;
	}

	@Override
	protected void initialize() {
		super.initialize();

		Robot.drivetrain.driveLeft(speed);
		Robot.drivetrain.driveRight(-speed);
	}

	@Override
	protected void execute() {
		Robot.drivetrain.driveLeft(speed);
		Robot.drivetrain.driveRight(-speed);
	}

	@Override
	protected void end() {
		Robot.drivetrain.drive(0D);
	}
}