# Katch Kenny

A fun Android reaction-testing game. Kenny (the cartoon character) pops up at random positions on a 4x5 grid — tap him as many times as you can before time runs out!

## How to Play

1. Tap **Start** to begin the game.
2. Kenny appears at a random grid position every ~400ms.
3. Tap Kenny as fast as you can to increase your score.
4. You have **15 seconds** — catch as many Kennys as possible!
5. Your high score is saved locally on the device.
6. Tap **Reset** to clear the high score and start fresh.

## Features

- 20-position grid with randomly appearing Kenny
- 15-second countdown timer
- Live score tracking
- Persistent high score via `SharedPreferences`
- Edge-to-edge display support

## Tech Stack

- **Language:** Kotlin
- **Platform:** Android (minSdk 23, targetSdk 34)
- **UI:** XML layouts with ViewBinding, ConstraintLayout
- **Build system:** Gradle (Kotlin DSL)

## Project Structure

```
app/
└── src/main/
    ├── java/com/katchkenny/
    │   └── MainActivity.kt      # Game logic (timer, random spawn, scoring)
    ├── res/
    │   ├── layout/
    │   │   └── activity_main.xml  # Game grid UI
    │   └── drawable/
    │       └── kenny.png          # Kenny character image
    └── AndroidManifest.xml
```

## Getting Started

### Prerequisites

- Android Studio (latest stable)
- JDK 17+
- Android SDK 34

### Build & Run

```bash
# Clone the repo
git clone <repo-url>
cd Katch-Kenny

# Build debug APK
./gradlew assembleDebug

# Install on a connected device/emulator
./gradlew installDebug
```

Or open the project in **Android Studio** and press **Run ▶**.

### Run Tests

```bash
./gradlew test              # Unit tests
./gradlew connectedAndroidTest  # Instrumented tests (requires device/emulator)
```

## Environment

See [env.md](env.md) for environment setup details.
