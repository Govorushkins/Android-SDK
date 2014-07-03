package com.backendless;

import com.backendless.async.callback.AsyncCallback;

import java.util.Map;

/**
 * Created by scadge on 6/23/14.
 */
public class Events
{
  private static final String EVENTS_MANAGER_SERVER_ALIAS = "com.backendless.services.servercode.EventHandler";

  private static final Events instance = new Events();

  static Events getInstance()
  {
    return instance;
  }

  private Events()
  {

  }

  public void dispatch( String eventName, Map eventArgs, AsyncCallback<Map> callback )
  {
    Invoker.invokeAsync( EVENTS_MANAGER_SERVER_ALIAS, "dispatchEvent", new Object[] { Backendless.getApplicationId(), Backendless.getVersion(), eventName, eventArgs }, callback );
  }
}
