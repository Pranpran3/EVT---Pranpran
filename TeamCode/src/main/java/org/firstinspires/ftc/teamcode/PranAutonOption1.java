//
//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//
//import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
//import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
//import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
//
//import java.util.Locale;
//
//@TeleOp(name="PranAutonOption1", group="Linear OpMode")
//
//
//public class PranAutonOption1 extends LinearOpMode {
//
//    GoBildaPinpointDriver odo; // Declare OpMode member for the Odometry Computer
//
//    double oldTime = 0;
//
//
//    @Override
//    public void runOpMode() {
//
//
//        odo = hardwareMap.get(GoBildaPinpointDriver.class,"pinpoint");
//
//
//        odo.setOffsets(-84.0, -168.0); //these are tuned for 3110-0002-0001 Product Insight #1
//        odo.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
//
//        /*
//        Set the direction that each of the two odometry pods count. The X (forward) pod should
//        increase when you move the robot forward. And the Y (strafe) pod should increase when
//        you move the robot to the left.
//         */
//        odo.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);
//
//
//        /*
//        Before running the robot, recalibrate the IMU. This needs to happen when the robot is stationary
//        The IMU will automatically calibrate when first powered on, but recalibrating before running
//        the robot is a good idea to ensure that the calibration is "good".
//        resetPosAndIMU will reset the position to 0,0,0 and also recalibrate the IMU.
//        This is recommended before you run your autonomous, as a bad initial calibration can cause
//        an incorrect starting value for x, y, and heading.
//         */
//        //odo.recalibrateIMU();
//        odo.resetPosAndIMU();
//
//        telemetry.addData("Status", "Initialized");
//        telemetry.addData("X offset", odo.getXOffset());
//        telemetry.addData("Y offset", odo.getYOffset());
//        telemetry.addData("Device Scalar", odo.getYawScalar());
//        telemetry.update();
//
//        // Wait for the game to start (driver presses START)
//        waitForStart();
//        resetRuntime();
//
//        // run until the end of the match (driver presses STOP)
//        while (opModeIsActive()) {
//
//            drive_to_position(
//            odo.update();
//
//            Pose2D pos = odo.getPosition();
//            String data = String.format(Locale.US, "{X: %.3f, Y: %.3f, H: %.3f}", pos.getX(DistanceUnit.MM), pos.getY(DistanceUnit.MM), pos.getHeading(AngleUnit.DEGREES));
//            telemetry.addData("Position", data);
//
//            /*
//            gets the current Velocity (x & y in mm/sec and heading in degrees/sec) and prints it.
//             */
//            Pose2D vel = odo.getVelocity();
//            String velocity = String.format(Locale.US,"{XVel: %.3f, YVel: %.3f, HVel: %.3f}", vel.getX(DistanceUnit.MM), vel.getY(DistanceUnit.MM), vel.getHeading(AngleUnit.DEGREES));
//            telemetry.addData("Velocity", velocity);
//
//
//            /*
//            Gets the Pinpoint device status. Pinpoint can reflect a few states. But we'll primarily see
//            READY: the device is working as normal
//            CALIBRATING: the device is calibrating and outputs are put on hold
//            NOT_READY: the device is resetting from scratch. This should only happen after a power-cycle
//            FAULT_NO_PODS_DETECTED - the device does not detect any pods plugged in
//            FAULT_X_POD_NOT_DETECTED - The device does not detect an X pod plugged in
//            FAULT_Y_POD_NOT_DETECTED - The device does not detect a Y pod plugged in
//            */
//            telemetry.addData("Status", odo.getDeviceStatus());
//
//            telemetry.addData("Pinpoint Frequency", odo.getFrequency()); //prints/gets the current refresh rate of the Pinpoint
//
//            telemetry.addData("REV Hub Frequency: ", frequency); //prints the control system refresh rate
//            telemetry.update();
//
//        }
//    }}
