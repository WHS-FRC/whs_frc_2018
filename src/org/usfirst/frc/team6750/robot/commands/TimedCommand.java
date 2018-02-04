package org.usfirst.frc.team6750.robot.commands;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

public abstract class TimedCommand extends Command {
	public final Timer timer;
	public final double duration;

	public TimedCommand(double duration) {
		this.timer = new Timer();

		this.duration = duration;
	}

	@Override
	protected void initialize() {
		timer.start();
	}

	@Override
	protected boolean isFinished() {
		return timeUp();
	}

	public boolean timeUp() {
		return timer.get() > duration;
	}
}