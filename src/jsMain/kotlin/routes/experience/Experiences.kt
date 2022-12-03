package routes.experience

import androidx.compose.runtime.Composable
import markdownParagraph
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Section
import AppStyle

@Composable
fun Experiences() {
	Style(ExperiencesStyle)
	
	Div({
		classes(AppStyle.monoFont, AppStyle.sections)
	}) {
		Div({
			classes(ExperiencesStyle.experiencesList)
		}) {
			Section {
				P({
					markdownParagraph(
						"""
							## Jio Platforms · Team Lead (Android, Kotlin and Multiplatform) · Apr 2021 - Present
							[Jio Platforms](https://www.jio.com/) is a technology company and subsidiary of Reliance Industries, 
							headquartered in Mumbai, India. Established in 2019, it acts as a holding company for India's largest mobile network operator 
							Jio and other digital businesses of Reliance. In May 2020, it was reported to be the fourth largest Indian company by market 
							capitalization. Since April 2020, Reliance Industries has raised ₹152,056 crore (US${'$'}20 billion) by selling 32.97% equity 
							stake in the company. In August 2021, it was ranked 155th on the 2021 Fortune Global 500 list of world's biggest corporations. 
							JioMart and JioMart Partner apps part of Jio Platforms are serving over 10+ million customers and 1+ million merchants respectively. 
							
							Experience in Jio:
							- Senior Manager - Mobile Engineering · Apr 2020 - Mar 2021
							- Manager - Mobile Engineering · Apr 2018 - Mar 2020
							
							Roles and responsibilities:
							- I joined in 2018 with merchant android app team to build B2B &  B2C components. I was involved in the modules such as product discovery, cart, 
							checkout, order history and summary. While development we used the best practices that are followed by android community, such as, 
								1. Test driven development(TDD)
								2. MVVM + clean architecture
								3. SOLID design principles and design patterns. 
								4. Design complex algorithms
								5. App components as an reusable libs.
							- Back in 2020, I was assigned to improve application performance as most of the app modules were observed more than 10% crashes and ANRs. After having analysis through
							the entire module and vigorous profiling the app gave a option to eliminate the bottle necks that are reason for low crash free user count. For around more than 1.5yrs, my team 
							maintained 99% of crash free and ANR free sessions.
							- Now, with my team, I'm focused on improving the application performance on low memory cases. Also working on design systems creation for JioMart Partner app. 

							
							[JioMart Partner Android App](https://play.google.com/store/apps/details?id=com.jio.bapp&hl=en_IN&gl=US)
						""".trimIndent()
					)
				})
			}
		}

		Div({
			classes(ExperiencesStyle.experiencesList)
		}) {
			Section {
				P({
					markdownParagraph(
						"""
							## OLA · Software Development Engineer - II · Apr 2015 - Jan 2018
							[OLA - ANI TECH](https://www.olacabs.com/) - Ola, one of the largest ride-hailing platforms in India, also operates in the UK, 
							Australia & New Zealand. Download the Ola Driver app today and register to become an Ola Driver.
							
							Roles and responsibilities:
							- Tech leadership of the resuable component development team (Android, Frontend), used monthly by more than 50K unique Ola Partners.
							
							[Ola Partner Android App](https://play.google.com/store/apps/details?id=com.olacabs.oladriver&hl=en_IN&gl=US)
						""".trimIndent()
					)
				})
			}
		}

		Div({
			classes(ExperiencesStyle.experiencesList)
		}) {
			Section {
				P({
					markdownParagraph(
						"""
							## TaxiForSure · Senior Software Engineer · Nov 2014 - Apr 2015
							[TaxiForSure - Serendipity Infolabs Pvt Ltd](https://www.facebook.com/TaxiForSure?ref=br_tf) - TaxiForSure.com was an aggregator of car rentals and taxis in India. 
							It works with various taxi operators and enable them with technology to ensure that customers get an easily accessible, safe, reliable taxi ride ‘for sure’.
							
							Roles and responsibilities:
							- I was working with TaxiForSure Partner app development team responsible for entire end to end app development. Along with app development had a chance to work on some of the NodeJS APIs that consumed by apps.
							In 2015 the app had around 1L+ downloads in android app store. 
							
							[TaxiForSure Partner Android App](https://www.facebook.com/TaxiForSure?ref=br_tf)
						""".trimIndent()
					)
				})
			}
		}

		Div({
			classes(ExperiencesStyle.experiencesList)
		}) {
			Section {
				P({
					markdownParagraph(
						"""
							## Strobilanthes · Technical Lead  · Nov 2013 - Nov 2014
							[Strobilanthes Technology solutions](https://www.facebook.com/strobilanthes/) - A product based startup company helping 
							restaurants to serve their customers with help of IoT and android apps. Used in the best restaurants of india.
							
							Roles and responsibilities:
							- Hiring and training app developers.
							- Delegating work and assignments to team members.
							- Collaborating with team to identify and fix technical problems.
							- Create and set goals for team.
							- Guiding the team through technical issues and challenges
						""".trimIndent()
					)
				})
			}
		}

		Div({
			classes(ExperiencesStyle.experiencesList)
		}) {
			Section {
				P({
					markdownParagraph(
						"""
							## KRA systems · Software Engineer · Aug 2011 - Nov 2013
							[KRA Systems](https://www.linkedin.com/in/kra-systems-1058a0b6/) - KRA Systems is a leading Software service and solutions proivder
							for the Consumer Electronics industry. We offer a broad range of expertise covering embedded software,
							enterprise software and software quality assurance. We help companies establish offshore 
							software development centers in India.
							
							Roles and responsibilities:
							- Design and developed the application for RTLS - global monitor system runs on android devices.
							- Convert iOS app written in Objective-C to java with android.
						""".trimIndent()
					)
				})
			}
		}
	}
}
