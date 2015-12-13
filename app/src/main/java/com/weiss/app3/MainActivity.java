package com.weiss.app3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{


    Button btn1,btnMin,btnMax;
    TextView tv1,tv2;
    EditText et1,et2;


    int A[][];

   int x;
    int y;
    String l;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        btn1 = (Button)findViewById(R.id.btnGo);
        tv1 = (TextView)findViewById(R.id.tb1);
        tv2 = (TextView)findViewById(R.id.tb2);
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);



        tv1.setText("");
        tv2.setText("");
        et1.setText("");
        et2.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onClick(View v) {





        tv1.setText("");



        x = Integer.parseInt(String.valueOf(et1.getText()));
        y = Integer.parseInt(String.valueOf(et2.getText()));
        A = new int[y][x];

        for (int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                A[i][j] = (int)(Math.random()*9)+1;

            }

        }


        openArr();
        minMax();






    }


    public void minMax(){
        int min=A[0][0];
        int max=A[0][0];

        String minS="Минимальные элементы массива:\n";
        String maxS="Максимальные элементы массива:\n ";


        for (int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                if(A[i][j]<=min){
                    min=A[i][j];

                }

                if(A[i][j]>=max){
                    max=A[i][j];

                }
            }
        }



        for (int i=0;i<y;i++){
            for (int j=0;j<x;j++){
                if(A[i][j]==min){
                    minS+="A["+(i+1)+"]["+(j+1)+"] ";

                }
                if(A[i][j]==max){
                    maxS+="A["+(i+1)+"]["+(j+1)+"] ";
                }
            }
        }

        minS+=" равные "+min;
        maxS+=" равные "+max;
        String mm = minS+"\n\n"+maxS;
        tv2.setText(mm);
    }




   public void onMin(View v){


       int temp1st;
       int temp2nd;



       for (int f=0;f<y;f++){
           for (int d=0;d<x;d++){

       for (int i=0;i<y;i++){
           for (int j=0;j<x;j++){

                   if (A[i][j]>A[f][d]){
                       temp1st = A[i][j];
                       temp2nd = A[f][d];

                       A[i][j]=temp2nd;
                       A[f][d]=temp1st;


                   }

               }



               }

           }

       }


       openArr();
       minMax();
toast("Массив упорядочен по MIN");

    }


public void onMax(View v){
    int temp1st;
    int temp2nd;



    for (int f=0;f<y;f++){
        for (int d=0;d<x;d++){

            for (int i=0;i<y;i++){
                for (int j=0;j<x;j++){

                    if (A[i][j]<A[f][d]){
                        temp1st = A[i][j];
                        temp2nd = A[f][d];

                        A[i][j]=temp2nd;
                        A[f][d]=temp1st;


                    }

                }



            }

        }

    }


    openArr();
    minMax();
    toast("Массив упорядочен по MAX");

}


    public void openArr(){
        String q="";

        for (int i=0;i<y;i++){
            for (int j=0;j<x;j++){
                q+=A[i][j]+" ";
            }
            q+="\n";
        }

               tv1.setText(q);
    }


    public void toast(String e){
        Toast tst = Toast.makeText(this,e,Toast.LENGTH_SHORT);
        tst.show();
    }

}
