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


public class IndexMotor extends SubsystemBase {
  /**
   * Creates a new IndexMotor.
   */

   static WPI_TalonSRX indexMotor;

  public IndexMotor() {
    indexMotor = new WPI_TalonSRX(6);
  }

  public void intake(double speed) {
    indexMotor.set(ControlMode.PercentOutput, speed);
  }
  public double getSpeed(){
    return indexMotor.get();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}