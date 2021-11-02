package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.TouchSensor;

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
telemetry.addData("Left Drive" , "PASS");
telemetry.update();
} else {
telemetry.addData("Right Drive" , "FAIL");
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
telemetry.addData("Right Drive" , "PASS");
telemetry.update();
} else {
telemetry.addData("Right Drive" , "FAIL");
telemetry.update();    
}

//test duck
duck.setTargetPosition(-300);
duck.setVelocity(200);

while(duck.isBusy()) {
telemetry.addData("Duck Spinner position", duck.getCurrentPosition());
telemetry.addData("Status", "Waiting for duck spinner to test");
telemetry.update();
}
 if(duck.getCurrentPosition() = -300){
telemetry.addData("Duck Spinner" , "PASS");
telemetry.update();
} else {
telemetry.addData("Duck Spinner" , "FAIL");
telemetry.update();    
}

//test spinner
spinner.setTargetPosition(300);
spinner.setVelocity(200);

while(spinner.isBusy()) {
telemetry.addData("Arm Spinner position", spinner.getCurrentPosition());
telemetry.addData("Status", "Waiting for arm spinner to test");
telemetry.update();
}
 if(spinner.getCurrentPosition() = 300){
telemetry.addData("Arm Spinner" , "PASS");
telemetry.update();
} else {
telemetry.addData("Arm Spinner" , "FAIL");
telemetry.update();    
}

//test arm
Arm.setTargetPosition(300);
Arm.setVelocity(200);

while(Arm.isBusy()) {
telemetry.addData("Arm position", Arm.getCurrentPosition());
telemetry.addData("Status", "Waiting for arm to test");
telemetry.update();
}
 if(Arm.getCurrentPosition() = 300){
telemetry.addData("Arm" , "PASS");
telemetry.update();
} else {
telemetry.addData("Arm" , "FAIL");
telemetry.update();    
}

//test push button
Arm.setTargetPosition(0);
Arm.setVelocity(200);

while(Arm.isBusy()) {
telemetry.addData("Arm position", Arm.getCurrentPosition());
telemetry.addData("Status", "Waiting for arm to retract then proceeding");
telemetry.update();
}
 if(Arm.getCurrentPosition() = 0  , armBack.isPressed()){
telemetry.addData("Arm location sensor" , "PASS");
telemetry.update();
} else {
telemetry.addData("Arm location sensor" , "FAIL");
telemetry.update();    
}

//test distance sensor
telemetry.addData("Distance sensor and Claw servo must be tested manually" , "Switch to a Tele-Op mode to test");


        // While the Op Mode is running, show the motor's status via telemetry
        while (opModeIsActive()) {
            
        }
    }
}