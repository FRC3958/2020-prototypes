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


public class IntakeMotor extends SubsystemBase {
  /**
   * Creates a new IntakeMotor.
   */

   static WPI_TalonSRX intakeMotor;

  public IntakeMotor() {
    intakeMotor = new WPI_TalonSRX(5);
  }

  public void intake(double speed) {
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }
  public double getSpeed(){
    return intakeMotor.get();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
