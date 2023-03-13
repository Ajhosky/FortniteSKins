import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cats.R
import com.example.cats.databinding.SkinBinding

class Adapter1(private val dataSet: List<Int>) :
    RecyclerView.Adapter<Adapter1.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = SkinBinding.bind(view)

        init {
            // Define click listener for the ViewHolder's View
            var imageEl: ImageView = view.findViewById<ImageView>(R.id.skinImage)
            var textEl: TextView = view.findViewById<TextView>(R.id.forniteNameView)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.skin, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.binding.skinImage.setImageResource(dataSet[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
//    fun addElement(newElement: Int) {
//        TODO("Not yet implemented")
//        //
//        dataSet = dataSet + newElement
//        notifyDataSetChanged()
//    }

}
