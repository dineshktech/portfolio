package data

import AppStyle
import localImage
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import routes.aboutme.AboutMeSection
import routes.home.HomeStyle

val sections = listOf(
    AboutMeSection(
        """
        I have been working for Jio Platforms Pvt Ltd since 2018. I worked on numerous tech aspects in Jio over past 4 years. In 2018, I was given
        an opportunity to work on B2B workflow in JioMart Partner App. I was given a product discovery and ordering modules
        in the android app. Initially,this app was developed for POS(Point Of Sale) devices later it was moved to play store users as well. I have excellent knowledge in architecture concepts,
        code re-usability, scalability, TDD concepts (Test Driven Development) and so forth. I have had a chance to work with backend team to define system architecture,
        database schema design and Object oriented system design.
        
        In 2019 - 2020, My team was asked to work on JioMart consumer app. With help of MVVM + clean architecture and android best practices we were able to 
        complete the first phase of the app. Our customers were able to order through JioMart app without much hiccups in the app. I have got chance 
        to learn how to unblock everyone in the team and work in parallel. Some of the team members were working on User Interface(UI) and UI validation
        layer and other team members were focused on continuously delivering business logics to UI team. I guided UI team to work on UI elements without having any 
        dependencies of business logics. Meanwhile, core team was delivering business use cases that was unit tested. We leveraged the multi-module concept and 
        parallelize the entire tech activities. We often create SDKs and published in our local repos to keep continuous delivery of app functionalities. We applied reusable concepts 
        to create `plug & play` components. <br>
        
        In early 2021, I was again moved back to JioMart Partner App where i was asked to increase the crash free and ANR(Application Not Responding) free user 
        sessions along with other feature development activities. When i get started the crash free user sessions were around ~89 - 92% and almost ANR also in the same category. 
        I had to unblock users who were impacted by crashes and ANRs for which focused on across all modules to resolve some fo the bottle-necks around. To ensure, my team enforced 
        all team members to write Unit and Instrumented testcases for all the crash fix added.As a result, we were able to reach ~99% of crash free and ANR free sessions. I get started
        with Kotlin Multiplatform framework and libraries to reuse business logics that was written in Android, iOS and Frontend Apps. <br>
        
        In 2022, I was more into improving Jio Merchant App performance with help of Baseline Profiles, Macro Benchmarking, Micro Benchmarking and App Startup Library. We did analyse 
        some of the case studies of Jio Merchant App on how to improve App startup time, Screen rending time, Overdrawn UI(Jank), Memory allocation, Memory leaks and Strict Mode Violations. Based
        on the data we captured over 3 months, we decided to work on the each module to nail down the issues around performance. Mean while, I published some of the open source projects around
        Kotlin Multiplatform and Backend(Ktor) development that you can find it on github repositories. <br>
     
         
	""".trimIndent(), 2022, true, id = "me"
    ) {
        Div({
            classes(HomeStyle.topInfo)
        }) {
            Img(localImage("dk.jpg"), "avatar") {
                classes(AppStyle.avatar)
            }
        }
    }
).sortedByDescending { it.date }