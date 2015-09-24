package com.example.niek.todolist;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends Activity {

    private ListView ListView ;
    private ArrayAdapter<String> listAdapter ;

    String word;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the ListView resource.
        ListView = (ListView) findViewById( R.id.listView );

        // Create and populate the List
        String[] todo = new String[] {""};
        ArrayList<String> todolist = new ArrayList<String>();
        todolist.addAll(Arrays.asList(todo));

        // Create ArrayAdapter using the list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.rows, todolist);

        // Create ArrayAdapter using the list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.rows, todolist);

        // Create the input registration
        final Button input = (Button)findViewById(R.id.button);
        final EditText wordGet = (EditText) findViewById(R.id.editText);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                word = wordGet.getText().toString();
                listAdapter.add(word);
                wordGet.setText("");
            }
        });

        // Set the ArrayAdapter as the ListView's adapter.
        ListView.setAdapter( listAdapter );
    }
}