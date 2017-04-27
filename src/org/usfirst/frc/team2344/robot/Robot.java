package org.usfirst.frc.team2344.robot;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
/*
 *  FIRST® Team 2344
 * 		   2017 OffSeason - Malone
 */

public class Robot extends IterativeRobot {
	/* 
	 *  Motors
	 *  	On Malone, we have eight (8) motors, of which six (6) controls the drive
	 * 		station and the other two (2) control the lifting procedure. They will be
	 *      controlled via TalonSRX in a CAN Bus.
	 */
	   //Right Motors
		CANTalon DriveRight = new CANTalon(1);
			//Slave Motors
			CANTalon RightFront = new CANTalon(2);
			CANTalon RightRear = new CANTalon(3);
			
		//Left Motors	
		CANTalon DriveLeft = new CANTalon(4);
			//Slave Motors
			CANTalon LeftFront = new CANTalon(5);
			CANTalon LeftRear = new CANTalon(6);
		
		// Lifting Motors
		CANTalon LiftLeft = new CANTalon(7);
		CANTalon LiftRight = new CANTalon(8);
		
		//Robot Drive
		RobotDrive Malone;
		
		public void robotInit() {
			//Right Motors
			// - Set DriveRight as Master
			// - Set RightFront & RightRear as the Slaves
			DriveRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
				RightFront.changeControlMode(CANTalon.TalonControlMode.Follower);
					RightFront.set(DriveRight.getDeviceID());
				RightRear.changeControlMode(CANTalon.TalonControlMode.Follower);
					RightRear.set(DriveRight.getDeviceID());
			
			//Left Motors
			// - Set DriveLeft as the Master
			// - Set LeftFront & LeftRear as the Slaves
			DriveLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
				LeftFront.changeControlMode(CANTalon.TalonControlMode.Follower);
					LeftFront.set(DriveLeft.getDeviceID());
				LeftRear.changeControlMode(CANTalon.TalonControlMode.Follower);
					LeftRear.set(DriveLeft.getDeviceID());
			//Lift Motors
			LiftLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
			LiftRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
			
			//RobotDrive
			Malone = new RobotDrive(DriveRight,DriveLeft);
			
		}
}