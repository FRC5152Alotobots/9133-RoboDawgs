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
/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */
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
    public HardwarePushbot(){

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