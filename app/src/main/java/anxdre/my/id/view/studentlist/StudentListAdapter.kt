package anxdre.my.id.view.studentlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import anxdre.my.id.data.model.Student
import anxdre.my.id.databinding.LayoutStudentItemBinding

class StudentListAdapter() : RecyclerView.Adapter<StudentListAdapter.StudentListViewHolder>() {
    private val dataset = mutableListOf<Student>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentListViewHolder {
        return StudentListViewHolder(
            LayoutStudentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: StudentListViewHolder, position: Int) {
        holder.createView(position)
    }

    override fun getItemCount(): Int = dataset.size

    fun changeDataSet(data:List<Student>){
        dataset.clear()
        dataset.addAll(data)
        notifyDataSetChanged()
    }

    inner class StudentListViewHolder(private val itemBinding: LayoutStudentItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun createView(position: Int) {
            with(itemBinding) {
                tvIdStudent.text = dataset[position].id
                tvStudentName.text = dataset[position].name
            }
        }
    }
}