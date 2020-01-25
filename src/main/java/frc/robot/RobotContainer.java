/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Gunk;
import frc.robot.commands.Intook;
import frc.robot.commands.RevUp;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Liam;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {


  public final static Intake m_eat = new Intake();
  private final static Intook m_consume = new Intook(m_eat);
  public final static Liam m_go = new Liam();
  private final static Gunk m_zom = new Gunk(m_go);
//
  private final XboxController m_controller = new XboxController(0);

  // The robot's subsystems and commands are defined here...
  private final Shooter m_shooter = new Shooter();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    SmartDashboard.putNumber("speed coeff", 1.f);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    double maxspeed = SmartDashboard.getNumber("speed coeff", .5f);
      
    // make command
    new JoystickButton(m_controller, XboxController.Button.kA.value)
      .whenPressed(new RunCommand(() -> m_shooter.fire(m_controller.getTriggerAxis(Hand.kRight) * maxspeed), m_shooter))
      .whenReleased(new RunCommand(() -> m_shooter.fire(0.f), m_shooter));

    // new JoystickButton(m_controller, XboxController.Button.kB.value)
    //   .whenPressed(new Shoot(.2f, m_shooter));

    new JoystickButton(m_controller, XboxController.Button.kB.value)
      .whenPressed(new Shoot(maxspeed, m_shooter))
      .whenReleased(new RevUp(maxspeed, 0.f, -.05f, m_shooter));

    new JoystickButton(m_controller, XboxController.Button.kBumperRight.value)
      .whenPressed(m_zom);


    new JoystickButton(m_controller, XboxController.Button.kX.value)
      .whenPressed(m_consume);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}

