package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class DmapOp {
    /* Public OpMode members. */
     public DcMotor leftdrive = null;
    public DcMotor rightdrive = null;
    public DcMotor spinner = null;
    public Servo claw = null;
    public DcMotor duck = null;
    public DcMotorEx Arm;
    public TouchSensor armBack; 
    public Servo hook = null;
    public RevBlinkinLedDriver led;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public DmapOp(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftdrive  = hardwareMap.get(DcMotor.class, "leftdrive");
        rightdrive = hardwareMap.get(DcMotor.class, "rightdrive");
        spinner = hardwareMap.get(DcMotor.class, "spinner");
        claw = hardwareMap.servo.get("claw");
        duck = hardwareMap.get(DcMotor.class, "duck");
        hook = hardwareMap.servo.get("hook");
        Arm = hardwareMap.get(DcMotorEx.class, "Arm");
        armBack = hardwareMap.get(TouchSensor.class, "armBack");
        led = hardwareMap.get(RevBlinkinLedDriver.class , "led");

        //set motor directions
        leftdrive.setDirection(DcMotor.Direction.REVERSE);
        rightdrive.setDirection(DcMotor.Direction.FORWARD);
        spinner.setDirection(DcMotor.Direction.REVERSE);
        claw.setDirection(Servo.Direction.FORWARD);
        hook.setDirection(Servo.Direction.FORWARD);
        duck.setDirection(DcMotor.Direction.FORWARD);
        Arm.setDirection(DcMotor.Direction.FORWARD);
    }
 }