package fes.aragon.acciones.inicio;

import java.io.*;

public class ManejoArchivos <E>{
    public void escribirEnArchivo(String nombreArchivo, E dato  ){
        File archivo = new File (nombreArchivo);

        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.print(dato);
            salida.close();
        }catch (IOException ex){
            System.out.println();
        }
    }

    public boolean archivoExiste(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    public void borrarArchivo(String nombreArchivo){
        File archivo = new File (nombreArchivo);
        archivo.delete();
    }
}
