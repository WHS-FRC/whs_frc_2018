/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
	public final Spark leftFront, leftBack, rightFront, rightBack;
	
	public Drivetrain() {
		leftFront = new Spark(RobotMap.DT_LEFT_FRONT);
		leftBack = new Spark(RobotMap.DT_LEFT_BACK);
		rightFront = new Spark(RobotMap.DT_RIGHT_FRONT);
		rightBack = new Spark(RobotMap.DT_RIGHT_BACK);
	}
	
	@Override
	public void periodic() {
	}

	@Override
	protected void initDefaultCommand() {
	}
}