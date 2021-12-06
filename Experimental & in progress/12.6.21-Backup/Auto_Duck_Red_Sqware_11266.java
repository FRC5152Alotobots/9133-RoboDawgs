/*THIS CODE IS TESTED AS OF 11.1.21
Coded by 2021-2022 RoboDawgs Programing team */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class Auto_Duck_Red_Sqware_11266 extends LinearOpMode {
private DcMotorEx leftdrive = null;
private DcMotorEx rightdrive = null;
private DcMotorEx duck = null;
private Servo claw = null;
    
    @Override
    public void runOpMode() {
        DcMotorEx leftdrive  = hardwareMap.get(DcMotorEx.class, "leftdrive");
        DcMotorEx rightdrive = hardwareMap.get(DcMotorEx.class, "rightdrive");
        DcMotorEx duck = hardwareMap.get(DcMotorEx.class, "duck");
        claw = hardwareMap.servo.get("claw");
    //leftdrive.setDirection(DcMotor.Direction.REVERSE);
    //rightdrive.setDirection(DcMotor.Direction.REVERSE);
    
    //set claw for pre load block
//claw.setPosition(0);

        // Reset the encoder during initialization
        leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        duck.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        waitForStart();
        
        // Set the motor's target position to 300 ticks
        leftdrive.setTargetPosition(-1000);
        rightdrive.setTargetPosition(1000);
        
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        leftdrive.setVelocity(800);
        rightdrive.setVelocity(800);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();
}

//set target pos 2
 duck.setTargetPosition(2000);
 
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
        leftdrive.setTargetPosition(0);
        rightdrive.setTargetPosition(-800);
        
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        leftdrive.setVelocity(1000);
        rightdrive.setVelocity(1000);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();
}


leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
duck.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//set target pos 3
leftdrive.setTargetPosition(-500);
rightdrive.setTargetPosition(-500);

leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

//set target 3 speed
 leftdrive.setVelocity(1000);
rightdrive.setVelocity(1000);


   while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();
}


leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

//set target pos 3
leftdrive.setTargetPosition(650);
rightdrive.setTargetPosition(-650);

leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

//set target 3 speed
 leftdrive.setVelocity(1000);
rightdrive.setVelocity(1000);
                
        // While the Op Mode is running, show the motor's status via telemetry
        while (opModeIsActive()) {
            //telemetry.addData("Left drive velocity", leftdrive.getVelocity());
            //telemetry.addData("Right drive velocity", rightdrive.getVelocity());
            telemetry.addData("Left drive position", leftdrive.getCurrentPosition());
            telemetry.addData("Right drive position", rightdrive.getCurrentPosition());
            telemetry.addData("is at target", !leftdrive.isBusy());
            telemetry.update();
        }
    }
}