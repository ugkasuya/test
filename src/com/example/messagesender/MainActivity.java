package com.example.messagesender;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;



public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	//送信成功時　動作確認ボタン
	Button btnAdd = (Button)findViewById(R.id.btnOK);
	btnAdd.setOnClickListener(new View.OnClickListener() {
	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			MessageBox("送信しました。　：）","message");
		}
	});
	
	//送信失敗時　動作確認テストボタン
	Button btnCancel = (Button)findViewById(R.id.btnCancel);
	btnCancel.setOnClickListener(new View.OnClickListener() {
	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			//メッセージボックス
			//MessageBox("失敗しました。Gmailで送信します。","message");
			
			//アラートダイアログ
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
			alertDialogBuilder.setTitle("自動送信に失敗しました");
			alertDialogBuilder.setMessage("Gmailで送信します");

			alertDialogBuilder.setPositiveButton("OK", 
					new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Intent intent = new Intent();
							
							String[] strTo = {"shoyano.ee@ezweb.ne.jp"};
							intent.putExtra(Intent.EXTRA_EMAIL, strTo);
							intent.putExtra(Intent.EXTRA_SUBJECT, "今から帰ります[タイトル]");
							intent.putExtra(Intent.EXTRA_TEXT, "あと１時間くらい[本文]\n");
							intent.setType("message/ref822");
							
							intent.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");
							startActivity(intent);
						}
					});
			
			alertDialogBuilder.setNegativeButton("キャンセル", 
					new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							
						}
					});
			
			//キャンセル可能か設定
			alertDialogBuilder.setCancelable(true);
			AlertDialog alertDialog = alertDialogBuilder.create();
			alertDialog.show();

		}
	});
	
	
	//初期設定/設定変更ボタン
	Button btnSetting = (Button)findViewById(R.id.btnSetting);
	btnSetting.setOnClickListener(new View.OnClickListener(){
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, SubActivity.class);
			startActivity(intent);
		}
	});
	}
	
	/*
	//Gmail送信テストボタン
	Button btnGmail = (Button)findViewById(R.id.btnGmail);
	btnGmail.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			
			String[] strTo = {"shoyano.ee@ezweb.ne.jp"};
			intent.putExtra(Intent.EXTRA_EMAIL, strTo);
			intent.putExtra(Intent.EXTRA_SUBJECT, "今から帰ります[タイトル]");
			intent.putExtra(Intent.EXTRA_TEXT, "あと１時間くらい[本文]\n");
			intent.setType("message/ref822");
			
			intent.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");
			
			
			//intent.setAction(Intent.ACTION_VIEW);
			//intent.setDataAndNormalize(Uri.parse("http://b.hatna.ne.jp"));
			
			
			//intent.setClassName("com.android.broser","com.android.browser.BrowserActivity");
			startActivity(intent);
		}
	});
	}
	*/
	void MessageBox(String message, String title){
		AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this);
		alertDialog.setTitle(title);
		alertDialog.setMessage(message);
		alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				setResult(RESULT_OK);
				
			}
		});
		alertDialog.create();
		alertDialog.show();
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
