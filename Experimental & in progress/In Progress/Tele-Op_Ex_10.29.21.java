/*THIS CODE IS TESTED AS OF 10.28.21
Coded by 2021-2022 RoboDawgs Programing team */

//Imports all packages 
package org.firstinspires.ftc.robotcontroller.external.samples;
 
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
 
//Mode        Program Name    
@TeleOp(name="BasicMode2P", group="Iterative Opmode")

//@Disabled (Tells if this program is disabled or not)

//          Program Name
public class BasicMode2P extends OpMode
{
   // Declare conected devices (Motors, Servos, etc.)
   private ElapsedTime runtime = new ElapsedTime();
   private DcMotor leftdrive = null;
   private DcMotor rightdrive = null;
   private DcMotor spinner = null;
  private Servo leftservo = null;
  private Servo rightservo = null;
  private Servo claw = null;

//Code to run ONCE when the driver hits INIT
   @Override
   public void init() {
       telemetry.addData("Status", "Initialized");
       //Init all motor properties. Below is the manual code in case of problems. Remove comments to
       //activate the backup set.
   robot.init(hwMap);
//  ↓ Remove to activate
   /*
       // Assign the devices variables. Note that the text used here as parameters
       // to 'get' must be the same names assigned using the FTC Robot Controller app on the phone
       leftdrive  = hardwareMap.get(DcMotor.class, "leftdrive");
       rightdrive = hardwareMap.get(DcMotor.class, "rightdrive");
       spinner = hardwareMap.get(DcMotor.class, "spinner");
     leftservo = hardwareMap.servo.get("leftservo");
     rightservo = hardwareMap.servo.get("rightservo");
    claw = hardwareMap.servo.get("claw");

       // Most robots need the motor on one side to be reversed to drive forward
       // Reverse the motor that runs backwards when connected directly to the battery
       leftdrive.setDirection(DcMotor.Direction.REVERSE);
       rightdrive.setDirection(DcMotor.Direction.REVERSE);
       spinner.setDirection(DcMotor.Direction.REVERSE);
       leftservo.setDirection(Servo.Direction.REVERSE);
       rightservo.setDirection(Servo.Direction.FORWARD);
      claw.setDirection(Servo.Direction.FORWARD);
       
       // Tell the driver that initialization is complete.
       telemetry.addData("Status", "Initialized");
   }
 */
//Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
   @Override
   public void init_loop() {
   }
 
//Code to run ONCE when the driver hits PLAY
   @Override
   public void start() {
       runtime.reset();
   }
 
//Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
   @Override
   public void loop() {

       // Setup a variable for each drive wheel to save power level for telemetry
       double leftPower;
       double rightPower;
       double spinnerPower = 1;
       double servoPower = 1;
       double power = 1;
       double poweralt = 1;
       boolean Chillmode = false;
    //Chill 
    if(gamepad1.right_trigger > .5) {
   telemetry.addData("Status" , "Chill ON");
    Chillmode = true;
    power = 2;
    poweralt = 2;
    } else {
     telemetry.addData("Status" , "Chill OFF");
     Chillmode = false;
    power = 1;
    poweralt = 1;
    }
    //Turbo
    if(gamepad1.left_trigger > .5) {
    power = .5;
    poweralt = .5;
    telemetry.addData("Status" , "Turbo ON");
    } else { if (Chillmode = false){
   telemetry.addData("Status" , "Turbo OFF");
    power = 1;
    poweralt = 1;
    }}

//DRIVE CONTROLS
//POV Mode uses left stick to go forward, and right stick to turn.
//This uses basic math to combine motions and is easier to drive straight.

       double drive = -gamepad1.right_stick_x;
       double turn  =  gamepad1.left_stick_y;
       leftPower    = Range.clip(drive + turn, -.5/power, .5/poweralt) ;
       rightPower   = Range.clip(drive - turn, -.5/power, .5/poweralt) ;
  
//SPINNER
spinner.setPower(gamepad2.right_trigger);
spinner.setPower(gamepad2.left_trigger*-1);
      
      
//LIFT ARM

//Rest Pos
if (gamepad2.dpad_up){
leftservo.setPosition(.25);
rightservo.setPosition(.25);
}
//Low Level Pos
 if (gamepad2.a){
leftservo.setPosition(.35);
rightservo.setPosition(.35);
}
//Mid Level Pos
 if (gamepad2.b){
leftservo.setPosition(.42);
rightservo.setPosition(.42);
}
//Top Level Pos
 if (gamepad2.y){
leftservo.setPosition(.60);
rightservo.setPosition(.60);
}

//Claw servo

//Open
if (gamepad2.right_bumper){
claw.setPosition(.5);
}
//Closed
if (gamepad2.left_bumper){
claw.setPosition(0);
} 

//send calculated power to wheels
leftdrive.setPower(leftPower);
rightdrive.setPower(rightPower);

 // Show the elapsed game time
telemetry.addData("Status", "Run Time: " + runtime.toString());
// Show the Power status of the motors
telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
   }
 
//Code to run ONCE after the driver hits STOP
@Override
public void stop() {
}
}
