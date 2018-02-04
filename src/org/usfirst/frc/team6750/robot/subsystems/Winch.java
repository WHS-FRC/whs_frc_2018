package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

public class Winch extends Subsystem {
	public final Spark left, right;

	public Winch() {
		left = new Spark(RobotMap.W_LEFT);
		right = new Spark(RobotMap.W_RIGHT);
	}

	@Override
	public void periodic() {
	}

	@Override
	protected void initDefaultCommand() {
	}

	public void setSpeed(double speed) {
		left.setSpeed(speed);
		right.setSpeed(speed);
	}
}