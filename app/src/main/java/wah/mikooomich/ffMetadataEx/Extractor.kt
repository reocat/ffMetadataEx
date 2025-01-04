package wah.mikooomich.ffMetadataEx

import android.app.Activity
import android.content.Intent

import android.widget.Toast

class Extractor : Activity() {
	// load advanced scanner libs
	init {
		System.loadLibrary("avcodec")
		System.loadLibrary("avdevice")
		System.loadLibrary("ffmetaexjni")
		System.loadLibrary("avfilter")
		System.loadLibrary("avformat")
		System.loadLibrary("avutil")
		System.loadLibrary("swresample")
		System.loadLibrary("swscale")
	}

	override fun onStart() {
		super.onStart()

		val path = intent.getStringExtra("filePath")
		if (path.isNullOrEmpty()) {
			Toast.makeText(this, "Invalid file path provided", Toast.LENGTH_SHORT).show()
			setResult(RESULT_CANCELED)
			finish()
			return
		}

		try {
			val result = FFMpegWrapper().getFullAudioMetadata(path)
			val intent = Intent().apply {
				putExtra("id", path)
				putExtra("rawExtractorData", result) // Pass raw string metadata
			}
			setResult(RESULT_OK, intent)
		} catch (e: Exception) {
			e.printStackTrace()
			setResult(RESULT_CANCELED)
		}

		finish()
	}
}
