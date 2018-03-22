/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.Robot;
import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
	public final Spark leftFront,
			leftBack,
			rightFront,
			rightBack;

	public final SpeedControllerGroup left,
			right;

	public final DifferentialDrive drive;

	public final Encoder encoder;

	public Drivetrain() {
		super();

		leftFront = new Spark(RobotMap.DT_LEFT_FRONT);
		leftBack = new Spark(RobotMap.DT_LEFT_BACK);
		rightFront = new Spark(RobotMap.DT_RIGHT_FRONT);
		rightBack = new Spark(RobotMap.DT_RIGHT_BACK);

		left = new SpeedControllerGroup(leftFront, leftBack);
		right = new SpeedControllerGroup(rightFront, rightBack);

		drive = new DifferentialDrive(left, right);

		encoder = new Encoder(this);
	}

	@Override
	public void periodic() {
		encoder.periodic();

		arcadeDrive();

		SmartDashboard.putNumber("Speed", this.leftBack.getSpeed());
	}

	private void arcadeDrive() {
		Joystick js = Robot.oi.ltJS;

		double rotAxis = js.getRawAxis(0),
				moveAxis = -js.getRawAxis(1); // Axis is inverted

		rotAxis *= 0.65D;
		moveAxis *= 0.65D;

		drive.arcadeDrive(moveAxis, rotAxis);
	}

	@Override
	protected void initDefaultCommand() {
	}

	/**
	 * Drives both the right-side and the left-side motors with a given speed
	 * 
	 * @param speed
	 * the speed
	 */
	public void drive(double speed) {
		driveLeft(speed);
		driveRight(-speed);
	}

	/**
	 * Drives the left-side motors with a given speed
	 * 
	 * @param speed
	 * the speed
	 */
	public void driveLeft(double speed) {
		leftFront.setSpeed(speed);
		leftBack.setSpeed(speed);
	}

	/**
	 * Drives the right-side motors with a given speed
	 * 
	 * @param speed
	 * the speed
	 */
	public void driveRight(double speed) {
		rightFront.setSpeed(speed);
		rightBack.setSpeed(speed);
	}
}