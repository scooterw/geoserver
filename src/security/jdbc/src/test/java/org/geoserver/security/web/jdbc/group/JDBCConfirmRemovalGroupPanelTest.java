/* Copyright (c) 2001 - 2011 TOPP - www.openplans.org.  All rights reserved.
 * This code is licensed under the GPL 2.0 license, availible at the root
 * application directory.
 */
package org.geoserver.security.web.jdbc.group;

import org.geoserver.security.jdbc.H2RoleServiceTest;
import org.geoserver.security.jdbc.H2UserGroupServiceTest;
import org.geoserver.security.web.group.ConfirmRemovalGroupPanelTest;
import org.junit.Test;

public class JDBCConfirmRemovalGroupPanelTest extends ConfirmRemovalGroupPanelTest {
    
    private static final long serialVersionUID = 1L;

    @Test
    public void testRemoveGroup() throws Exception {
        disassociateRoles=false;
        initializeForJDBC();
        removeObject();
        
    }

    @Test
    public void testRemoveGroupWithRoles() throws Exception {
        disassociateRoles=true;
        initializeForJDBC();
        removeObject();
    }

    void initializeForJDBC() throws Exception {
        initialize(new H2UserGroupServiceTest(), new H2RoleServiceTest());
    }
}

