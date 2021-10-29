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
@TeleOp(name="BasicAUTO", group="Iterative Opmode")

//@Disabled (Tells if this program is disabled or not)

//          Program Name
public class BasicAUTO extends OpMode
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
 
//Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
   @Override
   public void init_loop() {
   }
 
//Code to run ONCE when the driver hits PLAY
   @Override
   public void start() {
leftdrive.setPower(.5);
rightdrive.setPower(.5);

leftdrive.setPower(0);
rightdrive.setPower(0);
   }
 
//Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
   @Override
   public void loop() {
}}
