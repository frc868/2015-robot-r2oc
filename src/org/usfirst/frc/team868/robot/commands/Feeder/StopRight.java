package org.usfirst.frc.team868.robot.commands.Feeder;

import org.usfirst.frc.team868.robot.subsystems.FeederSubsystem;
import org.usfirst.frc.team868.robot.subsystems.RobotFactory;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopRight extends Command {

	private FeederSubsystem feeder;

	public StopRight() {
		feeder = RobotFactory.getInstance().getFeeder();
		requires(feeder);
	}

	protected void initialize() {
		feeder.stopRightWheel();
	}

	protected void execute() {

	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {

	}

	protected void interrupted() {

	}
}
