package com.devisscher.niek.tic_tac_toe;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    //Maak alle button objecten aan die gebruikt gaan worden:
    Button s1,s2,s3,s4,s5,s6,s7,s8,s9;
    //We gebruiken een array om alle knoppen in te zetten zodat niet voor elke knop individueel
    //hoeft te worden gecodeerd
    Button[] bArray;

    //We moeten bijhouden welke speler de beurt heeft, daarvoor gebruiken we een boolean variabele:
    boolean xturn = true;
    //We moeten ook de beurt bijhouden om een draw te kunnen resetten:
    int xcount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Het linken van de knoppen in de layout zodat ze ook gebruikt kunnen worden:
        s1 = (Button) findViewById(R.id.s1);
        s2 = (Button) findViewById(R.id.s2);
        s3 = (Button) findViewById(R.id.s3);
        s4 = (Button) findViewById(R.id.s4);
        s5 = (Button) findViewById(R.id.s5);
        s6 = (Button) findViewById(R.id.s6);
        s7 = (Button) findViewById(R.id.s7);
        s8 = (Button) findViewById(R.id.s8);
        s9 = (Button) findViewById(R.id.s9);

        bArray = new Button[]{s1,s2,s3,s4,s5,s6,s7,s8,s9};

        //We kunnen nu uit de array alle buttons onclicklisteners meegeven zodat ze ook echt iets
        //gaan registreren als ze worden gebruikt.
        for (Button b: bArray) {
            b.setOnClickListener(this);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {
        Button b =(Button) v;
        buttonPress(b);
    }

    private void buttonPress (Button b) {
        //De game begint altijd met speler X

        //Hier geven we aan dat er een X wordt gezet als het de beurt is van speler X
        if (xturn){
            b.setText("X");
            //We moeten natuurlijk de beurt veranderen
            xturn = false;
            xcount ++;
        }
        //Hier geven we aan dat er een O moet worden gezet omdat speler O aan de beurt is
        else{
            b.setText("O");
            //Hier ook weer de beurt terug veranderen
            xturn = true;
            xcount++;
        }
        //Nadat een knop is gebruikt moet hij niet nogmaals gebruikt kunnen worden:
        b.setClickable(false);
        //En we controleren of iemand heeft gewonnen (en wie):
        checkWinner();
    }

    private void checkWinner() {
        //We hebben een variabele die wordt gebruikt als er een winnaar is om het spel te resetten:
        boolean winner = false;
        //Hiermee checken we of Speler X heeft gewonnen, en als Speler X heeft gewonnen wordt er een
        //bericht getoond:
        if (s1.getText() == "X" && s2.getText() == "X" && s3.getText() == "X"){
            Toast.makeText(MainActivity.this, "Speler X heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        else if (s4.getText() == "X" && s5.getText() == "X" && s6.getText() == "X"){
            Toast.makeText(MainActivity.this, "Speler X heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        else if (s7.getText() == "X" && s8.getText() == "X" && s9.getText() == "X"){
            Toast.makeText(MainActivity.this, "Speler X heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        else if (s1.getText() == "X" && s4.getText() == "X" && s7.getText() == "X"){
            Toast.makeText(MainActivity.this, "Speler X heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
       else if (s2.getText() == "X" && s5.getText() == "X" && s8.getText() == "X"){
            Toast.makeText(MainActivity.this, "Speler X heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        else if (s3.getText() == "X" && s6.getText() == "X" && s9.getText() == "X"){
            Toast.makeText(MainActivity.this, "Speler X heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        else if (s1.getText() == "X" && s5.getText() == "X" && s9.getText() == "X"){
            Toast.makeText(MainActivity.this, "Speler X heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        else if (s3.getText() == "X" && s5.getText() == "X" && s7.getText() == "X"){
            Toast.makeText(MainActivity.this, "Speler X heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        //Hiermee checken we of Speler O heeft gewonnnen en tonen we een bericht:
        if (s1.getText() == "O" && s2.getText() == "O" && s3.getText() == "O"){
            Toast.makeText(MainActivity.this, "Speler O heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        else if (s4.getText() == "O" && s5.getText() == "O" && s6.getText() == "O"){
            Toast.makeText(MainActivity.this, "Speler O heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        else if (s7.getText() == "O" && s8.getText() == "O" && s9.getText() == "O"){
            Toast.makeText(MainActivity.this, "Speler O heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        else if (s1.getText() == "O" && s4.getText() == "O" && s7.getText() == "O"){
            Toast.makeText(MainActivity.this, "Speler O heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        else if (s2.getText() == "O" && s5.getText() == "O" && s8.getText() == "O"){
            Toast.makeText(MainActivity.this, "Speler O heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        else if (s3.getText() == "O" && s6.getText() == "O" && s9.getText() == "O"){
            Toast.makeText(MainActivity.this, "Speler O heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        else if (s1.getText() == "O" && s5.getText() == "O" && s9.getText() == "O"){
            Toast.makeText(MainActivity.this, "Speler O heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        else if (s3.getText() == "O" && s5.getText() == "O" && s7.getText() == "O"){
            Toast.makeText(MainActivity.this, "Speler O heeft gewonnen", Toast.LENGTH_LONG).show();
            winner = true;
        }
        //We resetten de game als er een winnaar is:
        if (winner || xcount == 9){
            for (Button b: bArray) {
                b.setText("");
                b.setClickable(true);
                xturn = true;
            }
        }
    }
}
