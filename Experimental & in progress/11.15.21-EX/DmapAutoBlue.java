package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
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

public class DmapAutoBlue {
    /* Public OpMode members. */
     public DcMotorEx leftdrive = null;
    public DcMotorEx rightdrive = null;
    public DcMotorEx spinner = null;
    public Servo claw = null;
    public DcMotorEx duck = null;
    public DcMotorEx Arm = null;
    public TouchSensor armBack; 
    public RevBlinkinLedDriver led;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public DmapAutoBlue(){

    }

    /* HARDWARE MAP*/
    public void init(HardwareMap ahwMap) {
        
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftdrive  = hwMap.get(DcMotorEx.class, "leftdrive");
        rightdrive = hwMap.get(DcMotorEx.class, "rightdrive");
        spinner = hwMap.get(DcMotorEx.class, "spinner");
        claw = hwMap.servo.get("claw");
        duck = hwMap.get(DcMotorEx.class, "duck");
        Arm = hwMap.get(DcMotorEx.class, "Arm");
        armBack = hwMap.get(TouchSensor.class, "armBack");
        led = hwMap.get(RevBlinkinLedDriver.class , "led");

        //set correct motor directions for driving
        leftdrive.setDirection(DcMotor.Direction.FORWARD);
        rightdrive.setDirection(DcMotor.Direction.REVERSE);
    }

    //reset all encoders
    public void resetEncoders() {
    leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    duck.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    Arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    spinner.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }

    //move to pos
    public void rtp(int lde , int rde , int ve){
    //reset encoders before every cmd
    leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

    //set pos
    leftdrive.setTargetPosition(lde);
    rightdrive.setTargetPosition(rde);

    //run to pos
    leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

    //set velocity
    leftdrive.setVelocity(ve);
    rightdrive.setVelocity(ve);
    }
 //REMOVE ALL OLD CMDS AFTER TESTING
 
 //AUTO BLUE B LOW
 
 //AUTO BLUE B MID
 public void BlueBmid() throws InterruptedException {

//telemetry.addData("Running class:" , "BlueBmid");
//telemetry.update();

        
        // Reset the encoders using custom cmd
        resetEncoders();
        claw.setPosition(0);
        Thread.sleep(2000);
    
    
// Set the motor's target position to 300 ticks
        /*leftdrive.setTargetPosition(1050);
        rightdrive.setTargetPosition(-1050);
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        leftdrive.setVelocity(500);
        rightdrive.setVelocity(500);
        rtp uses one cmd instead of multiple*/
        rtp(1050 , 1050 , 100);
        Thread.sleep(10000); //TEMP REMOVE AFTER TESTING
            while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 ////telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
        
             leftdrive.setTargetPosition(550);
        rightdrive.setTargetPosition(-1120);
        
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        leftdrive.setVelocity(500);
        rightdrive.setVelocity(500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
        
      //set arm pos
        Arm.setTargetPosition(300);

        // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);

        
        while(Arm.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
}
//reset for drive
leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//drive forward at a angle

leftdrive.setTargetPosition(520);
rightdrive.setTargetPosition(-475);
        
// Switch to RUN_TO_POSITION mode
leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
// Start the motor moving by setting the max velocity to 200 ticks per second
leftdrive.setVelocity(500);
rightdrive.setVelocity(500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
 
 
spinner.setTargetPosition(1000);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(500);

while(spinner.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
}
claw.setPosition(0.14);
Thread.sleep(1000);
spinner.setTargetPosition(0);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(500);

 
//reverse a little
leftdrive.setTargetPosition(-500);
rightdrive.setTargetPosition(500);
 
       
// Switch to RUN_TO_POSITION mode
leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
// Start the motor moving by setting the max velocity to 200 ticks per second
leftdrive.setVelocity(500);
rightdrive.setVelocity(500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
 //arm down
    Arm.setTargetPosition(0);
    
    while(Arm.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }

        // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
 
//reverse into wh
leftdrive.setTargetPosition(-1200);
rightdrive.setTargetPosition(1000);
 
       
// Switch to RUN_TO_POSITION mode
leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
// Start the motor moving by setting the max velocity to 200 ticks per second
leftdrive.setVelocity(500);
rightdrive.setVelocity(500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }
//set target pos 2
duck.setTargetPosition(2000);
 
duck.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//set target 2 speed
 duck.setVelocity(2000);

 while(duck.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to finish spin");
 //telemetry.update();
}

leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        // Set the motor's target position to 300 ticks
        leftdrive.setTargetPosition(500);
        rightdrive.setTargetPosition(500);
        
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        leftdrive.setVelocity(1500);
        rightdrive.setVelocity(1500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
}
        leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
         leftdrive.setTargetPosition(500);
        rightdrive.setTargetPosition(-500);
        
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        leftdrive.setVelocity(500);
        rightdrive.setVelocity(-500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 //telemetry.addData("Status", "Waiting for the motor to reach its target");
 //telemetry.update();
 }

        // While the Op Mode is running, show the motor's status via //telemetry
        //while (opModeIsActive()) {
            ////telemetry.addData("Left drive velocity", leftdrive.getVelocity());
            ////telemetry.addData("Right drive velocity", rightdrive.getVelocity());
            //telemetry.addData("Arm position", Arm.getCurrentPosition());
            //telemetry.addData("Left drive position", leftdrive.getCurrentPosition());
            //telemetry.addData("Right drive position", rightdrive.getCurrentPosition());
            //telemetry.addData("is at target", !leftdrive.isBusy());
            //telemetry.update();
        //}
 
 }
 
 
 
 //AUTO BLUE B HIGH
 
 //AUTO BLUE A LOW
 
 //AUTO BLUE A MID
 
 //AUTO BLUE A HIGH
}
