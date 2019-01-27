/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Subsystem representing the compressor
 */
public class CompressAir extends Subsystem {
  private Compressor theCompressor;

  public CompressAir()
  {
    theCompressor = new Compressor(RobotMap.compressorPort);
  }

  public void startCompressor()
  {
    if (theCompressor.enabled() == false)
    {
      theCompressor.start();
    }
  }

  public void stopCompressor()
  {
    if (theCompressor.enabled() == true)
    {
      theCompressor.stop();
    }
  }

  public boolean isLowPressure()
  {
    return theCompressor.getPressureSwitchValue();
  }

  @Override
  public void initDefaultCommand() {
  }
}
