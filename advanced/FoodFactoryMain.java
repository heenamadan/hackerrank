package hackerrank.advanced;

import java.security.Permission;
import java.util.Scanner;

/**
 * Created by heena.madan on 14/08/17.
 */
public class FoodFactoryMain {

    public static void main(String args[]){
        Do_Not_Terminate.forbidExit();

        try{

            Scanner sc=new Scanner(System.in);
            //creating the factory
            FoodFactory foodFactory = new FoodFactory();

            //factory instantiates an object
            Food food = foodFactory.getFood(sc.nextLine());


            System.out.println("The factory returned "+food.getClass().getName());
            System.out.println(food.getType());
        }
        catch (Do_Not_Terminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }

}
class Do_Not_Terminate {

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}
