package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.LED;
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

public class BlueBmiddle {
private ElapsedTime period  = new ElapsedTime();
DmapAuto ahw = new DmapAuto();

//MAY NEED TO ADD DMAP PREFIX TO MOTOR CMDS "ahw"
public void BlueBmid() throws InterruptedException {
//telemetry.addData("Running class:" , "BlueBmid");
//telemetry.update();
        // Reset the encoder during initialization
        ahw.leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        ahw.rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        ahw.duck.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        ahw.Arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        ahw.spinner.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        ahw.claw.setPosition(0);
    Thread.sleep(2000);
    
    
// Set the motor's target position to 300 ticks
        ahw.leftdrive.setTargetPosition(1050);
        ahw.rightdrive.setTargetPosition(-1050);
    
        // Switch to RUN_TO_POSITION mode
        ahw.leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        ahw.rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        ahw.leftdrive.setVelocity(500);
        ahw.rightdrive.setVelocity(500);
        
            while(ahw.leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 ////telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
        
             ahw.leftdrive.setTargetPosition(550);
        ahw.rightdrive.setTargetPosition(-1120);
        
        // Switch to RUN_TO_POSITION mode
        ahw.leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        ahw.rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        ahw.leftdrive.setVelocity(500);
        ahw.rightdrive.setVelocity(500);
        
        while(ahw.leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
        
      //set arm pos
        ahw.Arm.setTargetPosition(300);

        // Switch to RUN_TO_POSITION mode
        ahw.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        ahw.Arm.setVelocity(800);

        
        while(ahw.Arm.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
}
//reset for drive
ahw.leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
ahw.rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//drive forward at a angle

ahw.leftdrive.setTargetPosition(520);
ahw.rightdrive.setTargetPosition(-475);
        
// Switch to RUN_TO_POSITION mode
ahw.leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
ahw.rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
// Start the motor moving by setting the max velocity to 200 ticks per second
ahw.leftdrive.setVelocity(500);
ahw.rightdrive.setVelocity(500);
        
        while(ahw.leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
 
 
ahw.spinner.setTargetPosition(1000);
ahw.spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
ahw.spinner.setVelocity(500);

while(ahw.spinner.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
}
ahw.claw.setPosition(0.14);
Thread.sleep(1000);
ahw.spinner.setTargetPosition(0);
ahw.spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
ahw.spinner.setVelocity(500);

 
//reverse a little
ahw.leftdrive.setTargetPosition(-500);
ahw.rightdrive.setTargetPosition(500);
 
       
// Switch to RUN_TO_POSITION mode
ahw.leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
ahw.rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
// Start the motor moving by setting the max velocity to 200 ticks per second
ahw.leftdrive.setVelocity(500);
ahw.rightdrive.setVelocity(500);
        
        while(ahw.leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
 //arm down
    ahw.Arm.setTargetPosition(0);
    
    while(ahw.Arm.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }

        // Switch to RUN_TO_POSITION mode
        ahw.Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        ahw.Arm.setVelocity(800);
 
//reverse into wh
ahw.leftdrive.setTargetPosition(-1200);
ahw.rightdrive.setTargetPosition(1000);
 
       
// Switch to RUN_TO_POSITION mode
ahw.leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
ahw.rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
// Start the motor moving by setting the max velocity to 200 ticks per second
ahw.leftdrive.setVelocity(500);
ahw.rightdrive.setVelocity(500);
        
        while(ahw.leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
//set target pos 2
ahw.duck.setTargetPosition(2000);
 
ahw.duck.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//set target 2 speed
 ahw.duck.setVelocity(2000);

 while(ahw.duck.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to finish spin");
 //telemetry.update();
}

ahw.leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
ahw.rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        // Set the motor's target position to 300 ticks
        ahw.leftdrive.setTargetPosition(500);
        ahw.rightdrive.setTargetPosition(500);
        
        // Switch to RUN_TO_POSITION mode
        ahw.leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        ahw.rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        ahw.leftdrive.setVelocity(1500);
        ahw.rightdrive.setVelocity(1500);
        
        while(ahw.leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
}
        ahw.leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
ahw.rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
         ahw.leftdrive.setTargetPosition(500);
        ahw.rightdrive.setTargetPosition(-500);
        
        // Switch to RUN_TO_POSITION mode
        ahw.leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        ahw.rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        ahw.leftdrive.setVelocity(500);
        ahw.rightdrive.setVelocity(-500);
        
        while(ahw.leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }

        // While the Op Mode is running, show the motor's status via //telemetry
        //while (opModeIsActive()) {
            ////telemetry.addData("Left drive velocity", ahw.leftdrive.getVelocity());
            ////telemetry.addData("Right drive velocity", ahw.rightdrive.getVelocity());
            //telemetry.addData("ahw.Arm position", ahw.Arm.getCurrentPosition());
            //telemetry.addData("Left drive position", ahw.leftdrive.getCurrentPosition());
            //telemetry.addData("Right drive position", ahw.rightdrive.getCurrentPosition());
            //telemetry.addData("is at target", !ahw.leftdrive.isBusy());
            //telemetry.update();
        //}
    }
}