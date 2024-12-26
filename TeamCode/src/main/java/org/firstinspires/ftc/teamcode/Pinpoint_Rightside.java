package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

import java.util.Locale;

@Autonomous(name = "PinpointRightside")

public class Pinpoint_Rightside extends LinearOpMode {
    DcMotor frontLeft, frontRight, backLeft, backRight;
    GoBildaPinpointDriver odo;
    double dummyvalue= 99999999;

    @Override
    public void runOpMode() {
        // Initialize Motors
        frontLeft = hardwareMap.get(DcMotor.class, "fl");
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontRight = hardwareMap.get(DcMotor.class, "fr");
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        backLeft = hardwareMap.get(DcMotor.class, "bl");
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        backRight = hardwareMap.get(DcMotor.class, "br");
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        resetEncoders();

        // Initialize Pinpoint IMU module
        odo = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");
        odo.setOffsets(-84.0, 0.0);
        odo.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        odo.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);
        odo.resetPosAndIMU();

        telemetry.addData("Status", "Initialized");
        telemetry.addData("X offset", odo.getXOffset());
        telemetry.addData("Y offset", odo.getYOffset());
        telemetry.update();

        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            odo.update();
            Pose2D pos = odo.getPosition();
            String data = String.format(Locale.US, "{X: %.3f, Y: %.3f, H: %.3f}", pos.getX(DistanceUnit.MM), pos.getY(DistanceUnit.MM), pos.getHeading(AngleUnit.DEGREES));
            telemetry.addData("starting Position", data);

            // Move forward 100cm
            drivetoPosition(100, dummyvalue, 0);

            // Move left side 100cm
            drivetoPosition(dummyvalue, 1000, 0);

            drivetoPosition(1000, dummyvalue, 0);

            //drivetoPosition(dummyvalue, dummyvalue, 90);

            drivetoPosition(dummyvalue, 100, 0);

            drivetoPosition(-1200, dummyvalue, 0);

            drivetoPosition(1200, dummyvalue, 0);

            drivetoPosition(dummyvalue, 100, 0);

            drivetoPosition(-1200, dummyvalue, 0);

            drivetoPosition(1200, dummyvalue, 0);

            drivetoPosition(dummyvalue, 100, 0);

            drivetoPosition(-1200, dummyvalue, 0);

            drivetoPosition(1200, dummyvalue, 0);

        }
        stopMotors();
    }

    void drivetoPosition(double xoffset, double yoffset, int angle) {
        double last_Xpos, last_Ypos, last_Hpos;
        double exp_Xpos, exp_Ypos, exp_Hpos;
        double head_dev = 2.0;

        Pose2D curpos = odo.getPosition();
        // store current robot position to last position
        last_Xpos = curpos.getX(DistanceUnit.MM);
        last_Ypos = curpos.getY(DistanceUnit.MM);
        last_Hpos = curpos.getHeading(AngleUnit.DEGREES);


        // Check whether we need to move forward or backward based on xoffset
        // xoffset = dummyvale -> don't consider the xoffset value
        if (xoffset != dummyvalue) {
            // calculate expected new X position
            exp_Xpos = last_Xpos + xoffset;

            if (xoffset >= 0) {
                // positive xoffset value so move the robot forward
                setMotorPower(0.1);
                while (opModeIsActive() && odo.getPosX() < exp_Xpos) {
                    telemetry.addData("Moving Forward", "Target: %f", exp_Xpos);
                    telemetry.update();
                }
            } else if (xoffset < 0) {
                // negative xoffset value so move the robot backward
                setMotorPower(-0.1);
                while (opModeIsActive() && odo.getPosX() > exp_Xpos) {
                    telemetry.addData("Moving Backward", "Target: %f", exp_Xpos);
                    telemetry.update();
                }
            }
            stopMotors();
        } else {
            // since we are not moving in x co-ordinate
            // set expected new X position as last position
            exp_Xpos = last_Xpos;
        }

        // Check whether we need to move left or rightside based on yoffset
        // yoffset = dummyvalue -> don't consider the yoffset value
        if (yoffset != dummyvalue) {
            // calculate expected new Y position
            exp_Ypos = last_Ypos + yoffset;
            if (yoffset >= 0) {
                // positive yoffset value so move the robot to left side
                setMotorPower(-0.1,0.1, 0.1, -0.1);
                while (opModeIsActive() && odo.getPosY() < exp_Ypos) {
                    telemetry.addData("Moving Left", "Target: %f", exp_Ypos);
                    telemetry.update();
                }
            } else if (yoffset < 0) {
                // negative yoffset value so move the robot to right side
                setMotorPower(0.1, -0.1, -0.1, 0.1);
                while (opModeIsActive() && odo.getPosY() > exp_Ypos) {
                    telemetry.addData("Moving Right", "Target: %f", exp_Ypos);
                    telemetry.update();
                }
            }
            stopMotors();
        } else {
            // since we are not moving in  Y co-ordinate
            // set expected new Y position as last position
            exp_Ypos = last_Ypos;
        }
        if (angle != 0) {
            //exp_Hpos = last_Hpos + angle - head_dev;
            exp_Hpos = last_Hpos + angle - 2;
            if (angle > 0 ) {
                // set power to move robot for left side turn
                setMotorPower(-0.1, -0.1, 0.1, 0.1);
                while (opModeIsActive() && odo.getHeading() < exp_Hpos) {
                    telemetry.addData("Turning Left", "Target: %f", exp_Ypos);
                    telemetry.update();
                }
            } else if (angle < 0) {
                // set power to move robot for right side turn
                setMotorPower(0.1, 0.1, -0.1, -0.1);
                while (opModeIsActive() && odo.getHeading() > exp_Hpos) {
                    telemetry.addData("Turning Right", "Target: %f", exp_Ypos);
                    telemetry.update();
                }
            }
            stopMotors();
        } else {
            exp_Hpos = last_Hpos;
        }
    }

    // Function used to set motor power for moving robot forward and backward
    private void setMotorPower(double power) {
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }

    // Function used to set motor power for turn robot to an angle
    private void setMotorPower(double leftPower, double rightPower) {
        frontLeft.setPower(leftPower);
        backLeft.setPower(leftPower);
        frontRight.setPower(rightPower);
        backRight.setPower(rightPower);
    }

    // Function used to set motor power to move robot sideways
    private void setMotorPower(double flPower, double blPower, double frPower, double brPower) {
        frontLeft.setPower(flPower);
        backLeft.setPower(blPower);
        frontRight.setPower(frPower);
        backRight.setPower(brPower);
    }

    private void stopMotors() {
        setMotorPower(0);
    }

    private void resetEncoders() {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}
