package org.usfirst.frc.team316.robot;

/**
 * This class maps inputs from the joystick input to states for mechanisms to read in common sense names. 
 * This class differs from the Joystick Globals class because the Joystick Globals class does not
 * use common sense names. That class does not utilize any pre-cooking or special interpretation,
 * while this class does pre-cook values. 
 * @author Jake
 *
 */
public class SetControls {
	
	private static SetControls instance;
	private LunaXBox DriverJoy;
	private LunaXBox OperatorJoy;
	
	/**
	 * Private Constructor for Singleton
	 */
	private SetControls()
	{
		DriverJoy = new LunaXBox(0);
		OperatorJoy = new LunaXBox(1);
	}
	
	
	/**
	 * ===OPERATOR===
	 */
	//override
	private boolean override;
	
	//Shooter Variables
	private boolean shooterRev;
	private boolean shooterRPMControl;
	private double controlShooterSpeed;
	private boolean shoot;
	
	
	
	//Intake Variables
	public enum IntakeStates {BALL, GEAR, BOTHIN};
	public IntakeStates IntakeStates;
	private boolean intakeReverse;
	private boolean reverseGearMotor;
	
	/**
	 * ===DRIVER===
	 */
	//climber variables
	private boolean climb;
	
	
	/**
	 * The public method for Set Controls which either makes a new control frame or returns the old one.
	 * @return the control frame object
	 */
	public static SetControls getInstance()
	{
		if(instance == null)
		{
			instance = new SetControls();
		}
		return instance;
	}
	
	/**
	 * The main run method of the SetControls Class. This is called at the start of Teleop 
	 * to set Inputs to variables to be read by other classes. 
	 * @author Jake
	 */
	public void run() {
		setOverride(OperatorJoy.getStart());	//Setter for Override (Private)
		
/*
* ==========Shooter Global Code=================		
*/		
		//Sets the shooter global variables
		if(OperatorJoy.getLeftTrigger() > .8)   //If Operator Left Trigger > .8, then run the shooter
		{
			this.shooterRev = true;
			this.shooterRPMControl = false;
		} 
		else if(OperatorJoy.getLeftTrigger() < .8 && (this.getOverride() == true))
		{
			this.shooterRev = false;
			this.shooterRPMControl = true;
		}
		else
		{
			this.shooterRev = false;
			this.shooterRPMControl = false;
		}
		
		if(OperatorJoy.getRightTrigger() > .8)
		{
			this.shoot = true;
		}
		else
		{
			this.shoot = false;
		}
		
/*
 * ==========Intake Global Code=================		
 */
		if(OperatorJoy.getLeftBumper() == true)
		{
			this.setIntakeStates(IntakeStates.BALL);
		}
		if(OperatorJoy.getRightBumper() == true)
		{
			this.setIntakeStates(IntakeStates.GEAR);
		}
		if(OperatorJoy.getBack() == true)
		{
			this.setIntakeStates(IntakeStates.BOTHIN);
		}
/*
 * ==========Climber Global Code================
 */
		//Sets the climber global variable
		if(DriverJoy.getLeftTrigger() > .8)
		{
			setClimb(true);
		} else {
			setClimb(false);
		}
		
		intakeReverse = OperatorJoy.getXButton();	//Reverses the intake when jammed with balls
		reverseGearMotor = OperatorJoy.getLeftStickButton(); //Reverses the gear intake when placing on the peg
		
	}
	
	
	/**
	 * @return the override
	 */
	public boolean getOverride() {
		return override;
	}

	/**
	 * @param override the override to set
	 */
	private void setOverride(boolean override) {
		this.override = override;
	}
	
	public LunaXBox getDriverJoy()
	{
		return DriverJoy;
	}
	
	public LunaXBox getOperatorJoy()
	{
		return OperatorJoy;
	}
	
	public void setControlSpeed(double newControlSpeed) {
		controlShooterSpeed = newControlSpeed;
	}
	
	public double getControlSpeed() {
		return this.controlShooterSpeed;
	}
	
	
	public boolean getShooterRevStatus() {
		return this.shooterRev;
	}

	/**
	 * @return Climber Status
	 */
	public boolean getClimbStatus() {
		return climb;
	}

	/**
	 * @param Set the climber
	 */
	private void setClimb(boolean climb) {
		this.climb = climb;
	}

	/**
	 * @return the intakeStates
	 */
	public IntakeStates getIntakeStates() {
		return this.IntakeStates;
	}
	
	/**
	 * @param set the Intake State
	 */
	public void setIntakeStates(IntakeStates intakeStates) {
		this.IntakeStates = intakeStates;
	}

	


	
}
