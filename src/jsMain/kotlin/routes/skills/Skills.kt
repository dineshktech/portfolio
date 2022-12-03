package routes.skills

import P
import data.ProjectRepository
import androidx.compose.runtime.Composable
import localImage
import markdownParagraph
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import AppStyle

data class SkillsSet(
    val name: String,
    val since: Int,
    val learnedFor: String,
    val nowUsing: String,
    val level: Int,
    val description: String,
    val iconUrl: String,
    val githubProjects: List<String> = listOf(),
    val companyProjects: List<String> = listOf(),
)

data class Skill(
    val skillsSet: SkillsSet,
    var githubProjects: MutableList<ProjectRepository> = mutableListOf()
) {
    @Composable
    fun Display() {
        Div({
            classes("top")
        }) {
            Div({
                classes("info")
            }) {
                Div({
                    classes("left")
                }) {
                    Img(skillsSet.iconUrl, alt = skillsSet.name)
                    P(skillsSet.name, AppStyle.monoFont)
                }


                P({
                    val learnedAndNowUserFor =
                        if (skillsSet.learnedFor == skillsSet.nowUsing) "<br>Using for: ${skillsSet.learnedFor}"
                        else "<br>Learned for: ${skillsSet.learnedFor}<br>Now using: ${skillsSet.nowUsing}"

                    markdownParagraph(
                        """
							Since: ${skillsSet.since}$learnedAndNowUserFor
							Level: ${"<i class='fa-solid fa-star'></i> ".repeat(skillsSet.level)}
						""".trimIndent(), true
                    )
                })
            }

            P({
                markdownParagraph(skillsSet.description, false, AppStyle.monoFont, "description")
            })
        }

        Div({
            classes("bottom")
        }) {
            @Composable
            fun section(name: String, list: List<ProjectRepository>) {
                if (list.isEmpty()) return

                H4({
                    classes(AppStyle.monoFont)
                }) {
                    Text(name)
                }

//				Ul {
//					list.distinctBy { it.fullName }.sortedWith(compareBy(String.CASE_INSENSITIVE_ORDER) { it.name }).forEach {
//						Li {
//							A(it.htmlUrl, it.name)
//						}
//					}
//				}
            }

            //section("GitHub Projects:", githubProjects.filter { project -> schoolProjects.none { project.fullName == it.fullName } })
        }
    }

    @Composable
    fun DisplaySimple() {
        Img(skillsSet.iconUrl, alt = skillsSet.name)
        P(skillsSet.name, AppStyle.monoFont)
    }
}

fun devIcon(name: String, suffix: String = "original") =
    "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/$name/$name-$suffix.svg"

