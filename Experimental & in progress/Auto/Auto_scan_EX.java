/*THIS CODE IS TESTED AS OF 11.1.21
Coded by 2021-2022 RoboDawgs Programing team */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.DistanceSensor;
RevBlinkinLedDriver led;
@Autonomous
public class Auto_scan_Ex.java extends LinearOpMode {
private DcMotorEx leftdrive = null;
private DcMotorEx rightdrive = null;
private DcMotorEx duck = null;
private Servo claw = null;
private DistanceSensor distance = null;
    @Override
    public void runOpMode() {
        DcMotorEx leftdrive  = hardwareMap.get(DcMotorEx.class, "leftdrive");
        DcMotorEx rightdrive = hardwareMap.get(DcMotorEx.class, "rightdrive");
        DcMotorEx duck = hardwareMap.get(DcMotorEx.class, "duck");
        distance = hardwareMap.get(DistanceSensor.class, "distance");
        led = hardwareMap.get(RevBlinkinLedDriver.class , "led");
        claw = hardwareMap.servo.get("claw");
    //leftdrive.setDirection(DcMotor.Direction.REVERSE);
    //rightdrive.setDirection(DcMotor.Direction.REVERSE);

        if (distance.getDistance(DistanceUnit.CM) < 5)){ 
led.setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);
        }
       
//send calculated power to wheels
/* if (distance.getDistance(DistanceUnit.CM) < 5) {
               // Closes claw if Distance it less than 10 cm 
              if (Open = true){
               claw.setPosition(0.0);
               Open = false; 
              }
            } else {  // Otherwise keep claw open 
               Open = true;
               claw.setPosition(0.09);} */


                
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