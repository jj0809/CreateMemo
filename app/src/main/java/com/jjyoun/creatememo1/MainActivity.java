package com.jjyoun.creatememo1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText mMemoEdit = null;
    TextFileManager2 mTextFileManager = new TextFileManager2(this);

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMemoEdit = (EditText) findViewById(R.id.memo_edit);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.load_btn: {
                String memoData = mTextFileManager.load();
                Toast.makeText(this, "불러오기 완료", Toast.LENGTH_LONG).show();
                mMemoEdit.setText(memoData);
                break;
            }

            case R.id.save_btn: {
                    String memoData = mMemoEdit.getText().toString();
                    mTextFileManager.save(memoData);
                    mMemoEdit.setText("");

                    Toast.makeText(this, "저장 완료", Toast.LENGTH_LONG).show();
                    break;
                }

            case R.id.delete_btn: {
                    mTextFileManager.delete();
                    mMemoEdit.setText("");
                    Toast.makeText(this, "삭제 완료", Toast.LENGTH_LONG).show();
                }
            }


    }

}
