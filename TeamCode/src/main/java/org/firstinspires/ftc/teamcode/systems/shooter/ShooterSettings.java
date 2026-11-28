package org.firstinspires.ftc.teamcode.systems.shooter;

public class ShooterSettings {
    public String motorName, hoodName, gateName, gateAnalogName;
    public boolean motorReversed = false;
    public double kP, kV, kS, maxError, nominalVoltage = 12.0;
    public double gateOpen, gateClosed, shootTime, gateOpenVolts, gateToleranceVolts;
    public double minHoodPos, maxHoodPos, minShooterVel, maxShooterVel;
    public double failsafeVel, failsafeHoodAngle;
    public double shooterOffset;


}
