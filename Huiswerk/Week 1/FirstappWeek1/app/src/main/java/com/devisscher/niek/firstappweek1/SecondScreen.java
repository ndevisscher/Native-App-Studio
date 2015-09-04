package com.devisscher.niek.firstappweek1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        String FullName = getIntent().getStringExtra("InputName");
        TextView txtDisplay = (TextView)findViewById(R.id.NameImport);
        txtDisplay.setText("hoi " +FullName);

        Button redbutton = (Button)findViewById(R.id.redbutton);
        Button bluebutton = (Button)findViewById(R.id.bluebutton);
        Button greenbutton = (Button)findViewById(R.id.greenbutton);

        redbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondScreen.this, ThirdScreen.class);
                String ColorChoice = "rood";
                intent.putExtra("ColorChoice", ColorChoice);
                startActivity(intent);
            }
        });
        bluebutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondScreen.this, ThirdScreen.class);
                String ColorChoice = "blauw";
                intent.putExtra("colorChoice", ColorChoice);
                startActivity(intent);
            }
        });
        greenbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondScreen.this, ThirdScreen.class);
                String ColorChoice = "groen";
                intent.putExtra("ColorChoice", ColorChoice);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
