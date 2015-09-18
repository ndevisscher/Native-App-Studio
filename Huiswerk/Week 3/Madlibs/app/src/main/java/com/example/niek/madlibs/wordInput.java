package com.example.niek.madlibs;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class wordInput extends Activity {

    public class Story implements Serializable {
        private String text;                 // text of the story
        private List<String> placeholders;   // list of placeholders to fill in
        private int filledIn;                // number of placeholders that have been filled in
        private boolean htmlMode;            // set to true to surround placeholders with <b></b> tags

        {
            // instance initializer; runs before any constructor
            text = "";
            placeholders = new ArrayList<String>();
            filledIn = 0;
            htmlMode = false;
            clear();
        }

        /** constructs a new empty Story */
        public Story() {
            // empty
        }

        /** constructs a new Story reading its text from the given input stream */
        public Story(InputStream stream) {
            read(stream);
        }

        /** constructs a new Story reading its text from the given Scanner */
        public Story(Scanner input) {
            read(input);
        }

        /** resets the story back to an empty initial state */
        public void clear() {
            text = "";
            placeholders.clear();
            filledIn = 0;
        }

        /** replaces the next unfilled placeholder with the given word */
        public void fillInPlaceholder(String word) {
            if (!isFilledIn()) {
                text = text.replace("<" + filledIn + ">", word);
                filledIn++;
            }
        }

        /** returns the next placeholder such as "adjective",
         *  or empty string if story is completely filled in already */
        public String getNextPlaceholder() {
            if (isFilledIn()) {
                return "";
            } else {
                return placeholders.get(filledIn);
            }
        }

        /** returns total number of placeholders in the story */
        public int getPlaceholderCount() {
            return placeholders.size();
        }

        /** returns how many placeholders still need to be filled in */
        public int getPlaceholderRemainingCount() {
            return placeholders.size() - filledIn;
        }

        /** returns true if all placeholders have been filled in */
        public boolean isFilledIn() {
            return filledIn >= placeholders.size();
        }

        /** reads initial story text from the given input stream */
        public void read(InputStream stream) {
            read(new Scanner(stream));
        }

        /** reads initial story text from the given Scanner */
        public void read(Scanner input) {
            while (input.hasNext()) {
                String word = input.next();
                if (word.startsWith("<") && word.endsWith(">")) {
                    // a placeholder; replace with e.g. "<0>" so I can find/replace it easily later
                    // (make them bold so that they stand out!)
                    if (htmlMode) {
                        text += " <b><" + placeholders.size() + "></b>";
                    } else {
                        text += " <" + placeholders.size() + ">";
                    }
                    // "<plural-noun>" becomes "plural noun"
                    String placeholder = word.substring(1, word.length() - 1).replace("-", " ");
                    placeholders.add(placeholder);
                } else {
                    // a regular word; just concatenate
                    if (!text.isEmpty()) {
                        text += " ";
                    }
                    text += word;
                }
            }
        }

        /** returns story text */
        public String toString() {
            return text;
        }
    }

    String word;
    String hint;
    String hintline = "Please type a/an ";
    String inputCount;
    String wordText = " words left.";
    int count;

    String Tarzan = "One of the most <adjective> characters in fiction is named\n" +
            "\"Tarzan of the <plural-noun> .\" Tarzan was raised by a/an\n" +
            "<noun> and lives in the <adjective> jungle in the\n" +
            "heart of darkest <place> . He spends most of his time\n" +
            "eating <plural-noun> and swinging from tree to <noun> .\n" +
            "Whenever he gets angry, he beats on his chest and says,\n" +
            "\" <funny-noise> !\" This is his war cry. Tarzan always dresses in\n" +
            "<adjective> shorts made from the skin of a/an <noun>\n" +
            "and his best friend is a/an <adjective> chimpanzee named\n" +
            "Cheetah. He is supposed to be able to speak to elephants and\n" +
            "<plural-noun> . In the movies, Tarzan is played by <person's-name> .";

    String University = "Our American universities offer students many <adjective>\n" +
            "courses that will prepare them to become professional <plural-noun> .\n" +
            "You can get a degree as a Bachelor of <plural-noun> or take a\n" +
            "regular liberal <plural-noun> course. Or, if you want to become\n" +
            "a/an <adjective> engineer, you can study <adjective> mathematics\n" +
            "and differential <plural-noun> . Then, after <number> years, if\n" +
            "you want to continue your studies you can write a/an <noun> and\n" +
            "become a Doctor of <plural-noun> . \n" +
            "\n" +
            "When you get out into the <adjective> world, if you have a diploma \n" +
            "from a university, you will be able to get a job easily as a/an <job-title> \n" +
            "or even a/an <job-title> . If you don't have a diploma, you may have to take\n" +
            "a job as a <noun> . \n" +
            "\n" +
            "Remember, it's important that you study hard in high school so you are able \n" +
            "to do well on your college entrance <plural-noun> . It is true that \"a little \n" +
            "learning is a/an <adjective> thing.\"";

    String Clothes = "<Male-Name> has announced that his <adjective>\n" +
            "clothing store in the heart of downtown <CITY> is having\n" +
            "a/an <adjective> sale of all merchandise, including\n" +
            "<unusual-adjective> suits and slightly irregular <plural-noun>\n" +
            "available. Men's cable-knit <plural-noun> , only $15.99.\n" +
            "Hand-woven Italian <plural-noun> , 1/2-price. Double-\n" +
            "breasted cashmere <plural-noun> , $50.00. Genuine imported\n" +
            "<Color!> <adjective> shoes, <Exciting-adjective> handerchiefs,\n" +
            "and women's embroidered <plural-noun> , all at rock-bottom prices.\n" +
            "This is a chance to get some really <Interesting-Adjective> bargains.\n";

    String Dance = "Here's how you dance the Monstrosity. Stand with your feet together.\n" +
            "Now, move your left foot <aDvErB> to the side. Now stamp your\n" +
            "right foot <NUMBER> times and put your hands on your partner's\n" +
            "<Plural-Noun> . Next, you both <verb> slowly to the right and bend\n" +
            "your <body-part> backward. For the next eight counts,\n" +
            "both of you <verb> <adverb> to the left. Next, you and\n" +
            "your partner stand back to back and wiggle your <pluRAL-nOUN> and\n" +
            "slap your <plural-noun> together. Don't forget to keep stamping\n" +
            "your right foot. Now, face your partner again, put your <plural-noun>\n" +
            "together and shout, \" <FUNNY-noise> !\" Now, <verb> backward\n" +
            "and repeat the whole thing <Number> times. If you feel that you can't\n" +
            "learn this dance, you can always <verB> the next one out.";

    String Text = "I wannabe a <job> when I grow up.\n" +
            "Just like my dad.\n" +
            "Life is <adjective> like that!";

    String[] textArray = {Tarzan,University,Dance,Clothes,Text};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_input);

        //Selecting a random story to be used for the madlib
        Random number = new Random();
        int chosen = number.nextInt(4) + 1;

        //Creating the story class so we can use the underlying functions to read our text
        final Story story = new Story();
        Scanner Stext = new Scanner(textArray[chosen]);
        //Scanner Stext = new Scanner(new File(getAssets().open("madlib0_simple.txt")));
        story.read(Stext);

        //Showing a hint for the word that needs to be filled in
        hint = hintline + story.getNextPlaceholder();
        final TextView hintText = (TextView)findViewById(R.id.helper);
        hintText.setText(hint);

        //Showing how many words still need to be filled in
        final TextView wordCount = (TextView)findViewById(R.id.wordsLeft);
        inputCount = Integer.toString(story.getPlaceholderCount()) + wordText;
        wordCount.setText(inputCount);

        //Creating the listeners for the button and textfield so we can use these to get input
        final Button input = (Button)findViewById(R.id.Input);
        final EditText wordGet = (EditText) findViewById(R.id.editText);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = story.getPlaceholderRemainingCount();
                int total = story.placeholders.size();
                //After the last word is filled in we go to the story activity to display the story we formed
                if (count == 1) {
                    word = wordGet.getText().toString();
                    story.fillInPlaceholder(word);
                    wordGet.setText("");

                    Toast.makeText(getApplicationContext(), "Your story is being generated", Toast.LENGTH_LONG).show();
                    //Sending along the story text and starting the new activity
                    Intent intent = new Intent(v.getContext(), story.class);
                    String sendText = story.text;
                    intent.putExtra("Passed Text", sendText);
                    startActivity(intent);
                }
                //If there are words to be filled in we input the word and set in into our text
                else {
                    //Getting the word input for the story and placing it in the text
                    word = wordGet.getText().toString();
                    story.fillInPlaceholder(word);
                    wordGet.setText("");

                    //Showing a new hint for the word to be filled in
                    hint = hintline + story.getNextPlaceholder();
                    hintText.setText(hint);

                    //Showing how many words are left to be filled in
                    inputCount = Integer.toString(story.getPlaceholderRemainingCount()) + wordText;
                    wordCount.setText(inputCount);

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_word_input, menu);
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

    /*
 * CS 193A, Marty Stepp
 * This class represents a Mad Libs story that comes from a text file.
 * You can construct it and pass an input stream or Scanner to read the story text.
 * After constructing it, you can ask it for each placeholder by calling
 *  getNextPlaceholder, then filling in that placeholder by calling fillInPlaceholder.
 * To see how many placeholders are left, use the methods
 *  getPlaceholderRemainingCount and isFilledIn.
 * You can get the story's text by calling its toString method.
 * A Story is Serializable, so it can be packed into an Intent as "extra" data.
 */


}
