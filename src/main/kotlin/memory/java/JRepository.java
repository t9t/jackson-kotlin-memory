package memory.java;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public record JRepository(
        @JsonProperty("id") long id,
        @JsonProperty("node_id") String nodeId,
        @JsonProperty("name") String name,
        @JsonProperty("full_name") String fullName,
        @JsonProperty("owner") JOwner owner,
        @JsonProperty("private") boolean isPrivate,
        @JsonProperty("html_url") String htmlUrl,
        @JsonProperty("description") String description,
        @JsonProperty("fork") boolean fork,
        @JsonProperty("url") String url,
        @JsonProperty("archive_url") String archiveUrl,
        @JsonProperty("comments_url") String commentsUrl,
        @JsonProperty("commits_url") String commitsUrl,
        @JsonProperty("forks_url") String forksUrl,
        @JsonProperty("branches_url") String branchesUrl,
        @JsonProperty("git_refs_url") String gitRefsUrl,
        @JsonProperty("git_url") String gitUrl,
        @JsonProperty("issues_url") String issuesUrl,
        @JsonProperty("ssh_url") String sshUrl,
        @JsonProperty("homepage") String homepage,
        @JsonProperty("language") String language,
        @JsonProperty("forks_count") long forksCount,
        @JsonProperty("stargazers_count") long stargazersCount,
        @JsonProperty("size") long size,
        @JsonProperty("default_branch") String defaultBranch,
        @JsonProperty("topics") List<String> topics,
        @JsonProperty("pushed_at") String pushedAt,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("permissions") Map<String, Boolean> permissions
) {
}
