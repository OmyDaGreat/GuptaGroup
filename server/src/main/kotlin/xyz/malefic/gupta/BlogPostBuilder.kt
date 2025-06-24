package xyz.malefic.gupta

class BlogPostBuilder {
    companion object {
        private var nextId = 1
        private val assignedIds = mutableSetOf<String>()

        private fun getNextAvailableId(): String {
            while (assignedIds.contains(nextId.toString())) {
                nextId++
            }
            return nextId.toString()
        }
    }

    private var _id: String? = null
    var id: String
        get() = _id ?: getNextAvailableId()
        set(value) {
            _id = value
        }

    var title: String = ""
    var date: String = ""
    var image: String = ""
    var summary: String = ""
    var text: String = ""

    fun build(): BlogPost {
        assignedIds.add(id)
        if (_id == null) nextId++
        return BlogPost(id, title, date, image, summary, text)
    }
}

fun blogPost(init: BlogPostBuilder.() -> Unit): BlogPost = BlogPostBuilder().apply(init).build()
