package net.simplifiedcoding.androidnotificationtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SendNotificationActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editTextTitle, editTextBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notification);

        final User user = (User) getIntent().getSerializableExtra("user");


        textView = findViewById(R.id.textViewUser);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextBody = findViewById(R.id.editTextBody);

        textView.setText("Sending to : " + user.email);

        findViewById(R.id.buttonSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification(user);
            }
        });
    }

    private  void sendNotification(User user){
        String title = editTextTitle.getText().toString().trim();
        String body = editTextBody.getText().toString().trim();

        if(title.isEmpty()){
            editTextTitle.setError("Title required");
            editTextTitle.requestFocus();
            return;
        }

        if(body.isEmpty()){
            editTextBody.setError("Body required");
            editTextBody.requestFocus();
            return;
        }



    }
}
