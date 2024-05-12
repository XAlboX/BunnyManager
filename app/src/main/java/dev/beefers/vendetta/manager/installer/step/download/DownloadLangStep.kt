package dev.beefers.vendetta.manager.installer.step.download

import androidx.compose.runtime.Stable
import dev.beefers.vendetta.manager.R
import dev.beefers.vendetta.manager.installer.step.download.base.DownloadStep
import java.io.File
import java.util.Locale

/**
 * Downloads the languages split, will always be English because Discord doesn't store their strings in this split
 */
@Stable
class DownloadLangStep(
    dir: File,
    workingDir: File,
    version: String
): DownloadStep() {

    override val nameRes = R.string.step_dl_lang

    val localeLang = getLocaleLanguageInitials()

    override val url: String = "$baseUrl/tracker/download/$version/config." + "$localeLang"
    override val destination = dir.resolve("config." + "$localeLang" + "-$version.apk")
    override val workingCopy = workingDir.resolve("config." + "$localeLang" + "-$version.apk")

}

private fun getLocaleLanguageInitials(): String {
        val locale = java.util.Locale.getDefault()
        return locale.language
}
