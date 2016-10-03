package com.example.a14270729b.magicconfragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    private TextView cont1, cont2;
    private int jug1Vidas, jug2Vidas, jug1Veneno, jug2Veneno;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_main, container, false);

        View [] botones = new View []{vista.findViewById(R.id.btn1Veneno),
                vista.findViewById(R.id.btn7Vida),vista.findViewById(R.id.btn3Veneno),
                vista.findViewById(R.id.btn9Vida),vista.findViewById(R.id.btn2Vida),
                vista.findViewById(R.id.btn8Veneno),vista.findViewById(R.id.btn4Vida),
                vista.findViewById(R.id.btn10Veneno),vista.findViewById(R.id.btn5Subir),
                vista.findViewById(R.id.btn6Bajar)};

        for(int i=0; i<botones.length;i++)
            botones[i].setOnClickListener(this);

        cont1 = (TextView) vista.findViewById(R.id.contador1);
        cont2 = (TextView) vista.findViewById(R.id.contador2);

        initzialitzarVariables();

        //Toast.makeText(this.getContext(), " "+text1.substring(text1.lastIndexOf("/")+1)+" ", Toast.LENGTH_SHORT).show();
        return vista;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btn1Veneno:
                jug1Veneno++;
                cont1.setText(String.valueOf(jug1Vidas)+"/"+String.valueOf(jug1Veneno));
                break;
            case R.id.btn2Vida:
                jug1Vidas++;
                cont1.setText(String.valueOf(jug1Vidas)+"/"+String.valueOf(jug1Veneno));
                break;
            case R.id.btn3Veneno:
                jug1Veneno--;
                cont1.setText(String.valueOf(jug1Vidas)+"/"+String.valueOf(jug1Veneno));
                break;
            case R.id.btn4Vida:
                jug1Vidas--;
                cont1.setText(String.valueOf(jug1Vidas)+"/"+String.valueOf(jug1Veneno));
                break;
            case R.id.btn5Subir:
                jug1Vidas++;
                jug2Vidas--;
                cont2.setText(String.valueOf(jug2Vidas)+"/"+String.valueOf(jug2Veneno));
                cont1.setText(String.valueOf(jug1Vidas)+"/"+String.valueOf(jug1Veneno));
                break;
            case R.id.btn6Bajar:
                jug1Vidas--;
                jug2Vidas++;
                cont2.setText(String.valueOf(jug2Vidas)+"/"+String.valueOf(jug2Veneno));
                cont1.setText(String.valueOf(jug1Vidas)+"/"+String.valueOf(jug1Veneno));
                break;
            case R.id.btn7Vida:
                jug2Vidas++;
                cont2.setText(String.valueOf(jug2Vidas)+"/"+String.valueOf(jug2Veneno));
                break;
            case R.id.btn8Veneno:
                jug2Veneno++;
                cont2.setText(String.valueOf(jug2Vidas)+"/"+String.valueOf(jug2Veneno));
                break;
            case R.id.btn9Vida:
                jug2Vidas--;
                cont2.setText(String.valueOf(jug2Vidas)+"/"+String.valueOf(jug2Veneno));
                break;
            case R.id.btn10Veneno:
                jug2Veneno--;
                cont2.setText(String.valueOf(jug2Vidas)+"/"+String.valueOf(jug2Veneno));
                break;
            default:
                break;
        }

    }

    public void initzialitzarVariables(){

        String text1 = cont1.getText().toString();
        String text2 = cont2.getText().toString();

        jug1Vidas = Integer.parseInt(text1.substring(0,text1.indexOf("/")));
        jug1Veneno = Integer.parseInt(text1.substring(text1.lastIndexOf("/")+1));

        jug2Vidas = Integer.parseInt(text2.substring(0,text2.indexOf("/")));
        jug2Veneno = Integer.parseInt(text2.substring(text2.lastIndexOf("/")+1));
    }

}
