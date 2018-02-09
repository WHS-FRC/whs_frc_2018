package org.usfirst.frc.team6750.robot.subsystems;

import java.util.*;

import org.usfirst.frc.team6750.robot.Robot;

import edu.wpi.first.wpilibj.*;

/**
 * Used to count the rotations on the drivetrain motors, or most likely just one drivetrain motor
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
	public static final int SPOKE_COUNT = 4;
	
	/**
	 * The minimum voltage supplied by the sensor that counts as "triggering"
	 */
	public static final int MIN_VOLTAGE = 100, MAX_VOLTAGE = 500;
	
	/**
	 * The minimum time the sensor needs to be triggering to count as a count
	 */
	public static final double MIN_TRIGGER_DURATION = 0.25D;

	public final Drivetrain drivetrain;
	
	public final AnalogInput ai;

	private final List<Counter> counters;
	
	private boolean triggering = false, triggered = false;
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
		int rotations = 0;
		
		readSensor();

		manageCounters(rotations);
	}
	
	private int readSensor() {
		int rotations = 0;
		
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
					
					rotations = 1;
				}
			}
		} else {
			triggering = false;
			triggerDuration = 0;
			triggered = false;
		}
		
		return rotations;
	}
	
	private void manageCounters(int rotations) {
		for(int i = 0; i < counters.size(); i++) {
			Counter c = counters.get(i);

			if(c.remove) {
				counters.remove(i);
			} else {
				c.rotate(rotations);
			}
		}
	}

	public class Counter {
		private int rotations;

		private boolean remove = false;

		public Counter() {
			this.rotations = 0;
		}

		public void rotate(int rotations) {
			this.rotations += rotations;
		}

		public void setRotations(int rotations) {
			this.rotations = rotations;
		}

		public int getRotations() {
			return rotations;
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
			return rotations * WHEEL_CIRCUMFERENCE;
		}
	}
}