package com.example.danielfigueroa_semana02;

public class Pregunta {

    //variables globales
    private String pregunta; //id de la pregunta
    private String respuesta; //id de la respuesta

    //constructor
    public Pregunta(String pregunta, String respuesta){
        this.pregunta= pregunta;
        this.respuesta= respuesta;

    }

    //getter y setters

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
