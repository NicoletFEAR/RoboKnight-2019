/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Subsystem representing all 3 cannons and their status lights
 */
public class CannonArray extends Subsystem {
  public Servo lowPress;
  private Servo midPress;
  private Servo highPress;
  private AnalogOutput lowLight;
  private AnalogOutput midLight;
  private AnalogOutput highLight;

  public CannonArray()
  {
/*  lowPress = new Servo(RobotMap.servoLowPort);
    midPress = new Servo(RobotMap.servoMidPort);
    highPress = new Servo(RobotMap.servoHighPort);
    lowLight = new AnalogOutput(RobotMap.lowLightChan);
    midLight = new AnalogOutput(RobotMap.midLightChan);
    highLight = new AnalogOutput(RobotMap.highLightChan); */

    //allCannonsOff();
  }

  @Override
  public void initDefaultCommand() {
  }

  public void allCannonsOn()
  {
    lowLight.setVoltage(RobotMap.lightOff);
    midLight.setVoltage(RobotMap.lightOff);
    highLight.setVoltage(RobotMap.lightOff);

    lowPress.setAngle(RobotMap.onPos);
    midPress.setAngle(RobotMap.onPos);
    highPress.setAngle(RobotMap.onPos);
  }

  public void allCannonsOff()
  {
    lowLight.setVoltage(RobotMap.lightOn);
    midLight.setVoltage(RobotMap.lightOn);
    highLight.setVoltage(RobotMap.lightOn);

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
      lowLight.setVoltage(RobotMap.lightOff);
      lowPress.setAngle(RobotMap.offPos);
    }
    else
    {
      lowLight.setVoltage(RobotMap.lightOn);
      lowPress.setAngle(RobotMap.onPos);
    }
  }

  public void toggleMidCannon()
  {
    if (midPress.getAngle() != RobotMap.offPos)
    {
      midLight.setVoltage(RobotMap.lightOff);
      midPress.setAngle(RobotMap.offPos);
    }
    else
    {
      midLight.setVoltage(RobotMap.lightOn);
      midPress.setAngle(RobotMap.onPos);
    }
  }

  public void toggleHighCannon()
  {
    if (highPress.getAngle() != RobotMap.offPos)
    {
      highLight.setVoltage(RobotMap.lightOff);
      highPress.setAngle(RobotMap.offPos);
    }
    else
    {
      highLight.setVoltage(RobotMap.lightOn);
      highPress.setAngle(RobotMap.onPos);
    }
  }
}
