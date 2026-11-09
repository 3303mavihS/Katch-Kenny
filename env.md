# Environment Setup

## Required Environment

| Tool          | Version        |
|---------------|----------------|
| JDK           | 17+            |
| Android SDK   | 34 (compileSdk)|
| Min Android   | API 23 (6.0)   |
| Gradle        | Wrapper included (`./gradlew`) |
| Android Studio| Latest stable  |

## Environment Variables

This app does **not** require any environment variables, API keys, or secrets to build or run. It works fully offline — the high score is stored locally using Android `SharedPreferences`.

## Local Configuration (optional)

If the Android SDK is not auto-detected, create a `local.properties` file in the project root (this file is git-ignored):

```properties
sdk.dir=/path/to/Android/sdk
```

## Build Commands

```bash
./gradlew assembleDebug     # Build debug APK
./gradlew installDebug      # Install to connected device
./gradlew test              # Run unit tests
```
