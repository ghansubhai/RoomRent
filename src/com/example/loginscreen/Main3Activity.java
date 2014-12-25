package com.example.loginscreen;
 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
 
public class Main3Activity extends Activity {
 
	Button button;
 private DBHelper1 myDB;
private Button register;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home1);
		//myDB=new DBHelper1(this);
		//register=(Button)findViewById(R.id.button4);
		 //register.setOnClickListener(new View.OnClickListener() {
	          

			//@Override
			//public void onClick(View v) {
				//System.out.println(v);
				//Intent myIntent = new Intent(v.getContext(), Main3Activity.class);
	            //startActivityForResult(myIntent, 0);

				
		//	}
		// });
	}
}