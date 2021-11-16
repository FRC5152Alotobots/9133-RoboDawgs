/*THIS CODE IS TESTED AS OF 10.28.21
Coded by 2021-2022 RoboDawgs Programing team */

//Imports all packages 
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
//Mode        Program Name    
@TeleOp(name="BasicMode2P", group="Iterative Opmode")

//@Disabled
//( @Disabled Tells if this program is disabled or not)

public class BasicMode2P extends OpMode
{
//Declare conected devices (Motors, Servos, etc.)
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftdrive = null;
    private DcMotor rightdrive = null;
    private DcMotor spinner = null;
    private Servo claw = null;
    private DcMotor duck = null;
    private DcMotorEx Arm;
    private TouchSensor armBack = null;
    //private DistanceSensor distance = null;
    private Servo hook = null;
    RevBlinkinLedDriver led;
//Code to run ONCE when the driver hits INIT

   @Override
   public void init() {
       telemetry.addData("Status", "Initialized");
//Init all motor properties. Below is the manual code in case of problems. Remove comments to
    //activate the backup set.
   //robot.init(hwMap);
// Assign the devices variables. Note that the text used here as parameters
       // to 'get' must be the same names assigned using the FTC Robot Controller app on the phone
leftdrive  = hardwareMap.get(DcMotor.class, "leftdrive");
rightdrive = hardwareMap.get(DcMotor.class, "rightdrive");
spinner = hardwareMap.get(DcMotor.class, "spinner");
claw = hardwareMap.servo.get("claw");
duck = hardwareMap.get(DcMotor.class, "duck");
hook = hardwareMap.servo.get("hook");
Arm = hardwareMap.get(DcMotorEx.class, "Arm");
armBack = hardwareMap.get(TouchSensor.class, "armBack");
led = hardwareMap.get(RevBlinkinLedDriver.class , "led");
// Most robots need the motor on one side to be reversed to drive forward
      
leftdrive.setDirection(DcMotor.Direction.REVERSE);
rightdrive.setDirection(DcMotor.Direction.FORWARD);
spinner.setDirection(DcMotor.Direction.REVERSE);
claw.setDirection(Servo.Direction.FORWARD);
hook.setDirection(Servo.Direction.FORWARD);
duck.setDirection(DcMotor.Direction.FORWARD);
Arm.setDirection(DcMotor.Direction.FORWARD);
       // Tell the driver that initialization is complete.
telemetry.addData("Status", "Initialized");
   }
//Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY (This is a loop)
@Override
public void init_loop() {
   }
//Code to run ONCE when the driver hits PLAY
@Override
public void start() {
Arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    runtime.reset();
   }
 
//Code to run REPEATEDLY after the driver hits PLAY (This is a loop)
@Override
public void loop() {
//REMOVED CODE ID=1 

resetStartTime();
    // Setup a variable for each drive wheel to save power level for telemetry
double leftPower;
double rightPower;
    double servoPower = 1;
        boolean Chillmode = false;
        double power = 1;
        double poweralt = 1;
    
    //Chill Creates a slow Driveing mode 
   
    //IF right triger is pressed THEN set power to 2 (slow)
    if(gamepad1.right_trigger > .5) {
        telemetry.addData("Status" , "Chill ON");
        Chillmode = true;
        power = 2;
        poweralt = 2;
    } 
    //REMOVED CODE ID=2 
        //Turbo Creates a fast driving mode 
        //IF left triger is pressed THEN set power to .57 (fast)
    if(gamepad1.left_trigger > .5) {
        power = .57;
        poweralt = .57;
        telemetry.addData("Status" , "Turbo ON");
    } 
    //REMOVED CODE ID=3
//DRIVE CONTROLS
    //POV Mode uses left stick to go forward, and right stick to turn.
    //This uses basic math to combine motions and is easier to drive straight.

       double drive = -gamepad1.right_stick_x;
       double turn  =  gamepad1.left_stick_y;
       leftPower    = Range.clip(drive + turn, -.57/power, .57/poweralt) ;
       rightPower   = Range.clip(drive + turn, -.57/power, .57/poweralt) ;
  
//SPINNER
spinner.setPower(gamepad2.left_trigger);
spinner.setPower(gamepad2.right_trigger*-1);
      
//Duck 
    //CHANGED CODE ID=4 
/* If dpad right is pressed duck set power 1 else set power 0. 
 If dpad left is pressed duck set power -1 else set power 0. */
if (gamepad2.dpad_right){
    duck.setPower(1);
}
else if (gamepad2.dpad_left) {
    duck.setPower(-1);
}
else {
    duck.setPower(0);
}
//LIFT ARM
telemetry.addData("Arm position", Arm.getCurrentPosition());

//HOOK
//Pickup pos
if (gamepad1.dpad_left){
    hook.setPosition(.9);
}
//Drop hook 
if (gamepad1.dpad_down){
    hook.setPosition(1);
}
//lift hook 
if (gamepad1.dpad_up){
hook.setPosition(.84);
}    
//Retract hook 
if (gamepad1.left_bumper){
    hook.setPosition(0);
}
//Override hook (Retract) 
if (gamepad2.back){
    hook.setPosition(0); 
}
//EMERGENCY REST 
while (gamepad2.dpad_down){
    Arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODERS);
    Arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    Arm.setPower(-.75);
    Arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
}
//Arm Set postion 
if (gamepad2.a){
Arm.setTargetPosition(0);
Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
Arm.setVelocity(750);
}
else if(gamepad2.b){
Arm.setTargetPosition(100);
Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
Arm.setVelocity(750);
}
else if (gamepad2.x){
Arm.setTargetPosition(160);
Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
Arm.setVelocity(750);
}
else if(gamepad2.y){
Arm.setTargetPosition(535);
Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
Arm.setVelocity(750);
}
    
//Claw servo

//Open
if (gamepad2.right_bumper){
claw.setPosition(.14);
}
//Closed
if (gamepad2.left_bumper){
claw.setPosition(0);
} 

//Set LEDS to GREEN if arm retreacted

if (armBack.isPressed()){
  led.setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);  
}


//Send calculated power to wheels
 
leftdrive.setPower(leftPower);
rightdrive.setPower(rightPower);

 // Show the elapsed game time
telemetry.addData("Status", "Run Time: " + runtime.toString());
// Show the Power status of the motors
telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
   }
 

}
