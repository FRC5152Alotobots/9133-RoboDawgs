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
private DcMotor leftdrive = null;
private DcMotor rightdrive = null;
private DcMotor spinner = null;
private Servo claw = null;
private DcMotor duck = null;
private DcMotor Arm = null;
private TouchSensor armBack = null;
//private DistanceSensor distance = null;
    
    @Override
    public void runOpMode() {
        DcMotorEx leftdrive  = hardwareMap.get(DcMotorEx.class, "leftdrive");
        DcMotorEx rightdrive = hardwareMap.get(DcMotorEx.class, "rightdrive");
        DcMotorEx spinner = hardwareMap.get(DcMotorEx.class, "spinner");
        DcMotorEx duck = hardwareMap.get(DcMotorEx.class, "duck");
        DcMotorEx Arm = hardwareMap.get(DcMotorEx.class, "Arm");
        armBack = hardwareMap.get(TouchSensor.class, "armBack");
        //distance = hardwareMap.get(DistanceSensor.class, "distance");
        claw = hardwareMap.servo.get("claw");

        // Reset the encoder during initialization
        leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        spinner.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        duck.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        Arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        waitForStart();
        
        // Set the motor's target position to 300 ticks
        leftdrive.setTargetPosition(300);
        
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        leftdrive.setVelocity(200);
        
        
        while(leftdrive.isBusy()) {
telemetry.addData("Status", "Waiting for left drive to test");
telemetry.addData("Left drive position", leftdrive.getCurrentPosition());
 telemetry.update();
}
if(leftdrive.getCurrentPosition() >= 300){
 telemetry.addLine()
.addData("Left Drive" , "PASS");
telemetry.update();
} else {
telemetry.addLine()
.addData("Right Drive" , "FAIL");
telemetry.update();    
}

//test right drive
rightdrive.setTargetPosition(-300);
rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
rightdrive.setVelocity(200);

while(rightdrive.isBusy()) {
telemetry.addData("Right drive position", rightdrive.getCurrentPosition());
telemetry.addData("Status", "Waiting for right drive to test");
telemetry.update();
}
 if(rightdrive.getCurrentPosition() >= -300){
telemetry.addLine()
.addData("Right Drive" , "PASS");
telemetry.update();
} else {
telemetry.addLine()
.addData("Right Drive" , "FAIL");
telemetry.update();    
}

//test duck
duck.setTargetPosition(-300);
duck.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
duck.setVelocity(200);

while(duck.isBusy()) {
telemetry.addData("Duck Spinner position", duck.getCurrentPosition());
telemetry.addData("Status", "Waiting for duck spinner to test");
telemetry.update();
}
 if(duck.getCurrentPosition() >= -300){
 telemetry.addLine()
.addData("Duck Spinner" , "PASS");
telemetry.update();
} else {
telemetry.addLine()
.addData("Duck Spinner" , "FAIL");
telemetry.update();    
}

//test spinner
spinner.setTargetPosition(300);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(200);

while(spinner.isBusy()) {
telemetry.addData("Arm Spinner position", spinner.getCurrentPosition());
telemetry.addData("Status", "Waiting for arm spinner to test");
telemetry.update();
}
 if(spinner.getCurrentPosition() >= 300){
telemetry.addLine()
.addData("Arm Spinner" , "PASS");
telemetry.update();
} else {
telemetry.addLine()
.addData("Arm Spinner" , "FAIL");
telemetry.update();    
}

//test arm
//arm doesn't have encoder
Arm.setTargetPosition(200);
Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
Arm.setVelocity(200);

while(Arm.isBusy()) {
telemetry.addData("Arm position", Arm.getCurrentPosition());
telemetry.addData("Status", "Waiting for arm");
telemetry.update();
}
//test push button
//Arm.setTargetPosition(0);
//Arm.setVelocity(200);

while(Arm.isBusy()) {
telemetry.addData("Arm position", Arm.getCurrentPosition());
telemetry.addData("Status", "Waiting for arm to retract then proceeding");
telemetry.update();
}
 if(armBack.isPressed()){
telemetry.addLine()
.addData("Arm location sensor" , "PASS");
telemetry.update();
} else {
telemetry.addLine()
.addData("Arm location sensor" , "FAIL");
telemetry.update();    
}

//test distance sensor
telemetry.addLine()
.addData("Distance sensor, Claw servo and Arm must be tested manually" , "Switch to a Tele-Op mode to test");
telemetry.update();

        // While the Op Mode is running, show the motor's status via telemetry
        while (opModeIsActive()) {
            
        }
    }
}