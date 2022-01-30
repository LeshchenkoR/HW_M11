public class Main {
    // статический метод ля генерирования исключения
    static void generator(int n){
        throw new MyException(n);
    }

    public static void main(String[] args) {
        try {
            try {
                //при вызове метода генерируется исключение с кодом:
                generator(444);
            }catch (MyException e){
                System.out.println(e.getMessage());
                throw e;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

class MyException extends RuntimeException{
    private int code;

    public MyException(int code) {
        super("Ошибка класса MyException");
        this.code = code;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "\nКод ошибки" + code;
    }

    @Override
    public String toString() {
        return "< MyException: " + code + ">";
    }
}
