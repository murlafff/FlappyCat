import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Locale;

public class ScoreManager {

    private static final Path SAVE_FILE =
            Paths.get("flappycat-highscore.txt");

    private static final double PIPE_HALF_POINTS = 0.5;
    private static final double TREAT_BONUS = 5.0;
    private static final double GOLDEN_FISH_BONUS = 10.0;

    private double score;
    private double bestScore;

    public ScoreManager() {
        score = 0.0;
        bestScore = loadBestScore();
    }

    // Each top or bottom pipe awards half a point.
    // Passing the complete pair awards one point.
    public void addPipeHalfPoint() {
        addPoints(PIPE_HALF_POINTS);
    }

    public void awardTreat() {
        addPoints(TREAT_BONUS);
    }

    public void awardGoldenFish() {
        addPoints(GOLDEN_FISH_BONUS);
    }

    public void addBonusPoints(double points) {
        if (!Double.isFinite(points) || points <= 0) {
            throw new IllegalArgumentException(
                    "Bonus points must be a positive, finite number."
            );
        }

        addPoints(points);
    }

    private void addPoints(double points) {
        score += points;

        if (score > bestScore) {
            bestScore = score;
            saveBestScore();
        }
    }

    public double getScore() {
        return score;
    }

    public double getBestScore() {
        return bestScore;
    }

    // Reset the current run, keeping the high score.
    public void reset() {
        score = 0.0;
    }

    private double loadBestScore() {
        if (!Files.exists(SAVE_FILE)) {
            return 0.0;
        }

        try {
            String contents = new String(
                    Files.readAllBytes(SAVE_FILE),
                    StandardCharsets.UTF_8
            ).trim();

            double saved = Double.parseDouble(contents);

            if (!Double.isFinite(saved) || saved < 0) {
                return 0.0;
            }

            return saved;
        } catch (IOException | NumberFormatException e) {
            System.err.println(
                    "Unable to load FlappyCat high score: "
                    + e.getMessage()
            );
            return 0.0;
        }
    }

    private void saveBestScore() {
        try {
            Files.write(
                    SAVE_FILE,
                    String.format(
                            Locale.ROOT, "%.1f", bestScore
                    ).getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE
            );
        } catch (IOException e) {
            System.err.println(
                    "Unable to save FlappyCat high score: "
                    + e.getMessage()
            );
        }
    }
}
