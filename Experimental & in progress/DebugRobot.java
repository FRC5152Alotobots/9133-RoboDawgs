//THIS PROGRAM TESTS ALL ASPECTS OF THE ROBOT. REMOVE @DISABLED TO MAKE IT SHOW UP IN THE OP LIST.



package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="AutoDriveByTimeRed", group="LinearOpMode")
//@Disabled
public class AutoDriveByTimeRed_Linear extends LinearOpMode {

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftdrive = null;
    private DcMotor rightdrive = null;
    private DcMotor spinner = null;
    private Servo claw = null;
    private DcMotor duck = null;
    private DcMotor Arm = null;

    @Override
    public void runOpMode() {

        
        //Initialize the drive system variables.
        leftdrive  = hardwareMap.get(DcMotor.class, "leftdrive");
        rightdrive = hardwareMap.get(DcMotor.class, "rightdrive");
        spinner = hardwareMap.get(DcMotor.class, "spinner");
        claw = hardwareMap.servo.get("claw");
        duck = hardwareMap.get(DcMotor.class, "duck");
        Arm = hardwareMap.get(DcMotor.class, "Arm");

    //Set motor direction
    leftdrive.setDirection(DcMotor.Direction.REVERSE);
    rightdrive.setDirection(DcMotor.Direction.REVERSE);
    spinner.setDirection(DcMotor.Direction.REVERSE);
    claw.setDirection(Servo.Direction.FORWARD);
    duck.setDirection(DcMotor.Direction.FORWARD);
    Arm.setDirection(DcMotor.Direction.FORWARD);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Resetting Encoders");    //
        telemetry.update();

        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("MotorTest",  "Waiting for start",
                          leftdrive.getCurrentPosition(),
                          rightdrive.getCurrentPosition());
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step through each leg of the path,
        // Note: Reverse movement is obtained by setting a negative distance (not speed)
        encoderDrive(TURN_SPEED,   12, -12, 4.0);  // S1: Turn Right 12 Inches with 4 Sec timeout
        encoderDrive(DRIVE_SPEED,  48,  48, 5.0);  // S2: Forward 47 Inches with 5 Sec timeout
        //encoderDrive(DRIVE_SPEED, -24, -24, 4.0);  // S3: Reverse 24 Inches with 4 Sec timeout
        telemetry.addData("Path", "Complete");
        telemetry.update();
    }

    