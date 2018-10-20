package soft.dot.com.hawelthon.data;

import android.content.SharedPreferences;

import soft.dot.com.hawelthon.entities.User;


/**
 * Created by sofien on 06/02/2018.
 */

public class UserSharedPref {
    public static final String USER_CIN = "USER_ID";
    public static final String EMAIL = "EMAIL";
    public static final String PHONE = "EMAIL";
    public static final String USER_FIRST_NAME = "USER_FIRST_NAME";
    public static final String USER_LAST_NAME = "USER_LAST_NAME";
    public static final String USER_JOB = "USER_JOB";
    public static final String USER_PASSWRD = "USER_PASSWRD";
    public static final String USER_ADDRESS = "USER_ADDRESS";


    SharedPreferences sharedPreferences;
    public static final String USER_FILE = "user";

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    //    public static final String  ;
    public static final String LIKES = "LikesSet";

    public UserSharedPref(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public boolean insertString(String label, String newText) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(label, newText);
        editor.apply();
        return editor.commit();
    }

    public String getString(String label) {
        return sharedPreferences.getString(label, "");
    }

    public boolean insertInt(String label, int newInt) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(label, newInt);
        editor.apply();
        return editor.commit();
    }

    public boolean inserLong(String label, long newInt) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(label, newInt);

        editor.apply();
        return editor.commit();
    }

    public boolean insertBollean(String label, boolean bool) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(label, bool);

        editor.apply();
        return editor.commit();

    }

    public boolean getBoolean(String label) {
        return sharedPreferences.getBoolean(label, false);
    }

    public int getInt(String label) {
        return sharedPreferences.getInt(label, -1);
    }

    public long getLong(String label) {
        return sharedPreferences.getLong(label, -1L);
    }

    public static void logOut(SharedPreferences sharedPreferences) {

        sharedPreferences.edit().clear().apply();
    }

    public void logIn(User user) {
        this.insertString(UserSharedPref.USER_FIRST_NAME, user.getFirst_name());
        insertString(UserSharedPref.USER_LAST_NAME, user.getLast_name());
        insertString(UserSharedPref.USER_PASSWRD, user.getPassword());
        insertString(UserSharedPref.EMAIL, user.getMail());
        insertString(UserSharedPref.USER_JOB, user.getJob());
        insertString(UserSharedPref.USER_ADDRESS, user.getAddress());
        inserLong(UserSharedPref.USER_CIN, user.getCin());
        inserLong(UserSharedPref.PHONE, user.getPhone());

    }

    public boolean isUserLogged() {
        if (getLong(USER_CIN) != -1)
            return true;
        else
            return false;
    }
}
