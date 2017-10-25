package com.example.nicoc.productos.Database;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by nicoc on 25/10/17.
 */

public class ManagerFile {
    private final static String IMAGENES_PATH = "imagenes";
    private final static String EXT_IMAGEN = ".jpg";

    private File getAlmacenamiento(){
        File file_base = android.os.Environment.getExternalStorageDirectory();
        return new File(file_base, IMAGENES_PATH);
    }

    public void guardarImagen(Bitmap bitmap, String nombre){
        File file_base = getAlmacenamiento();
        String file_name = file_base.getAbsolutePath() + File.separator + nombre + EXT_IMAGEN;
        File new_file = new File(file_name);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new_file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Devuelvo file imagen.
     * @param nombre_archivo nombre de la imagen que se guarda en bd ejemplo "img-20172334"
     * @return null o File que corresponde a la imagen guardada como IMAGEN_PATH/nombre_archivo.jpeg
     */
    public File getFileImagenByName(String nombre_archivo){
        if (nombre_archivo == null || nombre_archivo == "")
            return null;
        File file_base = getAlmacenamiento();
        return new  File(
                file_base.getAbsolutePath() +
                        File.separator +
                        nombre_archivo + EXT_IMAGEN);
    }



}
