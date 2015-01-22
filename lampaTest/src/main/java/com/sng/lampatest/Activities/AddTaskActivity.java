package com.sng.lampatest.Activities;

/**
 * Created by Alexandr on 22.01.2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.sng.lampatest.Models.TaskModel;
import com.sng.lampatest.R;

public class AddTaskActivity extends Activity {

    private EditText descriptionEditTxt;
    private EditText fulldescriptionEditTxt;
    private Button addTaskBtn;

    private TaskModel taskModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding_task_layout);

        descriptionEditTxt = (EditText) findViewById(R.id.descriptionEditTxt);
        fulldescriptionEditTxt = (EditText) findViewById(R.id.fulldescriptionEditTxt);

        addTaskBtn = (Button) findViewById(R.id.addTaskBtn);

    }

    public void onClick (View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        String description = descriptionEditTxt.getText().toString();
        String fullDescr = fulldescriptionEditTxt.getText().toString();

       /* if (description == null || fullDescr == null || description == "" || fullDescr == "") {
            Toast.makeText(getApplicationContext(), "Не все поля заполнены! Запись не добавлена.", Toast.LENGTH_LONG).show();
            finish();
            return;
        } */

        taskModel = new TaskModel(description, fullDescr);
        intent.putExtra(TaskModel.class.getCanonicalName(), taskModel);
        setResult(RESULT_OK, intent);
        finish();
    }

}
