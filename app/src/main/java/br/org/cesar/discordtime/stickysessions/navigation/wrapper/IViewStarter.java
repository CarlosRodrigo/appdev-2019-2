package br.org.cesar.discordtime.stickysessions.navigation.wrapper;

import android.content.Context;

import br.org.cesar.discordtime.stickysessions.navigation.exception.InvalidViewNameException;

public interface IViewStarter {

    void goNext(Context context, String activityName, boolean shouldClearStack)
            throws InvalidViewNameException;

    void goNext(Context context, String activityName, boolean shouldClearStack, IBundle extras)
        throws InvalidViewNameException;
}
