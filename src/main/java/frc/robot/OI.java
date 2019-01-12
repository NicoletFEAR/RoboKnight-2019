/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;

/**
 * Add your docs here.
 */
public class OI {
    private XboxController control;
    private JoystickButton aButton;
    private JoystickButton bButton;
    private JoystickButton xButton;
    private JoystickButton yButton;

    public OI()
    {
        control = new XboxController(RobotMap.xboxControlPort);
        aButton = new JoystickButton(control, RobotMap.aButtonID);
        bButton = new JoystickButton(control, RobotMap.bButtonID);
        xButton = new JoystickButton(control, RobotMap.xButtonID);
        yButton = new JoystickButton(control, RobotMap.yButtonID);
    }

    public XboxController getController()
    {
        return control;
    }
}
