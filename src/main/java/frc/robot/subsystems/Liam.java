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

public class Liam extends SubsystemBase {
  /**
   * Creates a new Liam.
   */

  WPI_TalonSRX steed, cope;
  public Liam() {
    steed = new WPI_TalonSRX(1);
    cope = new WPI_TalonSRX(2); //;)
  }

  public void zoom(double speed){
    steed.set(ControlMode.PercentOutput, speed);
    cope.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}