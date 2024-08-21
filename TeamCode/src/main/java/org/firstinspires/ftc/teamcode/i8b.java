package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Pran8b")
public class i8b extends LinearOpMode {
    DcMotor fl = null;
    DcMotor fr = null;
    DcMotor bl = null;
    DcMotor br = null;


    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Init_Success");
        telemetry.setMsTransmissionInterval(100);
        telemetry.update();

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

        double d;
        double s;
        double r;

        double flp, frp, blp, brp;

        while (opModeIsActive()) {
            d = gamepad1.left_stick_y * -1;
            s = gamepad1.left_stick_x;
            r = gamepad1.right_stick_x;

            flp = d + r + s;
            frp = d - r - s;
            blp = d + r - s;
            brp = d - r + s;

            double maxf = Math.max((Math.abs(flp)), (Math.abs(frp)));
            double maxb = Math.max((Math.abs(blp)), (Math.abs(brp)));
            double maxfb = Math.max((Math.abs(maxf)), (Math.abs(maxb)));

            if (maxfb > 0.9) {
                flp = flp/maxfb;
                frp = frp/maxfb;
                blp = blp/maxfb;
                brp = brp/maxfb;
            }

            fl.setPower(flp);
            fr.setPower(frp);
            bl.setPower(blp);
            br.setPower(brp);

            telemetry.addLine();
                telemetry.addData("fl_position", String.valueOf(fl.getCurrentPosition()), "fr_position", fr.getCurrentPosition());
                telemetry.addData("bl_position", String.valueOf(bl.getCurrentPosition()), "br_position", br.getCurrentPosition());
            telemetry.addLine();
                telemetry.addData("fl_speed", "%.2f", flp);
                telemetry.addData("fr_speed", "%.2f", frp);
                telemetry.addData("bl_speed", "%.2f", blp);
                telemetry.addData("br_speed", "%.2f", brp);
            telemetry.update();
        }
    }
}