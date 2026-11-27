package org.firstinspires.ftc.teamcode.Methods;

import com.bylazar.telemetry.TelemetryManager;

public class Robot_Methods {

    public Robot_States robotState;
    public TelemetryManager telemetryM;
    public enum Robot_States {
        DEFAULT,
        INTAKE,
        REVERSE,
        SHOOT
    }

    public void init() {///de pus in teleop in init
        robotState = Robot_States.DEFAULT;
    }

    public void runStateMachine() {/// in loop
        switch (robotState) {
            case DEFAULT:
                break;
            case INTAKE:
                break;
            case REVERSE:
                break;
            case SHOOT:///verificare pe turela ca sa nu dea shoot cu turela in miscare
                break;
        }
    }

//    public void update_telemetry(Telemetry telemetry, ElapsedTime loops){
//        telemetry.addLine("-------- ROBOT STATE --------");
//        telemetry.addData(" State", robotState.name());
//        telemetry.addData(" failsafe", Globals.FAILSAFE_MODE);
//
//        telemetry.addLine("-------- SHOOTER --------");
//        telemetry.addData(" vel shooter ", M_shooter.motor_shooter.getVelocity());
//        telemetry.addData(" RPM target", "%.1f", Shooter.TARGET_VELOCITY);
//        telemetry.addData(" hood angle", Shooter.HOOD_ANGLE);
//        telemetry.addData(" goalX", Shooter.goalX);
//        telemetry.addData(" goalY", Shooter.goalY);
//        telemetry.addData(" voltaj_shooter", M_shooter.shooter_voltage.getVoltage());
//
//
//        if (robotState == TeleOp_Methods.RobotState.SHOOT)
//            telemetry.addData("  Shoot timer", "%.0f / %.0f ms",
//                    M_shooter.shootTimer.milliseconds(), Shooter_Constants.SHOOT_TIME);
//
//        telemetry.addLine("-------- TURELA --------");
//        telemetry.addData(" Unghi target", "%.1f°", Turret.target_position);
//        telemetry.addData(" Rate", "%.1f°/s", Turret.target_angle);
//        telemetry.addData(" goalX", Turret.goalX);
//        telemetry.addData(" goalY", Turret.goalY);
//
//
//        telemetry.addLine("-------- INTAKE/TRANSFER --------");
//        telemetry.addData("  Intake power", "%.2f", IntakeTransfer.motorIntake.getPower());
//        telemetry.addData("  Transfer power", "%.2f", IntakeTransfer.motorTransfer.getPower());
//        telemetry.addData("  has artifact", IntakeTransfer.hasArtifact());
//        telemetry.addData("  flower", M_intakeTransfer.flower);
//        telemetry.addData("  amps", IntakeTransfer.getAmps());
//
//
//        telemetry.addData("  powIntake", IntakeTransfer.powIntake);
//        telemetry.addData("  powTransferCollect", IntakeTransfer.powTransferCollect);
//        telemetry.addData("  powTransferShoot", IntakeTransfer.powTransferShoot);
//
//        telemetry.addLine("-------- LOCALIZARE --------");
//        telemetry.addData("  Pose X", "%.1f", M_follower.pose().x());
//        telemetry.addData("  Pose Y", "%.1f", M_follower.pose().y());
//        telemetry.addData("  Heading", "%.1f°", Math.toDegrees(M_follower.pose().heading()));
//
//        telemetry.addData("distance from goal ", M_shooter.distance_from_goal);
//
//        telemetry.addLine("-------- PROFILING --------");
//        telemetry.addData("loop time ", loops.milliseconds());
//
//        telemetryM.debug("--- Shooter ---");
//        telemetryM.addData("motor1RPM",      M_shooter.motor_shooter.getVelocity());
//        telemetryM.addData("targetVelocity", Shooter.TARGET_VELOCITY);
//        telemetryM.addData("Velocity",       M_shooter.motor_shooter.getVelocity());
//
//        telemetryM.addData("graph.shooter.target", Shooter.TARGET_VELOCITY);
//        telemetryM.addData("graph.shooter.actual", M_shooter.motor_shooter.getVelocity());
//        telemetryM.addData("graph.shooter.pwr1",   M_shooter.motor_shooter.getPower());
//
//        telemetryM.addData("poseX", M_follower.pose().x());
//        telemetryM.addData("poseY", M_follower.pose().y());
//        telemetryM.addData("poseHeading", M_follower.pose().heading());
//
//        telemetryM.addData("graph.poseX", M_follower.pose().x());
//        telemetryM.addData("graph.poseY", M_follower.pose().y());
//        telemetryM.addData("graph.poseHeading", M_follower.pose().heading());
//
//        //telemetryM.addData("graph.battery",  batteryVoltage);
//
//        //telemetryM.addData("batteryVoltage ", batteryVoltage);
//
//        telemetryM.update(telemetry);
//        telemetry.update();
//    }
}
