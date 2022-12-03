package routes.home

import AppStyle
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import utils.*

object HomeStyle : StyleSheet() {
    init {
        id("main") style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            alignItems(AlignItems.Center)
            background(linearGradient(180.deg) {
                stop(Color("#1D1D1E"), (-3).percent)
                stop(Color("#111629"), 14.percent)
                stop(Color("#29183F"), 65.percent)
                stop(Color("#302F39"), 90.percent)
            })

            padding(1.cssRem, 8.5.vw)
        }

        media(
            CSSMediaQuery.Only(
                CSSMediaQuery.MediaType(CSSMediaQuery.MediaType.Enum.Screen),
                mediaMaxWidth(AppStyle.mobileFirstBreak)
            )
        ) {
            id("main") style {
                paddingLeft(5.vw)
                paddingRight(5.vw)
            }
        }

        media(
            CSSMediaQuery.Only(
                CSSMediaQuery.MediaType(CSSMediaQuery.MediaType.Enum.Screen),
                mediaMaxWidth(AppStyle.mobileFourthBreak)
            )
        ) {
            id("main") style {
                paddingLeft(2.vw)
                paddingRight(2.vw)
            }
        }
    }

    val top by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Center)
        textAlign(TextAlign.Center)
        maxWidth(100.percent)
    }

    val topInfo by style {
        height(80.percent)

        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Center)

        universal style {
            marginTop(.2.cssRem)
            marginBottom(.2.cssRem)
        }

        "h2" style {
            fontSize(1.7.cssRem)

            universal style {
                fontSize(1.2.cssRem)
                fontWeight(400)
            }

            lastChild style {
                fontWeight(700)
                fontSize(1.4.cssRem)
            }
        }

        "h3" {
            fontWeight(400)
        }
    }

    val section by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Center)
        gap(1.5.cssRem)
        marginTop(3.cssRem)
        padding(0.px, 1.cssRem)

        className("skills") style {
            flexWrap(FlexWrap.Wrap)
        }

        className("list") style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            justifyContent(JustifyContent.Center)
            gap(1.cssRem)

            className("skill") style {
                backgroundColor(Color("#252525"))
                borderRadius(.4.cssRem)
                color(Color.white)
                padding(.3.cssRem, .5.cssRem)

                "img" {
                    borderRadius(.4.cssRem)
                    size(3.5.cssRem)
                }
            }
        }

        media(
            CSSMediaQuery.Only(
                CSSMediaQuery.MediaType(CSSMediaQuery.MediaType.Enum.Screen),
                mediaMaxWidth(AppStyle.mobileFirstBreak)
            )
        ) {
            className("repos") style {
                flexDirection(FlexDirection.Column)
                alignItems(AlignItems.Center)

                className("repo") style {
                    maxWidth(95.percent)
                }
            }
        }
    }

    object DataStyle : StyleSheet() {
        const val homeCardBackground = "#181818"
        const val homeCardTitleBackground = "#0e0e0e"
        const val homeCardColor = "#cacaca"
        const val projectCardClosedBackground = "#2a2b36"
        const val projectCardOpenBackgroundStart = "#66085190"
        const val projectCardOpenBackgroundEnd = "#39379490"

        val gridColumnStartVar by variable<StylePropertyNumber>()
        val imageSize by variable<CSSSizeValue<*>>()

        @OptIn(ExperimentalComposeWebApi::class)
        val homeCard by style {
            borderRadius(.8.cssRem)
            overflow(Overflow.Hidden)
            width(clamp(17.5.cssRem, 25.vw, 25.cssRem))

            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            justifyContent(JustifyContent.SpaceBetween)

            "h3" {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.Center)
                alignItems(AlignItems.Center)
                gap(.5.cssRem)

                backgroundColor(Color(homeCardTitleBackground))
                margin(0.px)
                padding(1.cssRem)

                "a" {
                    color(Color.white)
                }

                "img" {
                    size(1.3.cssRem)
                }
            }

            "p" {
                color(Color(homeCardColor))
            }

            child(self, selector("div")) style {
                backgroundColor(Color(homeCardBackground))
                textAlign(TextAlign.Start)

                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                justifyContent(JustifyContent.SpaceBetween)
                gap(3.cssRem)

                height(100.percent)
                padding(1.cssRem)
            }

            combine(self, className("active")) style {
                transform {
                    scale(1.05)
                }
            }
        }

        val projectCard by style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            alignItems(AlignItems.Center)
            gap(1.cssRem)
            padding(clamp(1.6.cssRem, 2.vw, 3.5.cssRem))
            borderRadius(.75.cssRem)

            cursor(Cursor.Pointer)

            transitions {
                ease(AnimationTimingFunction.EaseInOut)
                duration(.5.s)
                properties("max-height")
            }

            "img" {
                size(imageSize.value())
                borderRadius(imageSize.value())
            }
        }

        val projectCardOpen by style {
            flexDirection(FlexDirection.Column)
            gap(2.cssRem)
            imageSize(5.cssRem)
            gridColumn("${gridColumnStartVar.value()} span")

            backgroundImage(linearGradient(135.deg) {
                stop(Color(projectCardOpenBackgroundStart))
                stop(Color(projectCardOpenBackgroundEnd))
            })
            maxHeight(500.cssRem)

            className("top") style {
                textAlign(TextAlign.Center)

                "h2" {
                    fontSize(2.5.cssRem)
                    margin(1.cssRem, 0.px)
                }

                "p" {
                    textAlign(TextAlign.Start)
                    margin(0.px, 1.5.cssRem)
                }

                child(self, type("div")) style {
                    margin(auto)
                    width(fitContent)
                }

                inline fun subSpanColor(color: CSSColorValue, index: Int) {
                    child(type("p"), type("span")) + nthOfType(index.n) style {
                        color(color)
                    }
                }

                subSpanColor(Color("#B4BBFF"), 1)
                subSpanColor(Color("#FFE24B"), 2)
                subSpanColor(Color("#75C9CE"), 3)
                subSpanColor(Color("#64E881"), 4)
            }

            className("bottom") style {
                backgroundColor(Color("#ffffff20"))
                borderRadius(.75.cssRem)
                padding(clamp(2.cssRem, 2.vw, 3.5.cssRem))
                maxWidth(90.percent)

                "h1" {
                    marginTop(0.px)
                }

                "code" {
                    whiteSpace("pre-wrap")
                }
            }

            media(mediaMaxWidth(AppStyle.mobileFourthBreak)) {
                self {
                    padding(clamp(.8.cssRem, 1.vw, 1.6.cssRem))
                }

                className("bottom") style {
                    maxWidth(95.percent)
                    padding(clamp(.8.cssRem, 1.vw, 2.cssRem))
                }
            }
        }

        val projectCardClosed by style {
            val maxSize by variable<CSSSizeValue<*>>()
            maxSize(6.cssRem)

            flexDirection(FlexDirection.Row)
            imageSize(3.5.cssRem)

            backgroundColor(Color(projectCardClosedBackground))
            height(maxSize.value())
            maxHeight(maxSize.value())

            className("top") style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                alignItems(AlignItems.Center)
                textAlign(TextAlign.Center)
                gap(.5.cssRem)

                className("stars") style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.RowReverse)
                    alignItems(AlignItems.Center)
                    justifyContent(JustifyContent.Center)
                    gap(.5.cssRem)
                }
            }

            className("bottom") style {
                group(type("h3"), type("p")) style {
                    property("text-ellipsis", "ellipsis")
                    margin(0.px)
                }

                "h3" {
                    marginBottom(.5.cssRem)
                }
            }

            media(mediaMaxWidth(AppStyle.mobileFirstBreak)) {
                self {
                    maxSize(8.cssRem)
                    padding(1.cssRem)
                }
            }

            media(mediaMaxWidth(AppStyle.mobileFourthBreak)) {
                self {
                    imageSize(3.cssRem)
                    height(auto)
                    maxHeight("none")

                    "h3" {
                        fontSize(1.1.cssRem)
                    }
                }
            }
        }
    }
}