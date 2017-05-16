/* 
 * FIRST Team 2344 - Saunders Droid Factory
 * FRC Season - SteamWorks
 * Developer - Jeffrey A. Mathew
 * Jr. Developer - Nico Altomare
 */

package org.usfirst.frc.team2344.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;

public class Robot extends IterativeRobot {
//Right side motors
	//Master
	CANTalon DriveRight = new CANTalon(4);
	//Slave
	
	CANTalon FrontRight = new CANTalon(5);
	CANTalon BackRight = new CANTalon(6);
	
	// Left side motors
	//Master
	CANTalon DriveLeft = new CANTalon(1);
	
	//Slave
	CANTalon FrontLeft = new CANTalon(2);
	CANTalon BackLeft = new CANTalon(3);
	
	
	RobotDrive Drive = new RobotDrive(DriveLeft,DriveRight); 
	//JoySticks
		Joystick Control = new Joystick(0);
	 Solenoid One = new Solenoid(0);	
	 Solenoid Two = new Solenoid(1);
	 Solenoid Three = new Solenoid(2);
	@Override
	public void robotInit(){
	//Slaves
		FrontRight.changeControlMode(CANTalon.TalonControlMode.Follower);
			FrontRight.set(DriveRight.getDeviceID());
			FrontRight.reverseOutput(true);
		BackRight.changeControlMode(CANTalon.TalonControlMode.Follower);
			BackRight.set(DriveRight.getDeviceID());
		FrontLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
			FrontLeft.set(DriveLeft.getDeviceID());
			FrontLeft.reverseOutput(true);
		BackLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
			BackLeft.set(DriveLeft.getDeviceID());
			
			
		
		
	}
	@Override
	public void teleopPeriodic() {
		double leftstick = Control.getRawAxis(1);
		double rightstick = Control.getRawAxis(3);
		
		
		Drive.tankDrive(leftstick, rightstick);
		
		//shift
        if (Control.getRawButton(6)){
        	Three.set(true);
        	
        }
        else {
         Three.set(false);
        }
        
        //piston 1
        if (Control.getRawButton(5)){
        	Two.set(true);
        	
        }
        else {
         Two.set(false);
        }
        
        //piston 2
        if (Control.getRawButton(7)){
        	One.set(true);
        	
        }
        else {
         One.set(false);
        }
        
        
        
        
        
        
        
	}
}

