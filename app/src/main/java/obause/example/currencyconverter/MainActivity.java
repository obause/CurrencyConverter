package obause.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final double RATE = 0.86;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }

    public void calcUsdEur(View view) {

        EditText usdEditText = findViewById(R.id.editTextUsd);
        EditText eurEditText = findViewById(R.id.editTextEur);

        if(!isEmpty(usdEditText) && isEmpty(eurEditText)) {
            double dUsd = Double.parseDouble(usdEditText.getText().toString());
            double result = dUsd * RATE;
            Toast.makeText(this, String.format("%.2f$ sind %.2f€", dUsd, result), Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, usdEditText.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        else if(!isEmpty(eurEditText) && isEmpty(usdEditText)) {
            double dEur = Double.parseDouble(eurEditText.getText().toString());
            double result = dEur / RATE;
            Toast.makeText(this, String.format("%.2f€ sind %.2f$", dEur, result), Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Falsche Eingabe", Toast.LENGTH_SHORT).show();
        }
    }
}