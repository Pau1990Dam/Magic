package com.example.a14270729b.magicconfragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    private TextView cont1, cont2;
    private int jug1Vidas, jug2Vidas, jug1Veneno, jug2Veneno;
    private Jugador jugador1, jugador2;


    public MainActivityFragment() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

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


    //Indiquem quin es el xml corresponent al dibuix del menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main_fragment, menu);
    }

    //Indiquem que executi el métode void refresh() si es clica l'item del menu refresh.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btn1Veneno:
                jugador1.venenoMas();
                cont1.setText(String.valueOf(jugador1.getVida())+"/"+String.valueOf(jugador1.getVeneno()));
                break;
            case R.id.btn2Vida:
                jugador1.vidaMas();
                cont1.setText(String.valueOf(jugador1.getVida())+"/"+String.valueOf(jugador1.getVeneno()));
                break;
            case R.id.btn3Veneno:
                jugador1.venenoMenos();
                cont1.setText(String.valueOf(jugador1.getVida())+"/"+String.valueOf(jugador1.getVeneno()));
                break;
            case R.id.btn4Vida:
                jugador1.vidaMenos();
                cont1.setText(String.valueOf(jugador1.getVida())+"/"+String.valueOf(jugador1.getVeneno()));
                break;
            case R.id.btn5Subir:
                jugador1.robarVida(jugador2);
                cont1.setText(String.valueOf(jugador1.getVida())+"/"+String.valueOf(jugador1.getVeneno()));
                cont2.setText(String.valueOf(jugador2.getVida())+"/"+String.valueOf(jugador2.getVeneno()));
                break;
            case R.id.btn6Bajar:
                jugador2.robarVida(jugador1);
                cont1.setText(String.valueOf(jugador1.getVida())+"/"+String.valueOf(jugador1.getVeneno()));
                cont2.setText(String.valueOf(jugador2.getVida())+"/"+String.valueOf(jugador2.getVeneno()));
                break;
            case R.id.btn7Vida:
                jugador2.vidaMas();
                cont2.setText(String.valueOf(jugador2.getVida())+"/"+String.valueOf(jugador2.getVeneno()));
                break;
            case R.id.btn8Veneno:
                jugador2.venenoMas();
                cont2.setText(String.valueOf(jugador2.getVida())+"/"+String.valueOf(jugador2.getVeneno()));
                break;
            case R.id.btn9Vida:
                jugador2.vidaMenos();
                cont2.setText(String.valueOf(jugador2.getVida())+"/"+String.valueOf(jugador2.getVeneno()));
                break;
            case R.id.btn10Veneno:
                jugador2.venenoMenos();
                cont2.setText(String.valueOf(jugador2.getVida())+"/"+String.valueOf(jugador2.getVeneno()));
                break;
            default:
                break;
        }

    }

    public void initzialitzarVariables(){


        String text1 = cont1.getText().toString();
        String text2 = cont2.getText().toString();

        jugador1 = new Jugador(Integer.parseInt(text1.substring(0,text1.indexOf("/"))),
                Integer.parseInt(text1.substring(text1.lastIndexOf("/")+1)));
        jugador2 = new Jugador(Integer.parseInt(text2.substring(0,text2.indexOf("/"))),
                Integer.parseInt(text2.substring(text2.lastIndexOf("/")+1)));

      /*  jug1Vidas = Integer.parseInt(text1.substring(0,text1.indexOf("/")));
        jug1Veneno = Integer.parseInt(text1.substring(text1.lastIndexOf("/")+1));

        jug2Vidas = Integer.parseInt(text2.substring(0,text2.indexOf("/")));
        jug2Veneno = Integer.parseInt(text2.substring(text2.lastIndexOf("/")+1));*/
    }

}
