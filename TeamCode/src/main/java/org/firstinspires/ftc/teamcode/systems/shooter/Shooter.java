package org.firstinspires.ftc.teamcode.systems.shooter;

import com.pedropathing.utils.Utils;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.methods.Globals;
import org.firstinspires.ftc.teamcode.methods.GoalPose;

import dev.frozenmilk.dairy.cachinghardware.CachingServo;

public class Shooter {

    public ElapsedTime shootTimer;
    public FlywheelMotor flywheelMotor;
    public CachingServo gate, hood;
    public AnalogInput gate_encoder;
    public ShooterSettings settings;
    public double targetVelocity, hoodAngle;

    public Shooter(HardwareMap hardwareMap, ShooterSettings settings){
        this.settings = settings;
        flywheelMotor = new FlywheelMotor(hardwareMap, settings);
        gate = new CachingServo(hardwareMap.get(Servo.class, settings.gateName));
        hood = new CachingServo(hardwareMap.get(Servo.class, settings.hoodName));
        gate_encoder = hardwareMap.get(AnalogInput.class, settings.gateAnalogName);
        shootTimer = new ElapsedTime();
    }

    public void update_shooter(double x, double y, double heading, double voltage){
        ///luam distanta de la goal
        double distance_from_goal = GoalPose.getDistanceFromGoal(y, x, heading, settings.shooterOffset);

        ///calculam target vel si angle cu interpolarile
        if (!Globals.FAILSAFE_MODE) {
            targetVelocity = optimalRpm(distance_from_goal);
            hoodAngle = optimalAngle(distance_from_goal);
        }
        else {
            targetVelocity = settings.failsafeVel;
            hoodAngle = settings.failsafeHoodAngle;
        }

        ///dam putere la shooter si pos la hood
        flywheelMotor.update(targetVelocity, voltage);
        hood.setPosition(hoodAngle);
    }


    ///astia de modif ca sunt la fel mereu (asta pt 2 shootere)
    public double optimalRpm(double dist) {
        double rpm = -0.000333333 * Math.pow(dist, 4)
                + 0.05 * Math.pow(dist, 3)
                - 2.56667 * Math.pow(dist, 2)
                + 56 * dist
                + 930;
        return Utils.clamp(rpm, settings.minShooterVel, settings.maxShooterVel);
    }

    public double optimalAngle(double dist) {
        double angle = 0 * dist + 0.8;
        return Utils.clamp(angle, settings.minHoodPos, settings.maxHoodPos);
    }

}
