package org.geoserver.ows;

import static org.geoserver.ows.util.ResponseUtils.*;
import static org.junit.Assert.*;

import java.util.Collections;

import org.geoserver.config.GeoServerInfo;
import org.geoserver.ows.URLMangler.URLType;
import org.geoserver.test.GeoServerSystemTestSupport;
import org.geoserver.test.SystemTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(SystemTest.class)
public class URLManglersTest extends GeoServerSystemTestSupport {
    
    private static final String BASEURL = "http://localhost:8080/geoserver";

    @Test
    public void testBasic() {
        String url =  buildURL(BASEURL, "test", null, URLType.SERVICE);
        assertEquals("http://localhost:8080/geoserver/test", url);
    }

    @Test
    public void testKVP() {
        String url =  buildURL(BASEURL, "test", Collections.singletonMap("param", "value()"), URLType.SERVICE);
        assertEquals("http://localhost:8080/geoserver/test?param=value%28%29", url);
    }

    @Test
    public void testProxyBase() {
        GeoServerInfo gi = getGeoServer().getGlobal();
        gi.setProxyBaseUrl("http://geoserver.org/");
        getGeoServer().save(gi);
        
        String url =  buildURL(BASEURL, "test", null, URLType.SERVICE);
        assertEquals("http://geoserver.org/test", url);
    }
    
    
    
    
}
