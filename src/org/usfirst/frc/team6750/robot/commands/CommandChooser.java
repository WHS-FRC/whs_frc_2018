package org.usfirst.frc.team6750.robot.commands;

import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class CommandChooser extends SendableChooser<Command> {
	public void init() {
		this.addDefault("Default", new DefaultCommand());

		SmartDashboard.putData("Commands", this);
	}
}