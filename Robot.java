/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot {
  
private Timer m_timer = new Timer();


   // This function is run when the robot is first started up and should be
   // used for any initialization code.
   //
  @Override
  public void robotInit() {

  }


  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  }
  

  /**
   * this is run 1 time when autonomous starts
   *
   */
  @Override
  public void autonomousInit() {
m_timer.reset();
m_timer.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
if(m_timer.get() < 9){
  Drivetrain.m_leftGroup.set(config.autonSpeed + 0.025);
  Drivetrain.m_rightGroup.set(-config.autonSpeed);
}
if(m_timer.get() < 11 && m_timer.get() > 9){
  Drivetrain.m_launcher.set(config.LauncherSpeed);
  } else {
    Drivetrain.m_launcher.set(0);
  }

  if(m_timer.get() < 15 && m_timer.get() > 11){
    Drivetrain.m_leftGroup.set(-config.autonSpeed  -0.025);
    Drivetrain.m_rightGroup.set(config.autonSpeed);
  }
}
@Override
public void teleopInit() {

}
  /**
   * This function is called periodically during operator control.
   */

  Joystick joystick = new Joystick(0);
  @Override
  public void teleopPeriodic() {
    //motors a and c
    Drivetrain.m_robotDrive.tankDrive(Drivetrain.m_driverController.getY(Hand.kLeft) * -config.MaxSpeed - 0.025,
    Drivetrain.m_driverController.getY(Hand.kRight)* -config.MaxSpeed);
    //motors b and d
    Drivetrain.m_robotDrive1.tankDrive(Drivetrain.m_driverController.getY(Hand.kLeft) * -config.MaxSpeed - 0.025,
    Drivetrain.m_driverController.getY(Hand.kRight)* -config.MaxSpeed);
        if(joystick.getRawButton(4)){
            Drivetrain.m_launcher.set(config.LauncherSpeed);
        }
        if(joystick.getRawButton(2)){ 
          Drivetrain.m_launcher.set(-config.ReverseLauncherSpeed);
         }
         if(joystick.getRawButton(2) == false & joystick.getRawButton(4) == false){
          Drivetrain.m_launcher.set(0);
         }
         if(joystick.getRawAxis(3) > 0.3){
          config.MaxSpeed = (float) 1;
         }
         if(joystick.getRawAxis(2) > 0.3){
          config.MaxSpeed = (float) .5;
         }
         if(joystick.getRawAxis(2) < .3 & joystick.getRawAxis(3) < .3){
          config.MaxSpeed = (float) .75;
         }
    }
    
  

      
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
