import java.awt.*;
import javax.swing.*;

public class App extends JFrame {

    private final int WIDTH = 360;
    private final int HEIGHT = 640;

    public App() {
        setTitle("Flappy Cat");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showStartScreen();

        setVisible(true);
    }

    private void showStartScreen() {
        JPanel menu = new JPanel() {
            Image background;

            {
                background = new ImageIcon(
                    getClass().getResource("./flappycatbg.png")
                ).getImage();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Background
                g.drawImage(background, 0, 0, getWidth(), getHeight(), null);

                // Dark transparent overlay
                g.setColor(new Color(0, 0, 0, 70));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        menu.setLayout(null);

        // Title
        JLabel title = new JLabel("FLAPPY CAT", SwingConstants.CENTER);
        title.setBounds(30, 100, 300, 70);
        title.setFont(new Font("Arial", Font.BOLD, 42));
        title.setForeground(Color.WHITE);

        // Subtitle
        JLabel subtitle = new JLabel(
            "The Cat Who Can't Stop Flying",
            SwingConstants.CENTER
        );
        subtitle.setBounds(30, 165, 300, 30);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitle.setForeground(Color.WHITE);

        // Play button
        JButton playButton = new JButton("PLAY");
        playButton.setBounds(80, 270, 200, 60);
        playButton.setFont(new Font("Arial", Font.BOLD, 28));
        playButton.setFocusPainted(false);
        playButton.setBackground(new Color(255, 190, 80));
        playButton.setForeground(Color.WHITE);

        playButton.addActionListener(e -> startGame());

        // Instructions
        JLabel instructions = new JLabel(
            "<html><center>SPACE = FLAP<br><br>Avoid the pipes!</center></html>",
            SwingConstants.CENTER
        );

        instructions.setBounds(50, 370, 260, 100);
        instructions.setFont(new Font("Arial", Font.BOLD, 16));
        instructions.setForeground(Color.WHITE);

        // Version
        JLabel version = new JLabel(
            "Flappy Cat",
            SwingConstants.CENTER
        );

        version.setBounds(100, 560, 160, 25);
        version.setFont(new Font("Arial", Font.PLAIN, 12));
        version.setForeground(Color.WHITE);

        menu.add(title);
        menu.add(subtitle);
        menu.add(playButton);
        menu.add(instructions);
        menu.add(version);

        setContentPane(menu);
        revalidate();
        repaint();
    }

    private void startGame() {
        FlappyCat game = new FlappyCat();

        setContentPane(game);
        revalidate();

        game.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new App();
        });
    }
}