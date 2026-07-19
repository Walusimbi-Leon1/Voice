package voice.features.download

import androidx.compose.runtime.Composable
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.IntoSet
import dev.zacsweers.metro.Provides
import voice.core.common.rootGraphAs
import voice.navigation.Destination
import voice.navigation.NavEntryProvider
import voice.navigation.Navigator

@ContributesTo(AppScope::class)
interface DownloadGraph {
  val downloadNavigator: DownloadNavigator
}

class DownloadNavigator(
  private val navigator: Navigator,
) {
  fun goBack() {
    navigator.goBack()
  }
}

@ContributesTo(AppScope::class)
interface DownloadProvider {

  @Provides
  @IntoSet
  fun downloadNavEntryProvider(): NavEntryProvider<*> = NavEntryProvider<Destination.Download> { key ->
    NavEntry(key) {
      DownloadScreen(
        onBack = {
          rootGraphAs<DownloadGraph>().downloadNavigator.goBack()
        },
      )
    }
  }
}
