package org.usfirst.frc.team6750.robot.commands;

import edu.wpi.first.wpilibj.command.*;

public class AutonomousCommand extends Command {
	public AutonomousCommand() {
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