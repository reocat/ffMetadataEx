# ffMetadataEx

Standalone FFmpeg metadata extractor app plugin for [OuterTune](https://github.com/DD3Boh/OuterTune)

## What is this?
For downloads, go to the [releases](https://github.com/mikooomich/ffMetadataEx/releases)

At it's core, this extracts all the (text) tag data from audio files, and returns it in a plain text string, all in a somewhat hacky way.


## Building

1. First you will need to setup the [Android NDK](https://developer.android.com/studio/projects/install-ndk)

2. We use FFMpeg to extract metadata from local files. The FFMpeg binaries must be resolved in one of two ways:

	- a) Build libraries yourself. Clone [ffmpeg-android-maker](https://github.com/Javernaut/ffmpeg-android-maker) into
	  `/app/src/main/cpp/ffmpeg-android-maker`, run the build script. Note: It may be helpful to modify the
	  FFmpeg build script disable unneeded FFmpeg features to reduce app size,
	  see [here](https://github.com/mikooomich/ffmpeg-android-maker/blob/master/scripts/ffmpeg/build.sh) for an example.

	- b) Use prebuilt FFmpeg libraries.
	  Clone [prebuilt ffmpeg-android-maker](https://github.com/mikooomich/ffmpeg-android-maker-prebuilt) into
	  `/app/src/main/cpp/ffmpeg-android-maker`.

3Start the build are you normally would.
