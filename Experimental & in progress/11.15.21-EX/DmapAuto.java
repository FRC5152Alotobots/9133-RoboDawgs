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

public class DmapAuto {
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
    public DmapAuto(){

    }

    /* Initialize standard Hardware interfaces */
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
        leftdrive.setDirection(DcMotor.Direction.REVERSE);
        rightdrive.setDirection(DcMotor.Direction.FORWARD);
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
    public void mtp(int lde , int rde , int ve){
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
 }
