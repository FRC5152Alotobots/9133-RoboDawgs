package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 */
public class HardwareDec
{
    /* Public OpMode members. */
    public DcMotor  leftDrive   = null;
    public DcMotor  rightDrive  = null;
    public DcMotor spinner = null;
    public DcMotor Arm = null;
    public Servo    Claw   = null;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwareDec(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftDrive  = hwMap.get(DcMotor.class, "leftdrive");
        rightDrive = hwMap.get(DcMotor.class, "rightdrive");
        Arm    = hwMap.get(DcMotor.class, "Arm");
        spinner = hwMap.get(DcMotor.class, "spinner");
        leftDrive.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightDrive.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        spinner.setDirection(DcMotor.Direction.REVERSE);
        Arm.setDirection(DcMotor.Direction.FORWARD);

        // Set all motors to run with encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        Arm.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        spinner.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);

        // Define and initialize ALL installed servos.
        claw = hwMap.get(Servo.class, "claw");
        claw.setDirection(Servo.Direction.FORWARD);
    }
 }
