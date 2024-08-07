package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous (name = "Pran:)7a")
public class Pran7a extends LinearOpMode {
    DcMotor fl = null;
    DcMotor fr = null;
    DcMotor bl = null;
    DcMotor br = null;


    @Override
    public void runOpMode() throws InterruptedException {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");

        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection(DcMotorSimple.Direction.REVERSE);
        fr.setDirection(DcMotorSimple.Direction.FORWARD);
        br.setDirection(DcMotorSimple.Direction.FORWARD);

        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);

        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.left_stick_y >= -0.2) {
                fl.setPower(0.5);
                fr.setPower(0.5);
                bl.setPower(0.5);
                br.setPower(0.5);
            } else {
                fl.setPower(0);
                fr.setPower(0);
                bl.setPower(0);
                br.setPower(0);
            }

            if (gamepad1.left_stick_y >= 0.2) {
                fl.setPower(-0.5);
                fr.setPower(-0.5);
                bl.setPower(-0.5);
                br.setPower(-0.5);
            } else {
                fl.setPower(0);
                fr.setPower(0);
                bl.setPower(0);
                br.setPower(0);
            }

            if (gamepad1.left_stick_x >= -0.2) {
                fl.setPower(-0.5);
                fr.setPower(0.5);
                bl.setPower(0.5);
                br.setPower(-0.5);
            } else {
                fl.setPower(0);
                fr.setPower(0);
                bl.setPower(0);
                br.setPower(0);
            }

            if (gamepad1.left_stick_x >= 0.2) {
                fl.setPower(0.5);
                fr.setPower(-0.5);
                bl.setPower(-0.5);
                br.setPower(0.5);
            } else {
                fl.setPower(0);
                fr.setPower(0);
                bl.setPower(0);
                br.setPower(0);
            }

            if (gamepad1.right_stick_x >= 0.2) {
                fl.setPower(0.5);
                fr.setPower(-0.5);
                bl.setPower(0.5);
                br.setPower(-0.5);
            } else {
                fl.setPower(0);
                fr.setPower(0);
                bl.setPower(0);
                br.setPower(0);
            }

            if (gamepad1.right_stick_x >= -0.2) {
                fl.setPower(-0.5);
                fr.setPower(0.5);
                bl.setPower(-0.5);
                br.setPower(0.5);
            } else {
                fl.setPower(0);
                fr.setPower(0);
                bl.setPower(0);
                br.setPower(0);
            }
        }
    }
}