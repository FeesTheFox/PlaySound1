package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainSteps {
    private int[] scores = new int[3];
    private String[] melodies = {"melody1.wav", "melody2.wav"};

    @Given("игру запустили")
    public void the_game_is_started() {
        scores = new int[3]; // Reset scores
    }

    @When("Игрок {int} угадывает {string} для melody1.wav")
    public void игрок_угадывает_для_melody1_wav(int player, String guess) {
        if (guess.equalsIgnoreCase("Melody 1")) {
            scores[player - 1]++;
        }
    }

    @Then("счет Игрока {int} должен быть {int}")
    public void player_s_score_should_be(int player, int expectedScore) {
        assertEquals(expectedScore, scores[player - 1]);
    }
}
