package org.usfirst.frc.team316.robot;


import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is an subclass of the WPI Joystick Class. 
 * It provides easier to understand methods for each button
 * @author Jake
 */


public class LunaXBox extends Joystick {

	boolean previousButton = false;
	boolean currentButton = true;
	boolean toggle = false;
	
	public LunaXBox(int port) {
		super(port);
		// TODO Auto-generated constructor stub
	}

	public LunaXBox(int port, int numAxisTypes, int numButtonTypes) {
		super(port, numAxisTypes, numButtonTypes);
		// TODO Auto-generated constructor stub
	}
	
	//Buttons of an XBox controller
	public boolean getAButton() {
		return this.getRawButton(1);
	}
	
	public boolean getBButton() {
		return this.getRawButton(2);
	}
	
	public boolean getXButton() {
		return this.getRawButton(3);
	}
	
	public boolean getYButton() {
		return this.getRawButton(4);
	}
	
	public boolean getLeftBumper() {
		return this.getRawButton(5);
	}
	
	public boolean getRightBumper() {
		return this.getRawButton(6);
	}
	
	public boolean getLeftStickButton() {
		return this.getRawButton(7);
	}
	
	public boolean getRightStickButton() {
		return this.getRawButton(8);
	}
	
	public boolean getStart() {
		return this.getRawButton(9);
	}
	
	public boolean getBack() {
		return this.getRawButton(10);
	}
	
	
	//Axis of an XBox controller
	public double getLeftStickX() {
		return this.getRawAxis(0);
	}
	
	public double getLeftStickY() {
		return this.getRawAxis(1);
	}
	
	public double getRightStickX() {
		return this.getRawAxis(2);
	}
	
	public double getRightStickY() {
		return this.getRawAxis(3);
	}

	public double getLeftTrigger() {
		return this.getRawAxis(4);
	}
	
	public double getRightTrigger() {
		return this.getRawAxis(5);
	}
	
	//Special Controls
	public boolean toggle(boolean Button) {
		previousButton = currentButton;
		currentButton = Button;
		if (currentButton && !previousButton) {
			toggle = !toggle;
		}
		return toggle;
	}
	
	public double deadbandGetLeftX(double threshold) {
		if (Math.abs(this.getLeftStickX()) > threshold) {
			return this.getLeftStickX();
		} else {
			return 0;
		}
	}
	
	public double deadbandGetLeftY(double threshold) {
		if (Math.abs(this.getLeftStickY()) > threshold) {
			return this.getLeftStickY();
		} else {
			return 0;
		}
	}
	
	public double deadbandGetRightX(double threshold) {
		if (Math.abs(this.getRightStickX()) > threshold) {
			return this.getRightStickX();
		} else {
			return 0;
		}
	}
	
	public double deadbandGetRightY(double threshold) {
		if (Math.abs(this.getRightStickY()) > threshold) {
			return this.getRightStickY();
		} else {
			return 0;
		}
	}
	
}
