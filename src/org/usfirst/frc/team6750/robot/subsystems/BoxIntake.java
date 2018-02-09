package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BoxIntake extends Subsystem {
	public final Spark left,
			right;

	public BoxIntake() {
		left = new Spark(RobotMap.BI_LEFT);
		right = new Spark(RobotMap.BI_RIGHT);
	}

	@Override
	public void periodic() {
	}

	@Override
	protected void initDefaultCommand() {
	}

	public void setSpeed(double speed) {
		left.setSpeed(speed);
		right.setSpeed(-speed);
	}
}