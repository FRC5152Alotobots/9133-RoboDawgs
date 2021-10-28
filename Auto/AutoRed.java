package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import java.util.concurrent.TimeUnit;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="AutoRed", group="Iterative Opmode")
//@Disabled


public class AutoRed extends OpMode {
    
    // Declare Motors in program
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftdrive = null;
    private DcMotor rightdrive = null;
    private DcMotor spinner = null;
   private Servo leftservo = null;
   private Servo rightservo = null;


    public void init() {
        //map the motors/servos confiured to variables in the program.
        telemetry.addData("Status", "Initialized");
   leftdrive  = hardwareMap.get(DcMotor.class, "leftdrive");
        rightdrive = hardwareMap.get(DcMotor.class, "rightdrive");
        spinner = hardwareMap.get(DcMotor.class, "spinner");
      leftservo = hardwareMap.servo.get("leftservo");
      rightservo = hardwareMap.servo.get("rightservo");

      leftdrive.setDirection(DcMotor.Direction.REVERSE);
        rightdrive.setDirection(DcMotor.Direction.REVERSE);
        spinner.setDirection(DcMotor.Direction.REVERSE);
        leftservo.setDirection(Servo.Direction.REVERSE);
        rightservo.setDirection(Servo.Direction.FORWARD);

// Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

//Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
    @Override
    public void init_loop() {
    }
    
//Code to run ONCE when the driver hits PLAY
 @Override
    public void start() {
start_time = System.currentTimeMills;

//Sets both servos to the start pos
leftservo.setPosition(.25);
rightservo.setPosition(.25);
    }
    @Override
    public void loop(){
float powerlevel =0.0f;

//if time (.5 Sec) is less than the ammount of seconds at start keep driving
if (System.currentTimeMills() < start_time + 500){
leftdrive.setPower(1);
rightdrive.setPower(0);
}

//set power 0 after driving for set time
leftdrive.setPower(0);
rightdrive.setPower(0);

//if time (1 Sec) is less than the ammount of seconds at start keep driving
if (System.currentTimeMills() < start_time + 1500){
leftdrive.setPower(.6);
rightdrive.setPower(.6);
}

//set power 0 after driving for set time
leftdrive.setPower(0);
rightdrive.setPower(0);

//if time (.5 Sec) is less than the ammount of seconds at start keep driving
if (System.currentTimeMills() < start_time + 2000){
leftdrive.setPower(0);
rightdrive.setPower(1);
}

//set power 0 after driving for set time
leftdrive.setPower(0);
rightdrive.setPower(0);

//if time (2 Sec) is less than the ammount of seconds at start keep driving
if (System.currentTimeMills() < start_time + 4000){
leftdrive.setPower(.6);
rightdrive.setPower(.6);
}

//set power 0 after driving for set time
leftdrive.setPower(0);
rightdrive.setPower(0);

    }

}

        

