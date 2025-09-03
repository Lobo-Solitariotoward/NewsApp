package com.example.newsapp

import coil3.Image

data class NewsItem(
    val title : String,
    val image: String
)

val news = listOf(
    NewsItem("Retrato presidencial de Donald Trump", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Official_Presidential_Portrait_of_President_Donald_J._Trump_%282025%29.jpg/250px-Official_Presidential_Portrait_of_President_Donald_J._Trump_%282025%29.jpg"),
    NewsItem("Cleopatra", "https://oem.com.mx/diariodequeretaro/img/18751754/1664355593/BASE_LANDSCAPE/1200/Cleopatra.jpg"),
    NewsItem("Riesgos de seguridad en IA", "https://www.tarlogic.com/wp-content/uploads/2023/09/riesgos-seguridad-IA-3.jpg"),
    NewsItem("Imagen de La Tercera", "https://www.latercera.com/resizer/v2/RO76QH6WSBGDVFFFDRBML6WNBI.jpg?quality=80&smart=true&auth=af0b60c72624f0449cef3e81bf71374fb3b872d76ff9a0597ac669006190de63&width=1200&height=750")
)
