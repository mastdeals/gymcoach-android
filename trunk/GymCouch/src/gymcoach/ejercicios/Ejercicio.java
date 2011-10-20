package gymcoach.ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import gymcoach.main.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Ejercicio extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ejercicio);
		
		TextView ejercicioTitle = (TextView)findViewById(R.id.txtTitle);
		ImageView ejercicioImg = (ImageView)findViewById(R.id.imgEjercicio);
		TextView ejercicioDescripcion = (TextView)findViewById(R.id.txtDescripcion);
		TextView ejercicioNota = (TextView)findViewById(R.id.txtNota);
		
		String ejercicioStr = getIntent().getExtras().get("ejercicioSeleccionado").toString();
		int ejercicioImgId = getResources().getIdentifier(trimAll(ejercicioStr).toLowerCase(), "drawable", getBaseContext().getPackageName());
		int ejercicioDescripcionId = getResources().getIdentifier(trimAll(ejercicioStr).toLowerCase(), "raw", getBaseContext().getPackageName());
		
		ejercicioTitle.setText(ejercicioStr);
		ejercicioImg.setImageResource(ejercicioImgId);
		
		try{
			BufferedReader entrada = new BufferedReader(new InputStreamReader(getResources().openRawResource(ejercicioDescripcionId)));
			
			String descripcion = entrada.readLine();
			String nota = entrada.readLine();
			
			ejercicioDescripcion.setText(descripcion);
			ejercicioNota.setText(nota);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		((ImageButton)findViewById(R.id.ibtnIrAMenu)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	public String trimAll(String str){
		String []strSplit = str.split(" ");
		String strTrim = "";
		
		for(String s: strSplit){
			strTrim += s;
		}
		
		return strTrim;
	}
}
