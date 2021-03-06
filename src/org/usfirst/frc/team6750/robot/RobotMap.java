/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6750.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//DT = drivetrain
	public static final int DT_LEFT_FRONT = 1;
	public static final int DT_LEFT_BACK = 0;
	public static final int DT_RIGHT_FRONT = 4;
	public static final int DT_RIGHT_BACK = 5;

	//BI = box intake
	public static final int BI_LEFT = 8;
	public static final int BI_RIGHT = 7;

	public static final int ARM_LEFT = 6;
	public static final int ARM_RIGHT = 9;

	//W = winch
	public static final int W_LEFT = 2;
	public static final int W_RIGHT = 3;
}
