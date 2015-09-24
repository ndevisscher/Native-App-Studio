package com.example.niek.todolist;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends Activity {

    // Creating the variables to be used for our ListView
    private ListView ListView ;
    private ArrayAdapter<String> listAdapter ;

    String word;

    // set the function to be executed on activity start
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the List as blank list
        String[] todo = new String[] {""};
        ArrayList<String> todolist = new ArrayList<String>();
        todolist.addAll(Arrays.asList(todo));

        // Create new ArrayAdapter listAddapter using the list
        listAdapter = new ArrayAdapter<String>(this, R.layout.rows, todolist);

        // Find the ListView in the layout
        ListView = (ListView) findViewById( R.id.listView );
        ListView.setLongClickable(true);
        // Setting the longlcick to remove the chosen item
        ListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View v, int index, long arg3) {

                String remove = listAdapter.getItem(index);
                listAdapter.remove(remove);
                listAdapter.notifyDataSetChanged();
                return false;
            }
        });

        // Getting the button for input registration
        final Button input = (Button)findViewById(R.id.button);
        // Collecting the word in editText
        final EditText wordGet = (EditText) findViewById(R.id.editText);
        // The clickListener to know when a word needs to be added to the list
        input.setOnClickListener(new View.OnClickListener() {
            // Adding the word to the list and emptying the input field
            @Override
            public void onClick(View v) {
                word = wordGet.getText().toString();
                listAdapter.add(word);
                wordGet.setText("");
            }
        });

        // Set addapter for ListView as listAdapter
        ListView.setAdapter( listAdapter );
    }
}