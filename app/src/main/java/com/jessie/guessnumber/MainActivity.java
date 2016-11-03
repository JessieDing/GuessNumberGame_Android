package com.jessie.guessnumber;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    private GoogleApiClient client;

    private List<String> numbers;

    private void storeNumbers(int number) {
        if (numbers.size() < 4) {
            numbers.add(String.valueOf(number));
        }
        showNumber();
    }
    public void showNumber() {
        TextView showNumberArea = (TextView) findViewById(R.id.showNumber_area); //通过Activity的findViewById()方法获取表达式区域
        String strNewContent = "";
        for (String x : numbers) {
            strNewContent += x;
        }
        showNumberArea.setText(strNewContent); //把新的表达式内容，通过TextView的setText()方法，显示到表达式区域上
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {  //程序运行时首先进onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numbers = new ArrayList<>();

        Button buton0 = (Button) findViewById(R.id.btn_0);
        buton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number0 = 0;
                storeNumbers(number0);
            }
        });
        Button buton1 = (Button) findViewById(R.id.btn_1);
        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1 = 1;
                storeNumbers(number1);
            }
        });
        Button buton2 = (Button) findViewById(R.id.btn_2);
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number2 = 2;
                storeNumbers(number2);
            }
        });
        Button buton3 = (Button) findViewById(R.id.btn_3);
        buton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number3 = 3;
                storeNumbers(number3);
            }
        });
        Button buton4 = (Button) findViewById(R.id.btn_4);
        buton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number4 = 4;
                storeNumbers(number4);
            }
        });
        Button buton5 = (Button) findViewById(R.id.btn_5);
        buton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number5 = 5;
                storeNumbers(number5);
            }
        });
        Button buton6 = (Button) findViewById(R.id.btn_6);
        buton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number6 = 6;
                storeNumbers(number6);
            }
        });
        Button buton7 = (Button) findViewById(R.id.btn_7);
        buton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number7 = 7;
                storeNumbers(number7);
            }
        });
        Button buton8 = (Button) findViewById(R.id.btn_8);
        buton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number8 = 8;
                storeNumbers(number8);
            }
        });
        Button buton9 = (Button) findViewById(R.id.btn_9);
        buton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number9 = 9;
                storeNumbers(number9);
            }
        });

        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        final Answer answer = new Answer();
        answer.setNumbers(numberGenerator.generate());
        final Answer playerAnswer = new Answer();
        playerAnswer.setNumbers(numbers);

        final GameValidator gameValidator = new GameValidator();

        Button showResultButton = (Button) findViewById(R.id.button_showResult);
        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView showResultArea = (TextView) findViewById(R.id.showResult_area);
                TextView showNumberArea = (TextView) findViewById(R.id.showNumber_area);
                String resultMessage = "";
                for (int i = 0; i < 6; i++) {
                    if (!gameValidator.isLengthValid(playerAnswer)) {
                        showResultArea.setText("请输入四个数字!");
                        continue;
                    }
                    if (gameValidator.isRepeated(playerAnswer)) {
                        showResultArea.setText("请勿输入重复数字!");
                        continue;
                    }
                    if (gameValidator.isCorrect(answer, playerAnswer)) {
                        showResultArea.setText("恭喜你答对了！");
                        break;
                    }
                    resultMessage = answer.compareTo(playerAnswer);
                    showResultArea.setText(resultMessage);
                    showNumberArea.setText("");
                }
            }
        });
    }



// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.

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

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        AppIndex.AppIndexApi.end(client, getIndexApiAction());
//        client.disconnect();
    }
}
