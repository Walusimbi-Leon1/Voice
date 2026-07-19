package voice.features.download

data class AudiobookItem(
  val title: String,
  val repo: String,
  val downloadUrl: String,
  val tag: String,
)

object SgssCollection {

  val audiobooks = listOf(
    AudiobookItem(
      title = "1st Teachings",
      repo = "1st-teachings",
      downloadUrl = "https://github.com/Walusimbi-Leon1/1st-teachings/releases/download/v1.0-audiobook/1st.Teachings_full.mp3",
      tag = "v1.0-audiobook",
    ),
    AudiobookItem(
      title = "2nd Teachings",
      repo = "2nd-teachings",
      downloadUrl = "https://github.com/Walusimbi-Leon1/2nd-teachings/releases/download/v1.0-audiobook/2nd.Teachings_full.mp3",
      tag = "v1.0-audiobook",
    ),
    AudiobookItem(
      title = "4th Teachings",
      repo = "4th-teachings",
      downloadUrl = "https://github.com/Walusimbi-Leon1/4th-teachings/releases/download/v1.0-audiobook/4th.Teachings_full.mp3",
      tag = "v1.0-audiobook",
    ),
    AudiobookItem(
      title = "Beyond the Horizon",
      repo = "beyond-the-horizon",
      downloadUrl = "https://github.com/Walusimbi-Leon1/beyond-the-horizon/releases/download/v3.0-audiobook/Beyond.The.Horizon_chapter_001.mp3",
      tag = "v3.0-audiobook",
    ),
    AudiobookItem(
      title = "Dialogues with My Love",
      repo = "dialogues-with-my-love",
      downloadUrl = "https://github.com/Walusimbi-Leon1/dialogues-with-my-love/releases/download/v1.0-audiobook/Dialogues.with.My.Love_full.mp3",
      tag = "v1.0-audiobook",
    ),
    AudiobookItem(
      title = "Letters I Never Sent",
      repo = "letters-i-never-sent",
      downloadUrl = "https://github.com/Walusimbi-Leon1/letters-i-never-sent/releases/download/v3.0-audiobook/Letters.I.Never.Sent_chapter_001.mp3",
      tag = "v3.0-audiobook",
    ),
    AudiobookItem(
      title = "Salt and Silk",
      repo = "salt-and-silk",
      downloadUrl = "https://github.com/Walusimbi-Leon1/salt-and-silk/releases/download/v1.0-audiobook/Salt.and.Silk_full.mp3",
      tag = "v1.0",
    ),
    AudiobookItem(
      title = "Temple Mount",
      repo = "temple-mount",
      downloadUrl = "https://github.com/Walusimbi-Leon1/temple-mount/releases/download/v1.0-audiobook/Temple.Mount_full.mp3",
      tag = "v1.0-audiobook",
    ),
    AudiobookItem(
      title = "The Architecture of Thought",
      repo = "the-architecture-of-thought",
      downloadUrl = "https://github.com/Walusimbi-Leon1/the-architecture-of-thought/releases/download/v3.0-audiobook/The.Architecture.Of.Thought_chapter_001.mp3",
      tag = "v3.0-audiobook",
    ),
    AudiobookItem(
      title = "The Rhythm of Your Heart",
      repo = "the-rhythm-of-your-heart",
      downloadUrl = "https://github.com/Walusimbi-Leon1/the-rhythm-of-your-heart/releases/download/v3.0-audiobook/The.Rhythm.Of.Your.Heart_chapter_001.mp3",
      tag = "v3.0-audiobook",
    ),
    AudiobookItem(
      title = "Under the Acacia Tree",
      repo = "under-the-acacia-tree",
      downloadUrl = "https://github.com/Walusimbi-Leon1/under-the-acacia-tree/releases/download/v3.0-audiobook/Under.the.Acacia.Tree_full.mp3",
      tag = "v3.0-audiobook",
    ),
    AudiobookItem(
      title = "Whispers of Destiny",
      repo = "whispers-of-destiny",
      downloadUrl = "https://github.com/Walusimbi-Leon1/whispers-of-destiny/releases/download/v3.0-audiobook/Whispers.Of.Destiny_chapter_001.mp3",
      tag = "v3.0-audiobook",
    ),
    AudiobookItem(
      title = "Architecture of Stillness",
      repo = "architecture-of-stillness",
      downloadUrl = "https://github.com/Walusimbi-Leon1/architecture-of-stillness/releases",
      tag = "v1.0",
    ),
    AudiobookItem(
      title = "Atlas of Feeling",
      repo = "atlas-of-feeling",
      downloadUrl = "https://github.com/Walusimbi-Leon1/atlas-of-feeling/releases",
      tag = "v1.0",
    ),
    AudiobookItem(
      title = "Burning Hours",
      repo = "burning-hours",
      downloadUrl = "https://github.com/Walusimbi-Leon1/burning-hours/releases",
      tag = "v1.0",
    ),
  )
}
