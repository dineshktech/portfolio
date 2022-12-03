package routes.aboutme

import AppStyle
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.selectors.Nth
import utils.*


object AboutMeStyle : StyleSheet() {
    const val backgroundSectionOddColor = "#363636"
    const val backgroundSectionEvenColor = "#2e2e2e"
    const val timelineBgGradiantEndColor = "#71136D"
    const val timelineBgGradiantStartColor = "#4B4F9D"

    val timelineSize by variable<CSSSizeValue<*>>()
    val timelineOffset by variable<CSSSizeValue<*>>()

    init {
//		"html" {
//			property("scroll-padding-top", HeaderStyle.navbarHeight.value() + timelineDefaultOffset.px)
//		}

        id("main") style {
            timelineSize(max(4.cssRem, 6.vw))
            timelineOffset(1.5.cssRem)
        }

        media(mediaMaxWidth(AppStyle.mobileThirdBreak)) {
            id("main") style {
                timelineSize(max(4.cssRem, 5.vw))
                timelineOffset(1.cssRem)
            }
        }

        media(mediaMaxWidth(AppStyle.mobileFourthBreak)) {
            id("main") style {
                timelineSize(0.px)
                timelineOffset((-5).cssRem)
            }
        }
    }

    @OptIn(ExperimentalComposeWebApi::class)
    val appearLeft by keyframes {
        from {
            opacity(0.0)
            transform { translateX(3.cssRem) }
        }

        to {
            opacity(1.0)
            transform { translateX(0.px) }
        }
    }

    @OptIn(ExperimentalComposeWebApi::class)
    val appearBottom by keyframes {
        from {
            opacity(0.0)
            transform {
                translateY((-2).cssRem)
                translateX((-50).percent)
            }
        }

        to {
            opacity(1.0)
            transform {
                translateY(0.px)
                translateX((-50).percent)
            }
        }
    }

    val sectionSelection by keyframes {
        from {
            backgroundPosition("200% 0%")
        }

        to {
            backgroundPosition("0% 0%")
        }
    }

    @OptIn(ExperimentalComposeWebApi::class)
    val timeline by style {
        val thickness = 1.vh
        val length = 7.8.vh
        val roundSize = 3.vh

        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Center)

        position(Position.Absolute)
        left(timelineOffset.value().unsafeCast<CSSLengthValue>())
        height(90.percent)
        width(timelineSize.value())

        child(self, universal) style {
            background(linearGradient {
                stop(Color(timelineBgGradiantStartColor))
                stop(Color(timelineBgGradiantEndColor))
            })
            backgroundAttachment("fixed")

            marginTop((-.2).cssRem)
        }

        className("round") style {
            size(roundSize)
            borderRadius(10.cssRem)
            position(Position.Relative)

            transitions {
                delay(.4.s)
                ease(AnimationTimingFunction.cubicBezier(.47, 2.0, .41, .8))
                properties("transform", "box-shadow")
            }

            group(hover(self), self + className("selected")) style {
                boxShadow(Color("#00000070"), offset = 0.px, blur = .8.cssRem)
                zIndex(3)
            }

            hover(self) style {
                transform { scale(1.1) }
                cursor(Cursor.Pointer)
            }

            self + className("selected") style {
                transform { scale(1.2) }
                border {
                    color(Color.white)
                    style(LineStyle.Solid)
                    width(2.px)
                }

                self + after style {
                    property("content", "attr(data-date)")
                    fontWeight(700)

                    position(Position.Absolute)
                    top(0.px)
                    left((-3).cssRem)
                    height(100.percent)
                    width(minContent)

                    animation(appearLeft) {
                        duration(.4.s)
                        timingFunction(AnimationTimingFunction.cubicBezier(.47, 2.0, .41, .8))
                    }
                }
            }
        }

        className("separator") style {
            height(length)
            width(thickness)
        }

        media(mediaMaxWidth(AppStyle.mobileThirdBreak)) {
            className("round") + className("selected") + after style {
                left(50.percent)
                transform { translateX((-50).percent) }
                property("top", "unset")
                bottom((-2.5).cssRem)

                backgroundColor(Color("#00000070"))
                padding(.2.cssRem, .4.cssRem)
                borderRadius(.5.cssRem)

                animation(appearBottom) {
                    duration(.3.s)
                    timingFunction(AnimationTimingFunction.EaseInOut)
                }
            }
        }

        media(mediaMaxWidth(AppStyle.mobileFourthBreak)) {
            style {
                display(DisplayStyle.None)
            }
        }
    }

    val withImage by style {
        display(DisplayStyle.Flex)
        //flexDirection(FlexDirection.Row)
        //alignItems(AlignItems.Center)
        gap(2.5.cssRem)

        media(mediaMaxWidth(768.px)) {
            self {
                flexDirection(FlexDirection.Column)
            }
        }
    }

    @OptIn(ExperimentalComposeWebApi::class)
    val content by style {
        val titleHeight by variable<CSSSizeValue<*>>()

        marginLeft(timelineSize.value())
        marginRight(timelineSize.value())

        "section" {
            titleHeight(max(2.cssRem, 3.vw))

            backgroundColor(Color(backgroundSectionOddColor))
            fontFamily(AppStyle.monoFontFamily)
            padding(1.5.cssRem, titleHeight.value())
            position(Position.Relative)

            transitions {
                duration(.3.s)
                ease(AnimationTimingFunction.EaseInOut)
                properties("transform")
            }

            self + className("selected") style {
                val offset = 4.px
                transform {
                    scaleX(1.005)
                    translateX(-offset)
                }

                borderRadius(topLeft = 5.px, bottomLeft = 5.px, topRight = 0.px, bottomRight = 0.px)

                overflow(Overflow.Hidden)
                animation(sectionSelection) {
                    delay(.1.s)
                    duration(.4.s)
                    timingFunction(AnimationTimingFunction.EaseInOut)
                }

                property("background-size", "200% 100%")
                backgroundImage(linearGradient(90.deg) {
                    stop(Color("#50435A"))
                    stop(Color("#28273e"))
                    stop(Color.transparent)
                })
                backgroundRepeat("no-repeat")
            }

            self + nthChild(Nth.Even) style {
                backgroundColor(Color(backgroundSectionEvenColor))
            }

            "h2" {
                group(desc(self, type("img")), desc(self, type("i"))) style {
                    val iconPadding = .4.cssRem
                    val iconHeight = titleHeight.value() + (iconPadding * 2)

                    backgroundColor(Color("#00000015"))
                    borderRadius(.75.cssRem)
                    height(iconHeight)
                    lineHeight(iconHeight)
                    padding(iconPadding)
                    width(auto)
                }

                fontSize(titleHeight.value())
                margin(0.cssRem, 0.px, 1.5.cssRem)
            }

            "p" {
                fontSize(1.05.cssRem)
                lineHeight(1.6.cssRem)
                margin(0.px)
            }
        }

        media(mediaMaxWidth(AppStyle.mobileThirdBreak)) {
            self {
                marginLeft(timelineSize.value() * 1.5)
            }
        }

        media(mediaMaxWidth(AppStyle.mobileFourthBreak)) {
            self {
                titleHeight(1.5.cssRem)
                marginLeft(0.px)

                "section" {


                    self + className("selected") style {
                        property("transform", "none")
                    }
                }
            }
        }
    }

    val textIcon by style {
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.Start)
        flexDirection(FlexDirection.Row)
        gap(1.5.cssRem)

        media(mediaMaxWidth(686.px)) {
            self {
                flexDirection(FlexDirection.Column)
                textAlign(TextAlign.Center)
            }
        }
    }
}