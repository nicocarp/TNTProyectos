package com.example.nicoc.productos.Producto.Agregar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.nicoc.productos.Producto.Listado.ListadoView;
import com.example.nicoc.productos.R;
import com.google.common.collect.Range;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AgregarProductoView extends AppCompatActivity implements IProducto.View {

    private IProducto.Presenter presenter;

    private AwesomeValidation validator;

    @BindView(R.id.txtCodigo) EditText txtCodigo;
    @BindView(R.id.txtNombre) EditText txtNombre;
    @BindView(R.id.txtDescripcion) EditText txtDescripcion;
    @BindView(R.id.txtPrecio) EditText txtPrecio;
    @BindView(R.id.txtStock) EditText txtStock;
    @BindView(R.id.txtImagen) EditText txtImagen;
    @BindView(R.id.imagenProducto)
    ImageView imagenProducto;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto_view);

        ButterKnife.bind(this);

        this.presenter = new AgregarProductoPresenter(this);

        this.validator = new AwesomeValidation(ValidationStyle.BASIC);

        this.inicarView();

    }

    public void inicarView(){

        // Reglas de validacion
        validator.addValidation(txtCodigo, "[a-zA-Z\\s]+", "Ingrese codigo valido");
        validator.addValidation(txtNombre, RegexTemplate.NOT_EMPTY, "Requerido");
        validator.addValidation(txtNombre, "[a-zA-Z\\s]+", "Ingrese nombre");
        validator.addValidation(txtDescripcion, RegexTemplate.NOT_EMPTY, "Ingrese descripcion");
        validator.addValidation(txtPrecio, Range.greaterThan(0.0f), "Precio mayor a 0");
        validator.addValidation(txtPrecio, RegexTemplate.NOT_EMPTY, "Precio requerido");
        validator.addValidation(txtStock, Range.greaterThan(-1), "Stock 0 o mayor");
    }

    @OnClick(R.id.txtImagen) void seleccionarImagen(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");

        //intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
        startActivityForResult(intent, 1);
    }
    @OnClick(R.id.btnAgregarProducto)@Override public void agregarProducto(){
        this.validator.clear();
        if (!this.validator.validate())
            return;

        String codigo = txtCodigo.getText().toString();
        String nombre = txtNombre.getText().toString();
        String descripcion = txtDescripcion.getText().toString();
        //String imagen = txtImagen.getText().toString();
        Double precio = Double.valueOf(txtPrecio.getText().toString());
        Integer stock = Integer.valueOf(txtStock.getText().toString());

        String imagen = saveImage();
        this.presenter.agregarProducto(
                codigo, nombre, descripcion, precio, stock, imagen
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                Bundle extras = data.getExtras();
                Bitmap bMap = (Bitmap) extras.get("data");
                imagenProducto.setImageBitmap(bMap);
                //saveImage(bMap);
                /*
                File f = new File(Environment.getExternalStorageDirectory().|());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            bitmapOptions);
                    imagenProducto.setImageBitmap(bitmap);
                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                */
            }
        }
    }

    public String saveImage(){
        FileOutputStream fileOutputStream = null;
        File file = getDisc();
        if (!file.exists() && !file.mkdir()){
            mostrarError("No se puede abrir archivo para escribir");
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyymmsshhmmss");
        String date = format.format(new Date());
        String name = "img"+date+".jpg";
        String file_name = file.getAbsolutePath()+File.separator+name;
        File new_file = new File(file_name);
        try {
            fileOutputStream = new FileOutputStream(new_file);
            Bitmap bmap= ((BitmapDrawable)imagenProducto.getDrawable()).getBitmap();
            bmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        }
        return name;
    }

    public File getDisc(){
        File file = android.os.Environment.getExternalStorageDirectory();
        return new File(file, "imagenes");
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void productoAgregado(Long id) {
        Toast.makeText(getApplicationContext(), "Producto agregado "+id, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AgregarProductoView.this, ListadoView.class);
        startActivity(intent);
    }
}
