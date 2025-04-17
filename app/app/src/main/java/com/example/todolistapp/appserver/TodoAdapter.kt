package com.example.todolistapp.appserver

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.R
import com.example.todolistapp.dto.TodoDTO

class TodoAdapter(
    private val todoList: List<TodoDTO>,
    private val onItemClick: (TodoDTO) -> Unit,
    private val onCompleteClick: (TodoDTO) -> Unit //  완료 버튼 클릭 콜백 추가
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.tv_content)
        val dateText: TextView = itemView.findViewById(R.id.tv_date)
        val completeButton: Button = itemView.findViewById(R.id.btnComplete) //버튼 참조
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        val viewHolder = TodoViewHolder(view)

        view.setOnClickListener {
            val position = viewHolder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                onItemClick(todoList[position])
            }
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.titleText.text = todo.todoContent
        holder.dateText.text = todo.todoWriteDate

        // ✅ 완료 버튼 클릭 이벤트
        holder.completeButton.setOnClickListener {
            onCompleteClick(todo)
        }
    }

    override fun getItemCount(): Int = todoList.size
}
