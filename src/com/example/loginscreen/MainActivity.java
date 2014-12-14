package com.example.loginscreen;

import java.util.ArrayList;

import com.example.loginscreen.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

public class MainActivity extends Activity {

   private EditText  emailaddress=null;
   private EditText  password=null;
   private TextView attempts;
   private Button login;
   int counter = 3;
private DBHelper mydb;
private Context context;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      mydb = new DBHelper(this);
      emailaddress = (EditText)findViewById(R.id.editText1);
      password = (EditText)findViewById(R.id.editText2);
      attempts = (TextView)findViewById(R.id.textView5);
      attempts.setText(Integer.toString(counter));
      login = (Button)findViewById(R.id.button1);
      login.setOnClickListener(new View.OnClickListener() {
          public void onClick(View view) {
        	  if (mydb.validateUser(emailaddress.getText().toString(),password.getText().toString())) {
       		   Toast.makeText(getApplicationContext(), "Authenticated",
       				      Toast.LENGTH_SHORT).show(); 
       		   System.out.println("Before callling Intenet");
       		Intent myIntent = new Intent(view.getContext(), Main2Activity.class);
            startActivityForResult(myIntent, 0);
       		   	       

       		}
        	  else{
        	      Toast.makeText(getApplicationContext(), "Wrong Credentials",
        	      Toast.LENGTH_SHORT).show();
        	      attempts.setBackgroundColor(Color.RED);	
        	      counter--;
        	      attempts.setText(Integer.toString(counter));
        	      if(counter==0){
        	         login.setEnabled(false);
        	      }

        	   }


              
          }

      });
   }

   public void login(View view){
	  // mydb.insertUserDetails("sourabh.sethi@lntinfotech.com", "Newuser@123","SOurabh Sethi" ,"+91-9322503666", "022-27881986", "Flat 305 Breez CHS,Plot 27 F,Sector 11,KoperkhIRne", "NaviMumbai", "Maharashtra", 400709, "A");
	   if (mydb.validateUser(emailaddress.getText().toString(),password.getText().toString())) {
		   Toast.makeText(getApplicationContext(), "Authenticated",
				      Toast.LENGTH_SHORT).show(); 
		   System.out.println("Before callling Intenet");
		   	       

		}
	 	
   else{
      Toast.makeText(getApplicationContext(), "Wrong Credentials",
      Toast.LENGTH_SHORT).show();
      attempts.setBackgroundColor(Color.RED);	
      counter--;
      attempts.setText(Integer.toString(counter));
      if(counter==0){
         login.setEnabled(false);
      }

   }
	  

}
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }

} 