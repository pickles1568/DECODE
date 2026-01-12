package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class findDist extends OpMode {
    private Limelight3A limelight;
    //mount angle and lens height need to be changed.
    //docs for this: https://docs.limelightvision.io/docs/docs-limelight/tutorials/tutorial-estimating-distance
    //angle from perfectly vertical
    private static final double limelightMountAngleDegrees = 25.0;
    //center of lens to floor
    private static final double limelightLensHeightInches = 20.0;
    private static final double goalHeightInches = 29.5;

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
        LLResult llResult = limelight.getLatestResult();
        if (llResult != null && llResult.isValid()) {
            double targetOffsetAngleVertical = llResult.getTy();
            double angleToGoalDegrees = limelightMountAngleDegrees + targetOffsetAngleVertical;
            double angleToGoalRadians = Math.toRadians(angleToGoalDegrees);
            double distanceFromLimelightToGoalInches = (goalHeightInches - limelightLensHeightInches) / Math.tan(angleToGoalRadians);
            telemetry.addData("Ty", llResult.getTy());
            telemetry.addData("Distance", distanceFromLimelightToGoalInches);
        } else {
            telemetry.addData("Ty", "no target");
            telemetry.addData("Distance", "no target");
        }
        telemetry.update();
    }
}
