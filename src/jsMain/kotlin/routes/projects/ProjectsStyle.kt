package routes.projects

import org.jetbrains.compose.web.css.*
import utils.minmax

object ProjectsStyle : StyleSheet() {
    const val projectsBackgroundColor = "#15151C"

    val projects by style {
        backgroundColor(Color(projectsBackgroundColor))
    }

    val projectsList by style {
        display(DisplayStyle.Grid)
        gridTemplateColumns(utils.repeat("auto-fill", minmax(22.5.cssRem, 1.fr)))
        gap(2.cssRem)
        padding(0.px)

        media(mediaMaxWidth(AppStyle.mobileFirstBreak)) {
            self {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
            }
        }
    }
}