package org.firstinspires.ftc.teamcode.systems;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

import dev.frozenmilk.dairy.cachinghardware.CachingDcMotorEx;
import dev.frozenmilk.dairy.cachinghardware.CachingServo;

@Configurable
public class IntakeTransfer {///mai e de adaugat rpm ul
    public CachingDcMotorEx motorIntake, motorTransfer;
    public CachingServo rampa;

    /// VARIABILE RAMPA
    public static double posRampaSus = 0.1;
    public static double posRampaJos = 0.98;
    public boolean flower = false;


    /// VARIABILE INTAKE
    public static double powIntake = 0.8;
    public static double powReverse = -1;
    public double powOff = 0;

    /// VARIABILE AMPERAJ
    public boolean reset = true;
    public int confirmare = 0;
    public static double thresholdAmps = 16;


    /// VARIABILE TRANSFER
    public static double powTransferCollect = 0.5; /// gate  inchis
    public static double powTransferShoot = 0.5;   ///gate deschis

    public IntakeTransfer(HardwareMap hardwareMap){
        motorIntake = new CachingDcMotorEx(hardwareMap.get(DcMotorEx.class,"MINT"));
        motorTransfer = new CachingDcMotorEx(hardwareMap.get(DcMotorEx.class,"MTR"));
        rampa = new CachingServo(hardwareMap.get(Servo.class, "flower"));
        motorIntake.setDirection(CachingDcMotorEx.Direction.REVERSE);
        motorTransfer.setDirection(CachingDcMotorEx.Direction.FORWARD);
    }

    ///METODE INTAKE TRANSFER
    public void collect(){
        motorIntake.setPower(powIntake);
        motorTransfer.setPower(powTransferCollect);
    }
    public void off(){
        motorIntake.setPower(powOff);
        motorTransfer.setPower(powOff);
    }
    public void reverse(){
        motorIntake.setPower(powReverse);
        motorTransfer.setPower(powReverse);
    }
    public void shoot(){
        motorIntake.setPower(powIntake);
        motorTransfer.setPower(powTransferShoot);
    }

    ///METODE RAMPA
    public void rampaUp(){
        rampa.setPosition(posRampaSus);
        flower = false;
    }
    public void rampaDown(){
        rampa.setPosition(posRampaJos);
        flower = true;
    }

    ///GETTERI
    public double getAmps() {
        return motorIntake.getCurrent(CurrentUnit.AMPS);
    }
    public double getTicksIntake() { return motorIntake.getVelocity(); }
    public double getTicksTransfer() { return motorTransfer.getVelocity(); }

//    public boolean hasArtifact() {///de uitat la el ca nu e best practice
//        if (!reset) {
//            confirmare = 0;
//            return false;
//        }
//        else {
//            if (getAmps() > thresholdAmps) {
//                confirmare++;
//            } else {
//                confirmare = 0;
//            }
//        }
//        return confirmare > 4;
//    }
}
