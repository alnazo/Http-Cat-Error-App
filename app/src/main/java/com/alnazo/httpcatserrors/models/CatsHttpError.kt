package com.alnazo.httpcatserrors.models

data class CatsHttpError(
    val id: Int,
    val title: String,
    val image: String,
)

val errors = (100..599)
val exclu = setOf(
    104..199,
    205, 208..299,
    306, 309..399,
    419, 427, 430, 432..443,445..449,452..496,
    505,512..520,524,526..529,531..598
)

val finallist = errors.filter {
    number -> exclu.none {
        excluded ->
        when( excluded ) {
            is Int -> number == excluded
            is IntRange -> number in excluded
            else -> false
        }
    }
}.toList()

fun getHttpCats() = finallist.map {
    CatsHttpError(
        id = it,
        title = "$it",
        image = "https://http.cat/images/$it.jpg",
    )
}

fun getHttpCat(id: Int) =
    CatsHttpError(
        id = id,
        title = "$id",
        image = "https://http.cat/images/$id.jpg",
    )
