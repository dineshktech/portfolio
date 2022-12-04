import routes.aboutme.AboutMe
import app.softwork.routingcompose.BrowserRouter
import routes.experience.Experiences
import kotlinx.browser.document
import header.Header
import routes.home.Home
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.jetbrains.compose.web.renderComposableInBody
import routes.projects.Projects
import routes.skills.Skills

fun main() {
    //var count: Int by mutableStateOf(0)

    renderComposable(root = document.querySelector("head")!!) {
        Head()
    }

    val renderer = object : marked.TextRenderer() {
        override fun link(href: String?, title: String?, text: String) = """
			<a href="$href" ${title?.let { "title=$it" } ?: ""} class="link">$text</a>
		""".trimIndent()
    }

    marked.use(jso { this.renderer = renderer })

    renderComposableInBody {
        BrowserRouter("/") {
            val pathname = document.location?.pathname ?: "404"
            setTitle("${pathname.removePrefix("/").replace("/", " ")} - CodeWithDino")

            Header()

            Div({
                id("main")
            }) {
                route("/") {
                    Home()
                }

                route("/about") {
                    AboutMe()
                }

                route("/skills") {
                    Skills()
                }

                route("/projects") {
                    Projects()
                }

                route("/experiences") {
                    Experiences()
                }
            }

            Footer()

            noMatch {
                redirect("/portfolio", true)
            }
        }
    }
}

