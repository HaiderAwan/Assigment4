package com.example.aaa.assigment4;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    final String TAG = "MYTAG";
    public static volatile boolean shouldContinue = true;

    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.aaa.assigment4.action.FOO";
    private static final String ACTION_BAZ = "com.example.aaa.assigment4.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.aaa.assigment4.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.aaa.assigment4.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "stop", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    protected void onHandleIntent(Intent intent) {


            int a = intent.getIntExtra("Value", 10);
            for (int i = 0; i < a; i++) {
                if (shouldContinue = false) {

                    break;
                }
                try {
                    Thread.sleep(500);
                    Log.d(TAG, "Activity : " + i);
                    EventBus.getDefault().post(new MessageEvent(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
