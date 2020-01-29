/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;  
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SideWheelShooterMotorControl extends SubsystemBase {
  /**
   * Creates a new SideWheelShooterMotorControl. 
   */
  WPI_TalonSRX leftMotor,rightMotor;
   
  public SideWheelShooterMotorControl() {
    leftMotor = new WPI_TalonSRX(5);
    rightMotor = new WPI_TalonSRX(3);

    leftMotor.setNeutralMode(NeutralMode.Brake);
    rightMotor.setNeutralMode(NeutralMode.Brake);

    leftMotor.setInverted(InvertType.None);
    rightMotor.setInverted(InvertType.None);

   // leftMotor.configFactoryDefault();
   // rightMotor.configFactoryDefault();

  //  leftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kPIDLoopIdx , Constants.kTimeoutMs);
  //  rightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kPIDLoopIdx , Constants.kTimeoutMs);

  //  leftMotor.configNeutralDeadband(0.001, Constants.kTimeoutMs);
  //  rightMotor.configNeutralDeadband(0.001, Constants.kTimeoutMs);

  //  leftMotor.configMotionCruiseVelocity(15000, Constants.kTimeoutMs);
  //  leftMotor.configMotionAcceleration(6000, Constants.kTimeoutMs);
  //  rightMotor.configMotionCruiseVelocity(15000, Constants.kTimeoutMs);
  //  rightMotor.configMotionAcceleration(6000, Constants.kTimeoutMs);

  //  leftMotor.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
  //  rightMotor.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);

  }
  public void move(double speed){
    if (speed ==0){
      leftMotor.set(ControlMode.PercentOutput, speed);
      rightMotor.set(ControlMode.PercentOutput, speed);
    }
    else{
      leftMotor.set(ControlMode.PercentOutput, (speed-0.5));
      rightMotor.set(ControlMode.PercentOutput, speed);
    }

  }

  public void encodemove(double speed){
    // 4096 ticks/rev * 10 Rotations in either direction
    //double targetspeed = 4096*10.0;
    if (speed ==0){
      leftMotor.set(ControlMode.MotionMagic, speed);
      rightMotor.set(ControlMode.MotionMagic, speed);
    }
    else{
      leftMotor.set(ControlMode.MotionMagic, (speed-0.5));
      rightMotor.set(ControlMode.MotionMagic, speed);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
