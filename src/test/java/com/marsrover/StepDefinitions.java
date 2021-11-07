package com.marsrover;

import com.marsrover.model.CardinalPoint;
import com.marsrover.model.Exception.InvalidCommandException;
import com.marsrover.model.MarsRover;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.util.Pair;
import org.assertj.core.api.Assertions;

public class StepDefinitions {

    private MarsRover marsRover;
    private boolean invalidCommandExceptionWasThrown;

    @Given("a Mars Rover")
    public void aMarsRover() {
        this.marsRover = new MarsRover(new Pair<>(0, 0), CardinalPoint.NORTH);
    }

    @When("an operator sends an empty input to the Rover")
    public void anOperatorSendsAnEmptyInputToTheRover() {
        marsRover.processCommands("");
    }

    @Then("the Rover should not move")
    public void theRoverShouldNotMove() {
        Assertions.assertThat(marsRover.isAt(new Pair<>(0, 0), CardinalPoint.NORTH)).isTrue();
    }

    @When("an operator sends a move forward command to the Rover")
    public void anOperatorSendsAMoveForwardCommandToTheRover() {
        marsRover.processCommands("F");
    }

    @Then("the Rover should move forward")
    public void theRoverShouldMoveForward() {
        Assertions.assertThat(marsRover.isAt(new Pair<>(0, 1), CardinalPoint.NORTH)).isTrue();
    }

    @When("an operator sends a rotate left command to the Rover")
    public void anOperatorSendsARotateLeftCommandToTheRover() {
        marsRover.processCommands("L");
    }

    @Then("the Rover should rotate left")
    public void theRoverShouldRotateLeft() {
        Assertions.assertThat(marsRover.isAt(new Pair<>(0, 0), CardinalPoint.WEST)).isTrue();
    }

    @When("an operator sends an invalid command to the Rover")
    public void anOperatorSendsAnInvalidCommandToTheRover() {
        invalidCommandExceptionWasThrown = false;
        try {
            marsRover.processCommands("H");
        } catch (InvalidCommandException ex) {
            invalidCommandExceptionWasThrown = true;
        }
    }

    @Then("the Rover should not move and notify the operator that the command sent is not supported")
    public void theRoverShouldNotMoveAndNotifyTheOperatorThatTheCommandSentIsNotSupported() {
        Assertions.assertThat(invalidCommandExceptionWasThrown).isTrue();
        Assertions.assertThatThrownBy(() -> marsRover.processCommands("H"))
                .hasMessage("Command H is not supported by this rover");
        Assertions.assertThat(marsRover.isAt(new Pair<>(0, 0), CardinalPoint.NORTH)).isTrue();
    }
}
