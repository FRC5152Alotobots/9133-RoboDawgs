package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;

@Autonomous
public class DebugRobot extends LinearOpMode {
private DcMotorEx leftdrive = null;
private DcMotorEx rightdrive = null;
private DcMotorEx spinner = null;
private Servo claw = null;
private DcMotorEx duck = null;
private DcMotorEx Arm = null;
private TouchSensor armBack = null;
private DistanceSensor distance = null;
    
    @Override
    public void runOpMode() {
        DcMotorEx leftdrive  = hardwareMap.get(DcMotorEx.class, "leftdrive");
        DcMotorEx rightdrive = hardwareMap.get(DcMotorEx.class, "rightdrive");
        DcMotorEX spinner = hardwareMap.get(DcMotor.class, "spinner");
        DcMotorEX duck = hardwareMap.get(DcMotor.class, "duck");
        DcMotorEx Arm = hardwareMap.get(DcMotor.class, "Arm");
        armBack = hardwareMap.get(TouchSensor.class, "armBack");
        distance = hardwareMap.get(DistanceSensor.class, "distance");
        claw = hardwareMap.servo.get("claw");

        // Reset the encoder during initialization
        leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        waitForStart();
        
        // Set the motor's target position to 300 ticks
        leftdrive.setTargetPosition(300);
        
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        leftdrive.setVelocity(200);
        
        
        while(leftdrive.isBusy()) {
telemetry.addData("Status", "Waiting for left drive to test");
telemetry.addData("Left drive position", leftdrive.getCurrentPosition());
 telemetry.update();
}
if(leftdrive.getCurrentPosition() = 300){
telemetry.addData("Left Drive" , "PASS")
telemetry.update();
}

//test right drive
rightdrive.setTargetPosition(-300);
rightdrive.setVelocity(200);

while(rightdrive.isBusy()) {
telemetry.addData("Right drive position", rightdrive.getCurrentPosition());
telemetry.addData("Status", "Waiting for right drive to test");
telemetry.update();
}
 if(rightdrive.getCurrentPosition() = -300){
telemetry.addData("Right Drive" , "PASS")
telemetry.update();
}


        // While the Op Mode is running, show the motor's status via telemetry
        while (opModeIsActive()) {
            
        }
    }
}