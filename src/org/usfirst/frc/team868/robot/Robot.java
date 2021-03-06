package org.usfirst.frc.team868.robot;

import org.usfirst.frc.team868.robot.commands.ExampleCommand;
import org.usfirst.frc.team868.robot.subsystems.CanGrabberSubsystem;
import org.usfirst.frc.team868.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team868.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team868.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team868.robot.subsystems.FeederSubsystem;
import org.usfirst.frc.team868.robot.subsystems.RobotFactory;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;

	private CanGrabberSubsystem cg;
	private FeederSubsystem feeder;
	private ElevatorSubsystem elevator;
	private DriveSubsystem drive;

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotFactory.getInstance();
		oi = new OI();
		oi.initialize();

		cg = RobotFactory.getInstance().getCanGrabber();
		feeder = RobotFactory.getInstance().getFeeder();
		elevator = RobotFactory.getInstance().getElevator();
		drive = RobotFactory.getInstance().getDrive();

		autonomousCommand = new ExampleCommand();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		updateDashboard();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null) autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		updateDashboard();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) autonomousCommand.cancel();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		updateDashboard();
	}

	private void updateDashboard() {

		// SmartDashboard.putBoolean("Can Grabber Open", cg.isOpen());

		// SmartDashboard.putNumber("Left Sensor", feeder.getLeftSensor());
		// SmartDashboard.putNumber("Right Sensor", feeder.getRightSensor());
		// SmartDashboard.putBoolean("Feeder Arms In", feeder.isFeederIn());
		// SmartDashboard.putBoolean("Tote is In", feeder.isToteIn());
		// SmartDashboard.putNumber("Speed of Left Wheel",
		// feeder.getLeftSpeed());
		// SmartDashboard.putNumber("Speed of Right Wheel",
		// feeder.getRightSpeed());
		// SmartDashboard.putBoolean("Wheels Spinning", feeder.isSpinning());

		SmartDashboard.putNumber("Elevator Height", elevator.getEncDistance());
		
		SmartDashboard.putNumber("Left Motor Speed", drive.getLeftSpeed());
		SmartDashboard.putNumber("Right Motor Speed", drive.getRightSpeed());
		SmartDashboard.putNumber("Left Motor Power", drive.getLeftPower());
		SmartDashboard.putNumber("Right Motor Power", drive.getRightPower());
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
