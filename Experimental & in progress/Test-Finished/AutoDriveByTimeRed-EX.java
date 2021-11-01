package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class AutoDriveRed_EX extends LinearOpMode {
private DcMotor leftdrive = null;
private DcMotor rightdrive = null;

    
    @Override
    public void runOpMode() {
        DcMotorEx leftdrive  = hardwareMap.get(DcMotorEx.class, "leftdrive");
        DcMotorEx rightdrive = hardwareMap.get(DcMotorEx.class, "rightdrive");
        
        // Reset the encoder during initialization
        leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        waitForStart();
        
        // Set the motor's target position to 300 ticks
        leftdrive.setTargetPosition(10000);
        rightdrive.setTargetPosition(-10000);
        
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
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