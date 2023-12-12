package BlueBoxStorage.BackEnd.ManejoArchivos;

import BlueBoxStorage.BackEnd.Modelos.EmpleadoM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
    public Archivo() {}

    public String[] leer(){
        String[] usuarioYclave = new String[0];

        String direccionamiento = "../Conf.csv";

        String linea = new String();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(direccionamiento));

            while ((linea = bufferedReader.readLine()) != null){
                usuarioYclave = linea.split(",");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return usuarioYclave;
    }

    public EmpleadoM Emplear(){
        EmpleadoM empleadoM = new EmpleadoM();

        empleadoM.setNombreUsuario(leer()[0].replace("\"", ""));
        empleadoM.setClaveUsuario(leer()[1].replace("\"", ""));

        return empleadoM;
    }
}
