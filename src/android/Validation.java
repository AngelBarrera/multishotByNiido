package org.apache.cordova.multishot;

/**
 * Created by mind on 6/6/16.
 */
public class Validation {

    public static int getIntFromString(final String s)
    {
        if (s!=null && !s.isEmpty())
        {
            try {
                return Integer.parseInt(s);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return 0;
    }

}