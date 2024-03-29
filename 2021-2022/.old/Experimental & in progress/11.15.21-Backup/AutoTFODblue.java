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

@Autonomous(name = "HubWithCameraTEST")
//@Disabled
public class HubWithCameraTEST extends LinearOpMode {
    
    private DcMotorEx leftdrive = null;
    private DcMotorEx rightdrive = null;
    private DcMotorEx spinner = null;
    private Servo claw = null;
    private DcMotorEx duck = null;
    private DcMotorEx Arm;
    private TouchSensor armBack; 
     boolean isDuckDetected = false;
    RevBlinkinLedDriver led;
    float dpos = -1;
    float loc = -1; 
  /* Note: This sample uses the all-objects Tensor Flow model (FreightFrenzy_BCDM.tflite), which contains
   * the following 4 detectable objects
   *  0: Ball,
   *  1: Cube,
   *  2: Duck,
   *  3: Marker (duck location tape marker)
   *
   *  Two additional model assets are available which only contain a subset of the objects:
   *  FreightFrenzy_BC.tflite  0: Ball,  1: Cube
   *  FreightFrenzy_DM.tflite  0: Duck,  1: Marker
   */
    private static final String TFOD_MODEL_ASSET = "FreightFrenzy_DM.tflite";
    private static final String[] LABELS = {
    "Duck"
    };
    
    private static final String VUFORIA_KEY =
            "AYqql+L/////AAABmRBgznBQ0U15s7TkodZqkxIYy2w494atPUoLmlfg5Z2OQDD/CzfeBSr3vrfpje/YCS+P5QXnxBwu/2NCATd1Zo5XJG0ALUeQP4h/BcfeH6+y03HltttQ+174uO/NdQ8gBF8fwztTloDL0gsBnoXhElWff91TN2030MqpO0ujAPitC/hSheycvzk5SKx20XzmjzG6z3+ZMWIi8CZxws7g9kzWdtSfEnPqSxjbDmQY/NvVNYRHWl3GEl3RVIB0pWBOBVCFuacIRYD0TsG6WvPq5w/v9pmM4DQ4uFPCCI/ktuujuf/3ye16C1TNhDkUYGXTqGHg24GJy66dtaoKzdX1x6QtaOkqi8YxVit2pC671+fJ";

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
    public void runOpMode() {
        //init devices
         leftdrive  = hardwareMap.get(DcMotorEx.class, "leftdrive");
       rightdrive = hardwareMap.get(DcMotorEx.class, "rightdrive");
       spinner = hardwareMap.get(DcMotorEx.class, "spinner");
    claw = hardwareMap.servo.get("claw");
    duck = hardwareMap.get(DcMotorEx.class, "duck");
    Arm = hardwareMap.get(DcMotorEx.class, "Arm");
    armBack = hardwareMap.get(TouchSensor.class, "armBack");
    led = hardwareMap.get(RevBlinkinLedDriver.class , "led");
    
    
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

            // The TensorFlow software will scale the input images from the camera to a lower resolution.
            // This can result in lower detection accuracy at longer distances (> 55cm or 22").
            // If your target is at distance greater than 50 cm (20") you can adjust the magnification value
            // to artificially zoom in to the center of image.  For best results, the "aspectRatio" argument
            // should be set to the value of the images used to create the TensorFlow Object Detection model
            // (typically 16/9).
            tfod.setZoom(1, 16.0/9.0);
        }

        /** Wait for the game to begin */
        telemetry.addData(">", "Press Play to start op mode");
        telemetry.addData("Motor Status:", "Reset Encoders");
        leftdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightdrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        duck.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        Arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        spinner.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
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
                        
                            // check label to see if the camera now sees a Duck
                        if (recognition.getLabel().equals("Duck")) {            
                             isDuckDetected = true;                             
                             telemetry.addData("Object Detected", "Duck");
                             led.setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);
                         } else {                                               
                             isDuckDetected = false;  
                            led.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLACK);
                         }
                         dpos = recognition.getLeft();
                        if (dpos < 150 && dpos > 0){
                        telemetry.addData("1 OR 4 DICE ROLL" , "(LEFT)");
                        loc = 0;
                        vuforia.setFrameQueueCapacity(0);
                            }
                        if (dpos < 300 && dpos > 170){
                        telemetry.addData("2 OR 5 DICE ROLL" , "(MIDDLE)");
                        loc = 1;
                        vuforia.setFrameQueueCapacity(0);
                        }
                        if (dpos < 500  && dpos > 370){
                         loc = 2;
                        telemetry.addData("3 OR 6 DICE ROLL" , "(RIGHT)");
                        vuforia.setFrameQueueCapacity(0);
                        }
                        telemetry.update();
                    
                      }
                      telemetry.update();
                      
                    }
                }
            }
            
        }
        //where to put this code (not actual code just example)
            leftdrive.setTargetPosition(1000);
            rightdrive.setTargetPosition(1000);
            leftdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightdrive.setVelocity(1000);
            leftdrive.setVelocity(1000);
            
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


