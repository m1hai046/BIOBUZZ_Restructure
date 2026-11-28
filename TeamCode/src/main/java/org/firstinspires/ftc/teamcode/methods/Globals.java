package org.firstinspires.ftc.teamcode.methods;

import com.bylazar.configurables.annotations.Configurable;

@Configurable
public class Globals {

    public static boolean FAILSAFE_MODE = false;
    public static Alliance alliance;
    public static FAZE faze;

    public enum FAZE{
        AUTO,
        TELEOP
    }
    public enum Alliance{
        RED,
        BLUE
    }
}
