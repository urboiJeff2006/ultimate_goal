package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class MotrAutoTeleControl {




    public static DcMotor leftFront = MecanumChassis.getLf();
    public static DcMotor rightFront = MecanumChassis.getRf();
    public static DcMotor leftBack = MecanumChassis.getLb();
    public static DcMotor rightBack = MecanumChassis.getRb();


    public static void SetPowerToEachMotor(double lfPower, double rfPower, double lbPower, double rbPower){
        leftFront.setPower(-lfPower);
        rightFront.setPower(rfPower);
        leftBack.setPower(-lbPower);
        rightBack.setPower(rbPower);
    }


}
