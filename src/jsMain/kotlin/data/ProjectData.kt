@file:OptIn(ExperimentalJsExport::class)

package data

import kotlinx.serialization.Serializable

@JsExport
@Serializable
data class ProjectRepository(
    val language: String?,
    val name: String,
    val description: String?,
    val htmlUrl: String,
    val repoName: String,
    val appDownloads: String,
)
