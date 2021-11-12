/*THIS CODE IS TESTED AS OF 11.1.21
Coded by 2021-2022 RoboDawgs Programing team */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class Auto_Block_Arm extends LinearOpMode {
private DcMotorEx leftdrive = null;
private DcMotorEx rightdrive = null;
private DcMotorEx duck = null;
private DcMotorEx Arm = null;
private DcMotorEx spinner = null;
private Servo claw = null;
    @Override
    public void runOpMode() {
        
        DcMotorEx leftdrive  = hardwareMap.get(DcMotorEx.class, "leftdrive");
        DcMotorEx rightdrive = hardwareMap.get(DcMotorEx.class, "rightdrive");
        DcMotorEx duck = hardwareMap.get(DcMotorEx.class, "duck");
        DcMotorEx Arm = hardwareMap.get(DcMotorEx.class, "Arm");
        DcMotorEx spinner = hardwareMap.get(DcMotorEx.class, "spinner");
        claw = hardwareMap.servo.get("claw");
    //leftdrive.setDirection(DcMotor.Direction.REVERSE);
    //rightdrive.setDirection(DcMotor.Direction.REVERSE);
    
    //close claw for pre load box
    //claw.setPosition(0);
    
        // Reset the encoder during initialization
        leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        duck.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        Arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        spinner.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        waitForStart();
        claw.setPosition(0);
    sleep(2000);
    
    
// Set the motor's target position to 300 ticks
        leftdrive.setTargetPosition(1020);
        rightdrive.setTargetPosition(-1020);
    
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        leftdrive.setVelocity(500);
        rightdrive.setVelocity(500);
        
            while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();}
        
             leftdrive.setTargetPosition(600);
        rightdrive.setTargetPosition(-1020);
        
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        leftdrive.setVelocity(500);
        rightdrive.setVelocity(500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();}
        
      //set arm pos
        Arm.setTargetPosition(320);

        // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);

        
        while(Arm.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();
}

//drive forward at a angle

leftdrive.setTargetPosition(620);
rightdrive.setTargetPosition(-620);
        
// Switch to RUN_TO_POSITION mode
leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
// Start the motor moving by setting the max velocity to 200 ticks per second
leftdrive.setVelocity(500);
rightdrive.setVelocity(500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();}
spinner.setTargetPosition(1200);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(500);

while(spinner.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();
}
claw.setPosition(0.14);
sleep(1000);
spinner.setTargetPosition(0);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(500);

//set target pos 2
/* duck.setTargetPosition(2000);
 
duck.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//set target 2 speed
 duck.setVelocity(2000);

 while(duck.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to finish spin");
 telemetry.update();
}

leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        // Set the motor's target position to 300 ticks
        leftdrive.setTargetPosition(4000);
        rightdrive.setTargetPosition(-4000);
        
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        leftdrive.setVelocity(1500);
        rightdrive.setVelocity(1500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();
}

/*
leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
duck.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//set target pos 3
leftdrive.setTargetPosition(5000);
rightdrive.setTargetPosition(-5000);

leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

//set target 3 speed
 leftdrive.setVelocity(2000);
rightdrive.setVelocity(2000);
        */
        // While the Op Mode is running, show the motor's status via telemetry
        while (opModeIsActive()) {
            //telemetry.addData("Left drive velocity", leftdrive.getVelocity());
            //telemetry.addData("Right drive velocity", rightdrive.getVelocity());
            telemetry.addData("Arm position", Arm.getCurrentPosition());
            telemetry.addData("Left drive position", leftdrive.getCurrentPosition());
            telemetry.addData("Right drive position", rightdrive.getCurrentPosition());
            telemetry.addData("is at target", !leftdrive.isBusy());
            telemetry.update();
        }
    }
}
