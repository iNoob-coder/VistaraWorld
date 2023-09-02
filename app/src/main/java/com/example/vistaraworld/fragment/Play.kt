package com.example.vistaraworld.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vistaraworld.Model.CategoryData
import com.example.vistaraworld.Model.SliderData
import com.example.vistaraworld.Model.SubCategoryData
import com.example.vistaraworld.R
import com.example.vistaraworld.adapter.CategoryAdapter
import com.example.vistaraworld.adapter.SliderAdapter
import com.example.vistaraworld.adapter.SubCategoryAdapter
import com.example.vistaraworld.databinding.FragmentPlayBinding
import com.example.vistaraworld.databinding.RvSubCategoryLayoutBinding

class Play : Fragment(), CategoryAdapter.CategoryClicked, SliderAdapter.OnItemClicked {

    private lateinit var binding: FragmentPlayBinding
    private val categoryList = listOf(
        CategoryData("Movies"),
        CategoryData("Tv"),
        CategoryData("Shows"),
        CategoryData("Kids"),
        CategoryData("Audio"),
        CategoryData("Music"),
    )
    //hello

    private val sliderList = listOf(
        SliderData(
            "https://goggler.my/wp-content/uploads/2019/12/JM2_INTL_30Sht_BRIDGE_03-e1575889045252.jpg",
            "Jumanji"
        ),
        SliderData(
            "https://mir-s3-cdn-cf.behance.net/project_modules/fs/706b9474134343.5c239806af449.jpg",
            "URI"
        ),
        SliderData(
            "https://i.pinimg.com/736x/91/71/71/9171710a463f1f7defc537f4b4a1a83f.jpg",
            "Tiger Zinda Hai"
        ),
        SliderData(
            "https://th.bing.com/th/id/R.e7d0838b410fbe2ade3d9451943b042a?rik=%2f3lGWracQhvyGg&riu=http%3a%2f%2fthemobmuseum.org%2fwp-content%2fuploads%2f2014%2f12%2fgangster_squad-movie-poster-horizontal.jpg&ehk=tCQ3H%2bS4PvIJB51%2bgTYthpHHQU4jVqyyXvs9CG0zskc%3d&risl=&pid=ImgRaw&r=0",
            "Gangster Squad"
        ),
        SliderData("https://wallpapershome.com/images/pages/pic_hs/17945.jpg", "Infinty war")
    )


    private val subCategoryList = listOf(
        SubCategoryData(
            "Trending on Vistara World",
            listOf(
                "https://resizing.flixster.com/SwolvJvdfHEA_JO3X9fusPSLAWw=/fit-in/180x240/v2/https://resizing.flixster.com/LkLbwnW0XscqKuxfatfaG7sLeq0=/ems.cHJkLWVtcy1hc3NldHMvbW92aWVzLzc1YzY2OTkwLWUyYTktNGE0NS05YTg4LThlYzliNDRmNDExOS5qcGc=",
                "https://resizing.flixster.com/0SBOT90qGpYEuUK7TUywTS6zSjA=/fit-in/180x240/v2/https://resizing.flixster.com/vh4hku_jZ4dVNC3Sdhtzt9pFlxs=/ems.cHJkLWVtcy1hc3NldHMvbW92aWVzLzViN2RhN2I5LWIwNWEtNDIyZi04YTdiLWQyZjk4YTAzZGRiMy5qcGc=",
                "https://resizing.flixster.com/vQe3reckdEvLWfHh4UIT6Zq1kBs=/fit-in/180x240/v2/https://resizing.flixster.com/pd8HlQ9x33HBwalHtz6jTtmLZm0=/ems.cHJkLWVtcy1hc3NldHMvbW92aWVzLzg1NTg0ZGQyLTEzOTUtNDZhOS1iY2I2LWRjMzVmN2M3M2UwZS5qcGc=",
                "https://resizing.flixster.com/W_2PVy-bpudRMTPX4E1JpVpXHns=/fit-in/180x240/v2/https://resizing.flixster.com/BAiop_VF0lafqPbhco156WWbGlI=/ems.cHJkLWVtcy1hc3NldHMvbW92aWVzLzQwZjljMGJkLWE3OTktNDUxNi1iYWNjLTcyZDA2ZGU3MzhiMi5qcGc=",
                "https://resizing.flixster.com/imQ20aaw99tk1MF6VqOgmt3g3CQ=/fit-in/180x240/v2/https://resizing.flixster.com/Rj36W7XfjR7FUlGiJBCMNfLpk5k=/ems.cHJkLWVtcy1hc3NldHMvbW92aWVzLzg5NjQ4NjQxLTI5MzktNDVlMy04NTU0LTEzZGJiYTZmNzRlNi5qcGc="
            )
        )
    )

