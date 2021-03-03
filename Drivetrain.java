package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;

public class Drivetrain {
  // 2 and 3 are a and b, 0 and 1 are c and d
  public final static SpeedController m_leftMotor = new Spark(3);
  public final static SpeedController m_rightMotor = new Spark(0);
  public final static SpeedController m_leftMotor1 = new Spark(2);
  public final static SpeedController m_rightMotor1 = new Spark(1);
  public final static SpeedController m_launcher0 = new Spark(4);
  public final static SpeedController m_launcher1 = new Spark(5);
  public final static XboxController m_driverController = new XboxController(0);


  public final static DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
  public final static DifferentialDrive m_robotDrive1 = new DifferentialDrive(m_leftMotor1, m_rightMotor1);

  public final static SpeedControllerGroup m_leftGroup = new SpeedControllerGroup(m_leftMotor, m_leftMotor1);
  public final static SpeedControllerGroup m_rightGroup = new SpeedControllerGroup(m_rightMotor, m_rightMotor1);
  public final static SpeedControllerGroup m_launcher = new SpeedControllerGroup(m_launcher0, m_launcher1);





}
