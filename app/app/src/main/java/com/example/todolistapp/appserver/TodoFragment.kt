import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.R
import com.example.todolistapp.appserver.TodoAdapter
import com.example.todolistapp.dto.TodoDTO
import com.google.android.material.floatingactionbutton.FloatingActionButton


class TodoFragment : Fragment(R.layout.activity_main) { // 여기서 main.xml 연결!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerView, 버튼 등 UI 요소 연결
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_todo)
        val fab = view.findViewById<FloatingActionButton>(R.id.btn_write)

        // RecyclerView 기본 설정
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = TodoAdapter(getSampleTodoList()) // Adapter 설정 필요

    }

    private fun getSampleTodoList(): List<TodoDTO> {
        return listOf(
//            TodoDTO("공부하기", "2025-04-14"),
//            TodoDTO("운동하기", "2025-04-14")
        )
    }
}
