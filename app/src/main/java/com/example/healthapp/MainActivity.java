package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;


public class  MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//        chatView = findViewById(R.id.chatView);
//        editMessage = findViewById(R.id.editMessage);
//        btnSend = findViewById(R.id.btnSend);
//
//        chatAdapter = new ChatAdapter(messageList, this);
//        chatView.setAdapter(chatAdapter);

//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override public void onClick(View view) {
//                String message = editMessage.getText().toString();
//                if (!message.isEmpty()) {
//                    messageList.add(new Message(message, false));
//                    editMessage.setText("");
//                    sendMessageToBot(message);
//                    Objects.requireNonNull(chatView.getAdapter()).notifyDataSetChanged();
//                    Objects.requireNonNull(chatView.getLayoutManager())
//                            .scrollToPosition(messageList.size() - 1);
//                } else {
//                    Toast.makeText(MainActivity.this, "Please enter text!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        setUpBot();
    }
//    private void setUpBot() {
//        try {
//            InputStream stream = this.getResources().openRawResource(R.raw.credential);
//            GoogleCredentials credentials = GoogleCredentials.fromStream(stream)
//                    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
//            String projectId = ((ServiceAccountCredentials) credentials).getProjectId();
//
//            SessionsSettings.Builder settingsBuilder = SessionsSettings.newBuilder();
//            SessionsSettings sessionsSettings = settingsBuilder.setCredentialsProvider(
//                    FixedCredentialsProvider.create(credentials)).build();
//            sessionsClient = SessionsClient.create(sessionsSettings);
//            sessionName = SessionName.of(projectId, uuid);
//
//            Log.d("Success", "projectId : " + projectId);
//        } catch (Exception e) {
//            Log.d(TAG, "setUpBot: " + e.getMessage());
//        }
//    }
//    private void sendMessageToBot(String message) {
//        QueryInput input = QueryInput.newBuilder()
//                .setText(TextInput.newBuilder().setText(message).setLanguageCode("en-US")).build();
//        new SendMessageInBg(this, sessionName, sessionsClient, input).execute();
//    }
//  @Override
//    public void callback(DetectIntentResponse returnResponse) {
//       if(returnResponse!=null) {
//           String botReply = returnResponse.getQueryResult().getFulfillmentText();
//            if(!botReply.isEmpty()){
//                messageList.add(new Message(botReply, true));
//                chatAdapter.notifyDataSetChanged();
//                Objects.requireNonNull(chatView.getLayoutManager()).scrollToPosition(messageList.size() - 1);
//            }else {
//                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//           Toast.makeText(this, "failed to connect!", Toast.LENGTH_SHORT).show();
//        }
//    }
