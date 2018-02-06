package org.usfirst.frc.team6750.robot.subsystems;

import java.util.*;

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

	public final Drivetrain drivetrain;

	private final List<Counter> counters;

	public Encoder(Drivetrain drivetrain) {
		this.drivetrain = drivetrain;

		counters = new ArrayList<Counter>();
	}

	public Counter createCounter() {
		Counter counter = new Counter();

		counters.add(counter);

		return counter;
	}

	public void periodic() {
		int rotations = 0;

		//Add or subtract rotations

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