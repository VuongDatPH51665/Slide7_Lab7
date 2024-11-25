//package com.vn.lab1_1.Screen;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.vn.lab1_1.Dao.toDoDao;
//import com.vn.lab1_1.R;
//import com.vn.lab1_1.adapter.ToDoAdapter;
//import com.vn.lab1_1.model.ToDo;
//
//import java.util.ArrayList;
//
//public class MainActivity extends AppCompatActivity {
//    private ArrayList<ToDo> listToDo = new ArrayList<>();
//    ToDoAdapter ToDoadapter;
//    ListView lvToDoList;
//    ToDo Todo;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(com.vn.lab1_1.R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//        EditText edtTitle = findViewById(R.id.edtTitle);
//        EditText edtContent = findViewById(R.id.edtContent);
//        EditText edtDate = findViewById(R.id.edtDate);
//        EditText edtType = findViewById(R.id.edtType);
//        Button btnAdd = findViewById(R.id.btnAdd);
//        Button btnDelete = findViewById(R.id.btnDelete);
//        Button btnUpdate = findViewById(R.id.btnUpdate);
//        lvToDoList = findViewById(R.id.lvToDoList);
//
//
//
//        toDoDao toDoDao = new toDoDao(this);
//        listToDo = (ArrayList<ToDo>) toDoDao.getAllToDo();
//        ToDoadapter = new ToDoAdapter(MainActivity.this, listToDo);
//        lvToDoList.setAdapter(ToDoadapter);
//
//
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            toDoDao toDoDao1 = new toDoDao(MainActivity.this);
//            ToDo todo = new ToDo(edtTitle.getText().toString(),
//                    edtContent.getText().toString(),
//                    edtDate.getText().toString(),
//                    edtType.getText().toString());
//                    boolean isSuccessful = toDoDao1.insertToDo(todo);
//                listToDo = (ArrayList<ToDo>) toDoDao.getAllToDo();
//                ToDoadapter = new ToDoAdapter(MainActivity.this, listToDo);
//                lvToDoList.setAdapter(ToDoadapter);
//
//                    if (isSuccessful)
//                        Toast.makeText(MainActivity.this, "Add Success", Toast.LENGTH_SHORT).show();
//
//
//                    else
//                        Toast.makeText(MainActivity.this, "Add Fail", Toast.LENGTH_SHORT).show();
//
//
//            }
//
//        });
//
//        lvToDoList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                ToDo todo = listToDo.get(i);
//                edtTitle.setText(todo.getTitle());
//                edtContent.setText(todo.getContent());
//                edtDate.setText(todo.getDate());
//                edtType.setText(todo.getType());
//                return false;
//            }
//        });
//
//
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String title = edtTitle.getText().toString();
//                String content = edtContent.getText().toString();
//                String date = edtDate.getText().toString();
//                String type = edtType.getText().toString();
//                ToDo td = new ToDo(title, content, date, type);
//                boolean check = toDoDao.updateToDoList(td);
//                listToDo = (ArrayList<ToDo>) toDoDao.getAllToDo();
//                ToDoadapter = new ToDoAdapter(MainActivity.this, listToDo);
//                lvToDoList.setAdapter(ToDoadapter);
//
//                if(check)
//                    Toast.makeText(MainActivity.this, "Update Success", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(MainActivity.this, "Update False", Toast.LENGTH_SHORT).show();
//                reset();
//            }
//        });
//
//       btnDelete.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               String title = edtTitle.getText().toString();
//               boolean check = toDoDao.deleteToDoList(title);
//               listToDo = (ArrayList<ToDo>) toDoDao.getAllToDo();
//               ToDoadapter = new ToDoAdapter(MainActivity.this, listToDo);
//               lvToDoList.setAdapter(ToDoadapter);
//               if (check)
//                   Toast.makeText(MainActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
//               else
//                   Toast.makeText(MainActivity.this, "Delete False", Toast.LENGTH_SHORT).show();
//               reset();
//
//           }
//       });
//
//
//
//
//
//    }
//
//        public void reset(){
//            EditText edtTitle = findViewById(R.id.edtTitle);
//            EditText edtContent = findViewById(R.id.edtContent);
//            EditText edtDate = findViewById(R.id.edtDate);
//            EditText edtType = findViewById(R.id.edtType);
//            edtTitle.setText("");
//            edtContent.setText("");
//            edtDate.setText("");
//            edtType.setText("");
//        }
//
//
//
//
//}