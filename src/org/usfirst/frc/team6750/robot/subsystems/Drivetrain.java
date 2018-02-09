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

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
	public static final double BRAKE_MULT = 0.75D;

	public final Spark leftFront, leftBack, rightFront, rightBack;

	public final SpeedControllerGroup left, right;

	public final DifferentialDrive drive;

	public final Encoder encoder;

	public Drivetrain() {
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
		// encoder.periodic();

		Joystick js = Robot.oi.ltJS;

		double rotAxis = js.getRawAxis(4), moveAxis = -js.getRawAxis(5); // Axis is inverted

		rotAxis *= 0.75D;
		moveAxis *= 0.75D;

		if (Math.abs(rotAxis) > 0.1D || Math.abs(moveAxis) > 0.1D) {
			drive.arcadeDrive(moveAxis, rotAxis);
		} else {
			periodicBrake();
		}

	}

	@Override
	protected void initDefaultCommand() {
	}

	/**
	 * Drives both the right-side and the left-side motors with a given speed
	 * 
	 * @param speed
	 *            the speed
	 */
	public void drive(double speed) {
		driveLeft(speed);
		driveRight(speed);
	}

	/**
	 * Drives the left-side motors with a given speed
	 * 
	 * @param speed
	 *            the speed
	 */
	public void driveLeft(double speed) {
		leftFront.setSpeed(speed);
		leftBack.setSpeed(speed);
	}

	/**
	 * Drives the right-side motors with a given speed
	 * 
	 * @param speed
	 *            the speed
	 */
	public void driveRight(double speed) {
		rightFront.setSpeed(speed);
		rightBack.setSpeed(speed);
	}

	/**
	 * Called during periodic to slow the motors to a stop instead of abruptly
	 * setting to 0 Done by multiplying motor speeds by the BRAKE_MULT constant,
	 * which is < 1.0D
	 */
	public void periodicBrake() {
		brake(leftFront);
		brake(leftBack);
		brake(rightFront);
		brake(rightBack);
	}

	/**
	 * Used to slow down a given motor until it reaches 0 Rate at which is slows
	 * down the motor can be adjusted by changing the BRAKE_MULT constant
	 * 
	 * @param motor
	 *            the motor
	 */
	private void brake(Spark motor) {
		double speed = motor.getSpeed();

		if (speed == 0D) {
			return;
		} else if (speed < 0.1D) {
			speed = 0D;
		} else {
			speed -= Robot.delta * (speed * BRAKE_MULT);
		}

		motor.setSpeed(speed);
	}
}