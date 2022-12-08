package home;

public class Session {
    private static String userId;
    private static String userName;
    private static String weather;

    public static String getUsername() {return userName;}
    public static String getWeather() {return weather;}
    public static String getUserId() {return userId;}

    public static void setUsername(String userName) {
        Session.userName = userName;
    }
    public static void setWeather(String weather) {Session.weather = weather;}
    public static void setUserId(String userId) {Session.userId = userId;}



}
