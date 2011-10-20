package gymcoach.perfil;

import gymcoach.main.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Perfiles extends Activity{
	private static final String MIS_PREFS = "Perfiles";
    private static final String PERFILES = "";
	
	private String[] perfiles;
	private String nombre;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfiles);
		
		((ImageButton)findViewById(R.id.ibtnAgregar)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), AgregarPerfil.class);
				startActivity(intencion);
				finish();
			}
		});
		
		cargarPerfiles();
		LinearLayout container = (LinearLayout)findViewById(R.id.perfilesLayout);
		for(int i=1; i<perfiles.length; i++){
			nombre = perfiles[i];
			Button btnPerfil = new Button(this);
			btnPerfil.setText(nombre);
			btnPerfil.setOnClickListener(new OnClickListener() {
					
				@Override
				public void onClick(View v) {
					Intent intencion = new Intent(getBaseContext(), Perfil.class);
					intencion.putExtra("nombre", ((Button)v).getText().toString());
					startActivity(intencion);
					finish();
				}
			});
			container.addView(btnPerfil);
		}
	}
	
	public void cargarPerfiles(){
		SharedPreferences prefs = getSharedPreferences(MIS_PREFS, MODE_PRIVATE);
        perfiles = (prefs.getString(PERFILES, "")).split(" ");
	}
}