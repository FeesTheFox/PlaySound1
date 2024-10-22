package org.example;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] melodies = {"melody1.wav", "melody2.wav"};
        int[] scores = new int[3]; // Счет для трех игроков

        for (int round = 0; round < melodies.length; round++) {
            System.out.println("Round " + (round + 1) + ": Guess the melody!");
            for (int player = 0; player < 3; player++) {
                System.out.println("Player " + (player + 1) + ", your turn!");
                System.out.println("Playing melody...");

                // Воспроизведение мелодии
                playSound(melodies[round]);

                System.out.print("What is the melody? ");
                String guess = scanner.nextLine();

                // Здесь можно добавить логику для проверки ответа
                // Например, если мелодия называется "Melody 1", то игрок должен ввести "Melody 1"
                if (guess.equalsIgnoreCase("Melody " + (round + 1))) {
                    System.out.println("Correct!");
                    scores[player]++;
                } else {
                    System.out.println("Wrong! The correct melody was: Melody " + (round + 1));
                }
            }
        }

        System.out.println("Game over! Final scores:");
        for (int player = 0; player < 3; player++) {
            System.out.println("Player " + (player + 1) + ": " + scores[player] + " points");
        }
    }


    public static void playSound(String filePath) {
        try {
            File soundFile = new File("C:/Users/feesb/IdeaProjects/PlaySound1/src/main/resources/" + filePath);
            if (!soundFile.exists()) {
                System.out.println("File not found: " + soundFile.getAbsolutePath());
                return;
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            // Ждем, пока звук не закончится
            while (!clip.isRunning()) {
                Thread.sleep(10);
            }
            while (clip.isRunning()) {
                Thread.sleep(10);
            }

            clip.close();
            audioStream.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}