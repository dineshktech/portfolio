package routes.aboutme

import FontAwesomeType
import I
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import data.sections
import kotlinx.browser.document
import kotlinx.browser.window
import markdownParagraph
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLElement

data class AboutMeSection(val content: String, val date: Int, val image: Boolean = false, val id: String, val title: (@Composable () -> Unit)? = null) {
	var htmlElement: HTMLElement? = null
	
	@Composable
	fun Display(selected: Boolean = false) {
		Section({
			if (image) classes(AboutMeStyle.withImage)
			if (selected) classes("selected")
			id(id)
			
			ref {
				htmlElement = it
				onDispose {}
			}
		}) {
			title?.let {
				if (image) it()
				else H2({
					classes(AboutMeStyle.textIcon)
				}) {
					it()
				}
			}
			
			P({
				markdownParagraph(content)
			})
		}
	}
}

const val timelineDefaultOffset = 125.0

@Composable
fun AboutMe() {
	Style(AboutMeStyle)
	
	var timelineOffset by mutableStateOf(timelineDefaultOffset)
	var roundSelected by mutableStateOf(0)
	
//	Div({
//		classes(AboutMeStyle.timeline)
//		style {
//			top(timelineOffset.px)
//		}
//
//		window.addEventListener("scroll", {
//			val footerOffset = document.querySelector(".${FooterStyle.footer}")?.asDynamic()?.offsetTop as Double? ?: return@addEventListener
//
//			if (window.scrollY + window.innerHeight < footerOffset) {
//				timelineOffset = window.scrollY + timelineDefaultOffset * .8
//			}
//		})
//	}) {
//		sections.forEachIndexed { index, section ->
//			if (index > 0) {
//				Div({
//					classes("separator")
//				})
//			}
//
//			Div({
//				attr("data-date", section.date.toString())
//				classes("round")
//				if (index == roundSelected) classes("selected")
//
//				onClick {
//					window.location.hash = "#${section.id}"
//				}
//			}) {
//				A(href = "#${section.id}")
//			}
//		}
//	}
	
	Div({
		classes(AboutMeStyle.content)
	}) {
		sections.forEachIndexed { index, it -> it.Display(index == roundSelected) }
	}

	val callback = callback@{
		sections.forEachIndexed { index, section ->
			if (index == roundSelected) return@forEachIndexed
			val element = document.querySelector("#${section.id}") ?: return@forEachIndexed
			val elementOffset = element.asDynamic().offsetTop as Double - timelineDefaultOffset * 2
			val elementHeight = element.asDynamic().offsetHeight as Double

			val elementRange = elementOffset..(elementOffset + elementHeight)

			if (window.scrollY in elementRange) {
				roundSelected = index
				return@callback
			}
		}
	}

	window.addEventListener("resize", { callback() })
	window.addEventListener("scroll", { callback() })
	document.addEventListener("DOMContentLoaded", { callback() })
}

@Composable
fun TextIcon(text: String, icon: String) {
	Img(icon, "icon")
	Text(text)
}

@Composable
fun TextIcon(text: String, fontAwesomeType: FontAwesomeType, icon: String, color: CSSColorValue? = null) {
	I(fontAwesomeType, icon) {
		color?.let { color(it) }
	}
	Text(text)
}