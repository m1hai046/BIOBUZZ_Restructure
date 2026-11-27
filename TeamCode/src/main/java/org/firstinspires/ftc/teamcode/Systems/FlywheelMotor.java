package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import dev.frozenmilk.dairy.cachinghardware.CachingDcMotor;
import dev.frozenmilk.dairy.cachinghardware.CachingDcMotorEx;
import dev.frozenmilk.dairy.cachinghardware.CachingServo;

public class FlywheelMotor {
    public CachingDcMotorEx motor_shooter;
    public CachingServo gate, hood;
    public AnalogInput gate_encoder;
    public VoltageSensor voltage;
    public ElapsedTime shootTimer;
    public Settings settings;
    public double nominalVoltage = 12.0;
    public double targetVelocity = 0;

    public static class Settings{
        String name;

        double kP = 0.005 , kV = 0.00036, kS = 0.12;
        double maxError;
        double gateOpen = 0.8, gateClosed = 0.54;
        double FAILSAFE_VELOCITY = 1420.0, FAILSAFE_ANGLE = 0.8;
        double minHoodAngle = 0.8,  maxHoodAngle = 0.8;
        double minShooterRpm = 1370.0, maxShooterRpm = 1530.0;
    }

    public FlywheelMotor(HardwareMap hardwareMap, Settings settings) {
        this.settings = settings;
        motor_shooter = new CachingDcMotorEx(hardwareMap.get(DcMotorEx.class, "shooter_" + settings.name));
        gate = new CachingServo(hardwareMap.get(Servo.class, "gate_" + settings.name));
        gate_encoder = hardwareMap.get(AnalogInput.class, "gate_encoder_" + settings.name);
        hood = new CachingServo(hardwareMap.get(Servo.class, "hood_" + settings.name));

        motor_shooter.setZeroPowerBehavior(CachingDcMotor.ZeroPowerBehavior.FLOAT);
        motor_shooter.setMode(CachingDcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_shooter.setDirection(CachingDcMotor.Direction.FORWARD);
        motor_shooter.setCachingTolerance(0.001);

        voltage = hardwareMap.voltageSensor.iterator().next();

        shootTimer = new ElapsedTime();
    }

    public void Stop(){
        motor_shooter.setPower(0);
    }

    public void update(double Velocity){
        targetVelocity = Velocity;

        double error = targetVelocity - motor_shooter.getVelocity();
        double voltageScaling = nominalVoltage / voltage.getVoltage();

        double proportional = (settings.kP * error);
        double feedforward = (settings.kV * targetVelocity) + settings.kS;

        double pow = (proportional + feedforward) * voltageScaling;

        pow = Math.max(-1.0, Math.min(1.0, pow));

        motor_shooter.setPower(pow);
    }

    public boolean isReady(){
        return Math.abs(targetVelocity - motor_shooter.getVelocity()) <= settings.maxError;
    }
}
