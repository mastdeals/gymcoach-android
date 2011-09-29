package gymcouch.musculos;

import gymcouch.main.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Musculos extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.musculos);
		
		((ImageButton)findViewById(R.id.ibtnBiceps)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Musculo.class);
				intencion.putExtra("musculoSeleccionado", "biceps");
				startActivity(intencion);
			}
		});
	}
}
