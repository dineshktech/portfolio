package routes.experience

import org.jetbrains.compose.web.css.*

object ExperiencesStyle : StyleSheet() {
    const val experiencesBackgroundColor = "#363636"
    const val experienceBackgroundColor = "#1E1E1E"

    val experiences by style {
        backgroundColor(Color(experiencesBackgroundColor))
    }

    val experiencesList by style {
        margin(1.cssRem, 0.cssRem)
        display(DisplayStyle.Flex)
        gap(2.cssRem)

        "section" {
            backgroundColor(Color(experienceBackgroundColor))
            borderRadius(.75.cssRem)
            padding(.5.cssRem, 1.5.cssRem)

            child(self, type("p")) + firstOfType style {
                margin(0.cssRem)
            }

            "p" {
                lineHeight(1.6.cssRem)
            }

            media(mediaMaxWidth(AppStyle.mobileFirstBreak)) {
                self {
                    padding(.5.cssRem, .8.cssRem)
                }

                "p" {
                    fontSize(.9.cssRem)
                    lineHeight(1.4.cssRem)
                }
            }
        }
    }
}