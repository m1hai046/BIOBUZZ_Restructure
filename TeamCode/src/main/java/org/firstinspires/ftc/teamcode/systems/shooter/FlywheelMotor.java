package org.firstinspires.ftc.teamcode.systems.shooter;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import dev.frozenmilk.dairy.cachinghardware.CachingDcMotor;
import dev.frozenmilk.dairy.cachinghardware.CachingDcMotorEx;

public class FlywheelMotor {
    public ShooterSettings settings;
    public double targetVelocity = 0;
    private final CachingDcMotorEx motor_shooter;

    public FlywheelMotor(HardwareMap hardwareMap, ShooterSettings settings) {
        this.settings = settings;
        motor_shooter = new CachingDcMotorEx(hardwareMap.get(DcMotorEx.class, settings.motorName));

        motor_shooter.setZeroPowerBehavior(CachingDcMotor.ZeroPowerBehavior.FLOAT);
        motor_shooter.setMode(CachingDcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_shooter.setDirection(CachingDcMotor.Direction.FORWARD);
        motor_shooter.setCachingTolerance(0.001);
    }

    public void stop(){
        motor_shooter.setPower(0);
    }

    public void update(double velocity, double voltage){
        targetVelocity = velocity;

        double error = targetVelocity - motor_shooter.getVelocity();
        double voltageScaling = settings.nominalVoltage / voltage;

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
