package com.example.mulmeong00

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mulmeong00.Fragment.AlarmFragment
import com.example.mulmeong00.Fragment.HomeFragment
import com.example.mulmeong00.Fragment.TempFragment
import com.example.mulmeong00.databinding.ActivityMainBinding
import com.example.mulmeong00.databinding.ActivityMainBinding.inflate
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBinding = inflate(layoutInflater)

        setContentView(mBinding.root)

        //프래그먼트 시작페이지
        supportFragmentManager.beginTransaction().replace(R.id.nav_host, HomeFragment()).commitAllowingStateLoss()

        //죽은 소스라 작동은 되는데 새 코드로 작성해주는게 좋긴함
        mBinding.navBottom.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.home_nav -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.nav_host, HomeFragment()).commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.alarm_nav -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.nav_host, AlarmFragment()).commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.temp_nav -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.nav_host, TempFragment()).commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }
        )
    }
}