package org.usfirst.frc.team316.robot;

import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team316.robot.RobotConstants;

public class TeleopShooter {
	static Victor shooterVictor = new Victor(RobotConstants.SHOOTER_PWM);
	
	public static void run() {
/*		
		//The basis of the shooter. It drives the Shooter to different speeds depending on override, joystick, and control speed. 
		if(SetControls.shooterRev) {
			shooterVictor.set(SetControls.controlShooterSpeed);
		}else if(SetControls.getInstance().getOverride() && SetControls.getInstance().getShooterRevStatus()) {
			shooterVictor.set(SetControls.getInstance().getLeftStickY());
		}
		
*/		
	}
}
