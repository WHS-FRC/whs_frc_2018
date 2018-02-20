package org.usfirst.frc.team6750.robot.auto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousConfiguration {
	public Position robotPos;
	public Position scale1,
			scale2,
			scale3;
	
	public int rotMult;

	public AutonomousConfiguration() {
		determinePosition();
		determineScalePositions();
	}

	private void determinePosition() {
		switch(SmartDashboard.getString("Robot Position", "CENTER")) {
		case ("LEFT"):
			robotPos = Position.LEFT;
			break;
		case ("CENTER"):
			robotPos = Position.CENTER;
			break;
		case ("RIGHT"):
			robotPos = Position.RIGHT;
			break;
		default:
			robotPos = Position.CENTER;
		}
		
		rotMult = robotPos == Position.LEFT ? 1 : -1;
	}

	private void determineScalePositions() {
		String plates = DriverStation.getInstance().getGameSpecificMessage();

		scale1 = interpretScalePosition(plates.charAt(0));
		scale2 = interpretScalePosition(plates.charAt(1));
		scale3 = interpretScalePosition(plates.charAt(2));
	}

	private Position interpretScalePosition(char c) {
		return c == 'L' ? Position.LEFT : c == 'R' ? Position.RIGHT : Position.CENTER;
	}

	public enum Position {
		LEFT,
		CENTER,
		RIGHT;
	}
}