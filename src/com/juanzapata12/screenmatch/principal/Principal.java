package com.juanzapata12.screenmatch.principal;

import com.juanzapata12.screenmatch.calculos.CalculadoraDeTiempo;
import com.juanzapata12.screenmatch.calculos.FiltroRecomendacion;
import com.juanzapata12.screenmatch.modelos.Episodio;
import com.juanzapata12.screenmatch.modelos.Pelicula;
import com.juanzapata12.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal
{
    public static void main(String[] args)
    {
        Pelicula miPelicula = new Pelicula("Encanto",
                2021);

        miPelicula.setFechaDeLanzamiento(2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(7.8);

        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        Serie casaDragon = new Serie("La casa del dragon",
                2022);

        casaDragon.setTemporada(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("matrix", 1998);

        otraPelicula.setFechaDeLanzamiento(1998);
        otraPelicula.setDuracionEnMinutos(180);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo total necesario: " + calculadora.getTiempoTotal() + " minutos");

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("la casa targarean");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(50);

        filtroRecomendacion.filtra(episodio);

        var peliculaDeBruno = new Pelicula("el señor de los anillos",
                2001);

        peliculaDeBruno.setDuracionEnMinutos(180);
        peliculaDeBruno.setFechaDeLanzamiento(2001);

        ArrayList<Pelicula> listDePeliculas = new ArrayList<>();
        listDePeliculas.add(peliculaDeBruno);
        listDePeliculas.add(miPelicula);
        listDePeliculas.add(otraPelicula);
        System.out.println("tamaño de la lista: " + listDePeliculas.size());
        System.out.println("La primera pelicula es: " + listDePeliculas.get(0).getNombre());

        System.out.println(listDePeliculas.toString());
        System.out.println("toString de la pelicula " + listDePeliculas.get(0).toString());


    }
}
