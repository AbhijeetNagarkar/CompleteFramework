package project.utility;

public class ObjectRepository {

	public static ThreadLocal<WebPageObjectCreation> repoinstance = new ThreadLocal<WebPageObjectCreation>();

    public static WebPageObjectCreation GetInstance() {
        return repoinstance.get();
    }

    public static void SetInstance(WebPageObjectCreation obj) {
    	repoinstance.set(obj);
    }
}
