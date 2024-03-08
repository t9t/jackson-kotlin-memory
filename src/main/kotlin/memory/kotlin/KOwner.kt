package memory.kotlin

import com.fasterxml.jackson.annotation.JsonProperty

data class KOwner(
    @JsonProperty("id") val id: Long,
    @JsonProperty("node_id") val nodeId: String,
    @JsonProperty("login") val login: String,
    @JsonProperty("avatar_url") val avatarUrl: String,
    @JsonProperty("url") val url: String,
    @JsonProperty("html_url") val htmlUrl: String,
    @JsonProperty("type") val type: String,
    @JsonProperty("site_admin") val siteAdmin: Boolean,
    @JsonProperty("gists_url") val gistsUrl: String,
    @JsonProperty("starred_url") val starredUrl: String,
    @JsonProperty("repos_url") val reposUrl: String,
    @JsonProperty("events_url") val eventsUrl: String,
)
