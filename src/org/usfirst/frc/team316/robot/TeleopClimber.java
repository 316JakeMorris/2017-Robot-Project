package org.usfirst.frc.team316.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Victor;

public class TeleopClimber {

	//Pre-made classes that are not instanctized. 
	private CANTalon CANClimber;
	private Victor VicCLimber;
	private static TeleopClimber instance;
	SetControls CompBotControls;
	
	private TeleopClimber()
	{
		CANClimber = new CANTalon(2);
		VicCLimber = new Victor(5);	//Temporary PWM slot!
		CompBotControls = CompBotControls.getInstance();
		//Direct the SetControls object of CompBotControls to the object already created by the robot class. Robot Init!
	}
	
	public TeleopClimber getClimberInstance()
	{
		if(instance == null)
		{
			instance = new TeleopClimber();
		}
		return instance;
	}

	public void run()
	{
		//If climb is true, run the climber
		if(CompBotControls.getDriverJoy().getLeftTrigger() > .8){
			CANClimber.set(1.0); //These values run the climber in the right direction
			VicCLimber.set(-1.0);
		} else if(CompBotControls.getDriverJoy().getLeftTrigger() > .8 && CompBotControls.getOperatorJoy().getStart() == true){
		//If climb and override is true, then run the climber in reverse	
			CANClimber.set(-1.0); //These values run the climber in the opposite direction
			VicCLimber.set(1.0);
		} else{	//if neither are true, then don't run the climber
			CANClimber.set(0);
			VicCLimber.set(0);
		}
		
		
	}

}
