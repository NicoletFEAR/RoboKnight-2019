/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.commands.TankDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Subsystem for a tank drivetrain
 */
public class TankDriveTrain extends Subsystem {
  private WPI_TalonSRX frontLeft;
  private WPI_TalonSRX frontRight;
  private WPI_TalonSRX backLeft;
  private WPI_TalonSRX backRight;

  private DifferentialDrive tankDriver;

  private SpeedControllerGroup leftMotors;
  private SpeedControllerGroup rightMotors;

  public TankDriveTrain()
  {
    frontLeft = new WPI_TalonSRX(RobotMap.frontLeftPort);
    frontRight = new WPI_TalonSRX(RobotMap.frontRightPort);
    backLeft = new WPI_TalonSRX(RobotMap.backLeftPort);
    backRight = new WPI_TalonSRX(RobotMap.backRightPort);

    
    frontLeft.configOpenloopRamp(0);
    frontRight.configOpenloopRamp(0);
    backLeft.configOpenloopRamp(0);
    backRight.configOpenloopRamp(0);
    

    leftMotors = new SpeedControllerGroup(frontLeft, backLeft);
    rightMotors = new SpeedControllerGroup(frontRight, backRight);

    tankDriver = new DifferentialDrive(leftMotors, rightMotors);

    tankDriver.setSafetyEnabled(false);
  }

  //NOTE: Remember to divide speed values by 2 to slow down robot in gym
  //OTHER NOTE: For some reason changing Talon ports didn't work...negative fixes it though...
  public void mechDrive()
  {
    tankDriver.tankDrive((-Robot.oi.getController().getY(Hand.kLeft) * 0.7), 
                         (-Robot.oi.getController().getY(Hand.kRight)) * 0.7);
  }

  public void stopMotors()
  {
    tankDriver.stopMotor();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDrive());
  }
}