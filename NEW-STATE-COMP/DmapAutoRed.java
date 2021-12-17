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

public class DmapAutoRed {
    /* Public OpMode members. */
     public DcMotorEx leftdrive = null;
    public DcMotorEx rightdrive = null;
    public DcMotorEx spinner = null;
    public Servo claw = null;
    public DcMotorEx duckL = null;
    public DcMotorEx duckR = null;
    public DcMotorEx Arm = null;
    public TouchSensor armBack; 
    public RevBlinkinLedDriver led;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public DmapAutoRed(){

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
        duckL = hwMap.get(DcMotorEx.class, "duckL");
        duckR = hwMap.get(DcMotorEx.class, "duckR");
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
    
    public void wfl(){
    while(leftdrive.isBusy()) {
//waits for left motor (Only one is needed if both motors are moving) (Will be irrelevent if oodometry is setup)
 }
    }
    
    public void wfr(){
    while(rightdrive.isBusy()) {
//waits for right motor (Only one is needed if both motors are moving) (Will be irrelevent if oodometry is setup)
 }
    }
    


//Red B WH

//LOW
public void RedBlowWH() throws InterruptedException {
    //telemetry.addData("Running class:" , "BlueBmid");
//telemetry.update();

        
        // Reset the encoders using custom cmd
        resetEncoders();
        claw.setPosition(0);
        Thread.sleep(500);
        
        //run to pos custom class defined above
        rtp(750 , 750 , 500);
        
        //waits for left drive
        wfl();
        
        //same as above
        rtp(0 , 360, 500);
        wfl();
        
        //set arm pos
        Arm.setTargetPosition(82);
        // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
        //wait for arm to finish
        while(Arm.isBusy()) {
        }
        
    rtp(140 , 140 , 500);
    wfl();
    
//extend spinner
spinner.setTargetPosition(200);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(500);

while(spinner.isBusy()) {
}

//open claw
claw.setPosition(0.14);
//wait 1 second
Thread.sleep(1000);
//retract spinner
spinner.setTargetPosition(0);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(1000);

while(spinner.isBusy()) {
}
 
//reverse a little
rtp(-700 , -340 , 500);
wfl();

 //arm down
    Arm.setTargetPosition(100);
    // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
 
 while(Arm.isBusy()) {
 }
  //rv into wh
rtp(-1900 , -1900 , 1800);
wfl();

//arm down
    Arm.setTargetPosition(0);
    // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
 
 while(Arm.isBusy()) {
 }
 
}

//MID
public void RedBmidWH() throws InterruptedException {
    //telemetry.addData("Running class:" , "BlueBmid");
//telemetry.update();

        
        // Reset the encoders using custom cmd
        resetEncoders();
        claw.setPosition(0);
        Thread.sleep(500);
        
        //run to pos custom class defined above
        rtp(750 , 750 , 500);
        
        //waits for left drive
        wfl();
        
        //same as above
        rtp(0 , 360, 500);
        wfl();
        
        //set arm pos
        Arm.setTargetPosition(278);
        // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
        //wait for arm to finish
        while(Arm.isBusy()) {
        }
        
    rtp(140 , 140 , 500);
    wfl();
    
//extend spinner
spinner.setTargetPosition(800);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(500);

while(spinner.isBusy()) {
}

//open claw
claw.setPosition(0.14);
//wait 1 second
Thread.sleep(1000);
//retract spinner
spinner.setTargetPosition(0);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(1000);

while(spinner.isBusy()) {
}
 
//reverse a little
rtp(-700 , -340 , 500);
wfl();

 //arm down
    Arm.setTargetPosition(100);
    // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
 
 while(Arm.isBusy()) {
 }
  //rv into wh
rtp(-1900 , -1900 , 1800);
wfl();

//arm down
    Arm.setTargetPosition(0);
    // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
 
 while(Arm.isBusy()) {
 }
 
}

//HIGH
public void RedBHighWH() throws InterruptedException {
 // Reset the encoders using custom cmd
        resetEncoders();
        claw.setPosition(0);
        Thread.sleep(500);
        
        //same as above
        rtp(100 , 100, 500);
        wfl();
        
        //run to pos custom class defined above
        rtp(0 , 340 , 500);
        
        //waits for left drive
        wfr();
        
        //same as above
        rtp(540 , 540, 500);
        wfl();
        
        //set arm pos
        Arm.setTargetPosition(477);
        // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
        //wait for arm to finish
        while(Arm.isBusy()) {
        }
        
    rtp(305 , 200 , 500);
    wfl();
    
    //rtp(40 , 40 , 500);
    //wfl();
    
//extend spinner
spinner.setTargetPosition(3000);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(1000);

while(spinner.isBusy()) {
}

//open claw
claw.setPosition(0.14);
//wait 1 second
Thread.sleep(1000);
//retract spinner
spinner.setTargetPosition(0);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(1000);

while(spinner.isBusy()) {
}
 
//reverse a little
rtp(-300 , -350 , 500);
wfl();

 //arm down
    Arm.setTargetPosition(100);
    // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
 
 while(Arm.isBusy()) {
 }
rtp(-640 , 0 , 500);
wfl();

rtp(-2200 , -2200 , 1500);
wfl();

//arm down
    Arm.setTargetPosition(0);
    // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
}
 
 
//Red A SQ

//LOW
public void RedAlowSQ() throws InterruptedException{
// Reset the encoders using custom cmd
        resetEncoders();
        claw.setPosition(0);
        Thread.sleep(500);
        //same as above
        rtp(100 , 100, 500);
        wfl();
        
        //run to pos custom class defined above
        rtp(340 , 0 , 500);
        
        //waits for left drive
        wfl();
        
        //same as above
        rtp(540 , 540, 500);
        wfl();
        
        //set arm pos
        Arm.setTargetPosition(120);
        // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
        //wait for arm to finish
        while(Arm.isBusy()) {
        }
        
    rtp(130 , 290 , 500);
    wfl();
    
    //rtp(40 , 40 , 500);
    //wfl();
    
//extend spinner
spinner.setTargetPosition(600);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(500);

while(spinner.isBusy()) {
}

//open claw
claw.setPosition(0.14);
//wait 1 second
Thread.sleep(1000);
//retract spinner
spinner.setTargetPosition(0);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(1000);

while(spinner.isBusy()) {
}
 
//reverse a little
rtp(-500 , -500 , 500);
wfl();

 //arm down
    Arm.setTargetPosition(0);
    // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
 
 while(Arm.isBusy()) {
 }
rtp(675 , 0 , 500);
wfl();

rtp(-1500 , -1500 , 1500);
wfl();

rtp(0 , 462 , 500);
wfr();

rtp(-650 , -650 , 500);
wfl();

//duck spin
duckL.setTargetPosition(-7000);
duckL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
duckL.setVelocity(2000);

//duck spin
duckR.setTargetPosition(-7000);
duckR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
duckR.setVelocity(2000);

while(duckR.isBusy()) {
}

rtp(0 , 400 , 500);
wfr();

rtp(502 , 492 , 500);
wfl();

duckR.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
duckL.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
}
//MID
public void RedAmidSQ() throws InterruptedException{
//telemetry.addData("Running class:" , "BlueBmid");
//telemetry.update();

        
        // Reset the encoders using custom cmd
        resetEncoders();
        claw.setPosition(0);
        Thread.sleep(500);
        
        //run to pos custom class defined above
        rtp(750 , 750 , 500);
        
        //waits for left drive
        wfl();
        
        //same as above
        rtp(460 , 0, 500);
        wfl();
        
        //set arm pos
        Arm.setTargetPosition(298);
        // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
        //wait for arm to finish
        while(Arm.isBusy()) {
        }
        
    rtp(140 , 140 , 500);
    wfl();
    
//extend spinner
spinner.setTargetPosition(800);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(500);

while(spinner.isBusy()) {
}

//open claw
claw.setPosition(0.14);
//wait 1 second
Thread.sleep(1000);
//retract spinner
spinner.setTargetPosition(0);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(1000);

while(spinner.isBusy()) {
}
 
//reverse a little
rtp(-500 , -500 , 500);
wfl();

 //arm down
    Arm.setTargetPosition(100);
    // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
 
 while(Arm.isBusy()) {
 }
  //rv for duck
rtp(0 , -217, 500);
wfr();

rtp(-870 , -870, 500);
wfl();

//arm down
    Arm.setTargetPosition(0);
    // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
 
 while(Arm.isBusy()) {
 }
 
//duck spin
duckL.setTargetPosition(-7000);
duckL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
duckL.setVelocity(2000);

//duck spin
duckR.setTargetPosition(-7000);
duckR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
duckR.setVelocity(2000);

while(duckR.isBusy()) {
}

rtp(0 , 847, 500);
wfr();

rtp(550 , 550, 500);
wfl();

rtp(-286 , -294, 500);
wfl();

duckR.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
duckL.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

 }
//HIGH
public void RedAHighSQ() throws InterruptedException{
//telemetry.addData("Running class:" , "BlueBmid");
//telemetry.update();

        
        // Reset the encoders using custom cmd
        resetEncoders();
        claw.setPosition(0);
        Thread.sleep(500);
        
        //run to pos custom class defined above
        rtp(750 , 750 , 500);
        
        //waits for left drive
        wfl();
        
        //same as above
        rtp(460 , 0, 500);
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
        
    rtp(140 , 140 , 500);
    wfl();
    
//extend spinner
spinner.setTargetPosition(1800);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(1000);

while(spinner.isBusy()) {
}

//open claw
claw.setPosition(0.14);
//wait 1 second
Thread.sleep(1000);
//retract spinner
spinner.setTargetPosition(0);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(1000);

while(spinner.isBusy()) {
}
 
//reverse a little
rtp(-500 , -500 , 500);
wfl();

 //arm down
    Arm.setTargetPosition(100);
    // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
 
 while(Arm.isBusy()) {
 }
  //rv for duck
rtp(0 , -217, 500);
wfr();

rtp(-870 , -870, 500);
wfl();

//arm down
    Arm.setTargetPosition(0);
    // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
 
 while(Arm.isBusy()) {
 }
 
//duck spin
duckL.setTargetPosition(-7000);
duckL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
duckL.setVelocity(2000);

//duck spin
duckR.setTargetPosition(-7000);
duckR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
duckR.setVelocity(2000);

while(duckR.isBusy()) {
}

rtp(0 , 847, 500);
wfr();

rtp(550 , 550, 500);
wfl();

rtp(-286 , -294, 500);
wfl();

duckR.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
duckL.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
}
}
