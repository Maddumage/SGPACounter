package com.roshan.sgpacounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText inputID, inputFullName, inputEmail, inputBatch, inputUserName, inputPassword;
    private TextInputLayout inputLayoutID, inputLayoutFullName, inputLayoutEmail, inputLayoutBatch, inputLayoutUserName, inputLayoutPassword;
    private Button btnSignUp;
    String id,name,email,batch,uname,pword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        inputLayoutID = (TextInputLayout) findViewById(R.id.input_layout_sid);
//        inputLayoutFullName = (TextInputLayout) findViewById(R.id.input_layout_fullname);
//        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
//        inputLayoutBatch = (TextInputLayout) findViewById(R.id.input_layout_batch);
        inputLayoutUserName = (TextInputLayout) findViewById(R.id.input_layout_uname);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
//        inputID = (EditText) findViewById(R.id.input_sid);
//        inputFullName = (EditText) findViewById(R.id.input_fullname);
//        inputBatch = (EditText) findViewById(R.id.input_batch);
//        inputEmail = (EditText) findViewById(R.id.input_email);
        inputUserName = (EditText) findViewById(R.id.input_uname);
        inputPassword = (EditText) findViewById(R.id.input_password);
        btnSignUp = (Button) findViewById(R.id.btn_signup);

//        inputID.addTextChangedListener(new MyTextWatcher(inputID));
//        inputFullName.addTextChangedListener(new MyTextWatcher(inputFullName));
//        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
//        inputBatch.addTextChangedListener(new MyTextWatcher(inputBatch));
        inputUserName.addTextChangedListener(new MyTextWatcher(inputUserName));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));
//        id = inputID.getText().toString();
//        name = inputFullName.getText().toString();
//        email = inputEmail.getText().toString();
//        batch = inputBatch.getText().toString();
        uname = inputUserName.getText().toString();
        pword = inputPassword.getText().toString();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  submitForm();
                addStudent(uname,pword);
            }
        });



    }

    /**
     * Validating form
     */
    private void submitForm() {

        if (!validateID()) {
            return;
        }
        if (!validateFullName()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }

        if (!validateBatch()) {
            return;
        }
        if (!validatePassword()) {
            return;
        }

    }

    private boolean validateID() {
        if (inputID.getText().toString().trim().isEmpty()) {
            inputLayoutID.setError(getString(R.string.err_msg_name));
            requestFocus(inputID);
            return false;
        } else {
            inputLayoutID.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateFullName() {
        if (inputFullName.getText().toString().trim().isEmpty()) {
            inputLayoutFullName.setError(getString(R.string.err_msg_name));
            requestFocus(inputFullName);
            return false;
        } else {
            inputLayoutFullName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateBatch() {
        if (inputBatch.getText().toString().trim().isEmpty()) {
            inputLayoutBatch.setError(getString(R.string.err_msg_name));
            requestFocus(inputBatch);
            return false;
        } else {
            inputLayoutBatch.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
//                case R.id.input_sid:
//                    validateID();
//                    break;
//                case R.id.input_fullname:
//                    validateFullName();
//                    break;
//                case R.id.input_email:
//                    validateEmail();
//                    break;
//                case R.id.input_batch:
//                    validateBatch();
//                    break;
                case R.id.input_password:
                    validatePassword();
                    break;
            }
        }
    }

    public void addStudent(String uname, String pword)
    {
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.addLoginDetails(new Student(uname,pword));

        Student cn = new Student();
        String data = dbHelper.getStudent(id).toString();
       // String log = "Id: " + cn.getStudent_ID() + " ,Name: " + cn.getName() + " ,Email: " + cn.getEmail() + " ,Batch : " + cn.getBatch();
        // Writing Contacts to log
        //Log.d("Name: ", data);

        Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }
}
