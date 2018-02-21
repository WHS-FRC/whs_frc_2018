package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.commands.drive.DegreeRotateCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommand extends CommandGroup {
	public AutonomousCommand() {
		//AutonomousConfiguration autoCfg = new AutonomousConfiguration();

		this.addSequential(new DegreeRotateCommand(0.25D, 360));

		/**
		 * if(autoCfg.robotPos == autoCfg.scale1) {
		 * 
		 * } else {
		 * if(autoCfg.robotPos == autoCfg.scale2) {
		 * this.addSequential(new DistanceDriveCommand(0.25D, 266));
		 * this.addSequential(new DegreeRotateCommand(0.25D, 45 * autoCfg.rotMult));
		 * //shoot
		 * 
		 * if(autoCfg.robotPos == autoCfg.scale3) {
		 * this.addSequential(new DegreeRotateCommand(0.25D, -45 * autoCfg.rotMult));
		 * this.addSequential(new DistanceDriveCommand(0.25D, 38.24D));
		 * this.addSequential(new DegreeRotateCommand(0.25D, 90 * autoCfg.rotMult));
		 * this.addSequential(new DistanceDriveCommand(0.25D, 65.56D));
		 * this.addSequential(new DegreeRotateCommand(0.25D, -90 * autoCfg.rotMult));
		 * this.addSequential(new DistanceDriveCommand(0.25D, 78.47D));
		 * //intake
		 * this.addSequential(new DegreeRotateCommand(0.25D, 30 * autoCfg.rotMult));
		 * //shoot
		 * }
		 * }
		 * }
		 * 
		 **/

		//260" is approx. the distance needed to get in range of the tall scale
		//this.addSequential(new DistanceDriveCommand(0.25D, 24));
		//this.addSequential(new DegreeRotateCommand(0.25D, 5));

		/**
		 * this.addSequential(new DistanceDriveCommand(0.25D, 24));
		 * this.addSequential(new DegreeRotateCommand(0.25D, -18));
		 * this.addSequential(new DistanceDriveCommand(0.25D, 24));
		 * this.addSequential(new DegreeRotateCommand(0.25D, -9));
		 * this.addSequential(new DistanceDriveCommand(0.25D, 24));
		 * this.addSequential(new DegreeRotateCommand(0.25D, 18));
		 **/
	}

	@Override
	protected void initialize() {
		System.out.println("Running autonomous command");
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}