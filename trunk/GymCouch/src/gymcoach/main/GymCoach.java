package gymcoach.main;

import gymcoach.ejercicios.Ejercicios;
import gymcoach.musculos.Musculos;
import gymcoach.perfil.Perfiles;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class GymCoach extends Activity {
	
	private static final int DIALOG_ID_EXIT = 0;
	private static final int DIALOG_ID_CONTACTO = 1;
	private static final int DIALOG_ID_ACERCADE = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       	((ImageButton)findViewById(R.id.ibtnPerfil)).setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Perfiles.class);
				startActivity(intencion);
			}
		});
       	
       	((ImageButton)findViewById(R.id.ibtnEjercicios)).setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Ejercicios.class);
				startActivity(intencion);
			}
		});
       	
       	((ImageButton)findViewById(R.id.ibtnMusculos)).setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Musculos.class);
				startActivity(intencion);
			}
		});
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		
		MenuInflater md = getMenuInflater();
		md.inflate(R.menu.menu_pantalla_inicial, menu);
		
		return true;
	}
	
    @Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		super.onMenuItemSelected(featureId, item);
		
		switch(item.getItemId()){
		case R.id.menuSalir: 
			showDialog(DIALOG_ID_EXIT);
			break;
		case R.id.menuContacto: 
			showDialog(DIALOG_ID_CONTACTO);
			break;
		case R.id.menuAcercaDe: 
			showDialog(DIALOG_ID_ACERCADE);
			break;
		case R.id.menuConfigurar:
			Intent intencion = new Intent(this, Configurar.class);
			startActivity(intencion);
			break;
		}
		
		return true;
	}
    
    @Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog = null;
		
		switch(id){		
		case DIALOG_ID_EXIT:
			AlertDialog.Builder exitBuilder = new AlertDialog.Builder(this);
			exitBuilder.setMessage("¿Seguro que quieres salir de la aplicación?");
			exitBuilder.setTitle("Salir GymCouch");
			exitBuilder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			exitBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
			
			dialog = exitBuilder.create();
			break;
		case DIALOG_ID_CONTACTO:
			AlertDialog.Builder contactoBuilder = new AlertDialog.Builder(this);
			contactoBuilder.setMessage(R.string.txtContacto);
			contactoBuilder.setTitle("Ayuda GymCouch");
			
			dialog = contactoBuilder.create();
			break;
		case DIALOG_ID_ACERCADE:
			AlertDialog.Builder acercaBuilder = new AlertDialog.Builder(this);
			acercaBuilder.setMessage(R.string.txtAcercaDe);
			acercaBuilder.setTitle("Ayuda GymCouch");
			
			dialog = acercaBuilder.create();
			break;
		}
			
		return dialog;
	}
}