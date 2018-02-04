package org.usfirst.frc.team6750.robot;

import org.usfirst.frc.team6750.robot.commands.*;

public class Commands {
	public final DefaultCommand defaultCommand;
	public final AutonomousCommand autoCommand;

	public Commands() {
		defaultCommand = new DefaultCommand();
		autoCommand = new AutonomousCommand();
	}
}