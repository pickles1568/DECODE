package org.firstinspires.ftc.teamcode.paths;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.util.Timer;
@Autonomous
public class farBlue extends OpMode {

    private Follower follower;
    private Timer pathTimer, opModeTimer;

    public enum PathState {
        Drive_StartPos_ShootPos,
        Shoot_Preload
    }
    PathState pathState;

    private final Pose StartPose = new Pose();

    @Override
    public void init() {

    }
    @Override
    public void loop() {

    }

}
