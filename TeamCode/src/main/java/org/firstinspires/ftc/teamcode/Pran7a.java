package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Pran:)7a")
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

        double d ;
        double s ;
        double r ;



        while (opModeIsActive()) {
            d = gamepad1.left_stick_y;
            s = gamepad1.left_stick_x;
            r = gamepad1.right_stick_y;


            if (gamepad1.left_stick_y >= -0.2) {
                fl.setPower(d);
                fr.setPower(d);
                bl.setPower(d);
                br.setPower(d);
            } else {
                fl.setPower(0);
                fr.setPower(0);
                bl.setPower(0);
                br.setPower(0);
            }

            if (gamepad1.left_stick_y >= 0.2) {
                fl.setPower(-d);
                fr.setPower(-d);
                bl.setPower(-d);
                br.setPower(-d);
            } else {
                fl.setPower(0);
                fr.setPower(0);
                bl.setPower(0);
                br.setPower(0);
            }

            if (gamepad1.left_stick_x >= -0.2) {
                fl.setPower(-s);
                fr.setPower(s);
                bl.setPower(s);
                br.setPower(-s);
            } else {
                fl.setPower(0);
                fr.setPower(0);
                bl.setPower(0);
                br.setPower(0);
            }

            if (gamepad1.left_stick_x >= 0.2) {
                fl.setPower(s);
                fr.setPower(-s);
                bl.setPower(-s);
                br.setPower(s);
            } else {
                fl.setPower(0);
                fr.setPower(0);
                bl.setPower(0);
                br.setPower(0);
            }

            if (gamepad1.right_stick_x >= 0.2) {
                fl.setPower(r);
                fr.setPower(-r);
                bl.setPower(r);
                br.setPower(-r);
            } else {
                fl.setPower(0);
                fr.setPower(0);
                bl.setPower(0);
                br.setPower(0);
            }

            if (gamepad1.right_stick_x >= -0.2) {
                fl.setPower(-r);
                fr.setPower(r);
                bl.setPower(-r);
                br.setPower(r);
            } else {
                fl.setPower(0);
                fr.setPower(0);
                bl.setPower(0);
                br.setPower(0);
            }
        }
    }
}