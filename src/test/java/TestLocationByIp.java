import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

public class TestLocationByIp {
    GeoServiceImpl geoService = new GeoServiceImpl();
    Location location1Actual = new Location("Moscow", Country.RUSSIA,null,0);;

    @ParameterizedTest
    @MethodSource("GeoTestSource")

    public void testByLocationByIp (String ipExpected) {

        Location expected = geoService.byIp(ipExpected);
        Assertions.assertEquals(expected, location1Actual);

    }

    public static Stream<String> GeoTestSource() {
        return Stream.of(
                "200",
                "172.0.32.11",
                "96.44.183.149",
                "172.",
                "96");
    }

}
