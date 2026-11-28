package org.firstinspires.ftc.teamcode.methods;

import com.bylazar.configurables.annotations.Configurable;
import com.pedropathing.math.Pose;

import org.firstinspires.ftc.teamcode.systems.shooter.ShooterSettings;

@Configurable
public class GoalPose {
    public static double distance;
    public static double midLine = 70.7;
    public static Pose infGoal = new Pose(57, 52);
    public static Pose supGoal = new Pose(59, 97);

    public static Pose getGoal(double y) {
        return (y < midLine) ? infGoal : supGoal;
    }

    public static double getDistanceFromGoal(double y, double x, double heading, double offset) {

        Pose goalPose = GoalPose.getGoal(y);
        double shooterWorldX = x + (offset * Math.cos(heading));
        double shooterWorldY = y + (offset * Math.sin(heading));
        ///lam distanta de la goal
         return distance = Math.hypot(goalPose.x() - shooterWorldX, goalPose.y() - shooterWorldY);
    }

    public static void hiveOffsetX(){}///offset hive cand nu trage din fata goal ului
    ///cred ca asta merge bagat direg=ct in aia get goal
}
