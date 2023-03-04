package com.zaurtregulov.spring.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // отмечает класс для общих эксепшинов для всех существующих контроллеров
//этот класс будет автоматически ловить исключение, которое было выброшено в основном контроллере
public class EmployeeGlobalExceptionHandler {

    /*
     * ResponseEntity - Обёртка HTTP response
     * EmployeeIncorrectData - Тип объекта который добавляется в HTTP response body
     * NoSuchEmployeeException - exception на который должен реагировать данный метод
     *  */
    @ExceptionHandler // помечает метод ответственный за обработку исключений
    public ResponseEntity<EmployeeIncorrectData> handleException(
            NoSuchEmployeeException exception) {
        // в данном случае метод будет реагировать на созданный нами NoSuchEmployeeException

        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler // помечает метод ответственный за обработку исключений
    public ResponseEntity<EmployeeIncorrectData> handleException(
            Exception exception) { // в данном случае метод будет реагировать на ВСЕ эксепшены, даже если это будут буквы вместо цифр ID

        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
