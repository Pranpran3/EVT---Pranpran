package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class ArmPivot extends LinearOpMode {

    DcMotor fl = null;

    @Override
    public void runOpMode() throws InterruptedException {

        fl = hardwareMap.get(DcMotor.class, "bl");

        fl.setPower(0);

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        while (opModeIsActive()) {
            if(gamepad1.a) {
                fl.setTargetPosition(-1000);
                fl.setPower(0.3);
            }
            if(gamepad1.x) {
                fl.setTargetPosition(-625);
                fl.setPower(0.2);
            }
            if(gamepad1.b) {
                fl.setTargetPosition(0);
                fl.setPower(0.1);
            }
            if(gamepad1.y) {
                fl.setTargetPosition(-750);
                fl.setPower(0.05);
            }
        }
    }
}