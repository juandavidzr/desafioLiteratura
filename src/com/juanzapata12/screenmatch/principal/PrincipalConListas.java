package com.juanzapata12.screenmatch.principal;

import com.juanzapata12.screenmatch.modelos.Pelicula;
import com.juanzapata12.screenmatch.modelos.Serie;
import com.juanzapata12.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas
{
    public static void main(String[] args)
    {
        Pelicula miPelicula = new Pelicula("Encanto",
                2021);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("matrix", 1998);
        otraPelicula.evalua(6);
        Serie lost = new Serie("lost",
                2000);
        var peliculaDeBruno = new Pelicula("el señor de los anillos",
                2001);
        peliculaDeBruno.evalua(6);

        Pelicula p1 = peliculaDeBruno;

        List<Titulo> lista = new LinkedList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeBruno);
        lista.add(lost);

        for (Titulo item: lista)
        {
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2)
            {
                System.out.println(pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Penelope Cruz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Ricardo Darin");

        System.out.println("Lista de artistas no ordenada: " + listaDeArtistas);

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas ordenada: " + listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Lista de titulos ordenados" + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha " + lista);
    }
}
