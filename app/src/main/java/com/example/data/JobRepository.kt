package com.example.data

import com.example.model.ExperienceLevel
import com.example.model.Job
import com.example.model.SkillCategory
import com.example.model.SkillItem

object JobRepository {

    val availableSkills: List<SkillItem> = listOf(
        // Web & Dev
        SkillItem("HTML", SkillCategory.TECH),
        SkillItem("CSS", SkillCategory.TECH),
        SkillItem("JavaScript", SkillCategory.TECH),
        SkillItem("React", SkillCategory.TECH),
        SkillItem("Node.js", SkillCategory.TECH),
        SkillItem("Java", SkillCategory.TECH),

        // Data & ML
        SkillItem("Python", SkillCategory.DATA),
        SkillItem("SQL", SkillCategory.DATA),
        SkillItem("Data Analysis", SkillCategory.DATA),
        SkillItem("Machine Learning", SkillCategory.DATA),
        SkillItem("Excel", SkillCategory.DATA),

        // Business, Sales & Design
        SkillItem("Communication", SkillCategory.BUSINESS),
        SkillItem("Photoshop", SkillCategory.BUSINESS),
        SkillItem("Sales", SkillCategory.BUSINESS),
        SkillItem("Marketing", SkillCategory.BUSINESS),
        SkillItem("Accounting", SkillCategory.BUSINESS)
    )

