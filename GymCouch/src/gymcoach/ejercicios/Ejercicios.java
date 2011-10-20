package gymcoach.ejercicios;

import gymcoach.main.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class Ejercicios extends Activity{
    private String ejercicio;
    private String ejercicioSeleccionado;
    private ArrayList <Button> btnsEjercicio = new ArrayList<Button>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ejercicios);
		
		try{
			BufferedReader entrada = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.ejercicios)));
			int i = 0;
			
			while((ejercicio=entrada.readLine()) != null){
				btnsEjercicio.add(new Button(this));
				btnsEjercicio.get(i).setText(ejercicio);
				btnsEjercicio.get(i++).setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Button btn = (Button)v;
						ejercicioSeleccionado = btn.getText().toString();
						Intent intencion = new Intent(getBaseContext(), Ejercicio.class);
						intencion.putExtra("ejercicioSeleccionado", ejercicioSeleccionado);
						startActivity(intencion);
						finish();
					}
				});
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 	
		
		LinearLayout container = (LinearLayout)findViewById(R.id.ejerciciosLayout);
        for(Button b: btnsEjercicio){
        	container.addView(b);
        }
	}
}
