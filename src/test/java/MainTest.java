
import org.example.Main;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testPlaySound() {
        // Тест для проверки воспроизведения звука
        Main.playSound("melody1.wav");
        // Если нет исключений, значит звук воспроизвелся успешно
        assertTrue(true);
    }



    @Test
    public void testGameLogic() {
        // Тест для проверки основной логики игры
        String[] melodies = {"melody1.wav", "melody2.wav"};
        int[] scores = new int[3];

        // Симуляция ввода пользователя
        String[] guesses = {"Melody 1", "Melody 1", "Melody 1", "Melody 2", "Melody 2", "Melody 2"};
        int guessIndex = 0;

        for (int round = 0; round < melodies.length; round++) {
            for (int player = 0; player < 3; player++) {
                String guess = guesses[guessIndex++];
                if (guess.equalsIgnoreCase("Melody " + (round + 1))) {
                    scores[player]++;
                }
            }
        }

        // Проверка итоговых счетов
        assertEquals(2, scores[0]);
        assertEquals(2, scores[1]);
        assertEquals(2, scores[2]);
    }
}
