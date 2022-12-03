package routes.home

import A
import AppStyle
import HomeCard
import data.ProjectRepository
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import localImage
import markdownParagraph
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.CSSMediaQuery.MediaType
import org.jetbrains.compose.web.css.CSSMediaQuery.MediaType.Enum.Screen
import org.jetbrains.compose.web.css.CSSMediaQuery.Only
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.*
import projectRepos
import routes.skills.skills
import utils.*
import kotlin.js.Date

inline val years get() = (Date.now() - Date("2002-10-15").getTime()) / 1000 / 60 / 60 / 24 / 365

@Composable
fun Home() {
    val homeRepositories = remember { mutableStateListOf<ProjectRepository>() }

    Style(HomeStyle)
    Style(HomeStyle.DataStyle)

    Section({
        classes(HomeStyle.top)
    }) {
        Div({
            classes(HomeStyle.topInfo)
        }) {
            Img(localImage("dk.jpg"), "avatar") {
                classes(AppStyle.avatar)
            }

            H2 {
                Text("Dinesh Kumar M ")
            }

            H3 {
                Text("Team Lead - Software Engineering")
            }

            H3 {
                Text("Bangalore, India")
            }
        }

        P({
            markdownParagraph(
                """
					I'm Dinesh Kumar M, 11+ years experienced software engineer, currently working at [Jio Platforms](https://www.jio.com) as Team Lead.
					Working mostly on Android, Kotlin, ComposeUi(Android & Desktop), Compose(Kotlin/Js) and Kotlin-multiplatform SDKs. 

					In my extra time, I do explore Ktor-server/Spring Api development and Api automation testing, also do write and maintain open source code on github.
	
				""".trimIndent(), true, AppStyle.monoFont
            )
        })

        console.log("home repo empty : " + homeRepositories.isEmpty())
        if (homeRepositories.isEmpty()) {
            LaunchedEffect(Unit) {
                console.log("project repo size : " + projectRepos.size)
                projectRepos.forEach { gitHubData ->
                    homeRepositories.add(gitHubData)
                }
                console.log("home repo size : " + homeRepositories.size)
            }
        }

        Section({
            classes(HomeStyle.section)
        }) {
            Div({
                classes("list", "repos")
            }) {
                console.log("Trying to load repos : " + homeRepositories.size)
                if (homeRepositories.isNotEmpty()) {
                    homeRepositories.forEach {
                        Div({
                            classes(HomeStyle.DataStyle.homeCard, "repo")
                        }) {
                            HomeCard(it)
                        }
                    }
                }
            }

            A("/projects", "See other projects", AppStyle.button)
        }

        Section({
            classes(HomeStyle.section)
        }) {
            Div({
                classes("list", "skills")
            }) {
                skills.forEach {
                    A("/skills#${it.skillsSet.name}", {
                        classes("skill")
                    }) {
                        it.DisplaySimple()
                    }
                }
            }

            A("/skills", "See all skills", AppStyle.button)
        }
    }
}
