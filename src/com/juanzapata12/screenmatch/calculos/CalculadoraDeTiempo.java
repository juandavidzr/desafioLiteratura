package com.juanzapata12.screenmatch.calculos;
import com.juanzapata12.screenmatch.modelos.Pelicula;
import com.juanzapata12.screenmatch.modelos.Serie;
import com.juanzapata12.screenmatch.modelos.Titulo;

public class CalculadoraDeTiempo
{
    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void incluye(Titulo titulo)
    {
        System.out.println("Agregando duracion en minutos de " + titulo);
        this.tiempoTotal += titulo.getDuracionEnMinutos();
    }

}
