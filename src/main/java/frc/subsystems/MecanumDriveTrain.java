/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.commands.MecDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Subsystem for a mechanum drivetrain
 */
public class MecanumDriveTrain extends Subsystem {
  private WPI_TalonSRX frontLeft;
  private WPI_TalonSRX frontRight;
  private WPI_TalonSRX backLeft;
  private WPI_TalonSRX backRight;
  private MecanumDrive mecDriver;

  /* Uncomment all this navX code for Field Oriented Drive
     Don't forget to supply angle as 4th parameter to mecdrive constructor */
  //private AHRS navX;

  public MecanumDriveTrain()
  {
    frontLeft = new WPI_TalonSRX(RobotMap.frontLeftPort);
    frontRight = new WPI_TalonSRX(RobotMap.frontRightPort);
    backLeft = new WPI_TalonSRX(RobotMap.backLeftPort);
    backRight = new WPI_TalonSRX(RobotMap.backRightPort);

    //navX = new AHRS(I2C.Port.kMXP);
    mecDriver = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
    mecDriver.setSafetyEnabled(false);

    //resetNavX();
  }

  //NOTE: Remember to divide speed values by 2 to slow down robot in gym
  public void mechDrive()
  {
    mecDriver.driveCartesian(Robot.oi.getController().getY(Hand.kLeft),
                             -Robot.oi.getController().getX(Hand.kLeft),
                             Robot.oi.getController().getX(Hand.kRight));
  }

  /* See note above
  public void resetNavX()
  {
    navX.reset();
  }

  public double getNavXAngle()
  {
    return navX.getAngle();
  }
  */

  public void stopMotors()
  {
    mecDriver.stopMotor();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MecDrive());
  }
}
