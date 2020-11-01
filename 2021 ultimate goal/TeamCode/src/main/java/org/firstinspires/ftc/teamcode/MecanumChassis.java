package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


public class MecanumChassis{

    public static BNO055IMU imu = null;
    public static DcMotor lf = null;
    public static DcMotor rf = null;
    public static DcMotor lb = null;
    public static DcMotor rb = null;
    public static HardwareMap hwMap;


    public MecanumChassis(){

    }

    public static void initialize(HardwareMap hardwMap) {
        // assign from hardware map
        hwMap = hardwMap;
        lf = hardwMap.get(DcMotor.class, "lf");
        rf = hardwMap.get(DcMotor.class, "rf");
        lb = hardwMap.get(DcMotor.class, "lb");
        rb = hardwMap.get(DcMotor.class, "rb");

        // motor setup
        lf.setPower(0);
        rf.setPower(0);
        lb.setPower(0);
        rb.setPower(0);

        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //imu setup

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";

        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu = hardwMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
    }

    public static DcMotor getLf(){ return lf; }
    public static DcMotor getRf(){ return rf; }
    public static DcMotor getLb(){ return lb; }
    public  static DcMotor getRb(){ return rb; }
    public static BNO055IMU getImu(){return  imu;}

}





