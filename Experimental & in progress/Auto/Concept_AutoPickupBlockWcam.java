package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.TouchSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous(name = "AutoTFODblueB")
//@Disabled
public class AutoTFODblueB extends LinearOpMode {

//makes a copy of the code in the file DmapAuto to run in this file
DmapAutoBlue ahw = new DmapAutoBlue(); 
//local vars
boolean isCubeDetected = false;
float dpos = -1;
boolean dtc = false;
    private static final String TFOD_MODEL_ASSET = "FreightFrenzy_BC.tflite";
    private static final String[] LABELS = {
    "Cube"
    };
    
    private static final String VUFORIA_KEY =
            "AcDUHgP/////AAABmUftIp+4wU0MjlXQTngOYdWBkgSPf0WeR0r5SpGlcLSTNSTvFABVgKGwtzwk3kvp+OoKsCB5dy6ghVPMdJtbt8sqN8qsRMooX5VznbUd5ttKF2LWbx8cEUeJCO5a/XObDRvP1j5Rsbd/nHSQfdHboE65uQEtOt2Qi1X34+LA4QQDi3bdVHDN312zEGjhj7Sj4XunrgAMfQZ3Da6fNuOlJbDAgAB9BTPn8UMd5oR1SW9LbMuQZQuc2bhueMhN+ch+7LXaKuDmsXYGfQuWOpVVF4SMUBRL+QTA5RwDVgML6dKhQCHfbY+ffFIHV29K4FV77S3vE3w8ThUn0I8guItzUWWayo1GTCSs6zc153MrEB+u";

    /**
     * {@link #vuforia} is the variable we will use to store our instance of the Vuforia
     * localization engine.
     */
    private VuforiaLocalizer vuforia;

    /**
     * {@link #tfod} is the variable we will use to store our instance of the TensorFlow Object
     * Detection engine.
     */
    private TFObjectDetector tfod;

    @Override
    public void runOpMode() throws InterruptedException{
        //init devices from a file called DmapAuto using the copy made earlier
    ahw.init(hardwareMap);

        // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
        // first.
        initVuforia();
        initTfod();

        /**
         * Activate TensorFlow Object Detection before we wait for the start command.
         * Do it here so that the Camera Stream window will have the TensorFlow annotations visible.
         **/
        if (tfod != null) {
            tfod.activate();
        }

        /** Wait for the game to begin */
        telemetry.addData(">", "Press Play to start op mode");
        telemetry.addData("Motor Status:", "Reset Encoders");
        ahw.resetEncoders();
        waitForStart();

        if (opModeIsActive()) {
            while (opModeIsActive()) {
                if (tfod != null) {
                    // getUpdatedRecognitions() will return null if no new information is available since
                    // the last time that call was made.
                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                    if (updatedRecognitions != null) {
                      telemetry.addData("# Object Detected", updatedRecognitions.size());
                      // step through the list of recognitions and display boundary info.
                      int i = 0;
                      for (Recognition recognition : updatedRecognitions) {
                        telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
                        telemetry.addData(String.format("  left,top (%d)", i), "%.03f , %.03f",
                                recognition.getLeft(), recognition.getTop());
                        telemetry.addData(String.format("  right,bottom (%d)", i), "%.03f , %.03f",
                                recognition.getRight(), recognition.getBottom());
                        i++;
                        
                            // check label to see if the camera now sees a Cube
                        if (recognition.getLabel().equals("Cube")) {            
                             isCubeDetected = true;                             
                             telemetry.addData("Object Detected", "Cube");
                             ahw.led.setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);
                         } else {                                               
                             isCubeDetected = false;  
                            ahw.led.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLACK);
                         }


                         //check position from the left side of the screen for the cube
                         dpos = recognition.getLeft();
                         if (dtc == false){
                        if (dpos == -1){
                        telemetry.addData("Automatic Navigation in progress >" , "Status: Turning LEFT until detection");
                        telemetry.update();
                        //sleep(1000);
                        //dtc = true;
                        //vuforia.setFrameQueueCapacity(0);
                        //tfod.shutdown();
                        //add a dif class that runs dif code
                            }
                        
                        //middle/aligned
                        if (dpos < 349 && dpos > 0){
                        telemetry.addData("Automatic Navigation in progress >" , "Status: ALIGNED - Starting drive");
                        telemetry.update();
                        //sleep(1000);
                        //dtc = true;
                        //vuforia.setFrameQueueCapacity(0);
                        //tfod.shutdown();
                        rightdrive.setPower(.5);
                        leftdrive.setPower(.5);
                        telemetry.addData("Automatic Navigation in progress >" , "Status: Re-evaluation in progress");
                        telemetry.update();
                        }
                        //right side un-aligned
                        if (dpos < 550  && dpos > 350){
                        telemetry.addData("Automatic Navigation in progress >" , "Status: Un-aligned on right - Starting turn LEFT");
                        telemetry.update();
                        //sleep(1000);
                        //dtc = true;
                        //vuforia.setFrameQueueCapacity(0);
                        //tfod.shutdown();

                        //turn left until if statement fails
                        rightdrive.setPower(.5);
                        }
                         }
                      }
                      telemetry.update();
                      
                    }
                }
            }
        }           
    }

    /**
     * Initialize the Vuforia localization engine.
     */
    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);
    }

    /**
     * Initialize the TensorFlow Object Detection engine.
     */
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
            "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
       tfodParameters.minResultConfidence = 0.55f;
       tfodParameters.isModelTensorFlow2 = true;
       tfodParameters.inputSize = 320;
       tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
       tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABELS);
    }
    
}