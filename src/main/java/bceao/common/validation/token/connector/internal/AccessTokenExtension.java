package bceao.common.validation.token.connector.internal;

import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;

@Xml(prefix = "access-token")
@Extension(name = "Get Access Token")
@Configurations(AccessTokenConfiguration.class)
public class AccessTokenExtension {

}
