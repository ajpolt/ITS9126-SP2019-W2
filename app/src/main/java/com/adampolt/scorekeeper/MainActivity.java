package com.adampolt.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Add two class variables to track players' scores
    // Note that these will reset when the screen is rotated
    // We'll talk about how to fix that next week
    int player1Score = 0;
    int player2Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get both score buttons that we set up in our Layout file
        Button p1Button = findViewById(R.id.score1button);
        Button p2Button = findViewById(R.id.score2button);

        // Each button has an on-click action that increments the appropriate
        // player's score, and then calls updateScores() to update the views
        p1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment player 1's score by 1
                player1Score++;

                // Update the app's views to reflect the new score
                updateScores();
            }
        });

        // Each button has an on-click action that increments the appropriate
        // player's score, and then calls updateScores() to update the views
        p2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment player 2's score by 1
                player2Score++;

                // Update the app's views to reflect the new score
                updateScores();
            }
        });
    }

    private void updateScores() {
        // Get the score views from our layout file
        TextView player1ScoreText = findViewById(R.id.score1);
        TextView player2ScoreText = findViewById(R.id.score2);

        // Set the score views' text with their new values
        // Note that we have to convert to Strings first using String.valueOf(int)
        player1ScoreText.setText(String.valueOf(player1Score));
        player2ScoreText.setText(String.valueOf(player2Score));

        // Get the image views from our layout file so we can update them
        ImageView player1Image = findViewById(R.id.imageView);
        ImageView player2Image = findViewById(R.id.imageView2);

        if(player1Score == player2Score) {
            // If the score is tied, show both as "normal" faces
            player1Image.setImageResource(R.drawable.ic_normal);
            player2Image.setImageResource(R.drawable.ic_normal);
        } else if(player1Score > player2Score) {
            // If player 1 is ahead, show player 1 with a "happy" face
            // and player 2 with a "sad" face
            player1Image.setImageResource(R.drawable.ic_happy);
            player2Image.setImageResource(R.drawable.ic_sad);
        } else {
            // Player 2 is ahead (we don't have to do an if statement
            // to check--we already checked every other possible scenario)
            // Show player 1 with a "sad" face and 2 with a "happy" face
            player1Image.setImageResource(R.drawable.ic_sad);
            player2Image.setImageResource(R.drawable.ic_happy);
        }
    }
}
