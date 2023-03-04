package myLessons.multithreading.callableFuture;

import java.util.concurrent.*;

public class CallableFactorial {
    /* решение той же задачи из multithreading.callableFuture.RunnableFactorial нахождения факториала числа
     * имлементируем вместо Runnable интерфейс Callable<Integer> - дженерик с типом в данном случае Integer
     * в этом интерфейсе аналог метода run() - метод Integer call() имеет возварщаемый тип- автоматом подставляется Integer
     * кроме того мы можем выбросить свое исключение, если пользватель неправильно ввел данные
     * далее возвращаем просто result
     * Если не нужно чтобы возврщался результат то используем Runnable, если нужно вернуть результат то используем Callable
     * Затем в мэйн также создаем поток через ExecutorService, но у executorService вызываем не execute метод, а метод submit, который также как execute
     * принимает задачу на вход, но помимо этого возвращает результат в объект типа Future(тоже дженерик)
     * ВАЖНО Submit() может принять как Runnable, так и Callable задачу, но execute() может принять только Runnable задачу.
     * Callable нельзя прописать в Thread, в Thread можно прописать только Runnable
     * затем результат получаем через вызов у future метода get(), котрый в свою очередь выбрасывет Exception
     * в sout getCause() выводим причину, по которой этот Exception был выброшен
     * а shutdown() в таком случае лучше(рекомендовано) закрывать в finally блоке*/

    /* Отличие submit от execute
    Разница в том, что execute просто запускает задачу и ничего не возвращает, в то время как submit
    возвращает объект Future для управления задачей. С объектом Future можно выполнить следующие действия:
- Преждевременно отмените задачу с помощью метода cancel .
- Дождитесь завершения выполнения задачи с get .
Интерфейс Future более полезен, если вы отправляете Callable в пул. Возвращаемое значение метода call будет возвращено при вызове Future.get .
Если вы не поддерживаете ссылку на Future , нет никакой разницы.
*/
    static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial2 factorial2 = new Factorial2(5);
        Future<Integer> future = executorService.submit(factorial2);
        //================================================================
//Future<?> fu=executorService.submit(new Stet());
//        try {
//            fu.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            System.out.println(e.getCause());
//        }
//================================================================
        try {
            // !!!get() блокирует поток, в котором он вызван(как join() или awaitTermination() пока не выполнится задача, и future
            // не вернет результат работы задачи. Именно поэтому submit возвращает объект future. Т.е. результат будет в будущем, после отработки задачи
            factorialResult = future.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());// getCause() выводит причину, по которой этот Exception был выброшен
        } finally {
            executorService.shutdown();// shutdown() рекомендовано прописывать в finally блоке
        }
        System.out.println(factorialResult);
    }
}
//class Stet implements Runnable{
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 3; i++) {
//            System.out.println(i);
//        }
//    }
//}

class Factorial2 implements Callable<Integer> {
    int f;

    public Factorial2(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        int result;
        if (f <= 0) {
            throw new Exception("You enter wrong number");
        }
        result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }
        return result;

    }
}
