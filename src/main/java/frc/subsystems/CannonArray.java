/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Subsystem representing all 3 cannons
 */
public class CannonArray extends Subsystem {
  public Servo lowPress;
  private Servo midPress;
  private Servo highPress;

  public CannonArray()
  {
    lowPress = new Servo(RobotMap.servoLowPort);
    midPress = new Servo(RobotMap.servoMidPort);
    highPress = new Servo(RobotMap.servoHighPort);

    allCannonsOff();
  }

  @Override
  public void initDefaultCommand() {
  }

  public void allCannonsOn()
  {
    lowPress.setAngle(RobotMap.onPos);
    midPress.setAngle(RobotMap.onPos);
    highPress.setAngle(RobotMap.onPos);
  }

  public void allCannonsOff()
  {
    lowPress.setAngle(RobotMap.offPos);
    midPress.setAngle(RobotMap.offPos);
    highPress.setAngle(RobotMap.offPos);
  }

  public void toggleAllCannons()
  {
    if (lowPress.getAngle() != RobotMap.offPos || midPress.getAngle() == RobotMap.offPos || highPress.getAngle() != RobotMap.offPos)
    {
      allCannonsOff();
    }
    else
    {
      allCannonsOn();
    }
  }

  public void toggleLowCannon()
  {
    if (lowPress.getAngle() != RobotMap.offPos)
    {
      lowPress.setAngle(RobotMap.offPos);
    }
    else
    {
      lowPress.setAngle(RobotMap.onPos);
    }
  }

  public void toggleMidCannon()
  {
    if (midPress.getAngle() != RobotMap.offPos)
    {
      midPress.setAngle(RobotMap.offPos);
    }
    else
    {
      midPress.setAngle(RobotMap.onPos);
    }
  }

  public void toggleHighCannon()
  {
    if (highPress.getAngle() != RobotMap.offPos)
    {
      highPress.setAngle(RobotMap.offPos);
    }
    else
    {
      highPress.setAngle(RobotMap.onPos);
    }
  }
}
