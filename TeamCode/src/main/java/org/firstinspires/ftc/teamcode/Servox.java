package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp (name="ServoPran")
public class Servox extends LinearOpMode {
    Servo servo1;
    @Override
    public void runOpMode() throws InterruptedException {
        servo1 = hardwareMap.get(Servo.class, "servo1");
        waitForStart();
        while (opModeIsActive()){
            if (gamepad1.a) {
                servo1.setPosition(1);
            }
        }
    }
}
