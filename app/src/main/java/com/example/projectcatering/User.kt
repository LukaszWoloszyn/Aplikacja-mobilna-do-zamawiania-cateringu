data class User(
    val id: Int,
    val nazwa_uzytkownika: String,
    val email: String,
    val imie: String = "",
    val nazwisko: String = "",
    val adres_dostawy: String = "",
    val telefon: String = "",
    val rola: String
)
