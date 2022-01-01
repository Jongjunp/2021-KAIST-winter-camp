package com.example.commontask1_pjj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.commontask1_pjj.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        //1. 페이지 데이터 로드
        val list = listOf(AFragment(), BFragment(), CFragment())
        //2. 어댑터 생성
        val pagerAdapter = FragmentPagerAdapter(list, this)

        with(binding) {
            //3. 어댑터와 뷰페이저 연결
            viewPager.adapter = pagerAdapter
            //4. 탭 메뉴의 개수만큼 제목을 목록으로 생성
            val titles = listOf("Phone", "Image", "Chart")
            val icons = listOf(R.drawable.ic_baseline_phone_24, R.drawable.ic_baseline_image_24, R.drawable.ic_baseline_pie_chart_24)
            //5. 탭레이아웃과 뷰페이저 연결
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = titles.get(position)
                tab.setIcon(icons.get(position))
            }.attach()


        }

    }
}

 class FragmentPagerAdapter(val fragmentList:List<Fragment>, fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
     override fun getItemCount() = fragmentList.size
     override fun createFragment(position: Int) = fragmentList.get(position)
 }