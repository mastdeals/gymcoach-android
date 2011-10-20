package gymcoach.perfil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import gymcoach.ejercicios.Ejercicio;
import gymcoach.main.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Rutina extends Activity{
	private ArrayList <String> rutina = new ArrayList<String>();
	private ArrayList <String> ejercicios = new ArrayList<String>();
	private ArrayList <String> biceps = new ArrayList<String>();
	private ArrayList <String> triceps = new ArrayList<String>();
	private ArrayList <String> pectorales = new ArrayList<String>();
	private ArrayList <String> trapecio = new ArrayList<String>();
	private ArrayList <String> deltoides = new ArrayList<String>();
	private ArrayList <String> abdomen = new ArrayList<String>();
	private String nombre;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rutina);
		
		nombre = getIntent().getExtras().getString("nombre");
		cargarRutina();
		
		LinearLayout container = (LinearLayout)findViewById(R.id.rutinaLayout);
		for(int i=0; i<rutina.size(); i++){
			String ejercicio = rutina.get(i);
			
			ImageView ibtnEjercicio = new ImageView(this);
			ibtnEjercicio.setImageResource(getResources().getIdentifier(trimAll(ejercicio).toLowerCase(), "drawable", getBaseContext().getPackageName()));
			container.addView(ibtnEjercicio);
			
			TextView txtEjercicio = new TextView(this);
			txtEjercicio.setText(ejercicio);
			container.addView(txtEjercicio);
		}
		
		((Button)findViewById(R.id.btnRegresarR)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	public void cargarRutina(){
		SharedPreferences prefs = getSharedPreferences(nombre, MODE_PRIVATE);
		
		if((prefs.getString("RUTINA", "").toString()).equals("")){
			generarRutina();
		}else{
			for(String rtn: prefs.getString("RUTINA", "").split("-")){
				rutina.add(rtn);
			}
		}
		
	}
	
	public void generarRutina(){
		try{
			BufferedReader entrada = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.ejercicios)));
			
			String ejercicio;
			while((ejercicio=entrada.readLine()) != null){
				ejercicios.add(ejercicio);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		for(String ej: ejercicios){
			String ejercicio = ej;
			if(ejercicio.contains("Biceps")){
				biceps.add(ej);
			}else if(ejercicio.contains("Triceps")){
				triceps.add(ej);
			}else if(ejercicio.contains("Pectorales")){
				pectorales.add(ej);
			}else if(ejercicio.contains("Trapecio")){
				trapecio.add(ej);
			}else if(ejercicio.contains("Deltoides")){
				deltoides.add(ej);
			}else if(ejercicio.contains("Abdomen")){
				abdomen.add(ej);
			}
		}
		
		agregarEjerciciosARutina(biceps);
		agregarEjerciciosARutina(triceps);
		agregarEjerciciosARutina(pectorales);
		agregarEjerciciosARutina(trapecio);
		agregarEjerciciosARutina(deltoides);
		agregarEjerciciosARutina(abdomen);
		
		guardarRutina();
	}
	
	public void agregarEjerciciosARutina(ArrayList<String> musculo){
		int num_rnd1 = (int)Math.round((Math.random()*3));
		rutina.add(musculo.get(num_rnd1));
		
		int num_rnd2 = (int)Math.round((Math.random()*3));
		while(num_rnd2 == num_rnd1){
			num_rnd2 = (int)Math.round((Math.random()*3));
		}
		rutina.add(musculo.get(num_rnd2));
	}
	
	public void guardarRutina(){
		SharedPreferences prefs = getSharedPreferences(nombre, MODE_PRIVATE);
    	SharedPreferences.Editor editor = prefs.edit();
    	String rtn = "";
    	for(String ejercicio: rutina){
    		rtn += ejercicio + "-";
    	}
    	
    	editor.putString("RUTINA", rtn);
    	editor.commit();
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
