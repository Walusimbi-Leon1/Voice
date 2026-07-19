package voice.features.download

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import voice.core.ui.icons.VoiceIcons
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DownloadScreen(
  onBack: () -> Unit,
) {
  val context = LocalContext.current
  var showDownloadDialog by remember { mutableStateOf<AudiobookItem?>(null) }
  var showAllConfirm by remember { mutableStateOf(false) }

  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("SGSS Audiobooks") },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
          }
        },
      )
    },
  ) { padding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(padding)
        .padding(16.dp),
    ) {
      Text(
        text = "Download audiobooks from the SGSS collection",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )

      Spacer(modifier = Modifier.height(8.dp))

      TextButton(
        onClick = { showAllConfirm = true },
        modifier = Modifier.fillMaxWidth(),
      ) {
        Icon(VoiceIcons.Download, contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text("Download All Audiobooks")
      }

      Spacer(modifier = Modifier.height(16.dp))

      LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        items(SgssCollection.audiobooks) { item ->
          AudiobookCard(
            item = item,
            onClick = { showDownloadDialog = item },
          )
        }
      }
    }
  }

  showDownloadDialog?.let { item ->
    AlertDialog(
      onDismissRequest = { showDownloadDialog = null },
      title = { Text("Download ${item.title}") },
      text = { Text("Download this audiobook to your device?") },
      confirmButton = {
        TextButton(onClick = {
          startDownload(context, item)
          showDownloadDialog = null
        }) {
          Text("Download")
        }
      },
      dismissButton = {
        TextButton(onClick = { showDownloadDialog = null }) {
          Text("Cancel")
        }
      },
    )
  }

  if (showAllConfirm) {
    AlertDialog(
      onDismissRequest = { showAllConfirm = false },
      title = { Text("Download All Audiobooks") },
      text = { Text("Download all ${SgssCollection.audiobooks.size} audiobooks? This may take a while.") },
      confirmButton = {
        TextButton(onClick = {
          SgssCollection.audiobooks.forEach { item ->
            startDownload(context, item)
          }
          showAllConfirm = false
        }) {
          Text("Download All")
        }
      },
      dismissButton = {
        TextButton(onClick = { showAllConfirm = false }) {
          Text("Cancel")
        }
      },
    )
  }
}

@Composable
private fun AudiobookCard(
  item: AudiobookItem,
  onClick: () -> Unit,
) {
  Card(
    onClick = onClick,
    modifier = Modifier.fillMaxWidth(),
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.surfaceVariant,
    ),
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Icon(
        VoiceIcons.Download,
        contentDescription = null,
        tint = MaterialTheme.colorScheme.primary,
      )
      Spacer(modifier = Modifier.width(12.dp))
      Column(modifier = Modifier.weight(1f)) {
        Text(
          text = item.title,
          style = MaterialTheme.typography.titleMedium,
          fontWeight = FontWeight.Medium,
        )
        Text(
          text = item.repo,
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      }
    }
  }
}

private fun startDownload(context: Context, item: AudiobookItem) {
  val request = DownloadManager.Request(Uri.parse(item.downloadUrl))
    .setTitle(item.title)
    .setDescription("Downloading ${item.title} audiobook")
    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
    .setDestinationInExternalPublicDir(
      Environment.DIRECTORY_MUSIC,
      "SGSS_Audiobooks/${item.title}.mp3",
    )
    .setAllowedOverMetered(true)
    .setAllowedOverRoaming(true)

  val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
  downloadManager.enqueue(request)
}
