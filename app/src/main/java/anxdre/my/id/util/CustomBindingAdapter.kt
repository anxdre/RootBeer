package anxdre.my.id.util

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("binding:imageUrl", "binding:error")
fun loadImageFromUrl(view: ImageView, imageUrl: String?, error: Drawable){
    Picasso.get().load(imageUrl).error(error).into(view)
    Log.d("imgUrl",imageUrl ?: "")
}