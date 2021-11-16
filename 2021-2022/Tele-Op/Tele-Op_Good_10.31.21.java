/*THIS CODE IS TESTED AS OF 10.28.21
Coded by 2021-2022 RoboDawgs Programing team */

//Imports all packages 
package org.firstinspires.ftc.robotcontroller.external.samples;
 
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DigitalChannel;
//Mode        Program Name    
@TeleOp(name="BasicMode2P", group="Iterative Opmode")

//@Disabled(Tells if this program is disabled or not)

//          Program Name
public class BasicMode2P extends OpMode
{
   //add devices to program.
   // Declare conected devices (Motors, Servos, etc.)
   private ElapsedTime runtime = new ElapsedTime();
   private DcMotor leftdrive = null;
   private DcMotor rightdrive = null;
   private DcMotor spinner = null;
  private Servo claw = null;
  private DcMotor duck = null;
private DcMotor Arm = null;
//Code to run ONCE when the driver hits INIT
//FIX private DigitalChannel armBack = null;
   @Override
   public void init() {
       telemetry.addData("Status", "Initialized");
       //Init all motor properties. Below is the manual code in case of problems. Remove comments to
       //activate the backup set.
   //robot.init(hwMap);
//  ↓ Remove to activate
   
       // Assign the devices variables. Note that the text used here as parameters
       // to 'get' must be the same names assigned using the FTC Robot Controller app on the phone
       leftdrive  = hardwareMap.get(DcMotor.class, "leftdrive");
       rightdrive = hardwareMap.get(DcMotor.class, "rightdrive");
       spinner = hardwareMap.get(DcMotor.class, "spinner");
    claw = hardwareMap.servo.get("claw");
    duck = hardwareMap.get(DcMotor.class, "duck");
    Arm = hardwareMap.get(DcMotor.class, "Arm");
   //FIX armBack = hardwareMap.get(DigitalChannel.class, "armBack");
       // Most robots need the motor on one side to be reversed to drive forward
       // Reverse the motor that runs backwards when connected directly to the battery
       leftdrive.setDirection(DcMotor.Direction.REVERSE);
       rightdrive.setDirection(DcMotor.Direction.REVERSE);
       spinner.setDirection(DcMotor.Direction.REVERSE);
      claw.setDirection(Servo.Direction.FORWARD);
      duck.setDirection(DcMotor.Direction.FORWARD);
      Arm.setDirection(DcMotor.Direction.FORWARD);
    //FIX armBack.setMode(DigitalChannel.Mode.INPUT);
       // Tell the driver that initialization is complete.
       telemetry.addData("Status", "Initialized");
   }
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
      
//duck
  boolean Right = false;

if (gamepad2.dpad_right){
duck.setPower(1);
Right = true;
} else if (Right = true) {
duck.setPower(0);
Right = false;
}
if (gamepad2.dpad_left){
duck.setPower(-1);
} else if (Right = false) {
duck.setPower(0);
}
//LIFT ARM

//down
if (gamepad2.a){
Arm.setPower(-0.5);
   }
  else {
Arm.setPower(0);  
  }
   if (gamepad2.y){
Arm.setPower(0.5);
   }
  else {
Arm.setPower(0);  

//Claw servo

//Open
if (gamepad2.right_bumper){
claw.setPosition(.54);
}
//Closed
if (gamepad2.left_bumper){
claw.setPosition(0);
} 

//digital touch ARM IS BACK ALL THE WAY (FIX)
//if (armBack.getState() == true) {
//claw.setPosition(0);
//}

//send calculated power to wheels
leftdrive.setPower(leftPower);
rightdrive.setPower(rightPower);

 // Show the elapsed game time
telemetry.addData("Status", "Run Time: " + runtime.toString());
// Show the Power status of the motors
telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
   }
 

}}