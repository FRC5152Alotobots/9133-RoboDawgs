/*THIS CODE IS TESTED AS OF 11.1.21
Coded by 2021-2022 RoboDawgs Programing team */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class Auto_Duck_WH_Red extends LinearOpMode {
private DcMotorEx leftdrive = null;
private DcMotorEx rightdrive = null;
private DcMotorEx duck = null;
private DcMotoeEx Arm = null;
private Servo claw = null;
    @Override
    public void runOpMode() {
        
        DcMotorEx leftdrive  = hardwareMap.get(DcMotorEx.class, "leftdrive");
        DcMotorEx rightdrive = hardwareMap.get(DcMotorEx.class, "rightdrive");
        DcMotorEx duck = hardwareMap.get(DcMotorEx.class, "duck");
        DcMotorEx Arm = hardwareMap.get(DcMotorEx.class, "Arm")
        claw = hardwareMap.servo.get("claw");
    //leftdrive.setDirection(DcMotor.Direction.REVERSE);
    //rightdrive.setDirection(DcMotor.Direction.REVERSE);
    
    //close claw for pre load box
    //claw.setPosition(0);
    
        // Reset the encoder during initialization
    leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    duckL.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    duckR.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    Arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    spinner.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        
        public void resetEncoders() {
    leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    duckL.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    duckR.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    Arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    spinner.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }
    //move to pos
    public void rtp(int lde , int rde , int ve){
    //reset encoders before every cmd
    leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    //Set pos
    leftdrive.setTargetPosition(lde);
    rightdrive.setTargetPosition(rde);
    //Run to pos
    leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    //Set velocity
    leftdrive.setVelocity(ve);
    rightdrive.setVelocity(ve);
    }
    public void wfl(){
    while(leftdrive.isBusy()) {
//waits for left motor (Only one is needed if both motors are moving) (Will be irrelevent if oodometry is setup)
 }
    }
        waitForStart();
        
        rtp(750 , 750 , 500);
        wfl();
         
         rtp(460 , 0 , 500);
        wfl();
         //set arm pos
        Arm.setTargetPosition(462);
        // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
        //wait for arm to finish
        while(Arm.isBusy()) {
        }
        
    rtp(280 , 280 , 500);
    wfl();
  //Backup a bit   
        rtp(280 , 280 , 500);
        wfl();
    
    //extend spinner
        spinner.setTargetPosition(1000);
        spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        spinner.setVelocity(500);

        while(spinner.isBusy()) {}

    //open claw
        claw.setPosition(0.14);
    //wait 1/10 second
        Thread.sleep(100);
    //retract spinner
        spinner.setTargetPosition(0);
        spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        spinner.setVelocity(1000);
        
        while(spinner.isBusy()) {}
 
    //reverse a little
        rtp(-500 , -500 , 500);
        wfl();

    //arm down
        Arm.setTargetPosition(500);
    // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    //set vel of arm
        Arm.setVelocity(800);
 
        while(Arm.isBusy()) {}
 
    //setup to spin duck
        rtp(0 , -470 , 500);
        wfr();
    //drive forward to line up for duck
        rtp(2250 , 2250 , 1000);
        wfl();
    //turn to line up
        rtp(0 , 900 , 750);
        wfr();
    //reverse and touch duck
        rtp(-900 , -900 , 500);
        wfl();

    //set target pos 2
        duckR.setTargetPosition(2500);
        duckR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    //set target 2 speed
        duckR.setVelocity(1000);
        while(duckR.isBusy()) {}
    //Turn right a little
        rtp(0 , 580 , 750);
        wfr();
    //Full speed into the where house 
        rtp(3500 , 3500 , 1750);
        wfl();
        }
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
