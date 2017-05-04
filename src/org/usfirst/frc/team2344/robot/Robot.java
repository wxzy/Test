/* 
 * FIRST Team 2344 - Saunders Droid Factory
 * FRC Season - SteamWorks
 * Developer - Jeffrey A. Mathew
 */

package org.usfirst.frc.team2344.robot;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
public class Robot extends IterativeRobot {
	
	/*
	 * Drive 
	 *  - There are in total six (6) motors, in which two (2) will be defined the 
	 *  Master, and the rest as slaves.
	 *  
	 *  - There is also one solenoid to control the "shifting" or changing from
	 *  low gear mode to high gear mode. 
	 *  
	 */
		//Right Side Motors 
			// Master
				CANTalon DriveRight = new CANTalon(4);
			// Slave
				CANTalon RightFront = new CANTalon(5);
				CANTalon RightRear  = new CANTalon(6);
				
		//Left Side Motors
			// Master
				CANTalon DriveLeft  = new CANTalon(1);
			// Slave
				CANTalon LeftFront  = new CANTalon(2);
				CANTalon LeftRear   = new CANTalon(3);
	 
			   RobotDrive Test = new RobotDrive(DriveLeft, DriveRight);
		// JoySticks
			Joystick Joy = new Joystick(0);
			
			
		@Override
		public void robotInit(){
			RightFront.changeControlMode(CANTalon.TalonControlMode.Follower);
				RightFront.set(DriveRight.getDeviceID());
			RightRear.changeControlMode(CANTalon.TalonControlMode.Follower);
				RightRear.set(DriveRight.getDeviceID());
			LeftFront.changeControlMode(CANTalon.TalonControlMode.Follower);
				LeftFront.set(DriveLeft.getDeviceID());
			LeftRear.changeControlMode(CANTalon.TalonControlMode.Follower);
				LeftRear.set(DriveLeft.getDeviceID());
			}
		
		@Override
		public void teleopPeriodic() {
			double left = Joy.getRawAxis(1); // logitech gampad left X, positive is forward
	    	double right = Joy.getRawAxis(3); //logitech gampad right X, positive means turn right
	    	Test.tankDrive(left, right);
		}
}