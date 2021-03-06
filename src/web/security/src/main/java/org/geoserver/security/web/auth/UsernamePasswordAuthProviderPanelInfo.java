/* Copyright (c) 2001 - 2012 TOPP - www.openplans.org. All rights reserved.
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.security.web.auth;

import org.geoserver.security.auth.UsernamePasswordAuthenticationProvider;
import org.geoserver.security.config.UsernamePasswordAuthenticationProviderConfig;

/**
 * Configuration panel extension for {@link UsernamePasswordAuthenticationProvider}.
 * 
 * @author Justin Deoliveira, OpenGeo
 */
public class UsernamePasswordAuthProviderPanelInfo extends AuthenticationProviderPanelInfo
    <UsernamePasswordAuthenticationProviderConfig,UsernamePasswordAuthProviderPanel> {

    public UsernamePasswordAuthProviderPanelInfo() {
        setComponentClass(UsernamePasswordAuthProviderPanel.class);
        setServiceClass(UsernamePasswordAuthenticationProvider.class);
        setServiceConfigClass(UsernamePasswordAuthenticationProviderConfig.class);
        setPriority(0);
    }
}
