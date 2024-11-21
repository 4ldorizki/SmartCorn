package com.agrisustain.smartcorn.data

import com.agrisustain.smartcorn.R
import com.agrisustain.smartcorn.model.Edukasi
import com.agrisustain.smartcorn.model.Fitur

object SmartcornData {
    val fitur = listOf(
        Fitur(
            1,
            "Deteksi Penyakit",
            R.drawable.ic_plant_detection
        ),
        Fitur(
            2,
            "Edukasi Pertanian",
            R.drawable.ic_agriculture_education
        ),
        Fitur(
            3,
            "Forum Komunitas",
            R.drawable.ic_community_forum
        ),
        Fitur(
            4,
            "Profil Pengguna",
            R.drawable.ic_user_profile
        )
    )

    val edukasi = listOf(
        Edukasi(
            1,
            "Judul Edukasi 1",
            "Deskripsi edukasi 1",
            R.drawable.budidaya_image
        ),
        Edukasi(
            2,
            "Judul Edukasi 2",
            "Deskripsi edukasi 2",
            R.drawable.budidaya_image
        ),
        Edukasi(
            3,
            "Judul Edukasi 3",
            "Deskripsi edukasi 3",
            R.drawable.budidaya_image
        ),
        Edukasi(
            4,
            "Judul Edukasi 4",
            "Deskripsi edukasi 4",
            R.drawable.budidaya_image
        ),
        Edukasi(
            5,
            "Judul Edukasi 5",
            "Deskripsi edukasi 5",
            R.drawable.budidaya_image
        ),
        Edukasi(
            6,
            "Judul Edukasi 6",
            "Deskripsi edukasi 6",
            R.drawable.budidaya_image
        )
    )
}