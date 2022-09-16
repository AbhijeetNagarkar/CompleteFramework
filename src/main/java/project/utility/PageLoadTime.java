package project.utility;

import java.util.HashMap;

public class PageLoadTime {
	

    public static ThreadLocal<HashMap<String,String>> loadtime = new ThreadLocal<HashMap<String,String>>();

    public static HashMap<String,String> GetMap() {
        return loadtime.get();
    }

    public static void SetMap(HashMap<String,String> map) {
    	loadtime.set(map);
    }

}
