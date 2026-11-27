package org.firstinspires.ftc.teamcode.Systems;

import com.pedropathing.math.Pose;

import org.firstinspires.ftc.teamcode.Methods.Goal_pose;

import dev.frozenmilk.dairy.cachinghardware.CachingDcMotorEx;

public class Shooter {
    public CachingDcMotorEx motor;

    public void update_shooter(double x, double y){
        Pose goalPose = Goal_pose.getGoal(y);
        double vel = motor.getVelocity();

        double distance_from_goal = Math.hypot(goalPose.x() - x, goalPose.y() - y);

    }
}
