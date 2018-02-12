package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.commands.drive.DistanceDriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommand extends CommandGroup {
	public AutonomousCommand() {
		//260" is approx. the distance needed to get in range of the tall scale
		this.addParallel(new DistanceDriveCommand(0.225D, 260));
	}

	@Override
	protected void initialize() {
		System.out.println("Running autonomous command");
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}