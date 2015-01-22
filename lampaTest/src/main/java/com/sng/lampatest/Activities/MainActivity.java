package com.sng.lampatest.Activities;

/**
 * Created by Alexandr on 22.01.2015.
 */
import  android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
        initArrayWithDefaultValues();

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

        TaskModel model = new TaskModel("Задание № ", "Описание: Землекопы ", " Пять землекопов за 5 часов выкапывают 5 м канавы." +
                " Сколько потребуется землекопов, для того чтобы выкопать 100 м канавы за 100 часов? ");
        TaskModel model2 = new TaskModel("Задание № ","Описание: Деревенский дурачок ", "Люди, приезжавшие в одну деревушку, часто удивлялись местному дурачку. Когда ему предлага­ли выбор между блестящей 50-центовой монетой и мя­той пятидолларовой купюрой," +
                " он всегда выбирал моне­ту, хотя она стоит вдесятеро меньше купюры. Почему он никогда не выбирал купюру?");
        TaskModel model3 = new TaskModel("Задание № ", "Описание: Кольцо вокруг Земли", "Образно представьте себе нашу планету," +
                " плотно стянутую кольцом по всему ее экватору. После увеличения длины окружности кольца на 10 метров," +
                " между кольцом и поверхностью земли образовался зазор определенной величины. " +
                "Как Вы считаете, сможет ли человек пройти, или хотя бы протиснуться в этот зазор? \n" +
                "Известно, что экватор имеет длину приблизительно равную 40 000 километров." );
        TaskModel model4 = new TaskModel("Задание № ", "Описание: Коробки с конфетами", "Пете и Коле купили по коробке конфет. В каждой коробке находится 12 конфет. Петя из своей коробки съел несколько конфет," +
                " а Коля из своей коробки съел столько конфет, сколько осталось в коробке у Пети. " +
                "Сколько конфет осталось на двоих у Пети и Коли?" );
        TaskModel model5 = new TaskModel("Задание № ", "Описание: О лифте", " Человек живет на 17-м этаже. На свой этаж он поднимается на лифте только в дождливую погоду или тогда, когда кто-нибудь из соседей с ним едет в лифте." +
                " Если погода хорошая и он один в лифте, то он едет до 9-го этажа," +
                " а дальше до 17-го этажа идет пешком по лестнице... Почему?" );
        TaskModel model6 = new TaskModel("Задание № ", "Описание: Школьный инспектор", " Инспектор, проверявший некую школу, заметил, что, когда бы он ни задал классу вопрос, в ответ тянули руки все ученики." +
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
        intent.putExtra("fullDescription", model.getTaskNumber() + (position + 1)+ "_" + model.getSmallDescription() +
                "\n" + "\n" + model.getFullDescription());
        startActivity(intent);
    }
}
