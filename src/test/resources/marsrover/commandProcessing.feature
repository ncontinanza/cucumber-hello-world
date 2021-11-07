Feature: command processing
  Operators want to send commands to the Mars Rover in order to move it from one place to another

  Scenario: Mars Rover does not move when no commands are sent
    Given a Mars Rover
    When an operator sends an empty input to the Rover
    Then the Rover should not move

  Scenario: Mars Rover processes a movement input and executes the movement
    Given a Mars Rover
    When an operator sends a move forward command to the Rover
    Then the Rover should move forward

  Scenario: Mars Rover processes a rotation input and executes the rotation
    Given a Mars Rover
    When an operator sends a rotate left command to the Rover
    Then the Rover should rotate left

  Scenario: Mars Rover notifies the operator when an invalid command is received
    Given a Mars Rover
    When an operator sends an invalid command to the Rover
    Then the Rover should not move and notify the operator that the command sent is not supported




