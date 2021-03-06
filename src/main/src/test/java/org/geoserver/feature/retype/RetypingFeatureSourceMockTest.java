package org.geoserver.feature.retype;

import org.geotools.data.DataStore;
import org.geotools.data.Query;
import org.geotools.data.simple.SimpleFeatureSource;
import org.junit.Test;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.filter.Filter;

import junit.framework.TestCase;

import static org.easymock.EasyMock.*;

public class RetypingFeatureSourceMockTest {

    @Test
    public void testGetTypeNamesCalls() throws Exception {
        SimpleFeatureType orig = createNiceMock(SimpleFeatureType.class);
        expect(orig.getTypeName()).andReturn("orig").anyTimes();
        replay(orig);
        
        SimpleFeatureType wrapped = createNiceMock(SimpleFeatureType.class);
        expect(wrapped.getTypeName()).andReturn("wrapped").anyTimes();
        replay(wrapped);

        //ensure that getTypeNames() never called
        DataStore ds = createMock(DataStore.class);

        SimpleFeatureSource fs = createMock(SimpleFeatureSource.class);
        expect(fs.getSchema()).andReturn(orig).anyTimes();
        expect(fs.getDataStore()).andReturn(ds).anyTimes();
        expect(fs.getFeatures(new Query(orig.getTypeName(), Filter.INCLUDE))).andReturn(null).once();
        replay(fs);
        
        SimpleFeatureSource rts = RetypingFeatureSource.getRetypingSource(fs, wrapped);
        rts.getFeatures();
        
    }
}
