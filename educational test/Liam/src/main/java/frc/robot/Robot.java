/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

   private Spark leftmotor1 = new Spark(0);
   private Spark leftmotor2 = new Spark(1);
   private Spark rightmotor1 = new Spark(2);
   private Spark rightmotor2 = new Spark(3);



  @Override
  public void robotInit() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    double speed = -joy1.getRawAxis(1) = 0.6;
    double turn = joy1.getRawAxis(4) = 0.3;

   double left = speed + turn;
   double right = speed - turn;
    
  leftmotor1.set(left);
  leftmotor2.set(left);
  rightmotor1.set(-right);
  rightmotor2.set(-right);

  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
