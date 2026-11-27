package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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

    public FlywheelMotor(HardwareMap hardwareMap, String name) {
        motor_shooter = new CachingDcMotorEx(hardwareMap.get(DcMotorEx.class, "motor_" + name));
        gate = new CachingServo(hardwareMap.get(Servo.class, "gate_" + name));
        gate_encoder = hardwareMap.get(AnalogInput.class, "gate_encoder_" + name);
        hood = new CachingServo(hardwareMap.get(Servo.class, "hood_" + name));

        motor_shooter.setZeroPowerBehavior(CachingDcMotor.ZeroPowerBehavior.FLOAT);
        motor_shooter.setMode(CachingDcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_shooter.setDirection(CachingDcMotor.Direction.FORWARD);
        motor_shooter.setCachingTolerance(0.001);

        voltage = hardwareMap.voltageSensor.iterator().next();

        shootTimer = new ElapsedTime();
    }

    public void update_shooter(){

    }
}
