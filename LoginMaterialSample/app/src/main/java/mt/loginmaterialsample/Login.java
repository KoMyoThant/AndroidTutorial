package mt.loginmaterialsample;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by panacea on 6/17/17.
 */

public class Login extends Activity {
    private TextInputLayout emailTIL, pwdTIL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        emailTIL = (TextInputLayout) findViewById(R.id.emailTILId);
        pwdTIL = (TextInputLayout) findViewById(R.id.pwdTILId);
    }

    public boolean checkValidate() {
        boolean validate = true;

        return validate;
    }
}
