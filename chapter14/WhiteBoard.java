

class NullRobotProxyHandler implements InvocationHandler {
    /**
     *  INNER CLASS
     */
    private class NRobot implements Null, Robot {
        public String name() { return nullName; }
        public String model() { return nullName; }
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }
    /**
     *  METHODS
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }
    /**
     *  CONSTRUCTOR
     */
    NullRobotProxyHandler(Class<? extends Robot> type) {
        nullName = type.getSimpleName() + " NullRobot";
    }
    /**
     *  FIELDS
     */
    private String nullName;
    private Robot proxied = new NRobot();
}



public class NullRobot {
    /**
     *  INNER CLASS
     */
    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot)Proxy.newProxyInstance(
                                             NullRobot.class.getClassLoader(),
                                             new Class[]{ Null.class, Robot.class },
                                             new NullRobotProxyHandler(type));
    }
    /**
     *  MAIN
     */
    public static void main(String[] args) {
        Robot[] bots = {
            new SnowRemovalRobot("SnowBee"),
            newNullRobot(SnowRemovalRobot.class)
        };
        for(Robot bot : bots)
            Robot.Test.test(bot);
    }
}