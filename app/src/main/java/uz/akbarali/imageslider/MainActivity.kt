package uz.akbarali.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import uz.akbarali.adapter.TravelLocationsAdapter
import uz.akbarali.imageslider.databinding.ActivityMainBinding
import uz.akbarali.models.TravelLocation
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var list: ArrayList<TravelLocation>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = ArrayList()
        binding.locationsViewPager.adapter = TravelLocationsAdapter(getLocation())
        binding.apply {
            locationsViewPager.clipToPadding=false
            locationsViewPager.clipChildren=false
            locationsViewPager.offscreenPageLimit=3
            locationsViewPager.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER
            val compositePageTransformer=CompositePageTransformer()
            compositePageTransformer.addTransformer(MarginPageTransformer(40))
            compositePageTransformer.addTransformer { page, position ->
                val r: Float = 1 - abs(position)
                page.scaleY = 0.95f + r * 0.05f
            }
            locationsViewPager.setPageTransformer(compositePageTransformer)


        }

    }

    private fun getLocation(): ArrayList<TravelLocation> {
        val travelLocation = TravelLocation()
        travelLocation.imageUrl = "https://i.imgur.com/qLKBiG7.jpg"
        travelLocation.location = "Eiffel Tower"
        travelLocation.title = "France"
        travelLocation.startRating = 4.8f
        list.add(travelLocation)
        val travelLocation1 = TravelLocation()
        travelLocation1.imageUrl = "https://skipperclub.ru/images/spain/costa.jpg"
        travelLocation1.location = "Barcelona"
        travelLocation1.title = "Spain"
        travelLocation1.startRating = 4.5f
        list.add(travelLocation1)
        val travelLocation2 = TravelLocation()
        travelLocation2.imageUrl =
            "https://www.layoverguide.com/wp-content/uploads/2010/11/Moscow-city-center-Russia.jpg"
        travelLocation2.location = "Moscow city center"
        travelLocation2.title = "Russia"
        travelLocation2.startRating = 5f
        list.add(travelLocation2)
        val travelLocation3 = TravelLocation()
        travelLocation3.imageUrl = "https://images.alphacoders.com/271/thumb-1920-271761.jpg"
        travelLocation3.location = "United Kingdom London Westminster and Big Ben"
        travelLocation3.title = "UK"
        travelLocation3.startRating = 3.8f
        list.add(travelLocation3)
        val travelLocation4 = TravelLocation()
        travelLocation4.imageUrl =
            "https://wonderfulengineering.com/wp-content/uploads/2015/05/Tronto-wallpaper-3.jpg"
        travelLocation4.location = "Toronto"
        travelLocation4.title = "Canada"
        travelLocation4.startRating = 4.3f
        list.add(travelLocation4)
        val travelLocation5 = TravelLocation()
        travelLocation5.imageUrl =
            "https://s.zefirka.net/images/2019-08-19/chto-stoit-posmotret-v-egipte/chto-stoit-posmotret-v-egipte-6.jpg"
        travelLocation5.location = "Zefirka"
        travelLocation5.title = "Egypt"
        travelLocation5.startRating = 3.3f
        list.add(travelLocation5)

        return list
    }
}