public class cexception {
    public static void findclass(String className) throws ClassNotFoundException{
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Class" +className+" Not found");
        }
    }
    public static void main(String[] args){
        try {
            findclass("no.existent.className");
        } catch (ClassNotFoundException e) {
            System.out.println("Exception occurred "+e);
        }
    }
    
}
