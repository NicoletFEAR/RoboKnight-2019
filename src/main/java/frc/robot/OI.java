/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.commands.ToggleAllCannons;
import frc.commands.ToggleHighCannon;
import frc.commands.ToggleLowCannon;
import frc.commands.ToggleMidCannon;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The operator interface, maps controller buttons to commands
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

/*      xButton.whenPressed(new ToggleLowCannon());
        aButton.whenPressed(new ToggleMidCannon());
        bButton.whenPressed(new ToggleHighCannon());
        yButton.whenPressed(new ToggleAllCannons());
 */
    }

    public XboxController getController()
    {
        return control;
    }
}
