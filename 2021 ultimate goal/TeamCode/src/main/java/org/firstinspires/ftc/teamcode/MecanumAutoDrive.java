package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="Class Test", group="Linear Opmode")
public class MecanumAutoDrive extends LinearOpMode {
    @Override
    public void runOpMode(){

        MecanumChassis.initialize(hardwareMap);

        waitForStart();
        while(opModeIsActive()){
            double forward = -this.gamepad1.left_stick_y;
            double turn = this.gamepad1.left_stick_x;
            double strafe = this.gamepad1.right_stick_x;
            MotrAutoTeleControl.SetPowerToEachMotor(forward+turn+strafe,forward-turn-strafe,forward-turn+strafe,forward+turn-strafe);
        }
    }
}
