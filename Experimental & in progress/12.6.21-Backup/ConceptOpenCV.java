package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;

/**
 * In this sample, we demonstrate how to use EasyOpenCV in
 * Vuforia passthrough mode. In this mode, EasyOpenCV does not
 * take direct control over the camera. Instead, it pulls frames
 * out of a VuforiaLocalizer's frame queue. This allows you to
 * run both OpenCV and Vuforia simultaneously on the same camera.
 * The downside is that you do not get to choose the resolution
 * of frames delivered to your pipeline, and you do not get any
 * sort of manual control over sensor parameters such as exposure,
 * gain, ISO, or frame rate.
 */
@Autonomous
public class ConceptOpenCV extends LinearOpMode
{
DmapAutoBlue ahw = new DmapAutoBlue(); 

    VuforiaLocalizer vuforia = null;
    OpenCvCamera vuforiaPassthroughCam;

    @Override
    public void runOpMode()
    {
        
        /**
         * NOTE: Many comments have been omitted from this sample for the
         * sake of conciseness. If you're just starting out with EasyOpenCV,
         * you should take a look at {@link InternalCamera1Example} or its
         * webcam counterpart, {@link WebcamExample} first.
         */

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        int[] viewportContainerIds = OpenCvCameraFactory.getInstance().splitLayoutForMultipleViewports(cameraMonitorViewId, 2, OpenCvCameraFactory.ViewportSplitMethod.VERTICALLY);

        /*
         * Setup Vuforia
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(viewportContainerIds[0]);
        parameters.vuforiaLicenseKey = "AcDUHgP/////AAABmUftIp+4wU0MjlXQTngOYdWBkgSPf0WeR0r5SpGlcLSTNSTvFABVgKGwtzwk3kvp+OoKsCB5dy6ghVPMdJtbt8sqN8qsRMooX5VznbUd5ttKF2LWbx8cEUeJCO5a/XObDRvP1j5Rsbd/nHSQfdHboE65uQEtOt2Qi1X34+LA4QQDi3bdVHDN312zEGjhj7Sj4XunrgAMfQZ3Da6fNuOlJbDAgAB9BTPn8UMd5oR1SW9LbMuQZQuc2bhueMhN+ch+7LXaKuDmsXYGfQuWOpVVF4SMUBRL+QTA5RwDVgML6dKhQCHfbY+ffFIHV29K4FV77S3vE3w8ThUn0I8guItzUWWayo1GTCSs6zc153MrEB+u";
        parameters.cameraDirection   = VuforiaLocalizer.CameraDirection.BACK;
        // Uncomment this line below to use a webcam
        //parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Create a Vuforia passthrough "virtual camera"
        vuforiaPassthroughCam = OpenCvCameraFactory.getInstance().createVuforiaPassthrough(vuforia, parameters, viewportContainerIds[1]);

        vuforiaPassthroughCam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                // Using GPU acceleration can be particularly helpful when using Vuforia passthrough
                // mode, because Vuforia often chooses high resolutions (such as 720p) which can be
                // very CPU-taxing to rotate in software. GPU acceleration has been observed to cause
                // issues on some devices, though, so if you experience issues you may wish to disable it.
                vuforiaPassthroughCam.setViewportRenderer(OpenCvCamera.ViewportRenderer.GPU_ACCELERATED);
                vuforiaPassthroughCam.setViewportRenderingPolicy(OpenCvCamera.ViewportRenderingPolicy.OPTIMIZE_VIEW);
                vuforiaPassthroughCam.setPipeline(new UselessColorBoxDrawingPipeline(new Scalar(255,0,0,255)));

                // We don't get to choose resolution, unfortunately. The width and height parameters
                // are entirely ignored when using Vuforia passthrough mode. However, they are left
                // in the method signature to provide interface compatibility with the other types
                // of cameras.
                vuforiaPassthroughCam.startStreaming(0,0, OpenCvCameraRotation.SIDEWAYS_LEFT);
            }

            @Override
            public void onError(int errorCode)
            {
                telemetry.addData("Error:" , "Switching to backup system - Level: MIDDLE");
                telemetry.update();
                /*
                 * This will be called if the camera could not be opened
                 */
            }
        });

        waitForStart();

        while (opModeIsActive())
        {
            telemetry.addData("Passthrough FPS", vuforiaPassthroughCam.getFps());
            telemetry.addData("Frame count", vuforiaPassthroughCam.getFrameCount());
            telemetry.update();

            sleep(100);
        }
    }

    class UselessColorBoxDrawingPipeline extends OpenCvPipeline
    {
        Scalar color;

        UselessColorBoxDrawingPipeline(Scalar color)
        {
            this.color = color;
        }

        @Override
        public Mat processFrame(Mat input)
        {
            Imgproc.rectangle(
                    input,
                    new Point(
                            input.cols()/4,
                            input.rows()/4),
                    new Point(
                            input.cols()*(3f/4f),
                            input.rows()*(3f/4f)),
                    color, 4);

            return input;
        }
    }
}