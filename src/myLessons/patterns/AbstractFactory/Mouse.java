package myLessons.patterns.AbstractFactory;
/*Абстрактная фабрика — это порождающий паттерн проектирования, который позволяет создавать семейства связанных объектов,
 *не привязываясь к конкретным классам создаваемых объектов.*/
public interface Mouse {
    void click();
    void doubleClick();
    void scroll(int direction);


}
