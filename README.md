# 🐱 Flappy Cat

A simple **Flappy Bird-style game written in Java** using Java Swing.

Control the cat, avoid the pipes, and try to get the highest score possible!

---

## 🎮 Features

* 🐱 Flappy Cat character
* 🌤️ Custom background
* 🟩 Moving pipes
* 🕹️ SPACE key controls the cat
* 💥 Collision detection
* 📊 Score counter
* 🎨 Custom start/menu screen
* 🔄 Game-over detection
* 🚫 No external game engine required

---

## 📁 Project Structure

```text
FlappyCat/
│
├── src/
│   ├── App.java
│   └── FlappyCat.java
│
├── flappycat.png
├── flappycatbg.png
├── toppipe.png
├── bottompipe.png
│
└── README.md
```

### Java Files

| File             | Purpose                                       |
| ---------------- | --------------------------------------------- |
| `App.java`       | Starts the game and displays the start screen |
| `FlappyCat.java` | Contains the main game logic                  |

---

## 🕹️ Controls

| Key     | Action      |
| ------- | ----------- |
| `SPACE` | Flap / jump |

The goal is to pass through the gaps between the pipes without hitting them.

---

## 🚀 How to Run

### 1. Install Java

You need the **Java Development Kit (JDK)** installed.

Check whether Java is installed:

```bash
java --version
```

You can also check the Java compiler:

```bash
javac --version
```

---

### 2. Clone the repository

```bash
git clone https://github.com/murlafff/FlappyCat.git
```

Enter the project folder:

```bash
cd FlappyCat
```

---

### 3. Compile the game

If your Java files are in the same directory as the images:

```bash
javac App.java FlappyCat.java ScoreUI.java
```

---

### 4. Run the game

```bash
java App
```

The Flappy Cat start screen should appear.

Click **PLAY** to start the game.

---

## 🎯 Gameplay

The game uses a simple physics system:

* Gravity constantly pulls the cat downward.
* Pressing `SPACE` gives the cat upward velocity.
* Pipes move from right to left.
* The score increases when the cat successfully passes pipes.
* Hitting a pipe ends the game.
* Falling below the game area also ends the game.

---

## 🎨 Assets

The game currently uses the following image assets:

```text
flappycat.png
flappycatbg.png
toppipe.png
bottompipe.png
```

These images are loaded by the game at runtime.

Make sure they remain in the correct location when running the game.

---

## 🛠️ Built With

* **Java**
* **Java Swing**
* **AWT**
* `JFrame`
* `JPanel`
* `Timer`
* `Graphics`
* `ImageIcon`

No external game engine is required.

---

## 📚 What This Project Demonstrates

This project is also useful for learning Java game development concepts such as:

* Object-oriented programming
* Classes and objects
* Java Swing
* Game loops
* Timers
* Keyboard input
* Collision detection
* 2D graphics
* Image loading
* Basic physics
* UI design
* Score systems

---

## 🔮 Planned Features

Possible future improvements:

* [ ] High-score system
* [ ] Restart button
* [ ] Better game-over screen
* [ ] Settings menu
* [ ] Sound effects
* [ ] Background music
* [ ] Animated cat
* [ ] Animated pipes
* [ ] Start-screen animations
* [ ] Difficulty settings
* [ ] Pause button
* [ ] Multiple cat skins
* [ ] More backgrounds
* [ ] Pixel-art UI
* [ ] Best-score saving
* [ ] Main menu / settings / game screens
## ⚖️ Disclaimer

Flappy Cat is a fan-made learning project inspired by the gameplay concept of Flappy Bird.

This project is intended for educational and personal use.

---

## 👤 Author

Created as a Java game-development project.

⭐ If you like the project, consider giving the repository a star!
