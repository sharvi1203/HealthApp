package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.se.omapi.Session;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;



import static com.google.common.collect.TreeTraverser.using;

public class  MainActivity extends AppCompatActivity{
//    RecyclerView chatView;
//    ChatAdapter chatAdapter;
//    List<com.example.healthapp.model.Message> messageList=new ArrayList<>();
//    EditText editText;
//    ImageButton btnSend;
//    private SessionsClient sessionsClient;
//    private SessionName sessionName;
//    private String uuid= UUID.randomUUID().toString();
//    private String TAG="mainactivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        chatView=findViewById(R.id.chatView);
//        editText=findViewById(R.id.editMessage);
//        btnSend=findViewById(R.id.btnSend);
//        messageList.add(new Message("Hi",false));
//        messageList.add(new Message("hello",false));
//        messageList.add(new Message("hello",false));
//        messageList.add(new Message("hello",false));
//        messageList.add(new Message("hello",false));
//        messageList.add(new Message("hello",false));
//        messageList.add(new Message("hello",false));
//
//        chatAdapter=new ChatAdapter(messageList,this);
//        chatView.setAdapter(chatAdapter);
//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String message=editText.getText().toString();
//                if(!message.isEmpty()) {
//                    messageList.add(new com.example.healthapp.model.Message(message,false));
//                    editText.setText("");
//                    //sendMessageToBot(message);
//                    Objects.requireNonNull(chatView.getAdapter()).notifyDataSetChanged();
//                    Objects.requireNonNull(chatView.getLayoutManager())
//                            .scrollToPosition(messageList.size() - 1);
//                }else {
//                    Toast.makeText(MainActivity.this, "Please enter text!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        //setUpBot();
    }
//    private void setUpBot(){
//
//        try{
////            using (InputStream stream = File.Open(path, FileMode.Open, FileAccess.Write, FileShare.ReadWrite))
////            {
////            }
//
//            //using( var stream=File.Open());
//            InputStream stream=this.getResources().openRawResource(R.raw.creditional);
//            GoogleCredentials credentials=GoogleCredentials.fromStream(stream)
//                    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
//            String projectId = ((ServiceAccountCredentials) credentials).getProjectId();
//            SessionsSettings.Builder settingsBuilder = SessionsSettings.newBuilder();
//            SessionsSettings sessionsSettings = settingsBuilder.setCredentialsProvider(
//                    FixedCredentialsProvider.create(credentials)).build();
//            sessionsClient = SessionsClient.create(sessionsSettings);
//            sessionName = SessionName.of(projectId, uuid);
//            Log.d(TAG, "projectId : " + projectId);
//        }catch (Exception e){
//            Log.d(TAG, "setUpBot: " + e.getMessage());
//        }
//    }
//    private void sendMessageToBot(String message){
//        QueryInput input = QueryInput.newBuilder()
//                .setText(TextInput.newBuilder().setText(message).setLanguageCode("en-US")).build();
//        new SendMessageInBg(this, sessionName, sessionsClient, input).execute();

    //}

//    @Override
//    public void callback(DetectIntentResponse returnResponse) {
//        if(returnResponse!=null) {
//            String botReply = returnResponse.getQueryResult().getFulfillmentText();
//            if(!botReply.isEmpty()){
//                messageList.add(new Message(botReply,true));
//                chatAdapter.notifyDataSetChanged();
//                Objects.requireNonNull(chatView.getLayoutManager()).scrollToPosition(messageList.size() - 1);
//            }else {
//                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(this, "failed to connect!", Toast.LENGTH_SHORT).show();
//        }
//    }
}
