/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.as.web.deployment;

import org.jboss.as.server.deployment.AttachmentKey;
import org.jboss.as.server.deployment.DeploymentUnit;

/**
 * @author Stuart Douglas
 */
public class JsfVersionMarker {

    private static String DEFAULT_JSF_IMPL;

    public static final String Mojarra_1_2 = "Mojarra-1.2";
    @Deprecated public static final String Mojarra_2_0 = "Mojarra-2.0";
    public static final String Mojarra_2_x = "Mojarra-2.x";
    public static final String MyFaces_2_x = "MyFaces-2.x";
    public static final String WAR_BUNDLES_JSF_IMPL = "WAR_BUNDLES_JSF_IMPL";

    private JsfVersionMarker() {

    }

    /**
     * Set the default JSF implementation for all deployments.
     * @param defaultImpl The default impl;
     */
    public static void setDefaultJSFImpl(String defaultImpl) {
        DEFAULT_JSF_IMPL = defaultImpl;
    }

    private static AttachmentKey<String> VERSION_KEY = AttachmentKey.create(String.class);

    public static void setVersion(final DeploymentUnit deploymentUnit, String value) {
        if (value.equals(Mojarra_2_0)) value = Mojarra_2_x;
        deploymentUnit.putAttachment(VERSION_KEY, value);
    }

    public static String getVersion(final DeploymentUnit deploymentUnit) {
        final String version = deploymentUnit.getAttachment(VERSION_KEY);
        return version == null ? DEFAULT_JSF_IMPL : version;
    }

}
