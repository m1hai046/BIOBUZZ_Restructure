package org.firstinspires.ftc.teamcode.Methods;

import com.bylazar.configurables.annotations.Configurable;
import com.pedropathing.math.Pose;

@Configurable
public class Goal_pose {
    public static double midLine = 70.7;
    public static Pose infGoal = new Pose(57, 52);
    public static Pose supGoal = new Pose(59, 97);


    public static Pose getGoal(double y) {
        return (y < midLine) ? infGoal : supGoal;
    }

    public void hiveOffsetX(){}///offset hive cand nu trage din fata goal ului
}
