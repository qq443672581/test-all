package cn.dlj1.simple.classloader;

public class Load extends ClassLoader{

    public static void main(String[] args){

        Load load = new Load();

        try {
            Class<?> loadClass = load.findClass("xx");
            System.out.println(loadClass.getName());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {


        return String.class;

    }
}
