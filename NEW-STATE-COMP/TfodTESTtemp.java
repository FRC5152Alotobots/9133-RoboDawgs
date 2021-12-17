package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.RobotLog;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Autonomous(name = "AutoTFoDBlueB-HM" , group = "TFOD BLUE")
//@Disabled
public class TfodTESTtemp extends LinearOpMode {
    private static final String TFOD_MODEL_FILE = "/sdcard/FIRST/tflitemodels/detect_v2.tflite";
    private static final String TFOD_MODEL_LABELS = "/sdcard/FIRST/tflitemodels/label.txt";
    private String[] labels;

DmapAutoBlue ahw = new DmapAutoBlue(); 
private ElapsedTime runtime = new ElapsedTime();
//local vars
boolean isDuckDetected = false;
float dpos = -1;
boolean dtc = false;


    private static final String VUFORIA_KEY =
            "AcDUHgP/////AAABmUftIp+4wU0MjlXQTngOYdWBkgSPf0WeR0r5SpGlcLSTNSTvFABVgKGwtzwk3kvp+OoKsCB5dy6ghVPMdJtbt8sqN8qsRMooX5VznbUd5ttKF2LWbx8cEUeJCO5a/XObDRvP1j5Rsbd/nHSQfdHboE65uQEtOt2Qi1X34+LA4QQDi3bdVHDN312zEGjhj7Sj4XunrgAMfQZ3Da6fNuOlJbDAgAB9BTPn8UMd5oR1SW9LbMuQZQuc2bhueMhN+ch+7LXaKuDmsXYGfQuWOpVVF4SMUBRL+QTA5RwDVgML6dKhQCHfbY+ffFIHV29K4FV77S3vE3w8ThUn0I8guItzUWWayo1GTCSs6zc153MrEB+u";
            
    private VuforiaLocalizer vuforia;

    private TFObjectDetector tfod;

    @Override
    public void runOpMode() throws InterruptedException {

        // read the label map text files.
        readLabels();
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
            // Uncomment the following line if you want to adjust the magnification and/or the aspect ratio of the input images.
            //tfod.setZoom(2.5, 1.78);
        }

        /** Wait for the game to begin */
        telemetry.addData(">", "Press Play to start op mode");
        telemetry.addData("Motor Status:", "Reset Encoders");
        ahw.resetEncoders();
        waitForStart();
        dtc = false; //reset detection
        runtime.reset();
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                
                //failsafe
                if (dtc == false){
                if (runtime.seconds() > 5){
                    telemetry.addData("FAILSAFE ACTIVATED" , "This happens if the marker is in a position that the camera cannot see.");
                        telemetry.addData("1 OR 4 DICE ROLL" , "(LEFT)");
                        telemetry.addData("Running class:" , "BlueBHigh");
                        telemetry.update();
                        ahw.led.setPattern(RevBlinkinLedDriver.BlinkinPattern.RED);
                        sleep(200);
                        dtc = true;
                        vuforia.setFrameQueueCapacity(0);
                        tfod.shutdown();
                        
                        ahw.BlueBHighHM();
                        //add a dif class that runs dif code
                        }
                }
                
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
                      
                                //i++;
                                
                                //logic for levels
                                // check label to see if the camera now sees a Duck
                        if (recognition.getLabel().equals("TSE")) {            
                             telemetry.addData("Object Detected", "TSE");
                         }

                         //check position from the left side of the screen for the duck
                         dpos = recognition.getLeft();
                         
                        //check if code has been run yet
                        if (dtc == false){
                        //middle pos
                        if (dpos < 349 && dpos > 300){
                        telemetry.addData("2 OR 5 DICE ROLL" , "(MIDDLE)");
                        telemetry.addData("Running class:" , "BlueBmid");
                        telemetry.update();
                        ahw.led.setPattern(RevBlinkinLedDriver.BlinkinPattern.YELLOW);
                        sleep(200);
                        dtc = true;
                        vuforia.setFrameQueueCapacity(0);
                        tfod.shutdown();
                        //mid class
                        ahw.BlueBmidHM();
                        }
                        if (dpos < 290  && dpos > 100){
                        telemetry.addData("3 OR 6 DICE ROLL" , "(RIGHT)");
                        telemetry.addData("Running class:" , "BlueBLow");
                        telemetry.update();
                        ahw.led.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLUE);
                        sleep(200);
                        dtc = true;
                        vuforia.setFrameQueueCapacity(0);
                        tfod.shutdown();
                        //low class
                        ahw.BlueBlowHM();
                        }
                      }
                        }
                      telemetry.update();
                    }
                }
            }
        }

        if (tfod != null) {
            tfod.shutdown();
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

        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
    }

    /**
     * Initialize the TensorFlow Object Detection engine.
     */
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
            "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.6f;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        if(labels != null) {
            tfod.loadModelFromFile(TFOD_MODEL_FILE, labels);
        }
    }
    
    /**
     * Read the labels for the object detection model from a file.
     */
    private void readLabels() {
        ArrayList<String> labelList = new ArrayList<>();
        
        // try to read in the the labels.
        try (BufferedReader br = new BufferedReader(new FileReader(TFOD_MODEL_LABELS))) {
            int index = 0;
            while (br.ready()) {
                // skip the first row of the labelmap.txt file.
                // if you look at the TFOD Android example project (https://github.com/tensorflow/examples/tree/master/lite/examples/object_detection/android)
                // you will see that the labels for the inference model are actually extracted (as metadata) from the .tflite model file
                // instead of from the labelmap.txt file. if you build and run that example project, you'll see that
                // the label list begins with the label "person" and does not include the first line of the labelmap.txt file ("???").
                // i suspect that the first line of the labelmap.txt file might be reserved for some future metadata schema
                // (or that the generated label map file is incorrect).
                // for now, skip the first line of the label map text file so that your label list is in sync with the embedded label list in the .tflite model.
                if(index == 0) {
                    // skip first line.
                    br.readLine();
                } else {
                    labelList.add(br.readLine());
                }
                index++;
            }
        } catch (Exception e) {
            telemetry.addData("Exception", e.getLocalizedMessage());
            telemetry.update();
        }

        if (labelList.size() > 0) {
            labels = getStringArray(labelList);
            RobotLog.vv("readLabels()", "%d labels read.", labels.length);
            for (String label : labels) {
                RobotLog.vv("readLabels()", " " + label);
            }
        } else {
            RobotLog.vv("readLabels()", "No labels read!");
        }
   }

    // Function to convert ArrayList<String> to String[]
    private String[] getStringArray(ArrayList<String> arr)
    {
        // declaration and initialize String Array
        String str[] = new String[arr.size()];

        // Convert ArrayList to object array
        Object[] objArr = arr.toArray();

        // Iterating and converting to String
        int i = 0;
        for (Object obj : objArr) {
            str[i++] = (String)obj;
        }

        return str;
    }
}


