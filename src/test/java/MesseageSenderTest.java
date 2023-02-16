import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.Map;

class MesseageSenderTest {

    @Test
    void test_send_by_mockito_ru() {

        String expected = "Добро пожаловать";
        GeoService geoService = Mockito.mock(GeoService.class);

        Mockito.when(geoService.byIp("172.")).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        String preferences = messageSender.send(Map.of(MessageSenderImpl.IP_ADDRESS_HEADER, "172."));
        Assertions.assertEquals(expected, preferences);

    }

    @Test
    void test_send_by_mockito_usa(){

        String expected = "Welcome";

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.")).thenReturn(new Location("New York", Country.USA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        String preferences = messageSender.send(Map.of(MessageSenderImpl.IP_ADDRESS_HEADER, "96."));
        Assertions.assertEquals(expected, preferences);

    }
}
