package com.sng.lampatest.Activities;

/**
 * Created by Alexandr on 22.01.2015.
 */
import  android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.sng.lampatest.Models.TaskModel;
import com.sng.lampatest.R;
import com.sng.lampatest.SupportClasses.TaskViewAdapter;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView taskListView;
    ArrayList<TaskModel> taskModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        taskListView = (ListView) findViewById(R.id.taskListView);

        if (savedInstanceState == null) {
            initArrayWithDefaultValues();
        } else {
            onRestoreInstanceState(savedInstanceState);
        }

        TaskViewAdapter adapter = new TaskViewAdapter(getApplicationContext(), taskModels);
        taskListView.setAdapter(adapter);

        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startDescriptionActivity(taskModels.get(position), position);
            }
        });

    }

    public void initArrayWithDefaultValues(){
        taskModels = new ArrayList<TaskModel>();

        TaskModel model = new TaskModel("Землекопы ", " Пять землекопов за 5 часов выкапывают 5 м канавы." +
                " Сколько потребуется землекопов, для того чтобы выкопать 100 м канавы за 100 часов? ");
        TaskModel model2 = new TaskModel("Деревенский дурачок ", "Люди, приезжавшие в одну деревушку, часто удивлялись местному дурачку. Когда ему предлага­ли выбор между блестящей 50-центовой монетой и мя­той пятидолларовой купюрой," +
                " он всегда выбирал моне­ту, хотя она стоит вдесятеро меньше купюры. Почему он никогда не выбирал купюру?");
        TaskModel model3 = new TaskModel("Кольцо вокруг Земли", "Образно представьте себе нашу планету," +
                " плотно стянутую кольцом по всему ее экватору. После увеличения длины окружности кольца на 10 метров," +
                " между кольцом и поверхностью земли образовался зазор определенной величины. " +
                "Как Вы считаете, сможет ли человек пройти, или хотя бы протиснуться в этот зазор? \n" +
                "Известно, что экватор имеет длину приблизительно равную 40 000 километров." );
        TaskModel model4 = new TaskModel("Коробки с конфетами", "Пете и Коле купили по коробке конфет. В каждой коробке находится 12 конфет. Петя из своей коробки съел несколько конфет," +
                " а Коля из своей коробки съел столько конфет, сколько осталось в коробке у Пети. " +
                "Сколько конфет осталось на двоих у Пети и Коли?" );
        TaskModel model5 = new TaskModel("О лифте", " Человек живет на 17-м этаже. На свой этаж он поднимается на лифте только в дождливую погоду или тогда, когда кто-нибудь из соседей с ним едет в лифте." +
                " Если погода хорошая и он один в лифте, то он едет до 9-го этажа," +
                " а дальше до 17-го этажа идет пешком по лестнице... Почему?" );
        TaskModel model6 = new TaskModel("Школьный инспектор", " Инспектор, проверявший некую школу, заметил, что, когда бы он ни задал классу вопрос, в ответ тянули руки все ученики." +
                " Более того, хотя школьный учитель каждый раз выби­рал другого ученика, " +
                "ответ всегда был правильным. Как это получалось?" );

        taskModels.add(model);
        taskModels.add(model2);
        taskModels.add(model3);
        taskModels.add(model4);
        taskModels.add(model5);
        taskModels.add(model6);
    }

    public void startDescriptionActivity (TaskModel model, int position){
        Intent intent = new Intent(getApplicationContext(), DescriptionActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(TaskModel.class.getCanonicalName(), model);
        bundle.putInt("position", position);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.addBtn) {
            addNewTask();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addNewTask() {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if (data == null) return;

        TaskModel taskModel = data.getParcelableExtra(TaskModel.class.getCanonicalName());
        taskModels.add(taskModel);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("taskModels", taskModels);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        taskModels = savedInstanceState.getParcelableArrayList("taskModels");
    }
}
