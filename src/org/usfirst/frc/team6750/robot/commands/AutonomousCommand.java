package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.commands.drive.DegreeRotateCommand;
import org.usfirst.frc.team6750.robot.commands.drive.DistanceDriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommand extends CommandGroup {
	public AutonomousCommand() {
		//260" is approx. the distance needed to get in range of the tall scale
		this.addSequential(new DistanceDriveCommand(0.25D, 24));
		this.addSequential(new DegreeRotateCommand(0.25D, 5));
		
		/**
		this.addSequential(new DistanceDriveCommand(0.25D, 24));
		this.addSequential(new DegreeRotateCommand(0.25D, -18));
		this.addSequential(new DistanceDriveCommand(0.25D, 24));
		this.addSequential(new DegreeRotateCommand(0.25D, -9));
		this.addSequential(new DistanceDriveCommand(0.25D, 24));
		this.addSequential(new DegreeRotateCommand(0.25D, 18));
		**/
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