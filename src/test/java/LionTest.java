import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Predator predator; //Создаётся mock-объект для интерфейса Predator, который будет использоваться в тестах.

    // Тест для проверки количества тигрят
    @Test
    public void getKittens() throws Exception {
        // Настраиваем поведение мока: при вызове метода getKittens() возвращаем значение 3
        Mockito.when(predator.getKittens()).thenReturn(3);

        // Создаем экземпляр Lion, используя мок объект Predator
        Lion lion = new Lion("Самка", predator);

        // Проверяем, что метод getKittens() возвращает ожидаемое значение 3
        Assert.assertEquals(3, lion.getKittens());
    }

    // Тест для проверки рациона
    @Test
    public void getFood() throws Exception {
        // Настраиваем поведение мока: при вызове метода eatMeat() возвращаем список с элементами
        Mockito.when(predator.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        // Создаем экземпляр Lion, используя мок объект Predator
        Lion lion = new Lion("Самка", predator);

        // Проверяем, что метод getFood() возвращает ожидаемый список с элементами
        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}
