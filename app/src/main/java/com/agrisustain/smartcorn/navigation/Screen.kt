package com.agrisustain.smartcorn.navigation

sealed class Screen (val route: String) {
    object GetStarted : Screen("get_started")
    object Start : Screen("start")
    object PilihBahasa : Screen("pilih_bahasa")
    object Daftar : Screen("daftar")
    object VerifikasiDaftar : Screen("verifikasi_daftar")
    object Login : Screen("login")
    object Home : Screen("home")
    object Edukasi : Screen("edukasi")
    object DetailEdukasi : Screen ("detail_edukasi")
    object Forum : Screen("forum")
    object Chat : Screen("chat")
    object Scan : Screen("scan")
}