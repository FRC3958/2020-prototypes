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
import frc.robot.commands.ClimberCommand;
import frc.robot.commands.ClimberReel;
import frc.robot.commands.ClimberReelStop;
import frc.robot.commands.ClimberStop;
import frc.robot.commands.IndexCommand;
import frc.robot.commands.IndexStop;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.IntakeStop;
import frc.robot.commands.RevUp;
import frc.robot.commands.Shoot;
import frc.robot.commands.SideWheelShooterShoot;
import frc.robot.subsystems.ClimberMotors;
import frc.robot.subsystems.IndexMotor;
import frc.robot.commands.SideWheelShooter_stop;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.SideWheelShooterMotorControl;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
//
  private final XboxController m_controller = new XboxController(0);

  // The robot's subsystems and commands are defined here...
  private final Shooter m_shooter = new Shooter();

  // Intake shit
  
  public final static IntakeMotor m_intakeMotor = new IntakeMotor();

  private final IntakeCommand m_intakeCommand = new IntakeCommand(m_intakeMotor);

  private final IntakeStop m_intakeStop = new IntakeStop(m_intakeMotor);

  // Climber shit

  public final static ClimberMotors m_climberMotors = new ClimberMotors();

  private final ClimberCommand m_climberCommand = new ClimberCommand(m_climberMotors);

  private final ClimberStop m_climberStop = new ClimberStop(m_climberMotors); 

  private final ClimberReel m_climberReel = new ClimberReel(m_climberMotors);

  private final ClimberReelStop m_climberReelStop = new ClimberReelStop(m_climberMotors);
  
  // Index shit
  
  public final static IndexMotor m_indexMotor = new IndexMotor();

  private final IndexCommand m_indexCommand = new IndexCommand(m_indexMotor);

  private final IndexStop m_indexStop = new IndexStop(m_indexMotor);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */

   // beginning of code for the sidewheel shooter joystick, connected to buttons X and Y
   public final static SideWheelShooterMotorControl m_motor = new SideWheelShooterMotorControl();
   public final SideWheelShooterShoot m_Shoot = new SideWheelShooterShoot(m_motor);
   public final SideWheelShooter_stop m_stop = new SideWheelShooter_stop(m_motor);

// end of initializing wheel shooter joystick buttons
   
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

    //when right trigger is pressed then the SideWheel shooter starts 
    
    //end of sidewheel shooter control code 

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

      //intake controller shit
      new JoystickButton(m_controller, XboxController.Button.kBumperLeft.value)
      .whenPressed(m_intakeCommand)
      .whenReleased(m_intakeStop);
      
      //Climber controller shit      
      new JoystickButton(m_controller, XboxController.Button.kX.value)
      .whenPressed(m_climberCommand)
      .whenReleased(m_climberStop);

      new JoystickButton(m_controller, XboxController.Button.kY.value)
      .whenPressed(m_climberReel)
      .whenReleased(m_climberReelStop);


      new JoystickButton(m_controller, XboxController.Button.kBumperRight.value)
      .whenPressed(m_Shoot)
      .whenReleased(m_stop);
    
    //index controller shit
     new JoystickButton(m_controller, XboxController.Button.kBumperLeft.value)
     .whenPressed(m_indexCommand);
     new JoystickButton(m_controller, XboxController.Button.kBumperLeft.value) 
      .whenReleased(m_indexStop);  
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

