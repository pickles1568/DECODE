package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;

public class LimelightDistance {
    //mount angle and lens height need to be changed.
    //docs for this: https://docs.limelightvision.io/docs/docs-limelight/tutorials/tutorial-estimating-distance
    //angle from perfectly vertical
    private static final double LIMELIGHT_MOUNT_ANGLE_DEGREES = 25.0;
    //center of lens to floor
    private static final double LIMELIGHT_LENS_HEIGHT_INCHES = 20.0;
    private static final double GOAL_HEIGHT_INCHES = 29.5;

    public static Double getDistanceToTarget(Limelight3A limelight) {
        LLResult llResult = limelight.getLatestResult();

        if (llResult != null && llResult.isValid()) {
            double targetOffsetAngleVertical = llResult.getTy();
            double angleToGoalDegrees = LIMELIGHT_MOUNT_ANGLE_DEGREES + targetOffsetAngleVertical;
            double angleToGoalRadians = Math.toRadians(angleToGoalDegrees);
            double distanceInches = (GOAL_HEIGHT_INCHES - LIMELIGHT_LENS_HEIGHT_INCHES) / Math.tan(angleToGoalRadians);

            return distanceInches;
        }

        return null;
    }
}