package com.spring.Zaur_annot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

// Способ конфигурации через java code
/*Данный способ не использует сканирование пакета и поиск бинов. Здесь бины описываются в конфигклассе.
•Данный способ не использует аннотацию @Autowired. Здесь зависимости прописываются вручную.
•Название метода –это bean id как в xml
•Аннотация @Bean перехватывает все обращения к бину и регулирует его создание.*/

@Configuration
@PropertySource("classpath:AnnotExample.properties")
//@ComponentScan("com.spring.Zaur_annot") // в скобках название пакета, который нужно сканироавть для создания бинов
// @ComponentScan используется Только при первом способе конфигурации. При этом происходит поиск @Component в классах
// Т.к. ComponentScan не исползуется, то аннотация @Component в классах не нужна

public class MyConfig {
// код ниже в теле класса, используемый при втором способе конфигурации
//    При этом все бины и депеннденси инжекшн прописываются здесь.
//    Соотвественно аннотация @Component в классах не нужна для создания бинов. Также не нужны @Autowired и @Qualifier
//    Достаточно конструктора без аннотаций!!

    @Bean
    @Scope("singleton")
    public Pet catBean() {
        return new Cat();
    }

    //    ниже это dependency injection
    @Bean
    public Person personBean() {
        return new Person(catBean()); // в параметрах id, оно же название метода выше
    }

//    @Bean
//    public Pet dog(){
//        return new Dog();
//    }
//
//

}

