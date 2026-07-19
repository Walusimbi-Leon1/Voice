# Voice — Audiobook Player for Android

**A minimalistic, user-focused audiobook player for Android, built for reliability and simplicity.**

Voice turns your own audiobook files into a calm, focused listening library. It remembers where you stopped, keeps playback controls close, and includes the audiobook-specific details that generic music players miss: chapter navigation, sleep timer, bookmarks, playback speed, silence skipping, and auto-rewind after pauses.

## Features

- **Made for your files:** Add a folder once and Voice organizes your local M4B, MP3, M4A, OGG, OGA, and OPUS audiobooks.
- **Built for listening:** Resume positions, bookmarks, sleep timer fade-out, volume boost, speed control, and Android Auto support are part of the core experience.
- **Private and uncluttered:** No account, no ads, no forced cloud sync. Your library stays on your device.

## Download

Download the latest APK from [Releases](https://github.com/Walusimbi-Leon1/Voice/releases).

## Building from Source

1. Clone the repository:
   ```bash
   git clone https://github.com/Walusimbi-Leon1/Voice.git
   cd Voice
   ```

2. Build the debug APK:
   ```bash
   ./gradlew assembleFreeDebug
   ```

3. Build the release APK:
   ```bash
   ./gradlew assembleFreeRelease
   ```

The APK will be generated in `app/build/outputs/apk/`.

## License

Voice is licensed under [GNU GPLv3](LICENSE.md). By contributing, you agree to license your code under the same terms.
