/*
 * This text is generated automatically, do not delete it. 'FBA Toolkit', www.profi1c.ru
 */
package net.bakum.fu.samples;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import ru.profi1c.engine.app.FbaDBExchangeActivity;
import ru.profi1c.engine.exchange.ExchangeObserver;
import ru.profi1c.engine.exchange.ExchangeReceiver;
import ru.profi1c.engine.exchange.ExchangeVariant;
import ru.profi1c.engine.util.AppHelper;
import android.content.Context;
import android.os.Bundle;

/*
 * Эта Activity является основной и будет первой отображаться при запуске
 * приложения.
 *
 * Предупреждение! FBA использует библиотеку 'AppCompat',
 * взаимодействие с панелью действий обрабатывается с помощью функции getSupportActionBar() вместо getActionBar().
 * 
 * @author  ()
 * 
 */
public class MainActivity extends FbaDBExchangeActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(savedInstanceState==null && getFbaActivityNavigation().isMainActivity()){
			onCreateNewSession();
		}
		
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.fba_menu_settings) {

			getFbaActivityNavigation().showPreferenceActivity();
			return true;

		} else if (id == R.id.fba_menu_exchange) {

			startExchange(ExchangeVariant.FULL, true);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected ExchangeObserver getExchangeObserver() {
		return null;
	}

	/**
	 * Запущена новая сессия приложения т.н запуск, не поворот экрана
	 */
	private void onCreateNewSession() {

		Context ctx = getApplicationContext();
		
		//восстановить задание обмена в планировщике если требуется
		if(AppHelper.isAppInstalledToSDCard(ctx)) {
			ExchangeReceiver.createSchedulerTasks(ctx);
		}

	}

}