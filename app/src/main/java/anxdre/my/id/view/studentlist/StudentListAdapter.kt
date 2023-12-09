package anxdre.my.id.view.studentlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import anxdre.my.id.R
import anxdre.my.id.data.model.Student
import anxdre.my.id.databinding.LayoutStudentItemBinding
import com.squareup.picasso.Picasso

class StudentListAdapter(val onClickItem:(Student) -> Unit) : RecyclerView.Adapter<StudentListAdapter.StudentListViewHolder>() {
    private val dataset = mutableListOf<Student>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentListViewHolder {
        return StudentListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_student_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StudentListViewHolder, position: Int) {
        holder.createView(position)
    }

    override fun getItemCount(): Int = dataset.size

    fun changeDataSet(data: List<Student>) {
        dataset.clear()
        dataset.addAll(data)
        notifyDataSetChanged()
    }

    inner class StudentListViewHolder(private var itemBinding: LayoutStudentItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun createView(position: Int) {
            itemBinding.student = dataset[position]
            itemBinding.root.setOnClickListener { onClickItem(dataset[position]) }
        }
    }
}