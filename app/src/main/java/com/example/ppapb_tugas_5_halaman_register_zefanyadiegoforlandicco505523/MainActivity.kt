package com.example.ppapb_tugas_5_halaman_register_zefanyadiegoforlandicco505523

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ppapb_tugas_5_halaman_register_zefanyadiegoforlandicco505523.databinding.ActivityMainBinding

// Ini adalah deklarasi kelas MainActivity yang merupakan turunan dari AppCompatActivity.
class MainActivity : AppCompatActivity() {

    // Ini adalah variabel late-initialized (diinisialisasi kemudian) yang akan digunakan untuk mengikat tampilan Activity.
    private lateinit var binding: ActivityMainBinding

    // Ini adalah companion object, yang digunakan untuk mendeklarasikan variabel-variabel konstan yang dapat diakses secara langsung melalui nama kelas.
    companion object {
        const val EXTRA_USERNAME = "username" // Variabel konstan yang digunakan untuk menyimpan kunci untuk mengirim data username ke aktivitas lain.
        const val EXTRA_EMAIL = "email" // Variabel konstan yang digunakan untuk menyimpan kunci untuk mengirim data email ke aktivitas lain.
        const val EXTRA_PHONE = "phone" // Variabel konstan yang digunakan untuk menyimpan kunci untuk mengirim data nomor telepon ke aktivitas lain.
        const val EXTRA_PASSWORD = "password" // Variabel konstan yang digunakan untuk menyimpan kunci untuk mengirim data password ke aktivitas lain.
    }

    // Ini adalah fungsi onCreate() yang akan dipanggil saat aktivitas (Activity) ini dibuat.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengikat tampilan Activity menggunakan ActivityMainBinding.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur event listener untuk tombol btnRegister.
        with(binding) {
            newBtnRegisterId.setOnClickListener {
                // Membuat Intent yang akan digunakan untuk berpindah ke HomepageActivity.
                val intentToHome = Intent(this@MainActivity, HomepageActivity::class.java)

                // Mengambil nilai dari field input yang dimasukkan oleh pengguna (username, email, phone, password).
                val username = newETUsernameId.text.toString()
                val email = newETEMailId.text.toString()
                val phone = newETPhoneId.text.toString()
                val password = newETPasswordId.text.toString()

                // Menyisipkan data-data tersebut ke dalam Intent menggunakan kunci yang sudah dideklarasikan.
                intentToHome.putExtra(EXTRA_USERNAME, username)
                intentToHome.putExtra(EXTRA_EMAIL, email)
                intentToHome.putExtra(EXTRA_PHONE, phone)
                intentToHome.putExtra(EXTRA_PASSWORD, password)

                // Memulai aktivitas HomepageActivity dengan membawa data-data tersebut.
                startActivity(intentToHome)
            }
        }
    }
}