/*************************************************************************
 *                                                                       *
 *  CESeCore: CE Security Core                                           *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public           *
 *  License as published by the Free Software Foundation; either         *
 *  version 2.1 of the License, or any later version.                    *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/ 
package org.cesecore.audit;

import java.util.Arrays;
import java.util.Properties;

import org.cesecore.RoleUsingTestCase;
import org.cesecore.authorization.control.AuditLogRules;
import org.cesecore.keys.token.CryptoToken;
import org.cesecore.keys.token.CryptoTokenFactory;
import org.cesecore.keys.token.SoftCryptoToken;
import org.junit.After;
import org.junit.Before;

/**
 * 
 * @version $Id$
 */
public abstract class SecurityEventsBase extends RoleUsingTestCase {

    public static final String keyAlias = "secretkey";
    public static final String tokenPin = "userpin";
    public static final String keyPairAlgorithm = "1024";
    public static final String keyPairSignAlgorithm = "SHA512withRSA";

    public static final CryptoToken createTokenWithKeyPair() throws Exception {
        Properties props = new Properties();
        props.setProperty(CryptoToken.AUTOACTIVATE_PIN_PROPERTY, tokenPin);
        CryptoToken token = CryptoTokenFactory.createCryptoToken(SoftCryptoToken.class.getName(), props, null, 1, "name");
        token.activate(tokenPin.toCharArray());
        token.generateKeyPair(keyPairAlgorithm, keyAlias);
        return token;
    }

    @Before
    public void setUp() throws Exception{
    	super.setUpAuthTokenAndRole(null, "SecurityAuditTest", Arrays.asList(
    	        AuditLogRules.EXPORT_LOGS.resource(),
    	        AuditLogRules.VERIFY.resource(),
    	        AuditLogRules.VIEW.resource(),
    	        AuditLogRules.CONFIGURE.resource(),
    	        AuditLogRules.LOG.resource()
    	        ), null);
    }

    @After
    public void tearDown() throws Exception {
    	super.tearDownRemoveRole();
    }
}
