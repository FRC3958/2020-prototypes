/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberMotors extends SubsystemBase {
  /**
   * Creates a new ClimberMotors.
   */

    static WPI_TalonSRX climberMotor1, climberMotor2, climberMotor3;
  public ClimberMotors() {
    climberMotor1 = new WPI_TalonSRX(0);
    climberMotor2 = new WPI_TalonSRX(1);
    climberMotor3 = new WPI_TalonSRX(2);
    climberMotor3.setInverted(true);
  }

  public void climber1(double speed) {
    climberMotor1.set(ControlMode.PercentOutput, speed);
  }

  public void climber2and3(double speed) {
    climberMotor2.set(ControlMode.PercentOutput, speed);
    climberMotor3.set(ControlMode.PercentOutput, speed);
  }

  public double getSpeed1() {
    return climberMotor1.get();
  }

  public double getSpeed2() {
    return climberMotor2.get();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
