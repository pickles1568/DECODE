package org.firstinspires.ftc.teamcode.teleops;

import dev.nextftc.ftc.Gamepads;
import dev.nextftc.ftc.NextFTCOpMode;
import dev.nextftc.hardware.driving.FieldCentric;
import dev.nextftc.hardware.driving.MecanumDriverControlled;
import dev.nextftc.hardware.impl.Direction;
import dev.nextftc.hardware.impl.IMUEx;
import dev.nextftc.hardware.impl.MotorEx;

public class Test extends NextFTCOpMode {
    private final MotorEx frontLeftMotor = new MotorEx("front_left");
    private final MotorEx frontRightMotor = new MotorEx("front_right");
    private final MotorEx backLeftMotor = new MotorEx("back_left");
    private final MotorEx backRightMotor = new MotorEx("back_right");
    private final IMUEx imu = new IMUEx("imu", Direction.LEFT, Direction.UP).zeroed();

    private MecanumDriverControlled driverControlled;

    @Override
    public void onInit() {
        frontLeftMotor.brakeMode();
        frontRightMotor.brakeMode().reversed();
        backLeftMotor.brakeMode();
        backRightMotor.brakeMode().reversed();

        // Create but don't schedule yet
        driverControlled = new MecanumDriverControlled(
                frontLeftMotor,
                frontRightMotor,
                backLeftMotor,
                backRightMotor,
                Gamepads.gamepad1().leftStickY().negate(),
                Gamepads.gamepad1().leftStickX(),
                Gamepads.gamepad1().rightStickX(),
                new FieldCentric(imu)
        );
    }

    @Override public void onWaitForStart() { }

    @Override
    public void onStartButtonPressed() {
        driverControlled.schedule();
    }

    @Override
    public void onUpdate() {
        // Optional: IMU reset
        if (gamepad1.aWasPressed()){
            imu.zero();
        }
    }

    @Override public void onStop() { }
}