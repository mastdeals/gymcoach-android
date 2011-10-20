package gymcoach.perfil;

import gymcoach.main.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class EditarPerfil extends Activity{
	private String nombre;
	private int dia, mes, año;
	private String[] objetivos = new String[]{"Acondicionamiento", "Volumen muscular", "Marcar los musculos", "Perder peso", "Salud"};
	private float peso;
	private float estatura;
	private int objetivo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editarperfil);
		
		nombre = getIntent().getExtras().getString("nombre");
		cargarPerfil();
		((EditText)findViewById(R.id.etNombreEP)).setText(nombre);
		((EditText)findViewById(R.id.etNombreEP)).setEnabled(false);
		((DatePicker)findViewById(R.id.dpFechaNacEP)).updateDate(año, mes, dia);
		((EditText)findViewById(R.id.etEstaturaEP)).setText(estatura+"");
		((EditText)findViewById(R.id.etPesoEP)).setText(peso+"");
		
		Spinner sType = (Spinner)findViewById(R.id.spObjetivoEP);
		sType.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, objetivos));
		sType.setSelection(objetivo);
		sType.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> adapter, View v, int pos, long id) {
				objetivo = pos;
			}

			@Override
			public void onNothingSelected(AdapterView<?> adapter) {

			}
		});	
		
		((Button)findViewById(R.id.btnListoEP)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dia = ((DatePicker)findViewById(R.id.dpFechaNacEP)).getDayOfMonth();
				mes = ((DatePicker)findViewById(R.id.dpFechaNacEP)).getMonth();
				año = ((DatePicker)findViewById(R.id.dpFechaNacEP)).getYear();
				estatura = Float.parseFloat(((EditText)findViewById(R.id.etEstaturaEP)).getText().toString());
				peso = Float.parseFloat(((EditText)findViewById(R.id.etPesoEP)).getText().toString());
				
				guardarPerfil();
				finish();
			}
		});
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
	
	public void cargarPerfil(){
		SharedPreferences prefs = getSharedPreferences(nombre, MODE_PRIVATE);
		dia = prefs.getInt("DIA", 0);
		mes = prefs.getInt("MES", 0);
		año = prefs.getInt("AÑO", 0);
        estatura = prefs.getFloat("ESTATURA", 0.0f);
        peso = prefs.getFloat("PESO", 0.0f);
        objetivo = prefs.getInt("OBJETIVO", 0);
	}
}
