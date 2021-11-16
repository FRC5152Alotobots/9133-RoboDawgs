public class BlueB-Mid {
//MAY NEED TO ADD DMAP PREFIX TO MOTOR CMDS "ahw"
public void BlueBmid() throws InterruptedException {
telemetry.addData("Running class:" , "BlueB-Mid")
telemetry.update();
        // Reset the encoder during initialization
        leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        duck.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        Arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        spinner.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        waitForStart();
        claw.setPosition(0);
    thread.sleep(2000);
    
    
// Set the motor's target position to 300 ticks
        leftdrive.setTargetPosition(1050);
        rightdrive.setTargetPosition(-1050);
    
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        leftdrive.setVelocity(500);
        rightdrive.setVelocity(500);
        
            while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();}
        
             leftdrive.setTargetPosition(550);
        rightdrive.setTargetPosition(-1120);
        
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        leftdrive.setVelocity(500);
        rightdrive.setVelocity(500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();}
        
      //set arm pos
        Arm.setTargetPosition(300);

        // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);

        
        while(Arm.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();
}
//reset for drive
leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//drive forward at a angle

leftdrive.setTargetPosition(520);
rightdrive.setTargetPosition(-475);
        
// Switch to RUN_TO_POSITION mode
leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
// Start the motor moving by setting the max velocity to 200 ticks per second
leftdrive.setVelocity(500);
rightdrive.setVelocity(500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();}
 
 
spinner.setTargetPosition(1000);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(500);

while(spinner.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();
}
claw.setPosition(0.14);
sleep(1000);
spinner.setTargetPosition(0);
spinner.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
spinner.setVelocity(500);

 
//reverse a little
leftdrive.setTargetPosition(-500);
rightdrive.setTargetPosition(500);
 
       
// Switch to RUN_TO_POSITION mode
leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
// Start the motor moving by setting the max velocity to 200 ticks per second
leftdrive.setVelocity(500);
rightdrive.setVelocity(500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();}
 //arm down
    Arm.setTargetPosition(0);
    
    while(Arm.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();}

        // Switch to RUN_TO_POSITION mode
        Arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
      //set vel of arm
        Arm.setVelocity(800);
 
//reverse into wh
leftdrive.setTargetPosition(-1200);
rightdrive.setTargetPosition(1000);
 
       
// Switch to RUN_TO_POSITION mode
leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
// Start the motor moving by setting the max velocity to 200 ticks per second
leftdrive.setVelocity(500);
rightdrive.setVelocity(500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();}
//set target pos 2
duck.setTargetPosition(2000);
 
duck.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//set target 2 speed
 duck.setVelocity(2000);

 while(duck.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to finish spin");
 telemetry.update();
}

leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        // Set the motor's target position to 300 ticks
        leftdrive.setTargetPosition(500);
        rightdrive.setTargetPosition(500);
        
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        leftdrive.setVelocity(1500);
        rightdrive.setVelocity(1500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();
}
        leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
         leftdrive.setTargetPosition(500);
        rightdrive.setTargetPosition(-500);
        
        // Switch to RUN_TO_POSITION mode
        leftdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightdrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        // Start the motor moving by setting the max velocity to 200 ticks per second
        leftdrive.setVelocity(500);
        rightdrive.setVelocity(-500);
        
        while(leftdrive.isBusy()) {
 // Let the drive team see that we're waiting on the motor
 telemetry.addData("Status", "Waiting for the motor to reach its target");
 telemetry.update();}

        // While the Op Mode is running, show the motor's status via telemetry
        while (opModeIsActive()) {
            //telemetry.addData("Left drive velocity", leftdrive.getVelocity());
            //telemetry.addData("Right drive velocity", rightdrive.getVelocity());
            telemetry.addData("Arm position", Arm.getCurrentPosition());
            telemetry.addData("Left drive position", leftdrive.getCurrentPosition());
            telemetry.addData("Right drive position", rightdrive.getCurrentPosition());
            telemetry.addData("is at target", !leftdrive.isBusy());
            telemetry.update();
        }
    }
} 