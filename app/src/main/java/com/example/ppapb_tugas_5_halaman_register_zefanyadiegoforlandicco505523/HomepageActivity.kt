// Import semua paket yang diperlukan
package com.example.ppapb_tugas_5_halaman_register_zefanyadiegoforlandicco505523

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ppapb_tugas_5_halaman_register_zefanyadiegoforlandicco505523.MainActivity.Companion.EXTRA_USERNAME
import com.example.ppapb_tugas_5_halaman_register_zefanyadiegoforlandicco505523.databinding.ActivityHomepageBinding

// Mendefinisikan kelas HomepageActivity yang merupakan turunan dari AppCompatActivity
class HomepageActivity : AppCompatActivity() {

    // Deklarasikan variabel binding untuk ActivityHomepageBinding
    private lateinit var binding: ActivityHomepageBinding

    // Membuat launcher untuk menangani hasil dari activity lain
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val username = data?.getStringExtra(EXTRA_USERNAME)
            val email = data?.getStringExtra(MainActivity.EXTRA_EMAIL)
            val phone = data?.getStringExtra(MainActivity.EXTRA_PHONE)

            // Memeriksa apakah data yang diterima tidak kosong
            if (!username.isNullOrEmpty() && !email.isNullOrEmpty() && !phone.isNullOrEmpty()) {
                // Mengatur teks pada tampilan TextView dengan data yang diterima
                binding.yourNewUsernameId.text = "$username"
                binding.yourNewEmailId.text = "$email"
                binding.yourNewPhoneId.text = "$phone"
            }
        }
    }

    // Metode onCreate dipanggil saat aktivitas dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menginisialisasi binding menggunakan layout inflater
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data yang dikirimkan dari activity sebelumnya (MainActivity)
        var username = intent.getStringExtra(EXTRA_USERNAME)
        var email = intent.getStringExtra(MainActivity.EXTRA_EMAIL)
        var phone = intent.getStringExtra(MainActivity.EXTRA_PHONE)

        // Menampilkan data yang diterima pada tampilan menggunakan binding
        with(binding) {
            binding.yourNewUsernameId.text = "$username"
            binding.yourNewEmailId.text = "$email"
            binding.yourNewPhoneId.text = "$phone"

            // Mengatur aksi saat tombol logout diklik
            val btnLogout = findViewById<Button>(R.id.your_new_button_id)
            btnLogout.setOnClickListener {
                // Membuat intent untuk kembali ke MainActivity dan menghapus aktivitas sebelumnya
                val intentToMainActivity = Intent(this@HomepageActivity, MainActivity::class.java)
                intentToMainActivity.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intentToMainActivity)
            }
        }
    }
}
