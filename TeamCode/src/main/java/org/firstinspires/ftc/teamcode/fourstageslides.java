package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class fourstageslides extends LinearOpMode {
    DcMotor fl = null;

    @Override
    public void runOpMode() throws InterruptedException {
        fl = hardwareMap.get(DcMotor.class, "fl");

        fl.setDirection(DcMotorSimple.Direction.REVERSE);

        fl.setPower(0);

        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.a) {
                fl.setPower(0.25);
                fl.setTargetPosition(976);
                fl.wait(100);
                fl.setPower(0.25);
                fl.setTargetPosition(0);
            } else {
                fl.setPower(0);
            }
        }
    }
}
