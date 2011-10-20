package gymcoach.perfil;

import gymcoach.main.R;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Perfil extends Activity{
	private String nombre;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfil);
		
		nombre = getIntent().getExtras().getString("nombre");
		
		setTitle(nombre);
		
		((ImageButton)findViewById(R.id.ibtnRutina)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Rutina.class);
				intencion.putExtra("nombre", nombre);
				startActivity(intencion);
			}
		});
		
		((ImageButton)findViewById(R.id.ibtnEditarPerfil)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), EditarPerfil.class);
				intencion.putExtra("nombre", nombre);
				startActivity(intencion);
			}
		});
		
		((ImageButton)findViewById(R.id.ibtnIrAMenu)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
