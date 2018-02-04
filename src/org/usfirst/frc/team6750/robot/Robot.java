/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6750.robot;

import org.usfirst.frc.team6750.robot.commands.*;
import org.usfirst.frc.team6750.robot.subsystems.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static Drivetrain drivetrain;
	public static BoxIntake boxIntake;
	public static Arm arm;
	public static Winch winch;

	public static OI oi;
	public static Commands commands;

	/**
	 * Presents a menu to the driver station that contains various commandChooser
	 */
	public static CommandChooser commandChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		drivetrain = new Drivetrain();
		boxIntake = new BoxIntake();
		arm = new Arm();
		winch = new Winch();

		oi = new OI();
		commands = new Commands();
		commandChooser = new CommandChooser();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		periodic();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commandChooser to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commandChooser.
	 */
	@Override
	public void autonomousInit() {
		commands.autoCommand.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		periodic();
	}

	@Override
	public void teleopInit() {
		commands.autoCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		periodic();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		periodic();
	}

	private void periodic() {
		Scheduler.getInstance().run();

		drivetrain.periodic();
		boxIntake.periodic();
		arm.periodic();
		winch.periodic();
	}
}
