package com.juanzapata12.screenmatch.modelos;

import com.juanzapata12.screenmatch.excepcion.ErrorEnConversionDeDuracionException;

public class Titulo implements Comparable<Titulo>
{
    //@SerializedName("Title")
    private String nombre;
    //@SerializedName("Year")
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeLasEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamiento)
    {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo(TituloOmdb miTituloOmdb)
    {
        this.nombre = miTituloOmdb.title();
        this.fechaDeLanzamiento = Integer.valueOf( miTituloOmdb.year());
        if (miTituloOmdb.runtime().contains("N/A"))
        {
            throw new ErrorEnConversionDeDuracionException("No pude convertir la duracion, porque conteinen un N/A");
        }
        this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().substring(0,3).replace(" ",""));
    }

    public String getNombre() {return nombre;}
    public int getFechaDeLanzamiento() {return fechaDeLanzamiento;}
    public int getDuracionEnMinutos() {return duracionEnMinutos;}
    public boolean isIncluidoEnElPlan() {return incluidoEnElPlan;}

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {this.fechaDeLanzamiento = fechaDeLanzamiento;}
    public void setDuracionEnMinutos(int duracionEnMinutos) {this.duracionEnMinutos = duracionEnMinutos;}
    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {this.incluidoEnElPlan = incluidoEnElPlan;}

    public int getTotalDeLasEvaluaciones()
    {
        return totalDeLasEvaluaciones;
    }

    public void muestraFichaTecnica()
    {
        System.out.println("El nombre de la pelicula es: " + nombre);
        System.out.println("Fecha de lanzamiento: " + fechaDeLanzamiento);
        System.out.println("Duracion en minutos: " + getDuracionEnMinutos());
    }

    public void evalua(double nota)
    {
        sumaDeLasEvaluaciones += nota;
        totalDeLasEvaluaciones++;
    }

    public double calculaMedia()
    {
        return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo)
    {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return  "(nombre=" + nombre +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento +
                ", duracion = " + duracionEnMinutos+")";
    }
}
