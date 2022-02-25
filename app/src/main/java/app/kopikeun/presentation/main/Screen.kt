package app.kopikeun.presentation.main

enum class Screen(
    val route: String,
) {
    Main(route = "main"),
    Cafe(route = "cafe"),
    Dashboard(route = "dashboard"),
    Search(route = "search"),
    Account(route = "account"),
    CafeList(route = "cafe_list"),
    PhotoList(route = "photo_list"),
    Photo(route = "photo"),
}
