package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name = "LinTest! w/2")
public class LinearSlideOp extends LinearOpMode {

    DcMotor fl = null;
    DcMotor fr = null;

    @Override
    public void runOpMode() throws InterruptedException {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");

        fl.setDirection(DcMotorSimple.Direction.REVERSE);

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fl.setPower(0);
        fr.setPower(0);

        waitForStart();

        while (opModeIsActive()) {

            while (gamepad1.dpad_up) {
                fl.setPower(0.25);
                fr.setPower(0.25);
            }

            while (gamepad1.dpad_down) {
                fl.setPower(-0.25);
                fr.setPower(-0.25);
            }

            fl.setPower(0);
            fr.setPower(0);
        }
    }
}