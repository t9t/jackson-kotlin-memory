package memory.java;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JOwner(
        @JsonProperty("id") long id,
        @JsonProperty("node_id") String nodeId,
        @JsonProperty("login") String login,
        @JsonProperty("avatar_url") String avatarUrl,
        @JsonProperty("url") String url,
        @JsonProperty("html_url") String htmlUrl,
        @JsonProperty("type") String type,
        @JsonProperty("site_admin") boolean siteAdmin,
        @JsonProperty("gists_url") String gistsUrl,
        @JsonProperty("starred_url") String starredUrl,
        @JsonProperty("repos_url") String reposUrl,
        @JsonProperty("events_url") String eventsUrl
) {
}