val skills = listOf(
    SkillsSet(
        name = "Android", since = 2011,
        learnedFor = "Android application development.",
        nowUsing = "Pretty much everything.",
        level = 5,
        description = """
			Android is a mobile operating system based on a modified version of the Linux kernel and other open-source software, designed primarily for touchscreen mobile devices such as smartphones and tablets. 
            Android is developed by a consortium of developers known as the Open Handset Alliance and commercially sponsored by Google.
		""".trimIndent(),
        iconUrl = devIcon("android"),
        companyProjects = listOf()
    ),
    SkillsSet(
        name = "Kotlin", since = 2011,
        learnedFor = "Multiplatform application development",
        nowUsing = "Pretty much everything.",
        level = 5,
        description = """
			Kotlin is a static type, object-oriented programing (OOP) language that is interoperable with the Java virtual machine, Java libraries and Android.
			Kotlin saves time for developers as the less verbose language provides briefer and less redundant code. Kotlin can be compiled into JavaScript or an LLVM encoder.
		""".trimIndent(),
        iconUrl = localImage("kotlin_logo.svg"),
        companyProjects = listOf()
    ),
    SkillsSet(
        name = "Java",
        since = 2011,
        learnedFor = "Android application development",
        nowUsing = "Backend of mobile apps.",
        level = 5,
        description = """
			Java is a widely used object-oriented programming language and software platform that runs on billions of devices, including notebook computers, mobile devices, gaming consoles, medical devices and many others.
			The rules and syntax of Java are based on the C and C++ languages.
		""".trimIndent(),
        iconUrl = devIcon("java")
    ),
    SkillsSet(
        name = "Spring+Kotlin",
        since = 2020,
        learnedFor = "Storing data other than in a JSON.",
        nowUsing = "Storing data efficiently.",
        level = 3,
        description = """
			Spring boot is an Java-based open source framework used to create a micro service. Since kotlin has interoperable behaviour with Java, spring boot is widely used framework
            in most of the kotlin based projects. 
		""".trimIndent(),
        iconUrl = devIcon("spring"),
        githubProjects = listOf(),
        companyProjects = listOf()
    ),
    SkillsSet(
        name = "Postgres",
        since = 2020,
        learnedFor = "Storing data other than in a JSON.",
        nowUsing = "Storing data efficiently.",
        level = 3,
        description = """
			PostgreSQL(aka Postgres) is an advanced, enterprise-class, and open-source relational database system. PostgreSQL supports both SQL(relational) and JSON(non-relational) querying.
            PostgreSQL is used as a primary database for many web applications as well as mobile and analytics applications.
		""".trimIndent(),
        iconUrl = devIcon("mysql"),
        githubProjects = listOf(),
        companyProjects = listOf()
    ),
    SkillsSet(
        name = "TypeScript",
        since = 2020,
        learnedFor = "Frontend App Development.",
        nowUsing = "SDK Development",
        level = 4,
        description = """
			TypeScript is an open-source, object-oriented language developed and maintained by Microsoft, licensed under Apache 2 license.
			TypeScript extends JavaScript by adding data types, classes, and other object-oriented features with type-checking. It is a typed superset of JavaScript that compiles to plain JavaScript.
		""".trimIndent(),
        iconUrl = devIcon("typescript")
    ),
    SkillsSet(
        name = "JavaScript",
        since = 2020,
        learnedFor = "Web App Development",
        nowUsing = "Along with ReactJS",
        level = 4,
        description = """
			JavaScript (often shortened to JS) is a lightweight, interpreted, object-oriented language with first-class functions, and is best known as the scripting language for Web pages, but it's used in many non-browser environments as well.
		""".trimIndent(),
        iconUrl = devIcon("javascript"),
        githubProjects = listOf(),
        companyProjects = listOf()
    ),
    SkillsSet(
        name = "CSS", since = 2020,
        learnedFor = "Styling websites.",
        nowUsing = "Styling websites.",
        level = 5,
        description = """
			Cascading Style Sheets (CSS) is a stylesheet language used to describe the presentation of a document written in HTML or XML (including XML dialects such as SVG, MathML or XHTML).
			CSS describes how elements should be rendered on screen, on paper, in speech, or on other media.
		""".trimIndent(),
        iconUrl = devIcon("css3"),
        companyProjects = listOf(),
    ),
    SkillsSet(
        name = "HTML",
        since = 2020,
        learnedFor = "Creating websites.",
        nowUsing = "Creating websites.",
        level = 4,
        description = """
			HyperText Markup Language (HTML) is the basic scripting language used by web browsers to render pages on the world wide web. HyperText allows a user to click a link and be redirected to a new page referenced by that link.
		""".trimIndent(),
        iconUrl = devIcon("html5"),
        companyProjects = listOf(),
        githubProjects = listOf()
    ),
    SkillsSet(
        name = "Docker",
        since = 2020,
        learnedFor = "Shipping apps.",
        nowUsing = "Shipping apps.",
        level = 3,
        description = """
		    Docker is an open platform for developing, shipping, and running applications. Docker enables you to separate your applications from you infrastructure so you can deliver software quickly. 
            Docker provides the ability to package and run and application in a loosely isolated environment called a container. 
		""".trimIndent(),
        iconUrl = devIcon("docker"),
        companyProjects = listOf(),
    ),
//    Language(
//        name = "Kubernetes",
//        since = 2020,
//        learnedFor = "Styling websites.",
//        nowUsing = "Styling websites.",
//        level = 3,
//        description = """
//			Cascading Style Sheets (CSS) is a stylesheet language used to describe the presentation of a document written in HTML or XML (including XML dialects such as SVG, MathML or XHTML).
//			CSS describes how elements should be rendered on screen, on paper, in speech, or on other media.
//		""".trimIndent(),
//        iconUrl = devIcon("kubernetes", "plain"),
//        companyProjects = listOf(),
//    ),
//    SkillsSet(
//        name = "Git",
//        since = 2011,
//        learnedFor = "Styling websites.",
//        nowUsing = "Styling websites.",
//        level = 5,
//        description = """
//			Git is a distributed revision control and source code management syste with an emphasis on speed. Git was initially designed and developed by
//		""".trimIndent(),
//        iconUrl = devIcon("git"),
//        companyProjects = listOf(),
//    ),
//    SkillsSet(
//        name = "Jenkins",
//        since = 2015,
//        learnedFor = "Styling websites.",
//        nowUsing = "Styling websites.",
//        level = 5,
//        description = """
//			Cascading Style Sheets (CSS) is a stylesheet language used to describe the presentation of a document written in HTML or XML (including XML dialects such as SVG, MathML or XHTML).
//			CSS describes how elements should be rendered on screen, on paper, in speech, or on other media.
//		""".trimIndent(),
//        iconUrl = devIcon("jenkins"),
//        companyProjects = listOf(),
//    ),

    SkillsSet(
        name = "Bash",
        since = 2015,
        learnedFor = "Creating scripts on Linux.",
        nowUsing = "Creating scripts on Linux.",
        level = 3,
        description = """
			Bash is a sh-compatible command language interpreter that executes commands read from the standard input or from a file.
			bash also incorporates useful features from the Korn and C shells (ksh and csh).
		""".trimIndent(),
        iconUrl = devIcon("bash")
    ),
).map(::Skill)

@Composable
fun Skills() {
    Style(SkillsStyle)

//	val repos = remember { mutableStateListOf<GitHubRepository>() }
//
//	if (repos.isEmpty()) {
//		LaunchedEffect(Unit) {
//			data.then { gitHubData ->
//				repos += gitHubData.repos.filter { it.language != null }
//			}
//		}
//	}

    Div({
        classes(AppStyle.sections, SkillsStyle.skills)
    }) {

        Section({
            classes(SkillsStyle.skillsList)
        }) {
            skills.sortedWith(compareByDescending { it.skillsSet.level }).forEach { skill ->
//				if (skill.githubProjects.isEmpty()) {
//					skill.githubProjects += repos.filter {
//						it.language!!.equals(skill.language.name, true)
//					} + repos.filter { it.fullName in skill.language.githubProjects }
//				}

                Div({
                    id(skill.skillsSet.name)
                    classes(SkillsStyle.skill)
                }) {
                    skill.Display()
                }
            }
        }
    }
}
