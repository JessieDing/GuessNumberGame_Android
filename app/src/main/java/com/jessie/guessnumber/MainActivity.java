package com.jessie.guessnumber;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import static com.jessie.guessnumber.R.id.show_first_num;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    private GoogleApiClient client;
    private int count; //默认值为0
    private List<String> numbers;
    private TextView showNumberArea1;
    private TextView showNumberArea2;
    private TextView showNumberArea3;
    private TextView showNumberArea4;

    private TextView result_Area1;
    private TextView result_Area2;
    private TextView result_Area3;
    private TextView result_Area4;
    private TextView result_Area5;
    private TextView result_Area6;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    private void showPlayerInputNumbers(int number) {  //在相应区域显示玩家输入的数字
        if (numbers.size() < 4) {
            numbers.add(String.valueOf(number));
        }

        if (numbers.size() > 0) {
            showNumberArea1.setText(numbers.get(0));
        }
        if (numbers.size() > 1) {
            showNumberArea2.setText(numbers.get(1));
        }
        if (numbers.size() > 2) {
            showNumberArea3.setText(numbers.get(2));
        }
        if (numbers.size() > 3) {
            showNumberArea4.setText(numbers.get(3));
        }
    }

    private void delete() {

        if (numbers.size() > 3) {
            showNumberArea4.setText("");
        } else if (numbers.size() > 2) {
            showNumberArea3.setText("");
        } else if (numbers.size() > 1) {
            showNumberArea2.setText("");
        } else if (numbers.size() > 0) {
            showNumberArea1.setText("");
        }
        numbers.remove(numbers.size() - 1);
    }

    private void showResult(Answer answer, Answer playerAnswer) {
        String numberArr = numbers.get(0) + numbers.get(1) + numbers.get(2) + numbers.get(3);

        switch (count) {
            case 1:
                String result1 = answer.compareTo(playerAnswer);
                result_Area1.setText("(1)" + numberArr + "——>" + result1);
                numbers.clear();
                break;
            case 2:
                String result2 = answer.compareTo(playerAnswer);
                result_Area2.setText("(2)" + numberArr + "——>" + result2);
                numbers.clear();
                break;
            case 3:
                String result3 = answer.compareTo(playerAnswer);
                result_Area3.setText("(3)" + numberArr + "——>" + result3);
                numbers.clear();
                break;
            case 4:
                String result4 = answer.compareTo(playerAnswer);
                result_Area4.setText("(4)" + numberArr + "——>" + result4);
                numbers.clear();
                break;
            case 5:
                String result5 = answer.compareTo(playerAnswer);
                result_Area5.setText("(5)" + numberArr + "——>" + result5);
                numbers.clear();
                break;
            case 6:
                String result6 = answer.compareTo(playerAnswer);
                result_Area6.setText("(6)" + numberArr + "——>" + result6);
                numbers.clear();
                break;
        }
    }

    private void clearShowResultArea() {
        result_Area1.setText("");
        result_Area2.setText("");
        result_Area3.setText("");
        result_Area4.setText("");
        result_Area5.setText("");
        result_Area6.setText("");
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {  //程序运行时首先进onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showNumberArea1 = (TextView) findViewById(show_first_num);
        showNumberArea2 = (TextView) findViewById(R.id.show_second_num);
        showNumberArea3 = (TextView) findViewById(R.id.show_third_num);
        showNumberArea4 = (TextView) findViewById(R.id.show_fourth_num);

        result_Area1 = (TextView) findViewById(R.id.showResult_1);
        result_Area2 = (TextView) findViewById(R.id.showResult_2);
        result_Area3 = (TextView) findViewById(R.id.showResult_3);
        result_Area4 = (TextView) findViewById(R.id.showResult_4);
        result_Area5 = (TextView) findViewById(R.id.showResult_5);
        result_Area6 = (TextView) findViewById(R.id.showResult_6);

        numbers = new ArrayList<>();

        Button buton0 = (Button) findViewById(R.id.btn_0);
        buton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number0 = 0;
                showPlayerInputNumbers(number0);
            }
        });
        Button buton1 = (Button) findViewById(R.id.btn_1);
        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1 = 1;
                showPlayerInputNumbers(number1);
            }
        });
        Button buton2 = (Button) findViewById(R.id.btn_2);
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number2 = 2;
                showPlayerInputNumbers(number2);
            }
        });
        Button buton3 = (Button) findViewById(R.id.btn_3);
        buton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number3 = 3;
                showPlayerInputNumbers(number3);
            }
        });
        Button buton4 = (Button) findViewById(R.id.btn_4);
        buton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number4 = 4;
                showPlayerInputNumbers(number4);
            }
        });
        Button buton5 = (Button) findViewById(R.id.btn_5);
        buton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number5 = 5;
                showPlayerInputNumbers(number5);
            }
        });
        Button buton6 = (Button) findViewById(R.id.btn_6);
        buton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number6 = 6;
                showPlayerInputNumbers(number6);
            }
        });
        Button buton7 = (Button) findViewById(R.id.btn_7);
        buton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number7 = 7;
                showPlayerInputNumbers(number7);
            }
        });
        Button buton8 = (Button) findViewById(R.id.btn_8);
        buton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number8 = 8;
                showPlayerInputNumbers(number8);
            }
        });
        Button buton9 = (Button) findViewById(R.id.btn_9);
        buton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number9 = 9;
                showPlayerInputNumbers(number9);
            }
        });

        Button buton_DEL = (Button) findViewById(R.id.btn_del);
        buton_DEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });

        final RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        final Answer answer = new Answer();
        answer.setNumbers(numberGenerator.generate());
        final Answer playerAnswer = new Answer();
        playerAnswer.setNumbers(numbers);

        final Button buton_OK = (Button) findViewById(R.id.btn_OK);
        buton_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                showResult(answer, playerAnswer);
                showNumberArea1.setText("");
                showNumberArea2.setText("");
                showNumberArea3.setText("");
                showNumberArea4.setText("");

                if (count == 6) {
                    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    };
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("很遗憾，六次机会已用完！")
                            .setMessage("正确答案是" + TextUtils.join(",", answer.getNumbers()))
                            .setPositiveButton("确定", listener)
                            .show();
                    buton_OK.setClickable(false);
                }
            }
        });

        Button buton_Refresh = (Button) findViewById(R.id.btn_refresh);
        buton_Refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearShowResultArea();
                answer.setNumbers(numberGenerator.generate());
                count = 0;
                buton_OK.setClickable(true);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
        super.onStart();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        AppIndex.AppIndexApi.start(client, getIndexApiAction());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.start(client, getIndexApiAction0());
    }

    @Override
    public void onStop() {
        super.onStop();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction0());

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        AppIndex.AppIndexApi.end(client, getIndexApiAction());
//        client.disconnect();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction0() {
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
}
