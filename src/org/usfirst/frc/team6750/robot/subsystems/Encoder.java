package org.usfirst.frc.team6750.robot.subsystems;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team6750.robot.Robot;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Used to count the spokes on the drivetrain motors, or most likely just one drivetrain motor
 * 
 * Currently an empty class that will have more concrete code once the encoders are in place
 * 
 * Each rotation is equal to one full rotation of the wheel, but this is subject to change
 * 
 * @author phank
 *
 */
public class Encoder {
	/**
	 * The wheel circumference in inches
	 */
	public static final double WHEEL_CIRCUMFERENCE = 6D * Math.PI;

	/**
	 * The amount of spokes the wheel has
	 */
	public static final int SPOKE_COUNT = 6;

	/**
	 * The minimum voltage supplied by the sensor that counts as "triggering"
	 */
	public static final int MIN_VOLTAGE = 70,
			MAX_VOLTAGE = 90;

	/**
	 * The minimum time the sensor needs to be triggering to count as a count
	 */
	public static final double MIN_TRIGGER_DURATION = 0.25D;

	public final Drivetrain drivetrain;

	public final AnalogInput ai;

	private final List<Counter> counters;

	private boolean triggering = false,
			triggered = false;
	private double triggerDuration = 0D;

	public Encoder(Drivetrain drivetrain) {
		this.drivetrain = drivetrain;

		this.ai = new AnalogInput(0);

		counters = new ArrayList<Counter>();
	}

	public Counter createCounter() {
		Counter counter = new Counter();

		counters.add(counter);

		return counter;
	}

	public void periodic() {
		int spokes = 0;

		readSensor();

		manageCounters(spokes);
	}

	private int readSensor() {
		int spokes = 0;

		int voltage = ai.getAverageValue();

		System.out.println("AVG: " + voltage);

		if(voltage > MIN_VOLTAGE && voltage < MAX_VOLTAGE) {
			boolean prevState = triggering;
			triggering = true;

			if(prevState) {
				triggerDuration += Robot.delta;
			}

			if(triggerDuration > MIN_TRIGGER_DURATION) {
				if(!triggered) {
					triggered = true;

					spokes = 1;
				}
			}
		} else {
			triggering = false;
			triggerDuration = 0;
			triggered = false;
		}

		return spokes;
	}

	private void manageCounters(int spokes) {
		for(int i = 0; i < counters.size(); i++) {
			Counter c = counters.get(i);

			if(c.remove) {
				counters.remove(i);
			} else {
				c.rotate(spokes);
			}
		}
	}

	public class Counter {
		private int spokes;

		private boolean remove = false;

		public Counter() {
			this.spokes = 0;
		}

		public void rotate(int spokes) {
			this.spokes += spokes;
		}

		public void setspokes(int spokes) {
			this.spokes = spokes;
		}

		public int getspokes() {
			return spokes;
		}

		public void setToRemove() {
			remove = true;
		}

		/**
		 * Returns the distance recorded by the counter in inches
		 * 
		 * @return distance in inches
		 */
		public double getDistance() {
			return (spokes / SPOKE_COUNT) * WHEEL_CIRCUMFERENCE;
		}
	}
}