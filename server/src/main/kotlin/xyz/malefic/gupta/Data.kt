package xyz.malefic.gupta

object Data {
    val blogPosts =
        listOf(
            blogPost {
                title = "First Blog Post"
                date = "2024-06-01"
                image = "https://images.pexels.com/photos/1128318/pexels-photo-1128318.jpeg"
                summary = "This is the summary of the first blog post."
                text = "Full content of the first blog post."
            },
            blogPost {
                title = "Second Blog Post"
                date = "2024-06-02"
                image = "https://images.pexels.com/photos/8469941/pexels-photo-8469941.jpeg"
                summary = "This is the summary of the second blog post."
                text = "Full content of the second blog post."
            },
            blogPost {
                title = "Exploring Kotlin for Web Development"
                date = "2024-06-03"
                image = "https://images.pexels.com/photos/1181671/pexels-photo-1181671.jpeg"
                summary = "A quick overview of using Kotlin for building modern web applications."
                text = "Full content about using Kotlin for web development."
            },
            blogPost {
                title = "Understanding Compose Multiplatform"
                date = "2024-06-04"
                image = "https://images.pexels.com/photos/574071/pexels-photo-574071.jpeg"
                summary = "Learn how Compose Multiplatform enables UI development across platforms."
                text = "Full content about Compose Multiplatform."
            },
            blogPost {
                title = "Tips for Clean Code in Kotlin"
                date = "2024-06-05"
                image = "https://images.pexels.com/photos/574077/pexels-photo-574077.jpeg"
                summary = "Best practices and tips for writing clean, maintainable Kotlin code."
                text = "Full content with Kotlin clean code tips."
            },
            blogPost {
                title = "Deploying Kotlin Apps to the Cloud"
                date = "2024-06-06"
                image = "https://images.pexels.com/photos/325185/pexels-photo-325185.jpeg"
                summary = "A guide to deploying your Kotlin applications to popular cloud platforms."
                text = "Full content about deploying Kotlin apps to the cloud."
            },
            blogPost {
                title = "Async Programming in Kotlin"
                date = "2024-06-07"
                image = "https://images.pexels.com/photos/267614/pexels-photo-267614.jpeg"
                summary = "An introduction to asynchronous programming using coroutines in Kotlin."
                text = "Full content about async programming in Kotlin."
            },
        )

    fun findById(id: String) = blogPosts.find { it.id == id }
}
