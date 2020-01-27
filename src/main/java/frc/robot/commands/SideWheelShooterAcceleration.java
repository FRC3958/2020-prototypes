/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SideWheelShooterMotorControl;

public class SideWheelShooterAcceleration extends CommandBase {
  /**
   * Creates a new SideWheelShooterStop.
   */
  private SideWheelShooterMotorControl m_MotorControl;
  private double m_acceleration, m_lastSpeed, m_targetSpeed;
  private Timer m_timer = new Timer();

  public SideWheelShooterAcceleration(double startSpeed, double speed, double acceleration, SideWheelShooterMotorControl MotorControl) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(MotorControl);

    m_MotorControl = MotorControl;
    m_lastSpeed = startSpeed;
    m_targetSpeed = speed;
    m_acceleration = acceleration;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("test", m_lastSpeed);

    double step = m_acceleration * m_timer.get();

    if(m_acceleration > 0.f)
      m_lastSpeed = Math.min(m_targetSpeed, m_lastSpeed + step);
    else 
      m_lastSpeed = Math.max(m_targetSpeed, m_lastSpeed + step);

    m_timer.reset();
    m_timer.start();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_acceleration > 0.f)
      return m_lastSpeed >= m_targetSpeed;
    else
      return m_lastSpeed <= m_targetSpeed;
  }
}
