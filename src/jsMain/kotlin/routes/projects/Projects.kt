package routes.projects

import androidx.compose.runtime.Composable
import routes.home.HomeStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Text
import AppStyle
import utils.minmax
import utils.repeat

@Composable
fun Projects() {
	Style(ProjectsStyle)
	Style(HomeStyle.DataStyle)
	
//	val repos = remember { mutableStateListOf<GitHubRepository>() }
//
//	if (repos.isEmpty()) {
//		LaunchedEffect(Unit) {
////			data.then { gitHubData ->
////				repos += gitHubData.repos.sortedWith(compareByDescending<GitHubRepository> { it.stargazersCount }.thenBy(String.CASE_INSENSITIVE_ORDER) { it.fullName })
////			}
//		}
//	}
	
	Div({
		classes(AppStyle.sections, ProjectsStyle.projects)
	}) {
		H1({
			classes(AppStyle.monoFont, AppStyle.title)
		}) {
			Text("Projects: TBD")
		}
		
		Section({
			classes(ProjectsStyle.projectsList)
		}) {
//			repos.forEach {
//				ProjectCard(it) onClick@{
//					val list = document.querySelector(".${ProjectsStyle.projectsList}").unsafeCast<HTMLElement>()
//					val style = window.getComputedStyle(list)
//					val rowsCount = style.getPropertyValue("grid-template-columns").split(" ").size
//					val gridColumnStart = when {
//						rowsCount > 2 -> rowsCount - 1
//						else -> rowsCount
//					}
//
//					list.style.setProperty("--${DataStyle.gridColumnStartVar.name}", gridColumnStart.toString())
//				}
//			}
		}
	}
}

