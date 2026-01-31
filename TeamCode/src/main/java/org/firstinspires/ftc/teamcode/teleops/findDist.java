package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.util.LimelightDistance;

@TeleOp
public class findDist extends OpMode {
    private Limelight3A limelight;

    @Override
    public void init() {
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(0);
    }

    @Override
    public void start() {
        limelight.start();
    }

    @Override
    public void loop() {
        Double distance = LimelightDistance.getDistanceToTarget(limelight);

        if (distance != null) {
            telemetry.addData("Distance", distance);
        } else {
            telemetry.addData("Distance", "no target");
        }
        telemetry.update();
    }
}