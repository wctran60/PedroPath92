package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.pedroPathing.follower.Follower;

/**
 * This is the TeleOpEnhancements OpMode. It is an example usage of the TeleOp enhancements that
 * Pedro Pathing is capable of.Anyi Lin, Aaron Yang, Harrison Womack - 10158 Scott's Bots, @version 1.0, 3/21/2024
 */
/*8/26/2023:  update motor map in this class, in PedroPathing/follower/Follower, in PedroPathing/localization/localizers/ThreeWheelLocalizer


 */

@TeleOp(name = "PedroPath TeleOp Enhance 1.1", group = "Test")
public class TeleOp_PedroPath_OpMode extends OpMode {
    private Follower follower;

    private DcMotorEx leftFront;
    private DcMotorEx leftRear;
    private DcMotorEx rightFront;
    private DcMotorEx rightRear;

    /**
     * This initializes the drive motors as well as the Follower and motion Vectors.
     */
    @Override
    public void init() {
        follower = new Follower(hardwareMap);

        //leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        //leftRear = hardwareMap.get(DcMotorEx.class, "leftRear");
        //rightRear = hardwareMap.get(DcMotorEx.class, "rightRear");
        //rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");

        leftFront = hardwareMap.get(DcMotorEx.class, "LFront_Motor");
        leftRear = hardwareMap.get(DcMotorEx.class, "LBack_Motor");
        rightRear = hardwareMap.get(DcMotorEx.class, "RBack_Motor");
        rightFront = hardwareMap.get(DcMotorEx.class, "RFront_Motor");



        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        follower.startTeleopDrive();
    }

    /**
     * This runs the OpMode. This is only drive control with Pedro Pathing live centripetal force
     * correction.
     */
    @Override
    public void loop() {
        follower.setTeleOpMovementVectors(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x);
        follower.update();
    }
}
