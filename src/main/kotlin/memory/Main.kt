package memory

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import memory.java.JRepository
import memory.kotlin.KRepository

fun main() {
    val kotlinObjectMapper = ObjectMapper().registerModules(KotlinModule.Builder().build())
    val plainObjectMapper = ObjectMapper()

    fun runTest(type: String, readValue: () -> Unit) {
        gc()
        val before = usedMemory()
        println("    Reading $type")
        for (i in (0..50_000)) {
            readValue()
        }
        val after = usedMemory()
        println("      -> Before: ${formatBytes(before)}; After: ${formatBytes(after)}; Allocated: ${formatBytes(after - before)}")
    }

    gc()
    for ((type, objectMapper) in listOf("kotlin" to kotlinObjectMapper, "plain" to plainObjectMapper)) {
        println("Using ${type}ObjectMapper")

        runTest("KRepository") { objectMapper.readValue<KRepository>(payload) }
        runTest("JRepository") { objectMapper.readValue<JRepository>(payload) }
    }
}

private fun formatBytes(bytes: Long): String {
    return when {
        bytes <= 1024 -> "${bytes}B"
        bytes <= 1024 * 1024 -> "${round2(bytes / 1024.0)}KiB"
        bytes <= 1024 * 1024 * 1024 -> "${round2(bytes / 1024.0 / 1024.0)}MiB"
        else -> "${round2(bytes / 1024.0 / 1024.0 / 1024.0)}GiB"
    }
}

private fun round2(d: Double): Double = Math.round(d * 100.0) / 100.0

private fun usedMemory(): Long = Runtime.getRuntime().let { it.totalMemory() - it.freeMemory() }

private fun gc() {
    System.gc()
    Thread.sleep(1_000)
    System.gc()
    Thread.sleep(1_000)
}

private val payload = """{
    "id": 1296269,
    "node_id": "MDEwOlJlcG9zaXRvcnkxMjk2MjY5",
    "name": "Hello-World",
    "full_name": "octocat/Hello-World",
    "owner": {
      "login": "octocat",
      "id": 1,
      "node_id": "MDQ6VXNlcjE=",
      "avatar_url": "https://github.com/images/error/octocat_happy.gif",
      "url": "https://api.github.com/users/octocat",
      "html_url": "https://github.com/octocat",
      "gists_url": "https://api.github.com/users/octocat/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/octocat/starred{/owner}{/repo}",
      "repos_url": "https://api.github.com/users/octocat/repos",
      "events_url": "https://api.github.com/users/octocat/events{/privacy}",
      "type": "User",
      "site_admin": false
    },
    "private": false,
    "html_url": "https://github.com/octocat/Hello-World",
    "description": "This your first repo!",
    "fork": false,
    "url": "https://api.github.com/repos/octocat/Hello-World",
    "archive_url": "https://api.github.com/repos/octocat/Hello-World/{archive_format}{/ref}",
    "branches_url": "https://api.github.com/repos/octocat/Hello-World/branches{/branch}",
    "comments_url": "https://api.github.com/repos/octocat/Hello-World/comments{/number}",
    "commits_url": "https://api.github.com/repos/octocat/Hello-World/commits{/sha}",
    "forks_url": "https://api.github.com/repos/octocat/Hello-World/forks",
    "git_refs_url": "https://api.github.com/repos/octocat/Hello-World/git/refs{/sha}",
    "git_url": "git:github.com/octocat/Hello-World.git",
    "issues_url": "https://api.github.com/repos/octocat/Hello-World/issues{/number}",
    "ssh_url": "git@github.com:octocat/Hello-World.git",
    "homepage": "https://github.com",
    "language": null,
    "forks_count": 9,
    "stargazers_count": 80,
    "size": 108,
    "default_branch": "master",
    "topics": [
      "octocat",
      "atom",
      "electron",
      "api"
    ],
    "pushed_at": "2011-01-26T19:06:43Z",
    "created_at": "2011-01-26T19:01:12Z",
    "updated_at": "2011-01-26T19:14:43Z",
    "permissions": {
      "admin": false,
      "push": false,
      "pull": true
    }
  }"""
