/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  WPI_TalonSRX eat = new WPI_TalonSRX(1);

  public Intake() {
    
    eat.setNeutralMode(NeutralMode.Brake);
    
    eat.setInverted(InvertType.None);
  }  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void feed(double speed) {
    eat.set(ControlMode.PercentOutput, speed);
  }

}
