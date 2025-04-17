package com.example.todolistapp.appserver

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.R
import com.example.todolistapp.dto.TodoDTO

class TodoAdapter(private val todoList: List<TodoDTO>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    // ViewHolder: 아이템 한 개를 담당
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText = itemView.findViewById<TextView>(R.id.tv_content)
        val dateText = itemView.findViewById<TextView>(R.id.tv_date)
    }

    // 아이템 뷰를 처음 생성할 때 호출
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return TodoViewHolder(view)
    }

    // 아이템 뷰에 데이터 연결할 때 호출
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.titleText.text = todo.todoContent
        holder.dateText.text = todo.todoWriteDate

    }

    // 아이템 총 개수
    override fun getItemCount(): Int = todoList.size
}