    val jobDatabase: List<Job> = listOf(
        Job(
            id = "fe_dev",
            title = "Frontend Developer",
            skills = listOf("HTML", "CSS", "JavaScript", "React"),
            levels = listOf(ExperienceLevel.FRESHER, ExperienceLevel.JUNIOR, ExperienceLevel.MID),
            description = "Build user interfaces for web applications.",
            salaryRange = "$65,000 - $110,000 / yr",
            keyResponsibilities = listOf(
                "Build reusable UI components with React and modern CSS",
                "Ensure cross-browser compatibility and responsiveness",
                "Collaborate with UX designers to craft intuitive interfaces"
            )
        ),
        Job(
            id = "be_dev",
            title = "Backend Developer",
            skills = listOf("Node.js", "SQL", "Java", "Python"),
            levels = listOf(ExperienceLevel.JUNIOR, ExperienceLevel.MID, ExperienceLevel.SENIOR),
            description = "Develop and maintain server-side logic and databases.",
            salaryRange = "$75,000 - $130,000 / yr",
            keyResponsibilities = listOf(
                "Design and maintain scalable REST/GraphQL APIs",
                "Optimize database queries and data models",
                "Implement robust authentication and security protocols"
            )
        ),
        Job(
            id = "fs_dev",
            title = "Full Stack Developer",
            skills = listOf("HTML", "CSS", "JavaScript", "React", "Node.js", "SQL"),
            levels = listOf(ExperienceLevel.JUNIOR, ExperienceLevel.MID, ExperienceLevel.SENIOR),
            description = "Work across frontend and backend of applications.",
            salaryRange = "$80,000 - $140,000 / yr",
            keyResponsibilities = listOf(
                "Deliver end-to-end features across the complete stack",
                "Bridge frontend user experience with reliable backend microservices",
                "Maintain CI/CD pipelines and deployment automation"
            )
        ),
        Job(
            id = "da",
            title = "Data Analyst",
            skills = listOf("SQL", "Excel", "Data Analysis", "Python"),
            levels = listOf(ExperienceLevel.FRESHER, ExperienceLevel.JUNIOR, ExperienceLevel.MID),
            description = "Analyze data to help business decisions.",
            salaryRange = "$60,000 - $95,000 / yr",
            keyResponsibilities = listOf(
                "Write complex SQL queries to extract meaningful insights",
                "Build interactive executive dashboards in Excel and BI tools",
                "Identify trends and present actionable data findings to leadership"
            )
        ),
        Job(
            id = "mle",
            title = "Machine Learning Engineer",
            skills = listOf("Python", "Machine Learning", "SQL"),
            levels = listOf(ExperienceLevel.MID, ExperienceLevel.SENIOR),
            description = "Build and deploy ML models.",
            salaryRange = "$110,000 - $175,000 / yr",
            keyResponsibilities = listOf(
                "Train, validate, and fine-tune predictive machine learning models",
                "Deploy scalable ML inference pipelines in cloud environments",
                "Monitor model drift and retrain pipelines on new telemetry"
            )
        ),
        Job(
            id = "dme",
            title = "Digital Marketing Executive",
            skills = listOf("Marketing", "Communication", "Sales"),
            levels = listOf(ExperienceLevel.FRESHER, ExperienceLevel.JUNIOR),
            description = "Plan and run online marketing campaigns.",
            salaryRange = "$45,000 - $70,000 / yr",
            keyResponsibilities = listOf(
                "Design and execute multi-channel digital acquisition campaigns",
                "Track campaign conversion metrics, ROI, and CAC",
                "Write compelling ad copy and engage with community audiences"
            )
        ),
        Job(
            id = "se",
            title = "Sales Executive",
            skills = listOf("Sales", "Communication"),
            levels = listOf(ExperienceLevel.FRESHER, ExperienceLevel.JUNIOR, ExperienceLevel.MID),
            description = "Generate leads and close deals with clients.",
            salaryRange = "$50,000 - $85,000 + Commission",
            keyResponsibilities = listOf(
                "Proactively prospect, qualify, and nurture inbound and outbound leads",
                "Conduct persuasive product demonstrations and sales pitches",
                "Negotiate client contracts and exceed monthly revenue quotas"
            )
        ),
        Job(
            id = "uiux",
            title = "UI/UX Designer",
            skills = listOf("Photoshop", "CSS", "HTML", "Communication"),
            levels = listOf(ExperienceLevel.FRESHER, ExperienceLevel.JUNIOR, ExperienceLevel.MID),
            description = "Design user-friendly interfaces and experiences.",
            salaryRange = "$65,000 - $105,000 / yr",
            keyResponsibilities = listOf(
                "Design high-fidelity user interface wireframes and clickable prototypes",
                "Conduct user research and usability testing interviews",
                "Collaborate with frontend engineers on design system components"
            )
        ),
        Job(
            id = "acc",
            title = "Accountant",
            skills = listOf("Accounting", "Excel"),
            levels = listOf(ExperienceLevel.FRESHER, ExperienceLevel.JUNIOR, ExperienceLevel.MID, ExperienceLevel.SENIOR),
            description = "Handle financial records and reporting.",
            salaryRange = "$55,000 - $90,000 / yr",
            keyResponsibilities = listOf(
                "Prepare accurate monthly financial balance sheets and P&L statements",
                "Maintain general ledger integrity and manage vendor reconciliations",
                "Assist external auditors during annual fiscal year-end reviews"
            )
        ),
        Job(
            id = "java_dev",
            title = "Java Developer",
            skills = listOf("Java", "SQL"),
            levels = listOf(ExperienceLevel.JUNIOR, ExperienceLevel.MID, ExperienceLevel.SENIOR),
            description = "Develop enterprise applications using Java.",
            salaryRange = "$75,000 - $125,000 / yr",
            keyResponsibilities = listOf(
                "Build robust enterprise microservices using Spring Boot and Java",
                "Design fault-tolerant transactional database workflows",
                "Optimize performance, concurrency, and thread pool memory usage"
            )
        ),
        Job(
            id = "py_dev",
            title = "Python Developer",
            skills = listOf("Python", "SQL", "Machine Learning"),
            levels = listOf(ExperienceLevel.JUNIOR, ExperienceLevel.MID, ExperienceLevel.SENIOR),
            description = "Build applications and automation scripts using Python.",
            salaryRange = "$75,000 - $125,000 / yr",
            keyResponsibilities = listOf(
                "Write automated backend scripts, workers, and API services with FastAPI/Django",
                "Integrate machine learning inference workflows into production data streams",
                "Maintain high test coverage and clean architectural practices"
            )
        ),
        Job(
            id = "ba",
            title = "Business Analyst",
            skills = listOf("Data Analysis", "Excel", "Communication", "SQL"),
            levels = listOf(ExperienceLevel.JUNIOR, ExperienceLevel.MID, ExperienceLevel.SENIOR),
            description = "Bridge business needs and technical solutions.",
            salaryRange = "$70,000 - $115,000 / yr",
            keyResponsibilities = listOf(
                "Translate stakeholder business objectives into technical user stories",
                "Perform gap analyses and quantify operational efficiency metrics",
                "Facilitate sprint planning and cross-functional requirement alignment"
            )
        )
    )
}
