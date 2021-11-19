
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.TouchSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import java.util.List;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class BlueBmiddle{
private ElapsedTime period  = new ElapsedTime();
DmapAuto ahwb = new DmapAuto();


//MAY NEED TO ADD DMAP PREFIX TO MOTOR CMDS "ahwb"
public void BlueBmid() throws InterruptedException {
ahwb.init(hardwareMap);
//telemetry.addData("Running class:" , "BlueBmid");
//telemetry.update();

        
        // Reset the encoder during initialization
        ahwb.leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        ahwb.rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        ahwb.duck.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        ahwb.Arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        ahwb.spinner.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        ahwb.claw.setPosition(0);
    Thread.sleep(2000);
    
    
// Set the motor's target position to 300 ticks
        ahwb.leftdrive.setTargetPosition(1050);
        ahwb.rightdrive.setTargetPosition(-1050);
    
        // Switch to RUN_TO_POSITION mode
        ahwb.leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        ahwb.rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        ahwb.leftdrive.setVelocity(500);
        ahwb.rightdrive.setVelocity(500);
        
            while(ahwb.leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 ////telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
        
             ahwb.leftdrive.setTargetPosition(550);
        ahwb.rightdrive.setTargetPosition(-1120);
        
        // Switch to RUN_TO_POSITION mode
        ahwb.leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        ahwb.rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        ahwb.leftdrive.setVelocity(500);
        ahwb.rightdrive.setVelocity(500);
        
        while(ahwb.leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
        
      //set arm pos
        ahwb.Arm.setTargetPosition(300);

        // Switch to RUN_TO_POSITION mode
        ahwb.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        ahwb.Arm.setVelocity(800);

        
        while(ahwb.Arm.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
}
//reset for drive
ahwb.leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
ahwb.rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//drive forward at a angle

ahwb.leftdrive.setTargetPosition(520);
ahwb.rightdrive.setTargetPosition(-475);
        
// Switch to RUN_TO_POSITION mode
ahwb.leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
ahwb.rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
// Start the motor moving by setting the max velocity to 200 ticks per second
ahwb.leftdrive.setVelocity(500);
ahwb.rightdrive.setVelocity(500);
        
        while(ahwb.leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
 
 
ahwb.spinner.setTargetPosition(1000);
ahwb.spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
ahwb.spinner.setVelocity(500);

while(ahwb.spinner.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
}
ahwb.claw.setPosition(0.14);
Thread.sleep(1000);
ahwb.spinner.setTargetPosition(0);
ahwb.spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
ahwb.spinner.setVelocity(500);

 
//reverse a little
ahwb.leftdrive.setTargetPosition(-500);
ahwb.rightdrive.setTargetPosition(500);
 
       
// Switch to RUN_TO_POSITION mode
ahwb.leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
ahwb.rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
// Start the motor moving by setting the max velocity to 200 ticks per second
ahwb.leftdrive.setVelocity(500);
ahwb.rightdrive.setVelocity(500);
        
        while(ahwb.leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
 //arm down
    ahwb.Arm.setTargetPosition(0);
    
    while(ahwb.Arm.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }

        // Switch to RUN_TO_POSITION mode
        ahwb.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        ahwb.Arm.setVelocity(800);
 
//reverse into wh
ahwb.leftdrive.setTargetPosition(-1200);
ahwb.rightdrive.setTargetPosition(1000);
 
       
// Switch to RUN_TO_POSITION mode
ahwb.leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
ahwb.rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
// Start the motor moving by setting the max velocity to 200 ticks per second
ahwb.leftdrive.setVelocity(500);
ahwb.rightdrive.setVelocity(500);
        
        while(ahwb.leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
//set target pos 2
ahwb.duck.setTargetPosition(2000);
 
ahwb.duck.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//set target 2 speed
 ahwb.duck.setVelocity(2000);

 while(ahwb.duck.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to finish spin");
 //telemetry.update();
}

ahwb.leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
ahwb.rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        // Set the motor's target position to 300 ticks
        ahwb.leftdrive.setTargetPosition(500);
        ahwb.rightdrive.setTargetPosition(500);
        
        // Switch to RUN_TO_POSITION mode
        ahwb.leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        ahwb.rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        ahwb.leftdrive.setVelocity(1500);
        ahwb.rightdrive.setVelocity(1500);
        
        while(ahwb.leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
}
        ahwb.leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
ahwb.rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
         ahwb.leftdrive.setTargetPosition(500);
        ahwb.rightdrive.setTargetPosition(-500);
        
        // Switch to RUN_TO_POSITION mode
        ahwb.leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        ahwb.rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        ahwb.leftdrive.setVelocity(500);
        ahwb.rightdrive.setVelocity(-500);
        
        while(ahwb.leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }

        // While the Op Mode is running, show the motor's status via //telemetry
        //while (opModeIsActive()) {
            ////telemetry.addData("Left drive velocity", ahwb.leftdrive.getVelocity());
            ////telemetry.addData("Right drive velocity", ahwb.rightdrive.getVelocity());
            //telemetry.addData("ahwb.Arm position", ahwb.Arm.getCurrentPosition());
            //telemetry.addData("Left drive position", ahwb.leftdrive.getCurrentPosition());
            //telemetry.addData("Right drive position", ahwb.rightdrive.getCurrentPosition());
            //telemetry.addData("is at target", !ahwb.leftdrive.isBusy());
            //telemetry.update();
        //}
    }
}