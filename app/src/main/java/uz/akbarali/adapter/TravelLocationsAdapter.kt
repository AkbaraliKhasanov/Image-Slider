package uz.akbarali.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.flaviofaria.kenburnsview.RandomTransitionGenerator
import com.squareup.picasso.Picasso
import uz.akbarali.imageslider.databinding.ItemContainerLocationBinding
import uz.akbarali.models.TravelLocation


class TravelLocationsAdapter(private val list: ArrayList<TravelLocation>) :
    RecyclerView.Adapter<TravelLocationsAdapter.Vh>() {

    inner class Vh(private val binding: ItemContainerLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(travelLocation: TravelLocation) {

            binding.apply {
                Picasso.get().load(travelLocation.imageUrl).into(kbvLocation)
                val interpolator = AccelerateDecelerateInterpolator()

                // It is used to change the duration and
                // the interpolator of transitions

                // It is used to change the duration and
                // the interpolator of transitions
                val generator = RandomTransitionGenerator(2000, interpolator)
                kbvLocation.setTransitionGenerator(generator)

                textTitle.text = travelLocation.title
                textLocation.text = travelLocation.location
                textStarRating.text = travelLocation.startRating.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemContainerLocationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}