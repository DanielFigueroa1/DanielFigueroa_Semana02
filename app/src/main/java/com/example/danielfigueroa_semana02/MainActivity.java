package com.example.danielfigueroa_semana02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //creacion variables globales
    private TextView PreguntaTexto;
    private EditText RespuestaTexto;
    private Button Boton;
    private TextView PuntajeTexto;
    private ArrayList<Pregunta> preguntas; //clases creadas en la misma carpeta que el main
    private int NumeroPregunta;
    private int Puntaje;

    //no tiene constructor porque es una actividad
    //onCreate lo que se crea al iniciar la actividad, funciona mas de una vez
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar las variables
        PreguntaTexto = findViewById(R.id.Pregunta);
        RespuestaTexto = findViewById(R.id.Respuesta);
        Boton = findViewById(R.id.Boton);
        PuntajeTexto = findViewById(R.id.Puntaje);
        NumeroPregunta = 0;
        Puntaje = 0;

        preguntas = new ArrayList<Pregunta>();


        /*Pregunta pregunta1 = new Pregunta("5x10", "50");
        Pregunta pregunta2 = new Pregunta("4/2", "2");
        Pregunta pregunta3 = new Pregunta("60-40", "20");
        Pregunta pregunta4 = new Pregunta("25+35", "60");
        //for (pregunta++){
        // pregunta.add
        // }

            preguntas.add(pregunta1);
            preguntas.add(pregunta2);
            preguntas.add(pregunta3);
            preguntas.add(pregunta4);*/

        //para el valor I que es menor a 4 y se aumenta
        //selecicone numeros menores del 10+1
        for(int i=0;i<4;i++) {
            int numeroAleatorio1 = (int) (Math.random()*10+1);
            int numeroAleatorio2 = (int) (Math.random()*10+1);
            if (numeroAleatorio1 <= numeroAleatorio2 ){
                Pregunta pregunta = new Pregunta(String.valueOf(numeroAleatorio1)+"x"+String.valueOf(numeroAleatorio2), String.valueOf(numeroAleatorio1*numeroAleatorio2));
                preguntas.add(pregunta);
            } else {
                Pregunta pregunta = new Pregunta(String.valueOf(numeroAleatorio1)+"+"+String.valueOf(numeroAleatorio2), String.valueOf(numeroAleatorio1+numeroAleatorio2));
                preguntas.add(pregunta);
            }
        }

        Boton.setOnClickListener(
                (v)->{

                    if(RespuestaTexto.getText().toString().equals(preguntas.get(NumeroPregunta).getRespuesta())){
                        Toast.makeText(getApplicationContext(), "Son iguales", Toast.LENGTH_SHORT).show();
                        NumeroPregunta++;
                        Puntaje += 15;
                        PuntajeTexto.setText(String.valueOf(Puntaje));

                        if (NumeroPregunta<4){
                            PreguntaTexto.setText(preguntas.get(NumeroPregunta).getPregunta());
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "No son iguales", Toast.LENGTH_SHORT).show();
                    }


                }
        );
        PreguntaTexto.setText(preguntas.get(NumeroPregunta).getPregunta());


    }


}