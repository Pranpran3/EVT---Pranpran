package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name = "PRANPRANTASK4")

public class task4 extends OpMode {

    DcMotor motor_name;

    @Override
    public void init() {
        motor_name = hardwareMap.get(DcMotor.class, "motor1");
    }

    @Override
    public void loop() {
        boolean lb = gamepad1.left_bumper;

        if (lb) {
            motor_name.setPower(1);
        }else{
            motor_name.setPower(0);
        }
    }
}
