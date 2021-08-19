/*************************************************************************
 *                                                                       *
 *  EJBCA Community: The OpenSource Certificate Authority                *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public           *
 *  License as published by the Free Software Foundation; either         *
 *  version 2.1 of the License, or any later version.                    *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
package org.cesecore.certificates.ocsp;

import java.util.List;

import javax.ejb.Remote;

import org.cesecore.certificates.certificate.CertificateWrapper;

/**
 * @version $Id$
 */
@Remote
public interface OcspResponseGeneratorTestSessionRemote {

    void reloadOcspSigningCache();

    List<CertificateWrapper> getCacheOcspCertificates();
}
