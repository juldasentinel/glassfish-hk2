/*
 * Copyright (c) 2013, 2018 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2020 Payara Services Ltd.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.jvnet.hk2.guice.bridge.test;

import org.glassfish.hk2.utilities.NamedImpl;

import com.google.inject.AbstractModule;
import com.google.inject.internal.Annotations;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import jakarta.inject.Qualifier;
import java.util.ArrayList;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;

/**
 * @author jwells
 *
 */
public class GuiceBridgeModule extends AbstractModule {

    /* (non-Javadoc)
     * @see com.google.inject.AbstractModule#configure()
     */
    @Override
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    protected void configure() {
        GuiceBridge.allowJakartaInject();
        
        bind(GuiceService1.class).to(GuiceService1Impl.class);
        bind(GuiceService3.class).annotatedWith(new NamedImpl(GuiceBridgeTest.ALICE)).to(GuiceService3Alice.class);
        bind(GuiceService3.class).annotatedWith(new NamedImpl(GuiceBridgeTest.HATTER)).to(GuiceService3Hatter.class);
    }

}