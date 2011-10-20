package gymcoach.perfil;

import gymcoach.main.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.View.OnClickListener;

public class AgregarPerfil extends Activity {
	private static final String MIS_PREFS = "Perfiles";
    private static final String PERFILES = "";
	
	private String nombre;
	private int dia, mes, año;
	private String[] objetivos = new String[]{"Acondicionamiento", "Volumen muscular", "Marcar los musculos", "Perder peso", "Salud"};
	private float peso;
	private float estatura;
	private int objetivo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.agregarperfil);

		((Button)findViewById(R.id.btnListo)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				nombre = ((EditText)findViewById(R.id.etNombre)).getText().toString();
				dia = ((DatePicker)findViewById(R.id.dpFechaNac)).getDayOfMonth();
				mes = ((DatePicker)findViewById(R.id.dpFechaNac)).getMonth();
				año = ((DatePicker)findViewById(R.id.dpFechaNac)).getYear();
				estatura = Float.parseFloat(((EditText)findViewById(R.id.etEstatura)).getText().toString());
				peso = Float.parseFloat(((EditText)findViewById(R.id.etPeso)).getText().toString());
				if(nombre.equals("") || estatura == 0.0 || peso == 0.0){
					Toast.makeText(getBaseContext(), "Por favor ingrese todos los campos obligatorios", Toast.LENGTH_LONG).show();
					return;
				}
				
				if(!existePerfil()){
					guardarEnPerfiles();
					guardarPerfil();
				}else{
					Toast.makeText(getBaseContext(), "Ya existe un perfil con el mismo nombre", Toast.LENGTH_LONG).show();
					return;
				}
					
				Intent intencion = new Intent(getBaseContext(), Perfil.class);
				intencion.putExtra("nombre", nombre);
				startActivity(intencion);
				finish();
			}
		});
		
		Spinner sType = (Spinner)findViewById(R.id.spObjetivo);
		sType.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, objetivos));
		sType.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> adapter, View v, int pos, long id) {
				objetivo = pos;
			}

			@Override
			public void onNothingSelected(AdapterView<?> adapter) {
				objetivo = 0;
			}
		});
	}
	
	public void guardarEnPerfiles(){
		SharedPreferences prefs = getSharedPreferences(MIS_PREFS, MODE_PRIVATE);
    	SharedPreferences.Editor editor = prefs.edit();
    	editor.putString(PERFILES, prefs.getString(PERFILES, "") + " " + nombre);
    	editor.commit();
	}
	
	public void guardarPerfil(){
		SharedPreferences prefs = getSharedPreferences(nombre, MODE_PRIVATE);
    	SharedPreferences.Editor editor = prefs.edit();
    	editor.putInt("DIA", dia);
    	editor.putInt("MES", mes);
    	editor.putInt("AÑO", año);
    	editor.putFloat("ESTATURA", estatura);
    	editor.putFloat("PESO", peso);
    	editor.putInt("OBJETIVO", objetivo);
    	editor.commit();
	}
	
	public boolean existePerfil(){
		SharedPreferences prefs = getSharedPreferences(MIS_PREFS, MODE_PRIVATE);
        String perfiles = (prefs.getString(PERFILES, ""));
        
        return perfiles.contains(nombre);
	}
}