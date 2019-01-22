/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Constants used around the project.
 */
public class RobotMap {
    // Motors
    public static final int frontLeftPort = 13;
    public static final int frontRightPort = 14;
    public static final int backLeftPort = 15;
    public static final int backRightPort = 16;

    // Compressor
    public static final int compressorPort = 0;

    // Servos
    public static final int servoLowPort = 0;
    public static final int servoMidPort = 1;
    public static final int servoHighPort = 2;

    // Servo Positions (Degrees)
    public static final int offPos = 160;
    public static final int onPos = 90;

    // Lights
    public static final int lowLightChan = 0;
    public static final int midLightChan = 1;
    public static final int highLightChan = 2;

    // Light States
    public static final int lightOff = 0;
    public static final int lightOn = 12;

    // Controller
    public static final int xboxControlPort = 0;
    public static final int aButtonID = 1;
    public static final int bButtonID = 2;
    public static final int xButtonID = 3;
    public static final int yButtonID = 4;
}
