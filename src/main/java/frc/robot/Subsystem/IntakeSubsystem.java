// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystem;



import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class IntakeSubsystem extends SubsystemBase
{

  /**
   * Intake Motor objects.
   */
  DigitalInput intake_limit = new DigitalInput(0);
  DigitalInput intake_limit_2 = new DigitalInput(1);

  private static TalonFX upperMotor;
  private static TalonFX lowerMotor;
  private static DoubleSolenoid intakeSolenoid;
  private PneumaticHub hub = new PneumaticHub(23);
  public boolean isUp = false;

  public IntakeSubsystem(TalonFX upperMotor, DoubleSolenoid intakeSolenoid)
  {
    this.upperMotor = upperMotor;
    this.intakeSolenoid = intakeSolenoid;
  }
  //Sets the intake motor speeds
  public void moveIntake(double upperSpeed, double lowerSpeed,boolean Intake_up){
    moveSolenoid(Intake_up);
    upperMotor.set(upperSpeed);
 
    
  }
  //Stops the Intake
  public void Gamepiece(){
   
  }
  public void stopIntake(){
    upperMotor.set(0);
   
  }
  public boolean intake_limit(){
    System.out.println(intake_limit.get());
    return (!intake_limit.get()||!intake_limit_2.get());
  }
  public void moveSolenoid(boolean open){
    if (open){
      intakeSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    else{
      intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }
   public void Toggle(){
    isUp = !(isUp);
    if (isUp){
      intakeSolenoid.set(DoubleSolenoid.Value.kForward);
      moveIntake(0, 0, isUp);
    }
    else{
      intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
      moveIntake(0, 0, isUp);
    }
  }
}