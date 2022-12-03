package routes.skills

import org.jetbrains.compose.web.css.*
import utils.*

object SkillsStyle : StyleSheet() {
    const val skillsBackgroundColor = "#363636"
    const val skillBackgroundColor = "#141414"

    val skills by style {
        backgroundColor(Color(skillsBackgroundColor))
    }

    val skillsList by style {
        display(DisplayStyle.Grid)
        gridTemplateColumns(repeat("auto-fill", minmax(22.5.cssRem, 1.fr)))
        gap(2.cssRem)

        media(mediaMaxWidth(AppStyle.mobileThirdBreak)) {
            self {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
            }
        }
    }

    val skill by style {
        val borderGradient = linearGradient(135.deg) {
            stop(Color("#701CB3"))
            stop(Color("#534BAB"))
            stop(Color("#A24598"))
            stop(Color("#033596"))
        }

        borderRadius(.8.cssRem)
        border {
            color(Color.transparent)
            style(LineStyle.Solid)
            width(.1.cssRem)
        }

        background("""${
            linearGradient {
                stop(Color(skillBackgroundColor))
                stop(Color(skillBackgroundColor))
            }
        } padding-box,
			$borderGradient border-box""")

        color(Color.white)

        "img" {
            size(3.5.cssRem)
            borderRadius(.3.cssRem)
        }

        "p" {
            fontSize(.92.cssRem)
        }

        child(self, type("div")) + not(empty) style {
            padding(max(1.cssRem, 1.5.vw))
        }

        className("top") style {
            textAlign(TextAlign.Center)

            group(className("description"), desc(className("description"), type("p"))) style {
                margin(1.2.cssRem, 0.px, 0.px)
            }

            className("info") style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Row)
                alignItems(AlignItems.Center)
                gap(.8.cssRem)

                textAlign(TextAlign.Start)

                className("left") style {
                    backgroundColor(Color("#00000070"))
                    borderRadius(.5.cssRem)
                    padding(.7.cssRem)
                    textAlign(TextAlign.Center)
                    size(fitContent)

                    "p" {
                        margin(.5.cssRem, 0.px, 0.px)
                    }
                }

                child(self, type("p")) style {
                    fontWeight(700)
                    margin(0.px)
                    lineHeight(1.5.cssRem)

                    "p" {
                        margin(0.px)
                    }

                    "i" {
                        color(Color("#FFE547"))
                    }
                }
            }
        }

        className("bottom") style {
            self + not(empty) style {
                borderTop {
                    style(LineStyle.Solid)
                    width(.1.cssRem)
                }
                borderImageSource(borderGradient)
                borderImageSlice(1)
            }

            "h4" {
                margin(0.px)

                self + nthOfType(2.n) style {
                    marginTop(1.2.cssRem)
                }
            }

            "ul" {
                paddingLeft(2.cssRem)

                "li" + selector("::marker") style {
                    fontSize(.8.cssRem)
                }
            }

            "a" {
                color(Color(AppStyle.linkColor))
                textDecoration("none")

                hover {
                    color(Color(AppStyle.linkHoverColor))
                    textDecoration("underline")
                }
            }
        }

        media(mediaMaxWidth(AppStyle.mobileSecondBreak)) {
            self {
                desc(className("description"), type("p")) style {
                    fontSize(.85.cssRem)
                }
            }
        }


        media(mediaMaxWidth(AppStyle.mobileFourthBreak)) {
            self {
                desc(className("top"), className("info")) style {
                    flexDirection(FlexDirection.Column)

                    child(self, type("p")) style {
                        alignSelf(AlignSelf.Start)
                    }

                    className("left") style {
                        padding(.8.cssRem, 1.5.cssRem)
                    }
                }
            }
        }
    }
}