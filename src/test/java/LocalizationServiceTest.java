import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {

    LocalizationService service = new LocalizationServiceImpl();

    @ParameterizedTest
    @EnumSource(Country.class)

    public void testLocale(Country country) {
        String expected = "Welcome";
        Assertions.assertEquals(expected, service.locale(country));
    }
}
