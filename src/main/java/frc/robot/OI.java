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
import frc.commands.AllCannonsOff;
import frc.commands.AllCannonsOn;
import frc.commands.DisableCompressor;
import frc.commands.EnableCompressor;
import frc.commands.HighCannonOff;
import frc.commands.HighCannonOn;
import frc.commands.LowCannonOff;
import frc.commands.LowCannonOn;
import frc.commands.MidCannonOff;
import frc.commands.MidCannonOn;
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
    private JoystickButton lbButton;
    private JoystickButton rbButton;

    public OI()
    {
        control = new XboxController(RobotMap.xboxControlPort);
        aButton = new JoystickButton(control, RobotMap.aButtonID);
        bButton = new JoystickButton(control, RobotMap.bButtonID);
        xButton = new JoystickButton(control, RobotMap.xButtonID);
        yButton = new JoystickButton(control, RobotMap.yButtonID);
        lbButton = new JoystickButton(control, RobotMap.lbButtonID);
        rbButton = new JoystickButton(control, RobotMap.rbButtonID);
/* Want one press on, one press off control?
   Uncomment these lines of code, and comment cannon related buttons below
        xButton.whenPressed(new ToggleLowCannon());
        aButton.whenPressed(new ToggleMidCannon());
        bButton.whenPressed(new ToggleHighCannon());
        yButton.whenPressed(new ToggleAllCannons());
*/
        xButton.whenPressed(new LowCannonOn());
        aButton.whenPressed(new MidCannonOn());
        bButton.whenPressed(new HighCannonOn());
        yButton.whenPressed(new AllCannonsOn());

        xButton.whenReleased(new LowCannonOff());
        aButton.whenReleased(new MidCannonOff());
        bButton.whenReleased(new HighCannonOff());
        yButton.whenReleased(new AllCannonsOff());

        lbButton.whenPressed(new DisableCompressor());
        rbButton.whenPressed(new EnableCompressor());
    }

    public XboxController getController()
    {
        return control;
    }
}
