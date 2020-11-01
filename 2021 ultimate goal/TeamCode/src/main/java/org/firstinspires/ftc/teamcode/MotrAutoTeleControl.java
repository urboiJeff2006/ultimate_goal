package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class MotrAutoTeleControl {




    public static DcMotor leftFront = MecanumChassis.getLf();
    public static DcMotor rightFront = MecanumChassis.getRf();
    public static DcMotor leftBack = MecanumChassis.getLb();
    public static DcMotor rightBack = MecanumChassis.getRb();


    public static void Drive(double lfPower, double rfPower, double lbPower, double rbPower){
        leftFront.setPower(-lfPower);
        rightFront.setPower(rfPower);
        leftBack.setPower(-lbPower);
        rightBack.setPower(rbPower);
    }
    public static void Drive(double l, double r){
        leftFront.setPower(-l);

        leftBack.setPower(-l);
        rightBack.setPower(r);
        rightBack.setPower(r);
    }
    public  static void StopMotors(){
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
        rightBack.setPower(0);
    }
    public static void PDForward( double cm,double target, double speed,double kp, double kd){
        final double diameter = 5;
        final double ratio = 360/Math.PI*diameter;
        final double ticksToRunFor = ratio*cm*1316*2/360;
        double lastError = 0;
        while((leftBack.getCurrentPosition()+leftFront.getCurrentPosition()+rightBack.getCurrentPosition()+rightFront.getCurrentPosition())/4 < ticksToRunFor){
            double current = IMU.returnHeading();
            double Error = target-current;
            double P = Error*kp;
            double D = (lastError-Error)*kd;
            double total = P+D;

            Drive(speed-total,speed+total);


        }
        StopMotors();

    }
    public static  void PDTurn(){

    }

    



}