    private val subCategoryList2 = listOf(
        SubCategoryData(
            "Fresh on board",
            listOf(
                "https://resizing.flixster.com/-rFgv34f4XAPdUTpcLC9nnT-5GQ=/fit-in/180x240/v2/https://resizing.flixster.com/dV1vfa4w_dB4wzk7A_VzThWUWw8=/ems.cHJkLWVtcy1hc3NldHMvbW92aWVzLzEyZDMyYjZmLThmNzAtNDliNC1hMjFmLTA2ZWY4M2UyMjJhMi5qcGc=",
                "https://resizing.flixster.com/NdFqKxuu_qQLJCPIQuHhMpzp-U8=/fit-in/180x240/v2/https://flxt.tmsimg.com/assets/p13472534_p_v8_af.jpg",
                "https://resizing.flixster.com/qmcO1zjNbzkREECLVOC9dO8CTzE=/fit-in/180x240/v2/https://resizing.flixster.com/9WxKriao1BmRamIaqig2k8hd5uM=/ems.cHJkLWVtcy1hc3NldHMvbW92aWVzL2YyZDQwYTM2LWZmYzEtNGUwMC05NzRkLTA3ODM0NThiNDE4Ny5qcGc=",
                "https://resizing.flixster.com/J3GtkNVBKxU8h3Z4KIEvsG3m29Q=/fit-in/180x240/v2/https://resizing.flixster.com/c-8JdHz3gvS-CM7QuSr7yyQC710=/ems.cHJkLWVtcy1hc3NldHMvbW92aWVzLzIwY2IzNDRmLTY4MzktNGQ2Ni05ZjcwLTgzM2U0NWU4ODNlOS5qcGc=",
                "https://resizing.flixster.com/dW08y7uzqMU5XDWFOhUGPxUDOkw=/fit-in/180x240/v2/https://resizing.flixster.com/IXDTZRqseLxH9CVg8wuApMgEJpc=/ems.cHJkLWVtcy1hc3NldHMvbW92aWVzLzljYWQwYmM5LWVlMjgtNDQ5OC1iM2ViLTg4Y2MxM2U0YWFmZS5qcGc=",
            )
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPlayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        //set slider
        binding.slider.adapter = SliderAdapter(sliderList, this@Play)

        //set indicator
        binding.indicator.setViewPager(binding.slider)

        binding.rvCategory.apply {
            adapter = CategoryAdapter(categoryList, this@Play)
            layoutManager =
                LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }

        //by using this method we can set as many list as we want
        for (i in 0..4) {
            binding.mainLayout.addView(setHorizontalRv(subCategoryList[0]))
            binding.mainLayout.addView(setHorizontalRv(subCategoryList2[0]))
        }
    }

    private fun setHorizontalRv(subCategory: SubCategoryData): View? {
        //inflate recyclerView
        val rvLayout = LayoutInflater.from(requireContext())
            .inflate(R.layout.rv_sub_category_layout, binding.mainLayout, false)

        //binding views
        val rvBinding = RvSubCategoryLayoutBinding.bind(rvLayout)

        //set sub category title
        rvBinding.categoryTitle.text = subCategory.categoryTitle

        //set sub category list
        rvBinding.rvCategory.apply {
            adapter = SubCategoryAdapter(subCategory.thumbnail)
            layoutManager = LinearLayoutManager(
                requireContext(),
                RecyclerView.HORIZONTAL,
                false
            )
        }
        return rvLayout
    }

    override fun onCategoryClicked(categoryName: String) {
        Toast.makeText(requireContext(), "$categoryName clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onSliderClicked(title: String) {
        Toast.makeText(requireContext(), title, Toast.LENGTH_SHORT).show()
    }
}