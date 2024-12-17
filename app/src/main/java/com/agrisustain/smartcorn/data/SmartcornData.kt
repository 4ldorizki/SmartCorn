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
            "Penentuan Waktu Tanam",
            "Penentuan waktu tanam pada pertanian jagung",
            "1. Perhatikan ketersediaan air selama pertumbuhan tanaman jagung.\n" +
                    "2. Bertanam di musim kemarau, apabila tidak tersedia air maka pertumbuhan tanaman akan terganggu/kerdil.\n" +
                    "3. Bertanam di musim hujan, apabila drainase/pengaturan airnya tidak lancar, tanaman akan tergenang dan apabila tergenang selama 2 hari akan terjadi pembusukan akar.\n" +
                    "4. Sehingga untuk penentuan waktu tanam perlu dilakukan survey air terhadap lahan yang akan ditanami jagung.",
            R.drawable.budidaya_image2
        ),
        Edukasi(
            2,
            "Persiapan Lahan",
            "Hal-hal yang harus diperhatikan pada persiapan lahan pertanian jagung",
            "1. Tanpa Olah Tanah (TOT) atau olah tanah minimum (minimum tillage) pada lahan sawah setelah padi. Bila gulma sudah bersih bisa langsung ditanami, tetapi bila gulma masih banyak bisa disemprot dulu dengan herbisida.\n" +
                    "2. Olah Tanah Sempurna (OTS) pada lahan kering. Tanah diolah dengan bajak ditarik dengan traktor/sapi atau dapat menggunakan cangkul, kemudian digaru dan sisir sehingga rata.",
            R.drawable.ladang_jagung
        ),
        Edukasi(
            3,
            "Persiapan Tanam",
            "Persiapan tanam pada pertanian jagung meliputi:",
            "1. Pemilihan varietas berdasarkan pada kesesuaian lokasi, ketahanan terhadap OPT dan keinginan petani.\n" +
                    "2. Penggunaan varietas unggul akan memberikan hasil yang tinggi.\n" +
                    "3. Pilih varietas dengan benih berdaya hasil tinggi, tahan terhadap hama penyakit dan deraan lingkungan setempat. Misalnya, benih bermutu mempunyai tingkat kemurnian dan daya tumbuh yang tinggi (>95%) dan berlabel.\n" +
                    "4. Benih bermutu akan tumbuh serentak dan lebih cepat, menghasilkan tanaman yang sehat, tahan rebah, seragam dan berpotensi hasil tinggi.\n" +
                    "5. Keperluan benih 20 kg/ha.\n" +
                    "6. Perlakuan benih (seed treatment) menggunakan metalaksil mencegah penyakit bulai.",
            R.drawable.persiapan_tanam
        ),
        Edukasi(
            4,
            "Penanaman Jagung",
            "Bagaimana proses penanaman jagung yang baik",
            "1. Jarak tanam yang dianjurkan adalah 70 - 80 cm x 20 cm, dengan 1 tanaman per lubang atau 70-80 cm x 40 cm dengan 2 tanaman per lubang.\n" +
                    "2. Benih yang mempunyai daya tumbuh lebih dari 95% dapat memenuhi populasi tanam 66.000 - 75.000 tanaman/ha.\n" +
                    "3. Masukan benih dalam lubang tanam, tutup dengan tanah/pupuk kandang.\n" +
                    "4. Dalam budidaya jagung tidak dianjurkan menyulam karena pengisian biji dari tanaman sulaman tidak optimal. Penyulaman dapat dilakukan dengan tanaman yang sama umurnya dengan tanaman yang mati dan dilakukan saat tanaman berumur sekitar 1 minggu. Oleh karena itu penanaman benih pada polybag untuk persiapan penyulaman dilakukan pada hari yang sama pada penanaman di lapangan.",
            R.drawable.penanaman_jagung
        ),
        Edukasi(
            5,
            "Pemupukan Jagung",
            "Proses pemupukan pada jagung",
            "1. Pupuk kandang 1-3 ton/ha, diberikan pada lubang tanam\n" +
                    "2. Pupuk yang diberikan yaitu Urea 450 kg/ha, SP-36 100-150 kg/ha dan KCL 50-100 kg/ha, diberikan 2 kali, yaitu: Umur 7 - 10 hari setelah tanam urea 150 kg, seluruh dosis SP36 dan seluruh dosis KCI dan Umur 30 - 35 hari setelah tanam, diberikan sisa urea 300 kg.\n" +
                    "3. Kalau menggunakan pupuk majemuk maka pupuk yang diberikan Urea 300 kg/ha, Phonska 350 kg/ha, KCL 50-100 kg/ha, diberikan 2 kali, yaitu: Umur 7 - 10 hari setelah tanam Urea 200 kg, Phonska 250 kg dan seluruh dosis pupuk KCI dan Pada umur 30 - 35 hari setelah tanam, diberikan sisa Urea 100 kg dan sisa Phonska 100 kg.\n" +
                    "4. Pada lahan kering pemberian pupuk P dan K dapat menggunakan PUTK (Perangkat Uji Tanah Lahan Kering) dan untuk pemberian N (Urea) menggunakan Bagan Warna Daun (BWD) dimulai pada umur tanaman 40-45 hari setelah tanam.",
            R.drawable.pemupukan
        ),
        Edukasi(
            6,
            "Pemanenan Jagung",
            "Berikut adalah proses pemanenan jagung",
            "1. Periksa tingkat kematangan jagung, biasanya 90-120 hari setelah tanam.\n" +
                    "2. Ciri jagung siap panen: kelobot kering, bulu cokelat, dan biji keras.\n" +
                    "3. Panen dilakukan pagi atau sore hari, hindari saat hujan.\n" +
                    "4. Panen secara manual dengan memetik tongkol atau menggunakan mesin pemanen.\n" +
                    "5. Kupas kelobot dan bersihkan tongkol dari bulu atau kotoran.\n" +
                    "6. Keringkan jagung hingga kadar air mencapai 12-14%.\n" +
                    "7. Pipil biji dari tongkol jika diperlukan, menggunakan alat manual atau mesin.\n" +
                    "8. Simpan di tempat kering dan berventilasi untuk mencegah hama atau jamur.",
            R.drawable.pemanenan
        )
    )
}