package com.juanzapata12.screenmatch.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.juanzapata12.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.juanzapata12.screenmatch.modelos.Titulo;
import com.juanzapata12.screenmatch.modelos.TituloOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        while (true)
        {
            System.out.println("Escriba el nombre de la pelicula: ");
            var busqueda = lectura.nextLine();

            if (busqueda.equalsIgnoreCase("salir"))
            {
                break;
            }

            String direccion = "http://www.omdbapi.com/?t=" +
                    busqueda.replace(" ", "+") +
                    "&apikey=d5e7c9ef";
            try
            {
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);


                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(miTituloOmdb);
                //Titulo miTitulo = new Titulo(miTituloOmdb.title(), miTituloOmdb.year());

                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("tituloya convertido: " + miTitulo);

                //FileWriter escritura = new FileWriter("peliculas.txt");
                //escritura.write(miTitulo.toString());
                //escritura.close();

                titulos.add(miTitulo);

            }
            catch(NumberFormatException e)
            {
                System.out.println("ocurrio un error");
                System.out.println(e.getMessage());
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Error en la uri, verifique la direccion");
            }
            catch(ErrorEnConversionDeDuracionException e)
            {
                System.out.println("Contiene N/A");
            }
            catch(Exception e)
            {
                System.out.println("Error inesperado");
            }
        }
        System.out.println(titulos);
        FileWriter escritura = new FileWriter("Titulos.jason");
        escritura.write(gson.toJson(titulos));
        escritura.close();
        System.out.println("finalizo la ejecucion de programa");
    }
}
