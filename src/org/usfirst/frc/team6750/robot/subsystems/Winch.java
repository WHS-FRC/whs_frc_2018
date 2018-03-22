package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.Robot;
import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem {
	public final Spark left,
			right;

	public double speed = 0D;

	public Winch() {
		super();

		left = new Spark(RobotMap.W_LEFT);
		right = new Spark(RobotMap.W_RIGHT);
	}

	@Override
	public void periodic() {
		Joystick js = Robot.oi.ltJS;

		if(js.getRawButtonReleased(7)) {
			if(speed != -1D) {
				speed = -1D;
			} else {
				speed = 0D;
			}
		} else if(js.getRawButtonReleased(8)) {
			if(speed != 1D) {
				speed = 1D;
			} else {
				speed = 0D;
			}
		}
		
		setSpeed(speed);
	}

	@Override
	protected void initDefaultCommand() {
	}

	public void setSpeed(double speed) {
		left.setSpeed(speed);
		right.setSpeed(speed);
	}
}